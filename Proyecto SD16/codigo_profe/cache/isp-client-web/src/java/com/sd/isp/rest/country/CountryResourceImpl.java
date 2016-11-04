package com.sd.isp.rest.country;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.isp.dto.location.country.CountryDTO;
import com.sd.isp.dto.location.country.CountryResult;
import com.sd.isp.rest.base.BaseResourceImpl;

@Repository("countryResource")
public class CountryResourceImpl extends BaseResourceImpl<CountryDTO> implements
		ICountryResource {

	public CountryResourceImpl() {
		super(CountryDTO.class, "/country");
	}

	@Override
	@CacheEvict(value = CACHE_REGION, key = "'country_' + #dto.id", condition = "#dto.id!=null")
	public CountryDTO save(CountryDTO dto) {
		final CountryDTO country = getWebResource().entity(dto).post(
				getDtoClass());
		return country;
	}

	@Cacheable(value = CACHE_REGION, key = "'country_' + #id")
	@Override
	public CountryDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	public CountryResult getAll() {
		CountryResult countries = getWebResource().get(CountryResult.class);
		for (CountryDTO country : countries.getCountries()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"country_" + country.getId(), country);
		}
		return countries;
	}
}
