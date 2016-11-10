package com.sd.uni.labpatologia.rest.user;

import com.sd.uni.labpatologia.dto.user.UserDTO;
import com.sd.uni.labpatologia.dto.user.UserResult;
import com.sd.uni.labpatologia.rest.base.IBaseResource;

public interface IUserResource extends IBaseResource<UserDTO> {

	public UserResult getAll();
}