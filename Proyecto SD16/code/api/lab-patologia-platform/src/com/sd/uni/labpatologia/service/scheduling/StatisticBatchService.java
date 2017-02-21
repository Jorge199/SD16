package com.sd.uni.labpatologia.service.scheduling;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.report.IReportDao;
import com.sd.uni.labpatologia.dao.statistic.IStatisticDao;
import com.sd.uni.labpatologia.domain.report.ReportDomain;
import com.sd.uni.labpatologia.domain.request.RequestDomain;
import com.sd.uni.labpatologia.domain.statistic.StatisticDomain;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.util.DiagnosticEnum;

@Service
@Transactional
@EnableScheduling
public class StatisticBatchService {
	@Autowired
	private IReportDao _reportDao;
	@Autowired
	private IStatisticDao _statisticDao;
//	@Autowired
//	private IStatisticService _statisticService;

	@Value("${batch.enable}")
	private String enableBatch;
	
	@Scheduled(cron = "${statistics.batch}")
	public void calculateStatistics() throws PatologyException {
		
		if (enableBatch.equalsIgnoreCase("true")){
			System.out.println("Actualizando Estadísticas");
			try {
				for (DiagnosticEnum diagnostico : DiagnosticEnum.values()) {
					//List <ReportDTO> reports = _reportService.find("start=" + minDate + "&end=" + maxDate+"&diagnostic="+diagnostico.getKey()+"&isProcessed=false").getReports();
					List <ReportDomain> reports = _reportDao.find("diagnostic="+diagnostico.getKey()+"&isProcessed=false");
					for (ReportDomain report : reports) {
						//final StatisticDTO statistic = new StatisticDTO();
						StatisticDomain statistic = new StatisticDomain();
						statistic.setDate(report.getDate());
						statistic.setDiagnostic(report.getDiagnostic());
						RequestDomain request = report.getRequest();
						statistic.setSex(request.getPatient().getSex());
						statistic.setPatientAge(report.getAge());
						//StatisticDTO dto = _statisticService.save(statistic);
						_statisticDao.save(statistic);
						report.setIsProcessed(true);
						report.setStatistic(_statisticDao.save(statistic));
						_reportDao.save(report);
					}
				}
			} catch (PatologyException e) {
				throw new PatologyException("Formato de ruta invalido", e);
			}
			System.out.println("Estadísticas Actualizadas!");
		}
	}
}
