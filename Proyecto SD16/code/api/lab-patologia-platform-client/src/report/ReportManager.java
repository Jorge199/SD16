package report;
import java.util.Date;

import com.sd.uni.labpatologia.dto.report.ReportDTO;
import com.sd.uni.labpatologia.dto.report.ReportResult;
import com.sd.uni.labpatologia.dto.request.RequestDTO;
import com.sd.uni.labpatologia.util.DiagnosticEnum;

import base.AbstractBaseManager;

public class ReportManager extends AbstractBaseManager {

	public ReportManager() {
		super();
	}

	public void addReport(int requestId, Date date, String observations, DiagnosticEnum diagnostic) {
		ReportDTO reportDTO = new ReportDTO();
		reportDTO.setRequestId(requestId);
		reportDTO.setDate(date);
		reportDTO.setObservations(observations);
		reportDTO.setDiagnostic(diagnostic);
		getJerseyClient().resource(getBaseUrl() + "/report").entity(reportDTO).post(ReportDTO.class);

	}

	public void getAllReports() {
		ReportResult reportResult = getJerseyClient().resource(getBaseUrl() + "/report").get(ReportResult.class);
		for (ReportDTO r : reportResult.getReports()) {
			System.out.print("id: "+r.getId());
			System.out.print("\tid_ficha: "+ r.getRequestId());
			System.out.print("\tdiagnostico: "+r.getDiagnostic());
			System.out.print("\tfecha: "+r.getDate());
			System.out.println("\tobservaciones: "+r.getObservations());
		}
	}
	
	public void getById(int id) {
		ReportDTO report = getJerseyClient().resource(getBaseUrl() + "/report/"+id).get(ReportDTO.class);
			System.out.print("id: "+ report.getId());
			System.out.print("\tid_ficha: "+ report.getRequestId());
			//obtengo el request desde el RequestId del report
			RequestDTO request = getJerseyClient().resource(getBaseUrl() + "/request/"+report.getRequestId()).get(RequestDTO.class);
			System.out.print("\tdoctor_id: "+ request.getDoctorId());
			System.out.print("\tpaciente_id: "+ request.getPatientId());
			
			System.out.print("\tdiagnostico: "+report.getDiagnostic());
			System.out.print("\tfecha: "+report.getDate());
			System.out.println("\tobservaciones: "+report.getObservations());
	}
	
	public void getByDate(String textToFind) {
		ReportResult reportResult = getJerseyClient().resource(getBaseUrl() + "/report/search/date="+textToFind).get(ReportResult.class);
		for (ReportDTO r : reportResult.getReports()) {
			System.out.print("id: "+ r.getId());
			System.out.print("\tid_ficha: "+ r.getRequestId());
			//obtengo el request desde el RequestId del report
			RequestDTO request = getJerseyClient().resource(getBaseUrl() + "/request/"+r.getRequestId()).get(RequestDTO.class);
			System.out.print("\tdoctor_id: "+ request.getDoctorId());
			System.out.print("\tpaciente_id: "+ request.getPatientId());
			
			System.out.print("\tdiagnostico: "+r.getDiagnostic());
			System.out.print("\tfecha: "+r.getDate());
			System.out.println("\tobservaciones: "+r.getObservations());
		}
	}
	public void getByDate(String dateStart,String dateEnd ) {
		ReportResult reportResult = getJerseyClient().resource(getBaseUrl() + "/report/search/start="+dateStart+"&end="+dateEnd).get(ReportResult.class);
		for (ReportDTO r : reportResult.getReports()) {
			System.out.print("id: "+ r.getId());
			System.out.print("\tid_ficha: "+ r.getRequestId());
			//obtengo el request desde el RequestId del report
			RequestDTO request = getJerseyClient().resource(getBaseUrl() + "/request/"+r.getRequestId()).get(RequestDTO.class);
			System.out.print("\tdoctor_id: "+ request.getDoctorId());
			System.out.print("\tpaciente_id: "+ request.getPatientId());
			
			System.out.print("\tdiagnostico: "+r.getDiagnostic());
			System.out.print("\tfecha: "+r.getDate());
			System.out.println("\tobservaciones: "+r.getObservations());
		}
	}
	
	public void getByDiagnostic(String diagnostic) {
		ReportResult reportResult = getJerseyClient().resource(getBaseUrl() + "/report/search/diagnostic="+diagnostic).get(ReportResult.class);
		for (ReportDTO r : reportResult.getReports()) {
			System.out.print("id: "+ r.getId());
			System.out.print("\tid_ficha: "+ r.getRequestId());
			//obtengo el request desde el RequestId del report
			RequestDTO request = getJerseyClient().resource(getBaseUrl() + "/request/"+r.getRequestId()).get(RequestDTO.class);
			System.out.print("\tdoctor_id: "+ request.getDoctorId());
			System.out.print("\tpaciente_id: "+ request.getPatientId());
			
			System.out.print("\tdiagnostico: "+r.getDiagnostic());
			System.out.print("\tfecha: "+r.getDate());
			System.out.println("\tobservaciones: "+r.getObservations());
		}
	}

}
