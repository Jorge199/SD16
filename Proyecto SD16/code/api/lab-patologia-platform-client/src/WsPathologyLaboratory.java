
import laboratory.LaboratoryManager;

public class WsPathologyLaboratory {

	public static void main(String[] args) {
		laboratoryManager();
	}
	
	private static void laboratoryManager(){
		System.out.println("###### LABORATORIO #####");
		
		LaboratoryManager laboratoryManager = new LaboratoryManager();
		System.out.println("##### Agregar datos #####");
		laboratoryManager.addLaboratory("patologia","centro","patologia@email.com","192030");
		laboratoryManager.addLaboratory("clinica","alborada","clinica@email.com","192030");
		
		System.out.println("##### Buscar por id #####");
		laboratoryManager.getByIdLaboratory(1);
		
		System.out.println("##### Mostrar todos los datos #####");
		laboratoryManager.getAllLaboratory();
		
		System.out.println("##### Buscar por propiedades #####");
		laboratoryManager.getByPropertyLaboratory("centro");
	}

}