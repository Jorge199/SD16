package com.sd.uni.labpatologia.service.base;

import java.util.List;

import com.sd.uni.labpatologia.beans.base.BaseBean;
import com.sd.uni.labpatologia.dto.base.BaseDTO;

public interface IBaseService<BEAN extends BaseBean, DTO extends BaseDTO> {
	public BEAN save(BEAN bean);

	public List<BEAN> getAll();

	public BEAN getById(Integer id);
}
