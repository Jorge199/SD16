package com.sd.uni.labpatologia.rest.laboratory;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dto.laboratory.LaboratoryDto;
import com.sd.uni.labpatologia.dto.laboratory.LaboratoryResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;

@Repository("laboratoryResource")
public class LaboratoryResourceImpl extends BaseResourceImpl<LaboratoryDto> implements ILaboratoryResource{
	public LaboratoryResourceImpl(){
		super(LaboratoryDto.class,"/laboratory");
	}


	@Override
	@CacheEvict(value = CACHE_REGION, key = "'laboratories'")
	@CachePut(value = CACHE_REGION, key = "'laboratory_' + #laboratory.id", condition = "#laboratory.id!=null")
	public LaboratoryDto save(LaboratoryDto laboratory) {
		LaboratoryDto newDto = super.save(laboratory);
		if (null == laboratory.getId()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"laboratory_" + newDto.getId(), newDto);
		}
		return newDto;
	}
	
	@Cacheable(value = CACHE_REGION, key = "'laboratory_' + #id")
	@Override
	public LaboratoryDto getById(Integer id) {
		return super.getById(id);
	}
	
	@Cacheable(value = CACHE_REGION, key = "'laboratories'")
	@Override
	public LaboratoryResult getAll() {
		setWebResourceBasicAuthFilter();
		final LaboratoryResult result = getWebResource().get(LaboratoryResult.class);
		return result;
	}

	@Override
	public LaboratoryResult find(String textToFind, int maxItems, int page) {
		setWebResourceBasicAuthFilter();
		final LaboratoryResult result = findWR(textToFind, maxItems, page).get(LaboratoryResult.class);
		return result;
	}

}
