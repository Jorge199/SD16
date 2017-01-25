package login;

import grails.plugin.springsecurity.userdetails.GrailsUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sd.uni.labpatologia.beans.user.UserB;
import com.sd.uni.labpatologia.service.user.IUserService;

public class MyAuthenticationProvider implements AuthenticationProvider {

	BCryptPasswordEncoder _passwordEncoder = new BCryptPasswordEncoder();
	@Autowired
	private IUserService _userService;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		UsernamePasswordAuthenticationToken authentic = (UsernamePasswordAuthenticationToken) authentication;
		String username = String.valueOf(authentic.getPrincipal());
		String password = String.valueOf(authentic.getCredentials());
		UserB user;
		try{
			user = _userService.getByUsername(username);
		}catch(Exception exc){
			throw new BadCredentialsException("userError");
		}
		System.out.println("buscar" + user.getRol().getName());

		if (user != null) {
			if (_passwordEncoder.matches(password, user.getPassword())) {
				List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				authorities.add(new GrantedAuthorityImpl(user.getRol().getName()));
				if (authorities != null) {
					Boolean enabled = Boolean.valueOf(user.getAccountLocked());
					GrailsUser userDetails = new GrailsUser(username, password,
							enabled, true, true, true, authorities, 1);
					UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
							userDetails, password, userDetails.getAuthorities());
					token.setDetails(authentic.getDetails());
					return token;
				} else{
					throw new BadCredentialsException("Log in failed: El usuario no tiene ningun rol");
				}
			} else {
				throw new BadCredentialsException(
						"passError");
			}
		}
		return authentic;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
}
