package com.sd.uni.labpatologia.statistic

import org.springframework.beans.factory.annotation.Autowired;

import com.sd.uni.labpatologia.service.auth.IAuthService;
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService;
import com.sd.uni.labpatologia.service.request.IRequestService;
import com.sd.uni.labpatologia.service.statistic.IStatisticService;
import com.sd.uni.labpatologia.util.DiagnosticEnum;

import grails.plugin.springsecurity.annotation.Secured;

class StatisticController {

	def ILaboratoryService laboratoryService
	def IStatisticService statisticService
	@Autowired def IAuthService authService
	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR'
	])
	def index() {
		redirect(action: "list",params: params)
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR'
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
		
		//Si la consulta no esta vacia
		if(!textToFind.equals("")){
			System.out.println(textToFind)
			System.out.println(data)
			System.out.println(params)
			
			//Si no especifica el sexo entonces busca todos los sexos
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
			//Si no especifica un diagnostico entonces busca todos los diagnosticos
			if(data.get("getByDiagnostic")=='false'){
				int totalDiagnostic=0
				for(DiagnosticEnum diagnostic in DiagnosticEnum.values()){
					data.put(diagnostic.getKey(), statisticService.find("diagnostic="+diagnostic.getKey()+'&'+textToFind).size())
					totalDiagnostic+=data.get(diagnostic.getKey())
				}
				data.put("totalDiagnostic", totalDiagnostic)
			}else{
				int totalDiagnostic=0
				String diagnosticTextToFind = ""
				if(textToFind.indexOf('&')+1==textToFind.length()){
					diagnosticTextToFind=""
				}else{
					diagnosticTextToFind=textToFind.substring(textToFind.indexOf('&')+1,textToFind.length())
				}
				for(DiagnosticEnum diagnostic in DiagnosticEnum.values()){
					if(data.get("getByDiagnostic")==diagnostic.getKey()){
						data.put(diagnostic.getKey(), statisticService.find("diagnostic="+diagnostic.getKey()+'&'+diagnosticTextToFind).size())
						System.out.println(diagnostic.getKey() + " " + data.get(diagnostic.getKey()))
					}
					totalDiagnostic+=statisticService.find("diagnostic="+diagnostic.getKey()+'&'+diagnosticTextToFind).size()
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
		[user:authService.getName(), laboratoryInstanceList: laboratoryService.getAll(), dataMap: data]
	}
}
