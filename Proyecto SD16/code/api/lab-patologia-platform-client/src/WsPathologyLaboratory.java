
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import com.sd.uni.labpatologia.util.DiagnosticEnum;
import com.sd.uni.labpatologia.util.MovementTypeEnum;
import com.sd.uni.labpatologia.util.SexEnum;

import article.ArticleManager;
import article_movement.ArticleMovementManager;
import doctor.DoctorManager;
//import doctor.DoctorManager;
import laboratory.LaboratoryManager;
import patient.PatientManager;
import report.ReportManager;
import request.RequestManager;
import study_type.StudyTypeManager;
import user.UserManager;

public class WsPathologyLaboratory {

	public static void main(String[] args) {
		System.out.println("Cargar Datos");
		laboratoryManager();
		patientManager();
		doctorManager();
		// loadRequestData(); // carga fichas, si no tengo request (fichas)
		// cargadas no puedo generar reportes
		// loadReportData(); // carga reportes de prueba
		// testReport(); // prueba las busquedas de los reportes

		// testRequest();

		testStudyType();
		addUsersAndRoles();
		addArticles();
		addArticleMovements();
		System.out.println("Datos Cargados");
	}

	/*
	 * Cargo datos de prueba de request(ficha)
	 */
	private static void loadRequestData() {
		RequestManager requestManager = new RequestManager();
		requestManager.addRequest(1, 2, 3, "asd");
		requestManager.addRequest(3, 4, 6, "asd");
		requestManager.addRequest(2, 1, 6, "asd");
	}

	/* Metodo para cargar datos de paciente */

	private static void patientManager() {

		System.out.println("###### PACIENTES #####");

		PatientManager patientManager = new PatientManager();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			patientManager.addPatient("Karina Belen", "Sanabria Rios", "4763428", SexEnum.FEMENINO,
					formatter.parse("18-3-1993"), "Cap Miranda", "0985641789");
			patientManager.addPatient("Eliana", "Duarte Sanabria", "4893558", SexEnum.FEMENINO, formatter.parse("1-2-1984"),
					"Barrio Mosquito", "0985237233");
			patientManager.addPatient("Juan Carlos", "Perez Diaz", "2363438", SexEnum.MASCULINO,
					formatter.parse("12-06-1995"), "Barrio Obrero", "0985681789");
			patientManager.addPatient("Pablo Daniel", "Aquino allasi", "17823758", SexEnum.MASCULINO,
					formatter.parse("11-08-1990"), "Encarnacion", "0986245779");
			patientManager.addPatient("Pedro Emilio", "Gonzalez Mendieta", "3765478", SexEnum.MASCULINO,
					formatter.parse("17-6-1953"), "CDE", "0985241749");
			patientManager.addPatient("Carla Luisa", "Fernandez Acuña", "23893659", SexEnum.FEMENINO,
					formatter.parse("15-7-1968"), "Asuncion", "0985233533");
			patientManager.addPatient("Luis Nicolas", "Bado Amarilla", "3423428", SexEnum.MASCULINO,
					formatter.parse("2-04-1949"), "Chaco", "0985444779");
			patientManager.addPatient("Cesar", "Portillo Centurion", "15297418", SexEnum.MASCULINO,
					formatter.parse("30-08-1988"), "Quiteria", "0985585479");
			
			for(int i=0;i<30;i++){
				if(i%2==0){
					patientManager.addPatient("paciente"+i, "apellido"+i, Integer.toString(ThreadLocalRandom.current().nextInt(0, 6763428)), SexEnum.MASCULINO, new Date() , "direccion"+i, Integer.toString(ThreadLocalRandom.current().nextInt(1111111111, 1999999999)));	
				}else{
					patientManager.addPatient("paciente"+i, "apellido"+i, Integer.toString(ThreadLocalRandom.current().nextInt(0, 6763428)), SexEnum.FEMENINO, new Date() , "direccion"+i, Integer.toString(ThreadLocalRandom.current().nextInt(1111111111, 1999999999)));	

				}
				
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// System.out.println("Buscar por id");
		// patientManager.getByIdPatient(1);
		// System.out.println("Mostrar todos los pacientes");
		// patientManager.getAllPatients();
		// System.out.println("Buscar por propiedades");
		// patientManager.getByPropertyPatient("Karina");
	}

private static void doctorManager(){
	
	System.out.println("###### DOCTORES #####");
	
	DoctorManager doctortManager = new DoctorManager();
		doctortManager.addDoctor("Direccion1........",928163,"paciente1@email.com","Ortiz","Alejandro Ruben","0985441759","urologo");
		doctortManager.addDoctor("Direccion2........",294276,"paciente2@email.com","Amarilla","Mario Jose","0985741739","traumatologo");
		doctortManager.addDoctor("Direccion3........",392467,"paciente3@email.com","Quiroga","Celeste Pelmaza","0985344539","odontologo");
		doctortManager.addDoctor("Direccion4........",198769,"paciente4email.com","Laoz","Dalila Maria","0985423686","neumologo");
		doctortManager.addDoctor("Direccion5........",498464,"paciente5@email.com","Queen","Leila Daniela","0985495683","ginecologo");
		doctortManager.addDoctor("Direccion6........",368763,"paciente6@email.com","Fariña","Luis","0985462759","pediatra");
		for(int i=0;i<30;i++){
			doctortManager.addDoctor("Direccion"+i+"........",ThreadLocalRandom.current().nextInt(1000, 7000000),"paciente"+i+"@email.com","apellido"+i,"nombre"+i,	Integer.toString(ThreadLocalRandom.current().nextInt(1111111111, 1999999999)),"");
		}
}

	private static void laboratoryManager() {
		System.out.println("###### LABORATORIO #####");

		LaboratoryManager laboratoryManager = new LaboratoryManager();
		// System.out.println("##### Agregar datos #####");
		laboratoryManager.addLaboratory("Análisis Patológico", "Tte. Honorio González", "patologia@email.com",
				"192030");
		// laboratoryManager.addLaboratory("clinica", "alborada",
		// "clinica@email.com", "192030");

		// System.out.println("##### Buscar por id #####");
		// laboratoryManager.getByIdLaboratory(1);

		// System.out.println("##### Mostrar todos los datos #####");
		// laboratoryManager.getAllLaboratory();

		// System.out.println("##### Buscar por propiedades #####");
		// laboratoryManager.getByPropertyLaboratory("centro");
	}

	/*
	 * Metodo que carga datos de prueba para generar reportes Notese que no se
	 * puede crear un reporte de un id_ficha (request) que no existe (o no esta
	 * cargada)
	 */
	public static void loadReportData() {
		ReportManager reportManager = new ReportManager();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			reportManager.addReport(1, formatter.parse("11-06-2016"), "obs", DiagnosticEnum.CARCINOMA);
			reportManager.addReport(1, formatter.parse("22-05-2016"), "alguna observacion", DiagnosticEnum.LEUCEMIA);
			reportManager.addReport(3, formatter.parse("6-02-2016"), "alguna observacion", DiagnosticEnum.SIN_INDICIOS);
			reportManager.addReport(2, formatter.parse("25-08-2016"), "alguna observacion", DiagnosticEnum.SARCOMA);
			reportManager.addReport(3, formatter.parse("27-02-2016"), "alguna observacion",
					DiagnosticEnum.SIN_INDICIOS);
			reportManager.addReport(2, formatter.parse("28-01-2016"), "alguna observacion", DiagnosticEnum.LEUCEMIA);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Este metodo obtiene datos de reportes
	 */
	public static void testReport() {
		ReportManager reportManager = new ReportManager();

		/*
		 * Get, con esta ruta obtienes todos los reportes
		 * http://localhost:8080/lab-patologia-platform/rest/report/
		 */
		System.out.println("\t Obtener Todos");
		reportManager.getAllReports();

		/*
		 * Get, con esta ruta obtienes el reporte con el id "1"
		 * http://localhost:8080/lab-patologia-platform/rest/report/1
		 */
		System.out.println("\n\t Obtener por Id");
		reportManager.getById(1);

		/*
		 * Get, con esta ruta obtienes los reportes de la fecha "25-08-2016"
		 * http://localhost:8080/lab-patologia-platform/rest/report/search/date=
		 * 25-08-2016
		 */
		System.out.println("\n\t Obtener por Fecha (25-8-2016)");
		reportManager.getByDate("25-8-2016");

		/*
		 * Get, con esta ruta obtienes los reportes desde una fecha hasta otra
		 * (del 2016 en este caso)
		 * http://localhost:8080/lab-patologia-platform/rest/report/search/start
		 * =01-01-2016&end=31-12-2016
		 */
		System.out.println("\n\t Obtener por Fecha (año 2016)");
		reportManager.getByDate("1-1-2016", "31-12-2016");

		/*
		 * Get, con esta ruta obtienes todos los reportes con diagnostico
		 * "cancer
		 * http://localhost:8080/lab-patologia-platform/rest/report/search/
		 * diagnostic=cancer
		 */
		System.out.println("\n\t Obtener por Diagnostico (Carcinoma)");
		reportManager.getByDiagnostic("CARCINOMA");
	}

	public static void testRequest() {
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
	}

	public static void testStudyType() {
		System.out.println("###### ESTUDIOS #####");
		StudyTypeManager s = new StudyTypeManager();
		s.addStudy("Cancer", "alguncancer");
		s.addStudy("Gripe", "alguna gripe");
		s.addStudy("Cancer de mama", "cancer de mama");

		// System.out.println("Obtenemos el estudio por id = 1");
		// s.getById(1);

		// System.out.println("\nObtenemos todos");
		// s.getAllStudies();

		// System.out.println("\nObtenemos el estudio por propiedad = cancer");
		// s.getByPropertyStudyType("cancer");
		// System.out.println("No me funciona");
		
	}
	
	public static void addUsersAndRoles(){
		System.out.println("###### User y Roles #######");
		UserManager u = new UserManager();
		u.addRols();
		u.addUser("Alex", "admin", "Jines", "admin", 1, 000, SexEnum.MASCULINO);
		u.addUser("Fatima", "secre", "Talavera", "secre", 2, 000, SexEnum.FEMENINO);
		u.addUser("Jerson", "doctor", "Derulo", "doctor", 3, 000, SexEnum.MASCULINO);
		u.addUser("Jorge", "tecnico", "Esquivel", "tecnico", 4, 000, SexEnum.MASCULINO);
		
	}
	
	public static void addArticles(){
		System.out.println("###### Articulos #######");
		ArticleManager a = new ArticleManager();
		a.addArticle("Alcohol A1", "Ese que parece alcohol", "Botellas de 1 litro");
		a.addArticle("Alcohol A2", "Ese que parece alcohol tambi�n", "Botellas de 200 ml");
		
	}
	
	public static void addArticleMovements(){
		System.out.println("###### Movimientos de articulos #######");
		ArticleMovementManager a = new ArticleMovementManager();
		a.addArticle(1, Calendar.getInstance().getTime(), MovementTypeEnum.ENTRADA, 5);
		a.addArticle(2, Calendar.getInstance().getTime(), MovementTypeEnum.ENTRADA, 6);
		a.addArticle(1, Calendar.getInstance().getTime(), MovementTypeEnum.SALIDA, 1);
		a.addArticle(2, Calendar.getInstance().getTime(), MovementTypeEnum.SALIDA, 1);
		
	}

}