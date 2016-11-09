package com.sd.isp.security;

import java.util.Date;

import javax.ws.rs.ext.Provider;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.isp.domain.session.SessionDomain;
import com.sd.isp.domain.user.UserDomain;
import com.sd.isp.service.security.session.ISessionService;
import com.sd.isp.service.security.user.IUserService;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import com.sun.jersey.spi.container.ResourceFilter;

@Component
@Provider
public class SdSecurityContextFilter implements ResourceFilter, ContainerRequestFilter {
	@Autowired
	ISessionService _sessionService;
	@Autowired
	IUserService _userService;

	@Override
	public ContainerRequest filter(ContainerRequest request) {
		final String sessionId = request.getHeaderValue("session-id");
		UserDomain user = null;
		SessionDomain session = null;
		
		if (sessionId != null && sessionId.length() > 0) {
			session = _sessionService.getById(Integer.valueOf(sessionId));

			if (null != session) {
				//user = _userService.getById(session.getUserId());
			}
			session.setLastAccessedTime(new Date());
		} else {
			final String token = request.getHeaderValue("token");
			System.out.println(token);
			if (StringUtils.isNotBlank(token)) {
				user = _userService.getByToken(token);
			}
			session = new SessionDomain();
			session.setUserId(user.getId());
			session.setActive(true);
			session.setSecure(true);
			session.setCreateTime(new Date());
			session.setLastAccessedTime(new Date());
			_sessionService.save(session);
		}

		request.setSecurityContext(new SdSecurityContext(session, user));
		return request;
	}

	@Override
	public ContainerRequestFilter getRequestFilter() {
		return this;
	}

	@Override
	public ContainerResponseFilter getResponseFilter() {
		// TODO Auto-generated method stub
		return null;
	}

}
