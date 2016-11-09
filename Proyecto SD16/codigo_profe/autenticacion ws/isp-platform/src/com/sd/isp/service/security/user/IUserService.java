package com.sd.isp.service.security.user;

import com.sd.isp.domain.user.UserDomain;

public interface IUserService {
	public UserDomain getByToken(String token);
}
