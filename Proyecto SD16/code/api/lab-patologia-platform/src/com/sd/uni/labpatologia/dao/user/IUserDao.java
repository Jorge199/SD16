package com.sd.uni.labpatologia.dao.user;

import java.util.List;

import com.sd.uni.labpatologia.dao.base.IBaseDao;
import com.sd.uni.labpatologia.domain.user.UserDomain;

public interface IUserDao extends IBaseDao<UserDomain> {

	public List<UserDomain>find(String textToFind);
}
