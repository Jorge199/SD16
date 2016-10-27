package laboratory;
import com.sd.uni.labpatologia.dto.laboratorio.LaboratorioDto;
import com.sd.uni.labpatologia.dto.laboratorio.LaboratorioResult;

import base.AbstractBaseManager;

public class LaboratoryManager extends AbstractBaseManager {
	public LaboratoryManager() {
		super();
	}
	/* crear */
	public void addLab() {
		LaboratorioDto labDTO = new LaboratorioDto();
		labDTO.setName("Laboratorio");
		labDTO.setAddress("alborada");
		labDTO.setEmail("lab@email.com");
		labDTO.setLogo("no");
		labDTO.setPhone("201020");

		getJerseyClient().resource(getBaseUrl() + "/laboratory").entity(labDTO).post(LaboratorioDto.class);
	}
	
	/* obtener todo */
	public void getAllLab() {
		LaboratorioResult labResult = getJerseyClient().resource(getBaseUrl() + "/laboratory").get(LaboratorioResult.class);
		for (LaboratorioDto c : labResult.getLaboratory()) {
			System.out.println(c.getName());
		}
	}
	
	/* obtener por id */
	public void getById(){
		LaboratorioDto labResult = getJerseyClient().resource(getBaseUrl() + "/laboratory/1").get(LaboratorioDto.class);
		System.out.println(labResult.getName());
		System.out.println(labResult.getAddress());
		System.out.println(labResult.getEmail());
		System.out.println(labResult.getLogo());
		System.out.println(labResult.getPhone());
	}
	/* encontrar por alguna propiedad */
	public void getByProperty(){
		// ejemplo buscar por propiedad direccion
		LaboratorioResult labResult = getJerseyClient().resource(getBaseUrl() + "/laboratory/search/kennedy").get(LaboratorioResult.class);
		for (LaboratorioDto c : labResult.getLaboratory()) {
			System.out.println(c.getName());
			System.out.println(c.getAddress());
			System.out.println(c.getEmail());
			System.out.println(c.getPhone());
		}
		
	}
	
}
