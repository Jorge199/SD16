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
		UserDTO newDto = super.save(user);
	//	if (user.getId() == null) {
		//	getCacheManager().getCache(CACHE_REGION).put(
			//		"user_" + newDto.getId(), newDto);
//		}
		return newDto;
	}
	
	
	@Override
	//@Cacheable(value = CACHE_REGION, key = "'user_' + #id")
	public UserDTO getById(Integer id) {
		setWebResourceBasicAuthFilter();
		return super.getById(id);
	}
	
	@Override
	//@Cacheable(value = CACHE_REGION, key = "'users'")
	public UserResult getAll() {
		setWebResourceBasicAuthFilter();
		UserResult users = getWebResource().get(UserResult.class);
		return users;
	}

	@Override
	public UserResult find(String textToFind, int maxItems, int page) {
		setWebResourceBasicAuthFilter();
		final UserResult result = findWR(textToFind, maxItems, page).get(UserResult.class);
		return result;
	}
	
	@Override
	public UserDTO getByUsername(String username) {
		return getWebResource().path("/username/" + username).get(getDtoClass());
	}
}