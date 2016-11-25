package com.sd.uni.labpatologia.service.scheduling;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dto.report.ReportDTO;
import com.sd.uni.labpatologia.dto.request.RequestDTO;
import com.sd.uni.labpatologia.dto.statistic.StatisticDTO;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.patient.IPatientService;
import com.sd.uni.labpatologia.service.report.IReportService;
import com.sd.uni.labpatologia.service.request.IRequestService;
import com.sd.uni.labpatologia.service.statistic.IStatisticService;
import com.sd.uni.labpatologia.util.DiagnosticEnum;

@Service
@Transactional
@EnableScheduling
public class StatisticBatchService {
	@Autowired
	private IRequestService _requestService;
	@Autowired
	private IPatientService _patientService;

	@Autowired
	private IReportService _reportService;
	@Autowired
	private IStatisticService _statisticService;

	@Scheduled(cron = "${statistics.batch}")
	public void doSomething() throws PatologyException {
		try {
			String minDate;
			String maxDate;

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			c.add(Calendar.DATE, -1);
			minDate = formatter.format(c.getTime());
			maxDate = formatter.format(new Date());
			for (DiagnosticEnum diagnostico : DiagnosticEnum.values()) {
				for (ReportDTO report : _reportService.find("start=" + minDate + "&end=" + maxDate+"&diagnostic="+diagnostico).getReports()) {
					final StatisticDTO statistic = new StatisticDTO();
					statistic.setDate(report.getDate());
					statistic.setDiagnostic(report.getDiagnostic());
					RequestDTO request = _requestService.getById(report.getRequestId());
					statistic.setSex(_patientService.getById(request.getPatientId()).getSex());
					statistic.setPatientAge(report.getAge());
					_statisticService.save(statistic);
				}
			}
		} catch (PatologyException e) {
			throw new PatologyException("Formato de ruta invalido", e);
		}
	}

	private int getAge(Date birthDay) {
		Calendar fechaNac = Calendar.getInstance();
		fechaNac.setTime(birthDay);
		Calendar today = Calendar.getInstance();

		int diff_year = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
		int diff_month = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
		int diff_day = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

		if (diff_month < 0 || (diff_month == 0 && diff_day < 0)) {
			diff_year--;
		}
		return diff_year;
	}
}
