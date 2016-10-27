package report;
import java.util.Date;

import com.sd.uni.labpatologia.dto.report.ReportDTO;
import com.sd.uni.labpatologia.dto.report.ReportResult;

public class ReportManager extends AbstractBaseManager {

	public ReportManager() {
		super();
	}

	public void addReport(int idDoctor, int idPaciente, int idEstudio, Date fecha, String observaciones, String diagnostico) {
		ReportDTO reportDTO = new ReportDTO();
		reportDTO.setIdDoctor(idDoctor);
		reportDTO.setIdPaciente(idPaciente);
		reportDTO.setIdEstudio(idEstudio);
		reportDTO.setFecha(fecha);
		reportDTO.setObservaciones(observaciones);
		reportDTO.setDiagnostico(diagnostico);
		getJerseyClient().resource(getBaseUrl() + "/report").entity(reportDTO).post(ReportDTO.class);

	}

	public void getAllReports() {
		ReportResult reportResult = getJerseyClient().resource(getBaseUrl() + "/report").get(ReportResult.class);
		for (ReportDTO r : reportResult.getReports()) {
			System.out.println("id " + r.getId());
			System.out.println(r.getIdPaciente());
			System.out.println(r.getIdEstudio());
			System.out.println(r.getDiagnostico());
			System.out.println(r.getFecha());
			System.out.println(r.getObservaciones());
		}
	}
	
	public void getById(int id) {
		ReportDTO report = getJerseyClient().resource(getBaseUrl() + "/report/"+id).get(ReportDTO.class);
			System.out.println(report.getId());
			System.out.println(report.getIdPaciente());
			System.out.println(report.getIdEstudio());
			System.out.println(report.getDiagnostico());
			System.out.println(report.getFecha());
			System.out.println(report.getObservaciones());
	}
	
	public void getByDate(String textToFind) {
		ReportResult reportResult = getJerseyClient().resource(getBaseUrl() + "/report/search/"+textToFind).get(ReportResult.class);
		for (ReportDTO r : reportResult.getReports()) {
			System.out.print("\nid " + r.getId());
			System.out.print(r.getIdPaciente());
			System.out.print(r.getFecha());
			System.out.print(r.getObservaciones()+"\n");
		}
	}

}
