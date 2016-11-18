package sistema

import com.sd.uni.labpatologia.beans.article.ArticleB
import com.sd.uni.labpatologia.beans.patient.PatientB
import com.sd.uni.labpatologia.beans.request.RequestB
import com.sd.uni.labpatologia.service.article.IArticleService
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService;
import com.sd.uni.labpatologia.service.patient.IPatientService
import com.sd.uni.labpatologia.service.request.IRequestService
import com.sd.uni.labpatologia.util.StatusEnum;

import grails.gsp.PageRenderer
import grails.plugin.springsecurity.SpringSecurityUtils;
import grails.plugin.springsecurity.annotation.Secured;

class InicioController {
	def ILaboratoryService laboratoryService
	def IPatientService patientService
	def IArticleService articleService
	def IRequestService requestService

	@Secured(['ROLE_ADMINISTRADOR','ROLE_DOCTOR','ROLE_SECRETARIA','ROLE_TECNICO'])
	def index() {
		String text = "status=RECIBIDO"
		List<PatientB> patients = null
		List<ArticleB> articles = null
		List<RequestB> cantRecibido = null
		
		if (SpringSecurityUtils.ifNotGranted('ROLE_TECNICO')) {
			patients = patientService.getAll()
			cantRecibido = requestService.find(text,0,0)
		}
		
		if (SpringSecurityUtils.ifNotGranted('ROLE_SECRETARIA')) {
			articles = articleService.getAll()
		}
		
		[laboratoryInstanceList:laboratoryService.getAll(),
			patientInstanceList:patients,
			articleInstanceList:articles,
			requestInstanceList:cantRecibido]


	}

}