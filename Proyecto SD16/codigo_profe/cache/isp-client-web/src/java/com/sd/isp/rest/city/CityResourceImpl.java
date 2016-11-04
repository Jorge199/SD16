package com.sd.isp.rest.city;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.isp.dto.location.city.CityDTO;
import com.sd.isp.dto.location.city.CityResult;
import com.sd.isp.rest.base.BaseResourceImpl;

@Repository("cityResouce")
public class CityResourceImpl extends BaseResourceImpl<CityDTO> implements
		ICityResource {

	public CityResourceImpl() {
		super(CityDTO.class, "/city");
	}

	@CacheEvict(value = CACHE_REGION, key = "'city_' + #city.id", condition = "#city.id!=null")
	@Override
	public CityDTO save(CityDTO city) {
		return super.save(city);
	}

	@Cacheable(value = CACHE_REGION, key = "'city_' + #id")
	@Override
	public CityDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	public CityResult getAll() {
		CityResult cities = getWebResource().get(CityResult.class);
		for(CityDTO city: cities.getCities()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"city_" + city.getId(), city);
		}
		return cities;
	}

}
