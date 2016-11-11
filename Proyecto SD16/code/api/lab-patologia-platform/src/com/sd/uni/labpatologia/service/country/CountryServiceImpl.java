package com.sd.uni.labpatologia.service.country;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.country.CountryDaoImpl;
import com.sd.uni.labpatologia.dao.country.ICountryDao;
import com.sd.uni.labpatologia.domain.country.CountryDomain;
import com.sd.uni.labpatologia.dto.country.CountryDTO;
import com.sd.uni.labpatologia.dto.country.CountryResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service
public class CountryServiceImpl extends BaseServiceImpl<CountryDTO, CountryDomain, CountryDaoImpl, CountryResult> implements ICountryService {
	@Autowired
	private ICountryDao countryDao;

	@Override
	@Transactional
	public CountryDTO save(CountryDTO dto) {
		final CountryDomain domain = convertDtoToDomain(dto);
		final CountryDomain countryDomain = countryDao.save(domain);
		return convertDomainToDto(countryDomain);
	}

	@Override
	@Transactional
	public CountryDTO getById(Integer id) throws PatologyException {
		final CountryDomain domain = countryDao.getById(id);
		final CountryDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public CountryResult getAll() {
		final List<CountryDTO> countries = new ArrayList<>();
		for (CountryDomain domain : countryDao.findAll()) {
			final CountryDTO dto = convertDomainToDto(domain);
			countries.add(dto);
		}
		final CountryResult countryResult = new CountryResult();
		countryResult.setCountries(countries);
		return countryResult;
	}

	@Override
	protected CountryDTO convertDomainToDto(CountryDomain domain) {
		final CountryDTO dto = new CountryDTO();
		dto.setId(domain.getId());
		dto.setName(domain.getName());
		return dto;
	}

	@Override
	protected CountryDomain convertDtoToDomain(CountryDTO dto) {
		final CountryDomain domain = new CountryDomain();
		domain.setId(dto.getId());
		domain.setName(dto.getName());
		return domain;
	}

	@Override
	public CountryResult find(String textToFind, int page, int maxItems) throws PatologyException {
		// TODO Auto-generated method stub
		return null;
	}

}
