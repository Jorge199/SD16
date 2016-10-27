package report;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class WsClient {

	public static void main(String[] args) {
		ReportManager reportManager = new ReportManager();
		cargarDatos();
		System.out.println("\t Obtener Todos");
		reportManager.getAllReports();
		
		System.out.println("\n\t Obtener por Id");
		reportManager.getById(1);
		
		System.out.println("\n\t Obtener por Fecha (25-8-2016)");
		reportManager.getByDate("25-8-2016");
		
		System.out.println("\n\t Obtener por Fecha (año 2016)");
		reportManager.getByDate("1-1-2016","31-12-2016" );
	}

	public static void cargarDatos() {
		ReportManager reportManager = new ReportManager();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			reportManager.addReport(1, formatter.parse("11-06-2016"), "obs", "cancer");
			reportManager.addReport(6, formatter.parse("22-05-2016"), "alguna observacion", "no cancer");
			reportManager.addReport(3, formatter.parse("6-02-2016"), "alguna observacion", "no cancer");
			reportManager.addReport(2, formatter.parse("25-08-2016"), "alguna observacion", "cancer");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
