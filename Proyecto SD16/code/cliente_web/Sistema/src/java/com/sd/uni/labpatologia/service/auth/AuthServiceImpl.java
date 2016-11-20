/* Este servicio provee los metodos para obtener el username y password del usuario
 * logueado. Este servicio se usa en rest/BaseResourceImpl en el método setWebResourceBasicAuthFilter */
package com.sd.uni.labpatologia.service.auth;

import grails.plugin.springsecurity.userdetails.GrailsUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sd.uni.labpatologia.beans.rol.RolB;
import com.sd.uni.labpatologia.beans.user.UserB;
import com.sd.uni.labpatologia.service.user.IUserService;

@Service("AuthService")
public class AuthServiceImpl implements IAuthService {
	@Autowired
	IUserService _userService;
	public AuthServiceImpl(){		
	}	
	
	public String getUsername(){
		GrailsUser userDetails = (GrailsUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return userDetails.getUsername();
	}	
	
	public String getPassword(){
		GrailsUser userDetails = (GrailsUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return userDetails.getPassword();
	}
	
	public RolB getRol(){
		UserB user = _userService.getByUsername(getUsername());
		return user.getRol();
	}

	@Override
	public String getName() {
		UserB user = _userService.getByUsername(getUsername());
		return user.getName();
	}
}
