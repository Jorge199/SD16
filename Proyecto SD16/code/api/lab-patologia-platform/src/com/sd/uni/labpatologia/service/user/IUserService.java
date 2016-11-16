package com.sd.uni.labpatologia.service.user;

import com.sd.uni.labpatologia.dao.user.UserDaoImpl;
import com.sd.uni.labpatologia.domain.user.UserDomain;
import com.sd.uni.labpatologia.dto.user.UserDTO;
import com.sd.uni.labpatologia.dto.user.UserResult;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface IUserService extends IBaseService<UserDTO, UserDomain, UserDaoImpl, UserResult> {
	UserDTO getByUsername(String username);
}
