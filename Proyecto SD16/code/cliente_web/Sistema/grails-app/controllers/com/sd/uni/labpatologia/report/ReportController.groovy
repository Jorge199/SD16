package com.sd.uni.labpatologia.report

import java.text.SimpleDateFormat;

import com.sd.uni.labpatologia.beans.report.ReportB
import com.sd.uni.labpatologia.service.report.IReportService;
import com.sd.uni.labpatologia.service.report.ReportServiceImpl;

class ReportController {
	static allowedMethods = [save: "POST", update: "POST"]
	
	//service
	def IReportService reportService;
	//def IRequestService requestService;
	def index() {
		redirect(action: "list", params: params)
	}
	
	def list(Integer max) {
		
		def reports = reportService.getAll()
		System.out.println("Cantidad Reportes----------------------------->"+reports.size())
		[reportInstanceList: reports, reportInstanceTotal: reports?.size()]
	}
	
	def create() {
		[reportInstance: new ReportB(params)]//, requests:requestService.getAll()]
	}
	def save() {
		def reportInstance = new ReportB(params)
		//request
		//clientInstance.setCity(cityService.getById(Integer.valueOf(params.cityId)))
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		reportInstance.setDate(formatter.parse(formatter.format(new Date())));
		def newReport= reportService.save(reportInstance)
		if (!newReport?.getId()) {
			render(view: "create", model: [reportInstance: reportInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'report.label', default: 'Report'),
			newReport.getId()
		])
		redirect(action: "edit", id: newReport.getId())
	}
	
	def edit(Integer id) {
		def reportInstance = reportService.getById(id)
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
	
	def update(Long id, Long version) {
		def reportInstance = reportService.getById(id)
		if (!reportInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'report.label', default: 'Report'),
				id
			])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (reportInstance.version > version) {
				reportInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[
							message(code: 'report.label', default: 'Report')] as Object[],
						"Another user has updated this Report while you were editing")
				render(view: "edit", model: [reportInstance: reportInstance])
				return
			}
		}

		reportInstance.properties = params

		if (!reportInstance.save(flush: true)) {
			render(view: "edit", model: [reportInstance: reportInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [
			message(code: 'report.label', default: 'Report'),
			reportInstance.id
		])
		redirect(action: "show", id: reportInstance.id)
	}

	def delete(Integer id) {
		System.out.println("entro en delete");
		def reportInstance = reportService.getById(id)
		if (!reportInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'client.label', default: 'Report'),
				id
			])
			redirect(action: "list")
			return
		}
		System.out.println("entro en delete");
			reportInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
				message(code: 'report.label', default: 'Report'),
				id
			])
			redirect(action: "list")
	
			System.out.println("entro en delete");
		
	}
}
