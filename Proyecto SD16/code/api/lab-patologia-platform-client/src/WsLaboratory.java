import laboratory.LaboratoryManager;

public class WsLaboratory {

	public static void main(String[] args) {
		LaboratoryManager laboratoryManager = new LaboratoryManager();
		System.out.println("Agregar datos");
		//laboratoryManager.addLaboratory("Patologia","centro","patologia@email.com","logo.png","192030");
		
		System.out.println("Buscar por id");
		//laboratoryManager.getByIdLaboratory(1);
		
		System.out.println("Mostrar todos los datos");
		//laboratoryManager.getAllLaboratory();
		
		System.out.println("Buscar por propiedades");
		laboratoryManager.getByPropertyLaboratory("centro");

	}

}
