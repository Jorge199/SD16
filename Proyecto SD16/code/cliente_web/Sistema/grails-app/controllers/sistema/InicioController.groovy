
package sistema

import org.springframework.beans.factory.annotation.Autowired;

import grails.plugin.springsecurity.SpringSecurityService;
import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.annotation.Secured

import com.sd.uni.labpatologia.beans.article.ArticleB
import com.sd.uni.labpatologia.beans.doctor.DoctorB
import com.sd.uni.labpatologia.beans.patient.PatientB
import com.sd.uni.labpatologia.beans.request.RequestB
import com.sd.uni.labpatologia.service.article.IArticleService
import com.sd.uni.labpatologia.service.auth.IAuthService;
import com.sd.uni.labpatologia.service.doctor.IDoctorService
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService
import com.sd.uni.labpatologia.service.patient.IPatientService
import com.sd.uni.labpatologia.service.request.IRequestService

class InicioController {
	def ILaboratoryService laboratoryService
	def IPatientService patientService
	def IArticleService articleService
	def IRequestService requestService
	def IDoctorService doctorService
	@Autowired def IAuthService authService
	@Secured([
		'ROLE_ADMINISTRADOR',
		'ROLE_DOCTOR',
		'ROLE_SECRETARIA',
		'ROLE_TECNICO'
	])
	def index() {
		String text = "status=RECIBIDO"
		int patientCount;
		int articleCount;
		int requestCount;
		int doctorCount;

		if (SpringSecurityUtils.ifNotGranted('ROLE_TECNICO')) {
			patientCount = patientService.getCount()
			requestCount = requestService.getCount()
			doctorCount = doctorService.getCount()
		}

		if (SpringSecurityUtils.ifNotGranted('ROLE_SECRETARIA')) {
			articleCount = articleService.getCount()
		}

		[laboratoryInstanceList:laboratoryService.getAll(),
			patientCount:patientCount,
			articleCount:articleCount,
			requestCount:requestCount,
			doctorCount: doctorCount,
			user:authService.getName()]
	}
}