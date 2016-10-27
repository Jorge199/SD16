package report;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WsClient {

	public static void main(String[] args) {
		ReportManager reportManager = new ReportManager();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			reportManager.addReport(1,2,1, formatter.parse("11-06-2016"),"obs","cancer");
			reportManager.addReport(1,4,3,formatter.parse("22-05-2016"),"alguna observacion","no cancer");
			reportManager.addReport(1,3,4,formatter.parse("6-02-2016"),"alguna observacion","no cancer");
			reportManager.addReport(1,5,5,formatter.parse("25-08-2016"),"alguna observacion","cancer");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//reportManager.getAllReports();
		//reportManager.getById(1);
		//reportManager.getByDate("2016-2-5");
	}

}
