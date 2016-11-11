package com.sd.uni.labpatologia.rest.user;


//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dto.laboratory.LaboratoryResult;
import com.sd.uni.labpatologia.dto.user.UserDTO;
import com.sd.uni.labpatologia.dto.user.UserResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;
import com.sun.jersey.api.client.UniformInterface;

@Repository("userResource")
public class UserResourceImpl extends BaseResourceImpl<UserDTO> implements
		IUserResource {

	public UserResourceImpl() {
		super(UserDTO.class, "/user");
	}

	
	@Override
	public UserResult getAll() {
		UserResult users = getWebResource().get(UserResult.class);
		return users;
	}

	@Override
	public UserResult find(String textToFind) {
		final UserResult result = findWR(textToFind).get(UserResult.class);
		return result;
	}
}