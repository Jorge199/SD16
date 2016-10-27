package com.sd.uni.labpatologia.dao.request;

import java.util.List;

import com.sd.uni.labpatologia.dao.base.IBaseDao;
import com.sd.uni.labpatologia.domain.request.RequestDomain;

public interface IRequestDao extends IBaseDao<RequestDomain>{
	public List<RequestDomain>find(String textToFind) throws Exception;
}
