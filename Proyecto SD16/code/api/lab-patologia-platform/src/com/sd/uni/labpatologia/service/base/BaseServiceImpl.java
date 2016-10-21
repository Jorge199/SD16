package com.sd.uni.labpatologia.service.base;

import com.sd.uni.labpatologia.dao.base.BaseDaoImpl;
import com.sd.uni.labpatologia.domain.base.BaseDomain;
import com.sd.uni.labpatologia.dto.base.BaseDTO;
import com.sd.uni.labpatologia.dto.base.BaseResult;

public abstract class BaseServiceImpl<DTO extends BaseDTO, DOMAIN extends BaseDomain, DAO extends BaseDaoImpl<DOMAIN>, RESULT extends BaseResult<DTO>> implements IBaseService<DTO, DOMAIN, DAO, RESULT> {

	protected abstract DTO convertDomainToDto(DOMAIN domain);

	protected abstract DOMAIN convertDtoToDomain(DTO dto);

}
