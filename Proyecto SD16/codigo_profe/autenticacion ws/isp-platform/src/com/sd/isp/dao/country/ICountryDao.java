package com.sd.isp.dao.country;

import java.util.List;

import com.sd.isp.dao.base.IBaseDao;
import com.sd.isp.domain.location.country.CountryDomain;

public interface ICountryDao extends IBaseDao<CountryDomain> {

	public List<CountryDomain>find(String textToFind);
}
