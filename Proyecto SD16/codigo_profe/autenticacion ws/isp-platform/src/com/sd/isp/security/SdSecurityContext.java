package com.sd.isp.security;

import java.security.Principal;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.sd.isp.domain.session.SessionDomain;
import com.sd.isp.domain.user.UserDomain;

public class SdSecurityContext implements SecurityContext {
	private final UserDomain _user;
	private final SessionDomain _session;

	public SdSecurityContext(SessionDomain session, UserDomain user) {
		_session = session;
		_user = user;
	}

	@Override
	public String getAuthenticationScheme() {
		return SecurityContext.BASIC_AUTH;
	}

	@Override
	public Principal getUserPrincipal() {
		return _user;
	}

	@Override
	public boolean isSecure() {
		return null != _session ? _session.isSecure() : false;
	}

	@Override
	public boolean isUserInRole(String role) {
		/*if (null == _session || !_session.isActive()) {
			Response denied = Response.status(Response.Status.FORBIDDEN).entity("Permission denied").build();
			throw new WebApplicationException(denied);
		}*/

		try {
			return _user.getRoles().equals(UserDomain.Role.valueOf(role));
		} catch (Exception e) {
			throw e;
		}
		// return false;
	}

}
