package com.sd.isp.service.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.user.IUserDao;
import com.sd.isp.domain.user.UserDomain;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao _userDao;

	@Transactional
	public UserDomain getByToken(String token) {
		return _userDao.getByToken(token);
	}
}
