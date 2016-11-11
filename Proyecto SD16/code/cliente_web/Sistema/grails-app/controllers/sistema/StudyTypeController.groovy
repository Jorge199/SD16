package sistema

import com.sd.uni.labpatologia.beans.study_type.StudyTypeB
import com.sd.uni.labpatologia.service.study_type.IStudyTypeService
import com.sd.uni.labpatologia.service.study_type.StudyTypeServiceImpl
import org.springframework.dao.DataIntegrityViolationException

class StudyTypeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    
    def IStudyTypeService studyTypeService = new StudyTypeServiceImpl();
    
    def index() {
        redirect(action: "list", params: params)
    }
    
def list() {
        def text = params.text
		def studies = null
		if(null != text && !"".equals(text)){
			studies = studyTypeService.find(text)
			System.out.println("ingresado"+text)
			System.out.println("busqueda"+studies)
		}else{
			studies = studyTypeService.getAll()
		}
			
		System.out.println("Cantidad de Estudios----------------------------->" + studies.size())
        [studyTypeInstanceList: studies, studyTypeInstanceTotal: studies.size()]
    }
    
    def create() {
        [studyTypeInstance: new StudyTypeB(params)]
    }
    
    def save() {
        def studyTypeInstance = new StudyTypeB(params)
        def newStudyType = studyTypeService.save(studyTypeInstance)
        if (!newStudyType?.getId()) {
            render(view: "create", model: [studyTypeInstance: studyTypeInstance])
            return
        }
        
        flash.message = message(code: 'default.created.message', args: [
                message(code: 'studyType.label', default: 'StudyType'),
                newStudyType.getId()
            ])
        redirect(action: "show", id: newStudyType.getId())
    }
    
    def show(Long id) {
        def studyTypeInstance = studyTypeService.getById(id.intValue())
        if (!studyTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'studyType.label', default: 'StudyType'),
                    id
                ])
            redirect(action: "list")
            return
        }
        
        [studyTypeInstance: studyTypeInstance]
    }
    
    def edit(Long id) {
        def studyTypeInstance = studyTypeService.getById(id.intValue())
        if (!studyTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'studyType.label', default: 'StudyType'),
                    id
                ])
            redirect(action: "list")
            return
        }
        
        [studyTypeInstance: studyTypeInstance]
    }
    
    def delete(Long id) {
        def studyTypeInstance = studyTypeService.getById(id.intValue())
        if (!studyTypeInstancecityInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'studyType.label', default: 'StudyType'),
                    id
                ])
            redirect(action: "list")
            return
        }
        try {
            studyTypeInstancecityInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [
                    message(code: 'studyType.label', default: 'StudyType'),
                    id
                ])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [
                    message(code: 'studyType.label', default: 'StudyType'),
                    id
                ])
            redirect(action: "show", id: id)
        }
    }
    
    def update(Integer id) {
        def studyTypeInstance = new StudyTypeB(params)
        System.out.println("ID ==== " + params)
        studyTypeInstance.setId(Integer.parseInt(params.get("edit")))
        studyTypeInstance.setName(params.get("name"))
        studyTypeInstance.setDescription(params.get("description"))
        studyTypeService.save(studyTypeInstance)
        redirect(action: "list")
    }
}