package request;

import java.util.Date;

import base.AbstractBaseManager;

import com.sd.uni.labpatologia.dto.request.RequestDTO;
import com.sd.uni.labpatologia.dto.request.RequestResult;

public class RequestManager extends AbstractBaseManager {
	public RequestManager() {
		super();
	}
	
	/* crear un nuevo registro */
	public void addRequest() {
		RequestDTO dto = new RequestDTO();
		dto.setDoctorId(2);
		dto.setStudyId(3);
		dto.setNote("estudio");
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
	public void getById(){
		RequestDTO r = getJerseyClient().resource(getBaseUrl() + "/request/1").get(RequestDTO.class);
		System.out.println(r.getPatientId());
		System.out.println(r.getDoctorId());
		System.out.println(r.getStudyId());
		System.out.println(r.getNote());
		System.out.println(r.getDate());
	}
	/* encontrar por alguna propiedad */
	public void getByProperty(){
		RequestResult requestResult = getJerseyClient().resource(getBaseUrl() + "/request/search/estudio").get(RequestResult.class);
		for (RequestDTO r : requestResult.getRequests()) {
			System.out.println(r.getPatientId());
			System.out.println(r.getDoctorId());
			System.out.println(r.getStudyId());
			System.out.println(r.getNote());
			System.out.println(r.getDate());
		}
	}
	
	public static void main(String[] args) {
		RequestManager manager = new RequestManager();
		// manager.getById();
		 manager.addRequest();
		// manager.getAll();
		//manager.getByProperty();

	}
	
}

