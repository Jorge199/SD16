package src.laboratory;

import com.sd.uni.labpatologia.dto.laboratory.LaboratoryDto;
import com.sd.uni.labpatologia.dto.laboratory.LaboratoryResult;

import src.base.AbstractBaseManager;

public class LaboratoryManager extends AbstractBaseManager {
	public LaboratoryManager() {
		super();
	}
	/* crear */
	public void addLaboratory(String nombre, String address, String email, String phone) {
		LaboratoryDto laboratoryDTO = new LaboratoryDto();
		laboratoryDTO.setName(nombre);
		laboratoryDTO.setAddress(address);
		laboratoryDTO.setEmail(email);
		laboratoryDTO.setPhone(phone);

		getJerseyClient().resource(getBaseUrl() + "/laboratory").entity(laboratoryDTO).post(LaboratoryDto.class);
	}
	
	/* obtener todo */
	public void getAllLaboratory() {
		LaboratoryResult laboratoryResult = getJerseyClient().resource(getBaseUrl() + "/laboratory").get(LaboratoryResult.class);
		for (LaboratoryDto c : laboratoryResult.getLaboratories()) {
			System.out.println("Nombre: "+c.getName());
			System.out.println("Direccion: "+c.getAddress());
			System.out.println("Correo: "+c.getEmail());
			System.out.println("Telefono: "+c.getPhone());
		}
	}
	
	/* obtener por id */
	public void getByIdLaboratory(int id){
		LaboratoryDto laboratory = getJerseyClient().resource(getBaseUrl() + "/laboratory/"+id).get(LaboratoryDto.class);
		System.out.println("Nombre: "+laboratory.getName());
		System.out.println("Direccion: "+laboratory.getAddress());
		System.out.println("Correo: "+laboratory.getEmail());
		System.out.println("Telefono: "+laboratory.getPhone());
	}
	/* encontrar por alguna propiedad */
	public void getByPropertyLaboratory(String textToFind){
		// ejemplo buscar por propiedad direccion
		LaboratoryResult laboratoryResult = getJerseyClient().resource(getBaseUrl() + "/laboratory/search/"+textToFind).get(LaboratoryResult.class);
		for (LaboratoryDto c : laboratoryResult.getLaboratories()) {
			System.out.println("Nombre: "+c.getName());
			System.out.println("Direccion: "+c.getAddress());
			System.out.println("Correo: "+c.getEmail());
			System.out.println("Telefono: "+c.getPhone());
		}
		
	}
	
}
