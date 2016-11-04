package src.study_type;

import com.sd.uni.labpatologia.dto.study_type.StudyTypeDTO;
import com.sd.uni.labpatologia.dto.study_type.StudyTypeResult;

import src.base.AbstractBaseManager;

public class StudyTypeManager extends AbstractBaseManager{
	
	public StudyTypeManager() {
		super();
	}

	public void addStudy(String name, String description) {
		StudyTypeDTO estudioDTO = new StudyTypeDTO();
		estudioDTO.setName(name);
		estudioDTO.setDescription(description);
		
		getJerseyClient().resource(getBaseUrl() + "/study_type").entity(estudioDTO).post(StudyTypeDTO.class);
	}
	
	public void getAllStudies() {
		StudyTypeResult estudioResult = getJerseyClient().resource(getBaseUrl() + "/study_type").get(StudyTypeResult.class);
		for (StudyTypeDTO r : estudioResult.getStudies()) {
			System.out.print("id: "+r.getId());
			System.out.print("\tnombre "+ r.getName());
			System.out.print("\tdescripcion "+r.getDescription());
		}
	}
	
	public void getById(int id) {
		StudyTypeDTO study = getJerseyClient().resource(getBaseUrl() + "/study_type/"+id).get(StudyTypeDTO.class);
		System.out.print("id: "+study.getId());
		System.out.print("\tnombre "+ study.getName());
		System.out.print("\tdescripcion "+study.getDescription());
	}
	public void getByPropertyStudyType(String textToFind){
		// ejemplo buscar por propiedad direccion
		StudyTypeResult studyTypeResult = getJerseyClient().resource(getBaseUrl() + "/study_type/search/"+textToFind).get(StudyTypeResult.class);
		for (StudyTypeDTO c : studyTypeResult.getStudies()) {
			System.out.println(c.getName());
			System.out.println(c.getDescription());
		}
	}
	
}
