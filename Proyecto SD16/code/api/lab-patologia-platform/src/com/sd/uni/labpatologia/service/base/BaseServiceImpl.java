package com.sd.uni.labpatologia.service.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;

import com.sd.uni.labpatologia.dao.base.BaseDaoImpl;
import com.sd.uni.labpatologia.domain.base.BaseDomain;
import com.sd.uni.labpatologia.dto.base.BaseDTO;
import com.sd.uni.labpatologia.dto.base.BaseResult;
import com.sd.uni.labpatologia.exception.PatologyException;

public abstract class BaseServiceImpl<DTO extends BaseDTO, DOMAIN extends BaseDomain, DAO extends BaseDaoImpl<DOMAIN>, RESULT extends BaseResult<DTO>>
		implements IBaseService<DTO, DOMAIN, DAO, RESULT> {
	@Autowired
	private CacheManager _cacheManager;

	protected CacheManager getCacheManager() {
		return _cacheManager;
	}

	protected abstract DTO convertDomainToDto(DOMAIN domain) throws PatologyException;

	protected abstract DOMAIN convertDtoToDomain(DTO dto) throws PatologyException;

}
