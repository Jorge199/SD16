package request;

import java.util.Date;

import com.sd.uni.labpatologia.dto.request.RequestDTO;
import com.sd.uni.labpatologia.dto.request.RequestResult;

import base.AbstractBaseManager;

public class RequestManager extends AbstractBaseManager {
	public RequestManager() {
		super();
	}
	
	/* crear un nuevo registro */
	public void addRequest(int idPatient, int idDoctor, int idStudy, String note) {
		RequestDTO dto = new RequestDTO();
		dto.setPatientId(idPatient);
		dto.setDoctorId(idDoctor);
		dto.setStudyId(idStudy);
		dto.setNote(note);
		dto.setDate(new Date());

		getJerseyClient().resource(getBaseUrl() + "/request").entity(dto).post(RequestDTO.class);
	}
	
	/* obtener todo */
	public void getAll() {
		RequestResult requestResult = getJerseyClient().resource(getBaseUrl() + "/request").get(RequestResult.class);
		for (RequestDTO r : requestResult.getRequests()) {
			System.out.println(r.getPatientId());
			System.out.println(r.getDoctorId());
			System.out.println(r.getStudyId());
			System.out.println(r.getNote());
			System.out.println(r.getDate());
		}
	}
	
	/* obtener por id */
	public void getById(int id){
		RequestDTO r = getJerseyClient().resource(getBaseUrl() + "/request/"+id).get(RequestDTO.class);
		System.out.println(r.getId());
		System.out.println(r.getPatientId());
		System.out.println(r.getDoctorId());
		System.out.println(r.getStudyId());
		System.out.println(r.getNote());
		System.out.println(r.getDate());
	}
	
	
	/* encontrar por alguna propiedad */
	public void getByProperty(String textToFind){
		RequestResult requestResult = getJerseyClient().resource(getBaseUrl() + "/request/search/"+textToFind).get(RequestResult.class);
		for (RequestDTO r : requestResult.getRequests()) {
			System.out.println(r.getId());
			System.out.println(r.getPatientId());
			System.out.println(r.getDoctorId());
			System.out.println(r.getStudyId());
			System.out.println(r.getNote());
			System.out.println(r.getDate());
		}
	}
	
	
	
}

