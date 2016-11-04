package src.patient;

import java.util.Date;

import com.sd.uni.labpatologia.dto.patient.PatientDTO;
import com.sd.uni.labpatologia.dto.patient.PatientResult;

import src.base.AbstractBaseManager;

public class PatientManager extends AbstractBaseManager {
	public PatientManager() {
		super();
	}
	
	public void addPatient(String nombre, String lastName, String document,String sex, Date birthDate,String address, String phone) {
		PatientDTO patientDTO = new PatientDTO();
		patientDTO.setName(nombre);
		patientDTO.setLastName(lastName);
		patientDTO.setDocument(document);
		patientDTO.setSex(sex);
		patientDTO.setBirthDate(birthDate);
		patientDTO.setAddress(address);
		patientDTO.setPhone(phone);

		getJerseyClient().resource(getBaseUrl() + "/patient").entity(patientDTO).post(PatientDTO.class);
	}
	
	public void getAllPatients() {
		PatientResult patientResult = getJerseyClient().resource(getBaseUrl() + "/patient").get(PatientResult.class);
		for (PatientDTO p : patientResult.getPatients()) {
			System.out.println("Nombre: "+p.getName());
			System.out.println("Apellido: "+p.getLastName());
			System.out.println("CI: "+p.getDocument());
			System.out.println("Sexo: "+p.getSex());
			System.out.println("Fecha de Nac.: "+p.getBirthDate());
			System.out.println("Direccion: "+p.getAddress());
			System.out.println("Telefono: "+p.getPhone());
		}
	}
	
	public void getByIdPatient(int id){
		PatientDTO patientResult = getJerseyClient().resource(getBaseUrl() + "/patient/"+id).get(PatientDTO.class);
		System.out.println("Nombre: "+patientResult.getName());
		System.out.println("Apellido: "+patientResult.getLastName());
		System.out.println("CI: "+patientResult.getDocument());
		System.out.println("Sexo: "+patientResult.getSex());
		System.out.println("Fecha de Nac. : "+patientResult.getBirthDate());
		System.out.println("Direccion: "+patientResult.getAddress());
		System.out.println("Telefono: "+patientResult.getPhone());
		
	}
	public void getByPropertyPatient(String textToFind){
		PatientResult patResult = getJerseyClient().resource(getBaseUrl() + "/patient/search/"+textToFind).get(PatientResult.class);
		for (PatientDTO c : patResult.getPatients()) {
			System.out.println("Nombre: "+c.getName());
			System.out.println("Apellido: "+c.getLastName());
			System.out.println("CI: "+c.getDocument());
			System.out.println("Sexo: "+c.getSex());
			System.out.println("Fecha de Nac.: "+c.getBirthDate());
			System.out.println("Direccion: "+c.getAddress());
			System.out.println("Telefono: "+c.getPhone());
		}
		
	}
	
}
