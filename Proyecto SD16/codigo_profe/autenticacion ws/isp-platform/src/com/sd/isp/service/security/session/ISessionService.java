package com.sd.isp.service.security.session;

import com.sd.isp.domain.session.SessionDomain;

public interface ISessionService {

	public SessionDomain getById(Integer id);

	public SessionDomain save(SessionDomain domain);
}
