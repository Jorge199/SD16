package com.sd.isp.security;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.container.filter.RolesAllowedResourceFilterFactory;
import com.sun.jersey.api.model.AbstractMethod;
import com.sun.jersey.spi.container.ResourceFilter;

@Component
@Provider
public class SdResourceFilterFactory extends RolesAllowedResourceFilterFactory {
	@Autowired
	private SdSecurityContextFilter _securityContextFilter;

	@Override
	public List<ResourceFilter> create(AbstractMethod am) {
		List<ResourceFilter> rolesFilters = super.create(am);
		if (null == rolesFilters) {
			rolesFilters = new ArrayList<ResourceFilter>();
		}

		final List<ResourceFilter> filters = new ArrayList<ResourceFilter>(rolesFilters);
		filters.add(_securityContextFilter);
		return filters;
	}
}
