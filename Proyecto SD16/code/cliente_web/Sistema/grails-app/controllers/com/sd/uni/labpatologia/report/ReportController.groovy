package com.sd.uni.labpatologia.report

import java.text.SimpleDateFormat;

import com.sd.uni.labpatologia.beans.report.ReportB
import com.sd.uni.labpatologia.service.doctor.IDoctorService;
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService
import com.sd.uni.labpatologia.service.patient.IPatientService;
import com.sd.uni.labpatologia.service.report.IReportService;
import com.sd.uni.labpatologia.service.report.ReportServiceImpl;
import com.sd.uni.labpatologia.service.request.IRequestService;
import com.sd.uni.labpatologia.util.DiagnosticEnum;
import com.sd.uni.labpatologia.util.StatusEnum;

class ReportController {
	static allowedMethods = [save: "POST", update: "POST"]
	
	//service
	def IReportService reportService;
	def IRequestService requestService;
	def IDoctorService doctorService;
	def IPatientService patientService;
	def ILaboratoryService laboratoryService;
	def index() {
		redirect(action: "list", params: params)
	}
	
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
		[reportInstanceList: reports, reportInstanceTotal: reports?.size(), page: page, siguiente: siguiente?.size(),laboratoryInstanceList: laboratoryService.getAll(), text: textToFind]
	}
	
	def create(Integer id) {
		def reportInstance = new ReportB(params)
		reportInstance.setRequest(requestService.getById(id))
		[reportInstance: reportInstance,laboratoryInstanceList: laboratoryService.getAll()] //, requests:requestService.getAll()]
	}
	def save(Integer id) {
		
		def reportInstance = new ReportB(params)
		//request
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		reportInstance.setDate(formatter.parse(formatter.format(new Date())));
		reportInstance.setRequest(requestService.getById(Integer.parseInt(params.get("requestId"))))
		reportInstance.setDiagnostic(DiagnosticEnum.valueOf(params.get("diagnostic")))
		def requestInstance = requestService.getById(Integer.parseInt(params.get("requestId")))
		requestInstance.setStatus(StatusEnum.TERMINADO)
		requestService.save(requestInstance)
		System.out.println(reportInstance.diagnostic)
		def newReport= reportService.save(reportInstance)
		if (!newReport?.getId()) {
			//redirect(action: "list", id: newReport.getId())
			//return
		}
		redirect(action: "list", controller: "request")
	}
	
	def edit(Integer id) {
		def reportInstance = reportService.getById(Integer.parseInt(params.get("id")))
				//si no existe esa id
				if (!reportInstance) {
					flash.message = message(code: 'default.not.found.message', args: [
						message(code: 'report.label', default: 'Report'),
						id
					])
					redirect(action: "list")
					return
				}
		[reportInstance: reportInstance,laboratoryInstanceList: laboratoryService.getAll()]
	}
	
	def update(Integer id) {
		def reportInstance = new ReportB(params)
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		reportInstance.setDate(formatter.parse(formatter.format(new Date())));
		reportInstance.setRequest(requestService.getById(Integer.parseInt(params.get("requestId"))))
		reportInstance.setId(Integer.parseInt(params.get("edit")))
		reportInstance.setDiagnostic(DiagnosticEnum.valueOf(params.get("diagnostic")))
		reportService.save(reportInstance)
		redirect(action: "list")
	}
}
