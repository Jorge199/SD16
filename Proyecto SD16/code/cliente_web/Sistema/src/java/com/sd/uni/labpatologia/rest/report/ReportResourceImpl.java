package com.sd.uni.labpatologia.rest.report;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dto.report.ReportDTO;
import com.sd.uni.labpatologia.dto.report.ReportResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;

@Repository("reportResource")
public class ReportResourceImpl extends BaseResourceImpl<ReportDTO> implements
		IReportResource {

	public ReportResourceImpl() {
		super(ReportDTO.class, "/report");
	}

	@Override
	@CacheEvict(value = CACHE_REGION, key = "'reports'")
	@CachePut(value = CACHE_REGION, key = "'report_' + #report.id", condition = "#report.id!=null")
	public ReportDTO save(ReportDTO report) {
		ReportDTO newDto = super.save(report);
		if (null == report.getId()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"report_" + newDto.getId(), newDto);
		}
		return newDto;
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'report_' + #id")
	public ReportDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'reports'")
	public ReportResult getAll() {
		setWebResourceBasicAuthFilter();
		final ReportResult result = getWebResource().get(ReportResult.class);
		return result;
	}

	@Override
	public ReportResult find(String textToFind, int maxItems, int page) {
		setWebResourceBasicAuthFilter();
		final ReportResult result = findWR(textToFind, maxItems, page).get(
				ReportResult.class);
		return result;
	}
	

	public ReportResult find(String textToFind) {
		setWebResourceBasicAuthFilter();
		final ReportResult result = getWebResource().path("/search/" + textToFind).get(ReportResult.class);
		return result;
	}

}
