package com.sd.uni.labpatologia.dao.base;

import java.util.List;

import com.sd.uni.labpatologia.domain.base.BaseDomain;
import com.sd.uni.labpatologia.exception.PatologyException;

public interface IBaseDao<DOMAIN extends BaseDomain> {

	public DOMAIN save(DOMAIN domain);

	public DOMAIN getById(Integer domainId)throws PatologyException;;
	
	public abstract List<DOMAIN>find(String textToFind) throws PatologyException;;

	public List<DOMAIN> findAll();
}
