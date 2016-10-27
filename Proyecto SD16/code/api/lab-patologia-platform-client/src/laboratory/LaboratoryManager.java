package laboratory;

import com.sd.uni.labpatologia.dto.laboratory.LaboratoryDto;

import com.sd.uni.labpatologia.dto.laboratory.LaboratoryResult;

import base.AbstractBaseManager;

public class LaboratoryManager extends AbstractBaseManager {
	public LaboratoryManager() {
		super();
	}
	/* crear */
	public void addLaboratory() {
		LaboratoryDto laboratoryDTO = new LaboratoryDto();
		laboratoryDTO.setName("Laboratorio");
		laboratoryDTO.setAddress("alborada");
		laboratoryDTO.setEmail("lab@email.com");
		laboratoryDTO.setLogo("no");
		laboratoryDTO.setPhone("201020");

		getJerseyClient().resource(getBaseUrl() + "/laboratory").entity(laboratoryDTO).post(LaboratoryDto.class);
	}
	
	/* obtener todo */
	public void getAllLaboratory() {
		LaboratoryResult laboratoryResult = getJerseyClient().resource(getBaseUrl() + "/laboratory").get(LaboratoryResult.class);
		for (LaboratoryDto c : laboratoryResult.getLaboratories()) {
			System.out.println(c.getName());
		}
	}
	
	/* obtener por id */
	public void getByIdLaboratory(){
		LaboratoryDto laboratoryResult = getJerseyClient().resource(getBaseUrl() + "/laboratory/1").get(LaboratoryDto.class);
		System.out.println(laboratoryResult.getName());
		System.out.println(laboratoryResult.getAddress());
		System.out.println(laboratoryResult.getEmail());
		System.out.println(laboratoryResult.getLogo());
		System.out.println(laboratoryResult.getPhone());
	}
	/* encontrar por alguna propiedad */
	public void getByPropertyLaboratory(){
		// ejemplo buscar por propiedad direccion
		LaboratoryResult laboratoryResult = getJerseyClient().resource(getBaseUrl() + "/laboratory/search/kennedy").get(LaboratoryResult.class);
		for (LaboratoryDto c : laboratoryResult.getLaboratories()) {
			System.out.println(c.getName());
			System.out.println(c.getAddress());
			System.out.println(c.getEmail());
			System.out.println(c.getPhone());
		}
		
	}
	
}
