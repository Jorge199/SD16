package com.sd.uni.labpatologia.service.base;

import com.sd.uni.labpatologia.dao.base.BaseDaoImpl;
import com.sd.uni.labpatologia.domain.base.BaseDomain;
import com.sd.uni.labpatologia.dto.base.BaseDTO;
import com.sd.uni.labpatologia.dto.base.BaseResult;

public interface IBaseService<DTO extends BaseDTO, DOMAIN extends BaseDomain, DAO extends BaseDaoImpl<DOMAIN>, R extends BaseResult<DTO>> {
	public DTO save(DTO dto);

	public DTO getById(Integer id);

	public R getAll();

}