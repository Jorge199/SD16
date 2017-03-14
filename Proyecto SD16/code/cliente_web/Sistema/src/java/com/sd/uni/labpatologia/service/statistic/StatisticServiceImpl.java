/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sd.uni.labpatologia.service.statistic;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.labpatologia.beans.statistic.StatisticB;
import com.sd.uni.labpatologia.dto.statistic.StatisticDTO;
import com.sd.uni.labpatologia.dto.statistic.StatisticResult;
import com.sd.uni.labpatologia.rest.diagnostic.IDiagnosticResource;
import com.sd.uni.labpatologia.rest.statistic.IStatisticResource;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;
import com.sd.uni.labpatologia.service.diagnostic.IDiagnosticService;
import com.sd.uni.labpatologia.service.doctor.IDoctorService;

@Service("statisticService")
public class StatisticServiceImpl extends
		BaseServiceImpl<StatisticB, StatisticDTO> implements IStatisticService {

	@Autowired
	private IStatisticResource _statisticResource;
	@Autowired
	private IDiagnosticService _diagnosticService;
	public StatisticServiceImpl() {
	}

	@Override
	protected StatisticB convertDtoToBean(StatisticDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		final StatisticB statisticB = new StatisticB(params);
		statisticB.setDate(dto.getDate());
		statisticB.setPatientAge(dto.getPatientAge());
		statisticB.setDiagnostic(_diagnosticService.getById(dto.getDiagnosticId()));
		statisticB.setSex(dto.getSex());
		return statisticB;
	}

	@Override
	protected StatisticDTO convertBeanToDto(StatisticB bean) {
		final StatisticDTO dto = new StatisticDTO();
		dto.setId(bean.getId());
		dto.setDate(bean.getDate());
		dto.setDiagnosticId(bean.getDiagnostic().getId());
		dto.setPatientAge(bean.getPatientAge());
		dto.setSex(bean.getSex());
		return dto;
	}

	@Override
	public List<StatisticB> find(String textToFind, int maxItems, int page) {
		final StatisticResult result = _statisticResource.find(textToFind, maxItems, page);
		final List<StatisticDTO> rList = null == result.getStatistics() ? new ArrayList<StatisticDTO>()
				: result.getStatistics();

		final List<StatisticB> statistics = new ArrayList<StatisticB>();
		for (StatisticDTO dto : rList) {
			final StatisticB bean = convertDtoToBean(dto);
			statistics.add(bean);
		}
		return statistics;
	}

	@Override
	public List<StatisticB> find(String textToFind) {
		final StatisticResult result = _statisticResource.find(textToFind);
		final List<StatisticDTO> rList = null == result.getStatistics() ? new ArrayList<StatisticDTO>()
				: result.getStatistics();

		final List<StatisticB> statistics = new ArrayList<StatisticB>();
		for (StatisticDTO dto : rList) {
			final StatisticB bean = convertDtoToBean(dto);
			statistics.add(bean);
		}
		return statistics;
	}

	@Override
	public StatisticB save(StatisticB bean) {
		final StatisticDTO request = convertBeanToDto(bean);
		final StatisticDTO dto = _statisticResource.save(request);
		final StatisticB requestB = convertDtoToBean(dto);
		return requestB;
	}

	@Override
	public List<StatisticB> getAll() {
		final StatisticResult result = _statisticResource.getAll();
		final List<StatisticDTO> rList = null == result.getStatistics() ? new ArrayList<StatisticDTO>()
				: result.getStatistics();

		final List<StatisticB> statistics = new ArrayList<StatisticB>();
		for (StatisticDTO dto : rList) {
			final StatisticB bean = convertDtoToBean(dto);
			statistics.add(bean);
		}
		return statistics;
	}

	@Override
	public StatisticB getById(Integer id) {
		final StatisticDTO dto = _statisticResource.getById(id);
		final StatisticB bean = convertDtoToBean(dto);
		return bean;
	}
}
