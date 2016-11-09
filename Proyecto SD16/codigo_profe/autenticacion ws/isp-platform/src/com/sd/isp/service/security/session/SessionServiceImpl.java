package com.sd.isp.service.security.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.isp.dao.session.ISessionDao;
import com.sd.isp.domain.session.SessionDomain;

@Service
public class SessionServiceImpl implements ISessionService {

	@Autowired
	private ISessionDao _sessionDao;

	@Override
	@Transactional
	public SessionDomain getById(Integer id) {
		return _sessionDao.getById(id);
	}

	@Override
	@Transactional
	public SessionDomain save(SessionDomain domain) {
		SessionDomain newSession = _sessionDao.save(domain);
		return newSession;
	}

}
