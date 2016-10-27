package study_type;

import com.sd.uni.labpatologia.dto.estudio.EstudioDTO;
import com.sd.uni.labpatologia.dto.estudio.EstudioResult;
import com.sd.uni.labpatologia.dto.report.ReportDTO;
import com.sd.uni.labpatologia.dto.report.ReportResult;

import base.AbstractBaseManager;

public class StudyTypeManager extends AbstractBaseManager{
	
	public StudyTypeManager() {
		super();
	}

	public void addStudy(String name, String description) {
		EstudioDTO estudioDTO = new EstudioDTO();
		estudioDTO.setName(name);
		estudioDTO.setDescription(description);
	}
	
	public void getAllStudies() {
		EstudioResult estudioResult = getJerseyClient().resource(getBaseUrl() + "/estudio").get(EstudioResult.class);
		for (EstudioDTO r : estudioResult.getEstudios()) {
			System.out.print("id: "+r.getId());
			System.out.print("\tnombre "+ r.getName());
			System.out.print("\tdescripcion "+r.getDescription());
		}
	}
	
	public void getById(int id) {
		EstudioDTO study = getJerseyClient().resource(getBaseUrl() + "/estudio/"+id).get(EstudioDTO.class);
		System.out.print("id: "+study.getId());
		System.out.print("\tnombre "+ study.getName());
		System.out.print("\tdescripcion "+study.getDescription());
	}
	
}
