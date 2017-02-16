package com.sd.uni.labpatologia.dao.request;


import com.sd.uni.labpatologia.dao.base.IBaseDao;
import com.sd.uni.labpatologia.domain.request.RequestDomain;

public interface IRequestDao extends IBaseDao<RequestDomain>{
	public int getCount();
}
