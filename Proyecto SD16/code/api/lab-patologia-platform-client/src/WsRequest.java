import request.RequestManager;


public class WsRequest {
	public static void main(String[] args) {
		RequestManager manager = new RequestManager();
		System.out.println("Creamos un registro");
		manager.addRequest(1, 2, 3, "estudio");
		manager.addRequest(2, 1, 3, "estudio mama");
		
		System.out.println("Obtenemos el registro por id");
		manager.getById(1);
		
		System.out.println("\nObtenemos todos");
		manager.getAll();
		
		System.out.println("\nObtenemos el registro por propiedad");
		manager.getByProperty("estudio");
		
		System.out.println("\nObtenemos el registro por fecha");
		manager.getByProperty("2017-10-27");

	}
}
