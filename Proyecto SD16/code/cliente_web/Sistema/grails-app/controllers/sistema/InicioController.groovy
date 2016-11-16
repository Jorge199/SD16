package sistema

import com.sd.uni.labpatologia.service.article.IArticleService
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService;
import com.sd.uni.labpatologia.service.patient.IPatientService
import com.sd.uni.labpatologia.service.request.IRequestService
import com.sd.uni.labpatologia.util.StatusEnum;

import grails.gsp.PageRenderer

class InicioController {
	def ILaboratoryService laboratoryService
	def IPatientService patientService
	def IArticleService articleService
	def IRequestService requestService
    def index() { 
		String text = "status=RECIBIDO"
		
		def cantRecibido = requestService.find(text,0,0)
		[laboratoryInstanceList:laboratoryService.getAll(),
			patientInstanceList:patientService.getAll(),
			articleInstanceList:articleService.getAll(),
			requestInstanceList:cantRecibido]
	}
	
}