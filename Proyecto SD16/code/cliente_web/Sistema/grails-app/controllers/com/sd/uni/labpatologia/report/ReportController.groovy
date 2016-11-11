package com.sd.uni.labpatologia.report

import java.text.SimpleDateFormat;

import com.sd.uni.labpatologia.beans.report.ReportB
import com.sd.uni.labpatologia.service.report.IReportService;
import com.sd.uni.labpatologia.service.report.ReportServiceImpl;
import com.sd.uni.labpatologia.service.request.IRequestService;
import com.sd.uni.labpatologia.util.DiagnosticEnum;

class ReportController {
	static allowedMethods = [save: "POST", update: "POST"]
	
	//service
	def IReportService reportService;
	def IRequestService requestService;
	def index() {
		redirect(action: "list", params: params)
	}
	
	def list() {
		def reports = null
		String textToFind="";
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
		
		
		if(!textToFind.equals("")){
			reports = reportService.find(textToFind,10,0);
		}else{
			reports = reportService.find("all",10,0);
		}
		textToFind ="";
		System.out.println("Cantidad Reportes----------------------------->"+reports.size())
		[reportInstanceList: reports, reportInstanceTotal: reports?.size()]
	}
	
	def create(Integer id) {
		def reportInstance = new ReportB(params)
		reportInstance.setRequest(requestService.getById(id))
		[reportInstance: reportInstance] //, requests:requestService.getAll()]
	}
	def save(Integer id) {
		
		def reportInstance = new ReportB(params)
		//request
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		reportInstance.setDate(formatter.parse(formatter.format(new Date())));
		reportInstance.setRequest(requestService.getById(Integer.parseInt(params.get("requestId"))))
		def newReport= reportService.save(reportInstance)
		if (!newReport?.getId()) {
			//redirect(action: "list", id: newReport.getId())
			//return
		}
		redirect(action: "list", id: newReport.getId())
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
		[reportInstance: reportInstance]
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
