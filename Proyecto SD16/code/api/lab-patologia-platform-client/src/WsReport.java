import java.text.ParseException;
import java.text.SimpleDateFormat;

import report.ReportManager;

public class WsReport {
	
	/** NOTA IMPORTANTE: Se pueden unir las busquedas. Por ejemplo
	 *	http://localhost:8080/lab-patologia-platform/rest/report/search/diagnostic=cancer&start=01-01-2016&end=31-12-2016
	 *	En ese caso obtendremos todos los diagnosticados con cancer en el 2016
	 */
	public static void main(String[] args) {
		ReportManager reportManager = new ReportManager();
		cargarDatos();
		
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
		 * http://localhost:8080/lab-patologia-platform/rest/report/search/date=25-08-2016
		 */
		System.out.println("\n\t Obtener por Fecha (25-8-2016)");
		reportManager.getByDate("25-8-2016");
		
		/*
		 * Get, con esta ruta obtienes los reportes desde una fecha hasta otra (del 2016 en este caso)
		 * http://localhost:8080/lab-patologia-platform/rest/report/search/start=01-01-2016&end=31-12-2016	
		 */
		System.out.println("\n\t Obtener por Fecha (año 2016)");
		reportManager.getByDate("1-1-2016","31-12-2016" );
		
		/*
		 * Get, con esta ruta obtienes todos los reportes con diagnostico "cancer
		 * http://localhost:8080/lab-patologia-platform/rest/report/search/diagnostic=cancer
		 */
		System.out.println("\n\t Obtener por Diagnostico (no cancer)");
		reportManager.getByDiagnostic("no%20cancer" );
		
	}

	/*
	 * Esta clase solo carga datos de Reportes
	 */
	public static void cargarDatos() {
		ReportManager reportManager = new ReportManager();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			reportManager.addReport(1, formatter.parse("11-06-2016"), "obs", "cancer");
			reportManager.addReport(6, formatter.parse("22-05-2016"), "alguna observacion", "no cancer");
			reportManager.addReport(3, formatter.parse("6-02-2016"), "alguna observacion", "no cancer");
			reportManager.addReport(2, formatter.parse("25-08-2016"), "alguna observacion", "cancer");
			reportManager.addReport(2, formatter.parse("27-02-2016"), "alguna observacion", "cancer");
			reportManager.addReport(2, formatter.parse("28-01-2016"), "alguna observacion", "cancer");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}