package com.sd.uni.labpatologia.rest.base;

import com.sd.uni.labpatologia.dto.base.BaseDTO;

public interface IBaseResource<DTO extends BaseDTO> {

	public DTO save(DTO dto);

	public DTO getById(Integer id);

}
