package com.sd.uni.labpatologia.rest.report;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dto.report.ReportDTO;
import com.sd.uni.labpatologia.dto.report.ReportResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;
@Repository("reportResource")
public class ReportResourceImpl extends BaseResourceImpl<ReportDTO> implements IReportResource {

	public ReportResourceImpl() {
		super(ReportDTO.class, "/report");
	}

	@Override
	@CacheEvict(value = CACHE_REGION, key = "'report_' + #dto.id", condition = "#dto.id!=null")
	public ReportDTO save(ReportDTO dto) {
		final ReportDTO report = getWebResource().entity(dto).post(getDtoClass());
		return report;
	}
	
	@Cacheable(value = CACHE_REGION, key = "'report_' + #id")
	@Override
	public ReportDTO getById(Integer id) {
		return super.getById(id);
	}
	
	@Cacheable(value = CACHE_REGION, key = "'reports'")
	@Override
	public ReportResult getAll() {
		final ReportResult result = getWebResource().get(ReportResult.class);
		return result;
	}
	@Override
	public ReportResult find(String textToFind, int maxItems, int page) {
		final ReportResult result = findWR(textToFind, maxItems, page).get(ReportResult.class);
		return result;
	}

}
