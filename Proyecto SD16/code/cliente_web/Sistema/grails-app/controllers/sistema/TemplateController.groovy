package sistema

import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService;

class TemplateController {
	def ILaboratoryService laboratoryService
    def index() {
		def laboratoryInstanceList = laboratoryService.getAll()
		[laboratoryInstanceList:laboratoryInstanceList]
	}
}
