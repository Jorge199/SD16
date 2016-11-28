package com.sd.uni.labpatologia.statistic

import com.sd.uni.labpatologia.service.request.IRequestService;
import com.sd.uni.labpatologia.service.statistic.IStatisticService;
import com.sd.uni.labpatologia.util.DiagnosticEnum;

import grails.plugin.springsecurity.annotation.Secured;

class StatisticController {

	def IStatisticService statisticService
	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def index() {
		redirect(action: "list",params: params)
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def list() {
		def statistics = null
		def data = [getByDate: 'false', getByDiagnostic: 'false', getByPatientAge: 'false', getBySex:'false']
		String textToFind=""
		if(null!=params.get("diagnosticSearch") && !"".equals(params.get("diagnosticSearch")) && !"null".equals(params.get("diagnosticSearch"))){
			textToFind+="diagnostic="+params.get("diagnosticSearch")+'&'
			data.put("getByDiagnostic", params.get("diagnosticSearch"))
		}
		if((!"".equals(params.get("startSearch"))) && !"".equals(params.get("endSearch")) && (null != params.get("startSearch")) && (null != params.get("endSearch"))){
			textToFind+="start="+params.get("startSearch")+'&'
			textToFind+="end="+params.get("endSearch")+'&'
			data.put("getByDate", "true")
			data.put("startDate", params.get("startSearch"))
			data.put("endDate", params.get("endSearch"))
		}

		if((!"".equals(params.get("startAge"))) && !"".equals(params.get("endAge")) && (null != params.get("startAge")) && (null != params.get("endAge"))){
			textToFind+="startAge="+params.get("startAge")+'&'
			textToFind+="endAge="+params.get("endAge")+'&'
			data.put("getByPatientAge", "true")
			data.put("startAge", params.get("startAge"))
			data.put("endAge", params.get("endAge"))
		}
		if(null!=params.get("sex") && !"".equals(params.get("sex")) && !"null".equals(params.get("sex"))){
			textToFind+="sex="+params.get("sex")
			data.put("getBySex", params.get("sex"))
		}
		if(!textToFind.equals("")){
			System.out.println(textToFind)
			System.out.println(data)
			System.out.println(params)
			

			if(data.get("getBySex")=='false'){
				int totalSex=0
				statistics = statisticService.find("sex=MASCULINO&"+textToFind)
				data.put("masculino", statistics.size())
				totalSex+=statistics.size()

				statistics = statisticService.find("sex=FEMENINO&"+textToFind)
				data.put("femenino", statistics.size())
				totalSex+=statistics.size()

				data.put("totalSex",totalSex)
			}
			if(data.get("getByDiagnostic")=='false'){
				int totalDiagnostic=0
				for(DiagnosticEnum diagnostic in DiagnosticEnum.values()){
					data.put(diagnostic.getKey(), statisticService.find("diagnostic="+diagnostic.getKey()+'&'+textToFind).size())
					totalDiagnostic+=data.get(diagnostic.getKey())
				}
				data.put("totalDiagnostic", totalDiagnostic)
			}else{
				int totalDiagnostic=0
				for(DiagnosticEnum diagnostic in DiagnosticEnum.values()){
					if(data.get("getByDiagnostic")==diagnostic.getKey()){
						data.put(diagnostic.getKey(), statisticService.find("diagnostic="+diagnostic.getKey()+'&'+textToFind).size())
					}
					totalDiagnostic+=statisticService.find("diagnostic="+diagnostic.getKey()+'&'+textToFind).size()
				}
				data.put("totalDiagnostic", totalDiagnostic)
			}
			statistics = statisticService.find(textToFind)
		}else{
			//Si esta vacio entonces obtiene todas las cantidades de diagnosticos y sexos de todos los tiempos
			int totalSex=0, totalDiagnostic = 0

			//Para sexo
			statistics = statisticService.find("sex=MASCULINO")
			data.put("masculino", statistics.size())
			totalSex+=statistics.size()

			statistics = statisticService.find("sex=FEMENINO")
			data.put("femenino", statistics.size())
			totalSex+=statistics.size()

			data.put("totalSex",totalSex)

			//Para Diagnóstico
			for(DiagnosticEnum diagnostic in DiagnosticEnum.values()){
				data.put(diagnostic.getKey(), statisticService.find("diagnostic="+diagnostic.getKey()).size())
				totalDiagnostic+=data.get(diagnostic.getKey())
			}
			data.put("totalDiagnostic", totalDiagnostic)
		}
		[dataMap: data]
	}
}
