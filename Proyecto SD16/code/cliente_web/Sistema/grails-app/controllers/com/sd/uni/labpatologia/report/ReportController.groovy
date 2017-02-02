package com.sd.uni.labpatologia.report

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;

import com.sd.uni.labpatologia.beans.report.ReportB
import com.sd.uni.labpatologia.service.auth.IAuthService;
import com.sd.uni.labpatologia.service.doctor.IDoctorService;
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService
import com.sd.uni.labpatologia.service.patient.IPatientService;
import com.sd.uni.labpatologia.service.report.IReportService;
import com.sd.uni.labpatologia.service.report.ReportServiceImpl;
import com.sd.uni.labpatologia.service.request.IRequestService;
import com.sd.uni.labpatologia.service.statistic.IStatisticService
import com.sd.uni.labpatologia.util.DiagnosticEnum;
import com.sd.uni.labpatologia.util.StatusEnum;

import grails.plugin.springsecurity.annotation.Secured

class ReportController {
	static allowedMethods = [save: "POST", update: "POST"]

	//service
	def IReportService reportService;
	def IRequestService requestService;
	def IDoctorService doctorService;
	def IPatientService patientService;
	def ILaboratoryService laboratoryService;
	def IStatisticService statisticService;
	@Autowired def IAuthService authService

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def index() {
		redirect(action: "list", params: params)
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def show() {
		def reportInstance = reportService.getById(Integer.parseInt(params.get("id")))
		[reportInstance: reportInstance,laboratoryInstanceList: laboratoryService.getAll(),
			user:authService.getName(), reportShow:params.get("reportShow")]
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def list() {
		def page = 0
		def siguiente
		if(null != params.get("page")){
			page = Integer.parseInt(params.get("page"))
		}
		def reports = null
		String textToFind="";
		if (params.containsKey("text")){
			textToFind= params.get("text");
		}else{

			if(null!=params.get("diagnosticSearch") && !"".equals(params.get("diagnosticSearch")) && !"null".equals(params.get("diagnosticSearch"))){
				textToFind+="diagnostic="+params.get("diagnosticSearch")+'&'
			}
			if((!"".equals(params.get("startSearch")) && !"".equals(params.get("endSearch"))) &&
			(null!=(params.get("startSearch")) && null!=params.get("endSearch"))){
				textToFind+="start="+params.get("startSearch")+'&'
				textToFind+="end="+params.get("endSearch")
			}else{
				if(null!=(params.get("startSearch")) && !"".equals(params.get("startSearch"))){
					textToFind+="date="+params.get("startSearch")
				}
			}
		}
		if(!textToFind.equals("")){
			reports = reportService.find(textToFind,10,page);
			siguiente = reportService.find(textToFind,10,page+1);
		}else{
			reports = reportService.find(null,10,page);
			siguiente = reportService.find(null,10,page+1);
		}
		System.out.println("Cantidad Reportes----------------------------->"+reports.size())
		[reportInstanceList: reports, reportInstanceTotal: reports?.size(), page: page, siguiente: siguiente?.size(),laboratoryInstanceList: laboratoryService.getAll(), text: textToFind,
			user:authService.getName()]
	}
	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR'
	])
	def create(Integer id) {
		def reportInstance = new ReportB(params)
		reportInstance.setRequest(requestService.getById(id))
		if((null!=reportInstance.request.patient._birthDate)){
			reportInstance.setAge(calculateAge(reportInstance.request.patient._birthDate));
		}
		[reportInstance: reportInstance,laboratoryInstanceList: laboratoryService.getAll(),
			user:authService.getName()] //, requests:requestService.getAll()]
	}
	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR'
	])
	def save() {

		def reportInstance = new ReportB(params)
		//request
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		reportInstance.setId(Integer.parseInt(params.get("requestId")));
		reportInstance.setDate(formatter.parse(formatter.format(new Date())));
		reportInstance.setRequest(requestService.getById(Integer.parseInt(params.get("requestId"))))
		reportInstance.setDiagnostic(DiagnosticEnum.valueOf(params.get("diagnostic")))
		reportInstance.setDiagnosticDetail((params.get("diagnosticDetail")))
		if((null!=params.get("age"))){
			reportInstance.setAge(Integer.parseInt(params.get("age")));
		}
		def requestInstance = requestService.getById(Integer.parseInt(params.get("requestId")))
		requestInstance.setStatus(StatusEnum.TERMINADO)
		reportInstance.setIsProcessed(false);
		//reportInstance.setAge(calculateAge(requestInstance.getPatient().getBirthDate()));
		def newReport= reportService.save(reportInstance)
		requestService.save(requestInstance)

		if (!newReport?.getId()) {
			//redirect(action: "list", id: newReport.getId())
			//return
		}
		redirect(action: "list", controller: "request")
	}
	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR'
	])
	def edit(Integer id) {
		def reportInstance = reportService.getById(Integer.parseInt(params.get("id")))
		def statisticId = ""
		if(null!= reportInstance.getStatistic()){
			statisticId = reportInstance.getStatistic().getId()
		}
		[reportInstance: reportInstance,laboratoryInstanceList: laboratoryService.getAll(),
			user:authService.getName(), reportEdit:params.get("reportEdit"), statisticId:statisticId, isProcessed:reportInstance._isProcessed]
	}
	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR'
	])
	def update(Integer id) {
		def reportInstance = new ReportB(params)
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		reportInstance.setDate(formatter.parse(formatter.format(new Date())));
		def requestInstance = requestService.getById(Integer.parseInt(params.get("requestId")))
		reportInstance.setRequest(requestInstance)
		reportInstance.setId(Integer.parseInt(params.get("edit")))
		reportInstance.setDiagnostic(DiagnosticEnum.valueOf(params.get("diagnostic")))
		reportInstance.setDiagnosticDetail(params.get("diagnosticDetail"))
		if(params.get("isProcessed")=="true"){
			def statisticInstance = statisticService.getById(Integer.parseInt(params.get("statisticId")))
			statisticInstance.setDiagnostic(DiagnosticEnum.valueOf(params.get("diagnostic")))
			statisticInstance.setId(Integer.parseInt(params.get("statisticId")))
			reportInstance.setStatistic(statisticService.save(statisticInstance))
			reportInstance.setIsProcessed(true)
		}else{
			reportInstance.setIsProcessed(false)
		}
		
		if((null!=params.get("age"))){
			reportInstance.setAge(Integer.parseInt(params.get("age")))
		}

		reportService.save(reportInstance)
		if(params.get("reportEdit").equals("request")){
			redirect(action: "list", controller: "request")
		}else{
			redirect(action: "list")
		}
	}


	private int calculateAge(Date birthDay) {
		Calendar fechaNac = Calendar.getInstance();
		fechaNac.setTime(birthDay);
		Calendar today = Calendar.getInstance();

		int diff_year = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
		int diff_month = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
		int diff_day = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

		if (diff_month < 0 || (diff_month == 0 && diff_day < 0)) {
			diff_year--;
		}
		return diff_year;
	}
}
