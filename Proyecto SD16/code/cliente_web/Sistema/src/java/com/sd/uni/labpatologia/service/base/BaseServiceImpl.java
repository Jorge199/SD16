package com.sd.uni.labpatologia.service.base;

import com.sd.uni.labpatologia.beans.base.BaseBean;
import com.sd.uni.labpatologia.dto.base.BaseDTO;

public abstract class BaseServiceImpl<BEAN extends BaseBean, DTO extends BaseDTO> implements IBaseService<BEAN, DTO> {

	public BaseServiceImpl() {

	}

	protected abstract BEAN convertDtoToBean(DTO dto);

	protected abstract DTO convertBeanToDto(BEAN bean);

}
