package com.sd.uni.labpatologia.service.country;

import com.sd.uni.labpatologia.dao.country.CountryDaoImpl;
import com.sd.uni.labpatologia.domain.country.CountryDomain;
import com.sd.uni.labpatologia.dto.country.CountryDTO;
import com.sd.uni.labpatologia.dto.country.CountryResult;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface ICountryService extends IBaseService<CountryDTO, CountryDomain, CountryDaoImpl, CountryResult> {

}
