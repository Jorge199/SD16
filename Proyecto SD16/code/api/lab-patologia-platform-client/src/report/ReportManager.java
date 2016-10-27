package report;
import java.util.Date;

import com.sd.uni.labpatologia.dto.report.ReportDTO;
import com.sd.uni.labpatologia.dto.report.ReportResult;

public class ReportManager extends AbstractBaseManager {

	public ReportManager() {
		super();
	}

	public void addReport(int idFicha, Date fecha, String observaciones, String diagnostico) {
		ReportDTO reportDTO = new ReportDTO();
		reportDTO.setIdFicha(idFicha);
		reportDTO.setFecha(fecha);
		reportDTO.setObservaciones(observaciones);
		reportDTO.setDiagnostico(diagnostico);
		getJerseyClient().resource(getBaseUrl() + "/report").entity(reportDTO).post(ReportDTO.class);

	}

	public void getAllReports() {
		ReportResult reportResult = getJerseyClient().resource(getBaseUrl() + "/report").get(ReportResult.class);
		for (ReportDTO r : reportResult.getReports()) {
			System.out.print("id: "+r.getId());
			System.out.print("\tid_ficha "+ r.getIdFicha());
			System.out.print("\tdiagnostico "+r.getDiagnostico());
			System.out.print("\tfecha "+r.getFecha());
			System.out.println("\tobservaciones "+r.getObservaciones());
		}
	}
	
	public void getById(int id) {
		ReportDTO report = getJerseyClient().resource(getBaseUrl() + "/report/"+id).get(ReportDTO.class);
			System.out.print("id: "+ report.getId());
			System.out.print("\tid_ficha "+ report.getIdFicha());
			System.out.print("\tdiagnostico "+report.getDiagnostico());
			System.out.print("\tfecha "+report.getFecha());
			System.out.println("\tobservaciones "+report.getObservaciones());
	}
	
	public void getByDate(String textToFind) {
		ReportResult reportResult = getJerseyClient().resource(getBaseUrl() + "/report/search/date="+textToFind).get(ReportResult.class);
		for (ReportDTO r : reportResult.getReports()) {
			System.out.print("id: "+ r.getId());
			System.out.print("\tid_ficha "+ r.getIdFicha());
			System.out.print("\tdiagnostico "+r.getFecha());
			System.out.print("\tfecha "+r.getDiagnostico());
			System.out.println("\tobservaciones "+r.getObservaciones());
		}
	}
	public void getByDate(String dateStart,String dateEnd ) {
		ReportResult reportResult = getJerseyClient().resource(getBaseUrl() + "/report/search/start="+dateStart+"&end="+dateEnd).get(ReportResult.class);
		for (ReportDTO r : reportResult.getReports()) {
			System.out.print("id: "+ r.getId());
			System.out.print("\tid_ficha "+ r.getIdFicha());
			System.out.print("\tdiagnostico "+r.getFecha());
			System.out.print("\tfecha "+r.getDiagnostico());
			System.out.println("\tobservaciones "+r.getObservaciones());
		}
	}

}
