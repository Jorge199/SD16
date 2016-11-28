package com.sd.uni.labpatologia.rest.statistic;

import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dto.report.ReportResult;
import com.sd.uni.labpatologia.dto.statistic.StatisticDTO;
import com.sd.uni.labpatologia.dto.statistic.StatisticResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;

@Repository("statisticResource")
public class StatisticResourceImpl extends BaseResourceImpl<StatisticDTO>
		implements IStatisticResource {

	public StatisticResourceImpl() {
		super(StatisticDTO.class, "/statistic");
	}

	@Override
	public StatisticResult find(String textToFind, int maxItems, int page) {
		setWebResourceBasicAuthFilter();
		final StatisticResult result = findWR(textToFind, maxItems, page).get(
				StatisticResult.class);
		return result;
	}

	@Override
	public StatisticDTO save(StatisticDTO statistic) {
		StatisticDTO newDto = super.save(statistic);

		return newDto;
	}

	@Override
	public StatisticDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	public StatisticResult getAll() {
		setWebResourceBasicAuthFilter();
		final StatisticResult result = getWebResource().get(
				StatisticResult.class);
		return result;
	}

	public StatisticResult find(String textToFind) {
		setWebResourceBasicAuthFilter();
		final StatisticResult result = getWebResource().path(
				"/search/" + textToFind).get(StatisticResult.class);
		return result;
	}

}
