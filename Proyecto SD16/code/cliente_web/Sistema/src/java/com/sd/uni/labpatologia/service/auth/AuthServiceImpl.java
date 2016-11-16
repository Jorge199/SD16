/* Este servicio provee los metodos para obtener el username y password del usuario
 * logueado. Este servicio se usa en rest/BaseResourceImpl en el método setWebResourceBasicAuthFilter */
package com.sd.uni.labpatologia.service.auth;

import grails.plugin.springsecurity.userdetails.GrailsUser;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("AuthService")
public class AuthServiceImpl implements IAuthService {
		
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
}
