package com.sd.uni.labpatologia.dao.base;

import java.util.List;

import com.sd.uni.labpatologia.domain.base.BaseDomain;

public interface IBaseDao<DOMAIN extends BaseDomain> {

	public DOMAIN save(DOMAIN domain);

	public DOMAIN getById(Integer domainId);
	
	

	public List<DOMAIN> findAll();
}
