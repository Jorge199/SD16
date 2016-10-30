import java.text.ParseException;
import java.text.SimpleDateFormat;

import patient.PatientManager;

public class WsPatient {

	public static void main(String[] args)  {
		PatientManager patientManager = new PatientManager();
		Datos();
		System.out.println("Buscar por id");
		patientManager.getByIdPatient(1);
		System.out.println("Mostrar todos los pacientes");
		patientManager.getAllPatients();
		System.out.println("Buscar por propiedades");
		//patientManager.getByPropertyPatient("Karina");

	}
	/*Metodo para cargar datos*/
	
	public static void Datos(){
		PatientManager patientManager = new PatientManager();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Agregar datos");
		try{
		patientManager.addPatient("Karina","Sanabria","4763428","Femenino",formatter.parse("11-06-1994"), "Cap Miranda","0985241789");
		patientManager.addPatient("Eli","Sanabria","47893458","Femenino",formatter.parse("11-06-1994"),"Cap Miranda","0985241789");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
