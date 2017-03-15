package com.sd.uni.labpatologia.rest.diagnostic;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dto.diagnostic.DiagnosticDto;
import com.sd.uni.labpatologia.dto.diagnostic.DiagnosticResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;

@Repository("diagnosticResource")
public class DiagnosticResourceImpl extends BaseResourceImpl<DiagnosticDto> implements
		IDiagnosticResource{

	public DiagnosticResourceImpl() {
		super(DiagnosticDto.class, "/diagnostic");
	}

	@Override
	//@CacheEvict(value = CACHE_REGION, key = "'diagnostics'")
	//@CachePut(value = CACHE_REGION, key = "'diagnostic_' + #diagnostic.id", condition = "#diagnostic.id!=null")
	public DiagnosticDto save(DiagnosticDto diagnostic) {
		DiagnosticDto newDto = super.save(diagnostic);
		//if (null == diagnostic.getId()) {
			//getCacheManager().getCache(CACHE_REGION).put(
			//		"diagnostic_" + newDto.getId(), newDto);
		//}
		return newDto;
	}

	@Override
	//@Cacheable(value = CACHE_REGION, key = "'diagnostic_' + #id")
	public DiagnosticDto getById(Integer id) {
		return super.getById(id);
	}

	@Override
	//@Cacheable(value = CACHE_REGION, key = "'diagnostics'")
	public DiagnosticResult getAll() {
		setWebResourceBasicAuthFilter();
		final DiagnosticResult result = getWebResource().get(DiagnosticResult.class);
		return result;
	}

	
	@Override
	public DiagnosticResult find(String textToFind, int maxItems, int page) {
		setWebResourceBasicAuthFilter();
		final DiagnosticResult result = findWR(textToFind, maxItems, page).get(
				DiagnosticResult.class);
		return result;
	}

}
