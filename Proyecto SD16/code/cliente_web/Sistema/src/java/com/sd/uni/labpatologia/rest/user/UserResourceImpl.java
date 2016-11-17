package com.sd.uni.labpatologia.rest.user;


//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dto.user.UserDTO;
import com.sd.uni.labpatologia.dto.user.UserResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;

@Repository("userResource")
public class UserResourceImpl extends BaseResourceImpl<UserDTO> implements
		IUserResource {

	public UserResourceImpl() {
		super(UserDTO.class, "/user");
	}

	@Override
//	@CacheEvict(value = CACHE_REGION, key = "'users'")
//	@CachePut(value = CACHE_REGION, key = "'user_' + #user.id", condition = "#user.id!=null")
	public UserDTO save(UserDTO user) {
		UserDTO newDto = getWebResource().entity(user).post(UserDTO.class);
	//	if (user.getId() == null) {
		//	getCacheManager().getCache(CACHE_REGION).put(
			//		"user_" + newDto.getId(), newDto);
//		}
		return newDto;
	}
	
	
	@Override
	//@Cacheable(value = CACHE_REGION, key = "'user_' + #id")
	public UserDTO getById(Integer id) {
		return getWebResource().path("/" + id).get(UserDTO.class);
	}
	
	@Override
	//@Cacheable(value = CACHE_REGION, key = "'users'")
	public UserResult getAll() {
		UserResult users = getWebResource().get(UserResult.class);
		return users;
	}

	@Override
	public UserResult find(String textToFind, int maxItems, int page) {
		if (null == textToFind){

			return getWebResource().path("/search/" + maxItems + "/" + page).get(UserResult.class);
		}else{
			return getWebResource().path("/search/" + maxItems + "/" + page + "/" + textToFind).get(UserResult.class);
		}
	}
	
	@Override
	public UserDTO getByUsername(String username) {
		
		return getWebResource().path("/username/" + username).get(getDtoClass());
	}
}