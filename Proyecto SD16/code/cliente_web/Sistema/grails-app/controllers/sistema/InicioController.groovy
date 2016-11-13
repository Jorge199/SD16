package sistema

import com.sd.uni.labpatologia.service.article.IArticleService
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService;
import com.sd.uni.labpatologia.service.patient.IPatientService
import com.sd.uni.labpatologia.service.request.IRequestService

import grails.gsp.PageRenderer

class InicioController {
	def ILaboratoryService laboratoryService
	def IPatientService patientService
	def IArticleService articleService
	def IRequestService requestService
    def index() { 
		[laboratoryInstanceList:laboratoryService.getAll(),
			patientInstanceList:patientService.getAll(),
			articleInstanceList:articleService.getAll(),
			requestInstanceList:requestService.getAll()]
	}
	
}