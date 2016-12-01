package com.sd.uni.labpatologia.service.scheduling;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.patient.IPatientDao;
import com.sd.uni.labpatologia.dao.report.IReportDao;
import com.sd.uni.labpatologia.dao.request.IRequestDao;
import com.sd.uni.labpatologia.domain.report.ReportDomain;
import com.sd.uni.labpatologia.domain.request.RequestDomain;
import com.sd.uni.labpatologia.dto.report.ReportDTO;
import com.sd.uni.labpatologia.dto.report.ReportResult;
import com.sd.uni.labpatologia.dto.request.RequestDTO;
import com.sd.uni.labpatologia.dto.statistic.StatisticDTO;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.patient.IPatientService;
import com.sd.uni.labpatologia.service.report.IReportService;
import com.sd.uni.labpatologia.service.report.ReportServiceImpl;
import com.sd.uni.labpatologia.service.request.IRequestService;
import com.sd.uni.labpatologia.service.statistic.IStatisticService;
import com.sd.uni.labpatologia.util.DiagnosticEnum;

@Service
@Transactional
@EnableScheduling
public class StatisticBatchService {
	@Autowired
	private IReportDao _reportDao;
	@Autowired
	private IStatisticService _statisticService;

	@Scheduled(cron = "${statistics.batch}")
	//@Scheduled(fixedRate=10000)
	public void calculateStatistics() throws PatologyException {
		System.out.println("Actualizando Estadísticas");
		try {
			//String minDate;
			//String maxDate;

			//SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			//Calendar c = Calendar.getInstance();
			//c.setTime(new Date());
			//c.add(Calendar.DATE, -1);
			//minDate = formatter.format(c.getTime());
			//maxDate = formatter.format(new Date());
			for (DiagnosticEnum diagnostico : DiagnosticEnum.values()) {
				//List <ReportDTO> reports = _reportService.find("start=" + minDate + "&end=" + maxDate+"&diagnostic="+diagnostico.getKey()+"&isProcessed=false").getReports();
				List <ReportDomain> reports = _reportDao.find("diagnostic="+diagnostico.getKey()+"&isProcessed=false");
				for (ReportDomain report : reports) {
					final StatisticDTO statistic = new StatisticDTO();
					statistic.setDate(report.getDate());
					statistic.setDiagnostic(report.getDiagnostic());
					RequestDomain request = report.getRequest();
					statistic.setSex(request.getPatient().getSex());
					statistic.setPatientAge(report.getAge());
					_statisticService.save(statistic);
					report.setIsProcessed(true);
					_reportDao.save(report);
				}
			}
		} catch (PatologyException e) {
			throw new PatologyException("Formato de ruta invalido", e);
		}
		System.out.println("Estadísticas Actualizadas!");
	}
}
