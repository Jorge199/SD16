package laboratory;

import com.sd.uni.labpatologia.dto.laboratory.LaboratoryDto;

import com.sd.uni.labpatologia.dto.laboratory.LaboratoryResult;

import base.AbstractBaseManager;

public class LaboratoryManager extends AbstractBaseManager {
	public LaboratoryManager() {
		super();
	}
	/* crear */
	public void addLaboratory(String nombre, String address, String email, String logo, String phone) {
		LaboratoryDto laboratoryDTO = new LaboratoryDto();
		laboratoryDTO.setName(nombre);
		laboratoryDTO.setAddress(address);
		laboratoryDTO.setEmail(email);
		laboratoryDTO.setLogo(logo);
		laboratoryDTO.setPhone(phone);

		getJerseyClient().resource(getBaseUrl() + "/laboratory").entity(laboratoryDTO).post(LaboratoryDto.class);
	}
	
	/* obtener todo */
	public void getAllLaboratory() {
		LaboratoryResult laboratoryResult = getJerseyClient().resource(getBaseUrl() + "/laboratory").get(LaboratoryResult.class);
		for (LaboratoryDto c : laboratoryResult.getLaboratories()) {
			System.out.println(c.getName());
			System.out.println(c.getAddress());
			System.out.println(c.getEmail());
			System.out.println(c.getLogo());
			System.out.println(c.getPhone());
		}
	}
	
	/* obtener por id */
	public void getByIdLaboratory(int id){
		LaboratoryDto laboratoryResult = getJerseyClient().resource(getBaseUrl() + "/laboratory/"+id).get(LaboratoryDto.class);
		System.out.println(laboratoryResult.getName());
		System.out.println(laboratoryResult.getAddress());
		System.out.println(laboratoryResult.getEmail());
		System.out.println(laboratoryResult.getLogo());
		System.out.println(laboratoryResult.getPhone());
	}
	/* encontrar por alguna propiedad */
	public void getByPropertyLaboratory(String textToFind){
		// ejemplo buscar por propiedad direccion
		LaboratoryResult laboratoryResult = getJerseyClient().resource(getBaseUrl() + "/laboratory/search/"+textToFind).get(LaboratoryResult.class);
		for (LaboratoryDto c : laboratoryResult.getLaboratories()) {
			System.out.println(c.getName());
			System.out.println(c.getAddress());
			System.out.println(c.getEmail());
			System.out.println(c.getPhone());
		}
		
	}
	
}
