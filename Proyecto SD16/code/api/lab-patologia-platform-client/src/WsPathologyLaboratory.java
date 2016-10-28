
import java.text.ParseException;
import java.text.SimpleDateFormat;

import laboratory.LaboratoryManager;
import report.ReportManager;
import request.RequestManager;

public class WsPathologyLaboratory {

	public static void main(String[] args) {
		laboratoryManager();
		loadRequestData(); // carga fichas, si no tengo request (fichas)
							// cargadas no puedo generar reportes
		loadReportData(); // carga reportes de prueba
		testReport(); // prueba las busquedas de los reportes
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

	private static void laboratoryManager() {
		System.out.println("###### LABORATORIO #####");

		LaboratoryManager laboratoryManager = new LaboratoryManager();
		System.out.println("##### Agregar datos #####");
		laboratoryManager.addLaboratory("patologia", "centro", "patologia@email.com", "192030");
		laboratoryManager.addLaboratory("clinica", "alborada", "clinica@email.com", "192030");

		System.out.println("##### Buscar por id #####");
		laboratoryManager.getByIdLaboratory(1);

		System.out.println("##### Mostrar todos los datos #####");
		laboratoryManager.getAllLaboratory();

		System.out.println("##### Buscar por propiedades #####");
		laboratoryManager.getByPropertyLaboratory("centro");
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
			reportManager.addReport(1, formatter.parse("11-06-2016"), "obs", "cancer");
			reportManager.addReport(1, formatter.parse("22-05-2016"), "alguna observacion", "no cancer");
			reportManager.addReport(3, formatter.parse("6-02-2016"), "alguna observacion", "no cancer");
			reportManager.addReport(2, formatter.parse("25-08-2016"), "alguna observacion", "cancer");
			reportManager.addReport(3, formatter.parse("27-02-2016"), "alguna observacion", "cancer");
			reportManager.addReport(2, formatter.parse("28-01-2016"), "alguna observacion", "cancer");
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
		System.out.println("\n\t Obtener por Diagnostico (no cancer)");
		reportManager.getByDiagnostic("no%20cancer");
	}

}