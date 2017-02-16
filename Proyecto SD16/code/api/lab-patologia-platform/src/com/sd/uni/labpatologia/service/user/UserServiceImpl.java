package com.sd.uni.labpatologia.service.user;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;





import com.sd.uni.labpatologia.dao.rol.IRolDao;
import com.sd.uni.labpatologia.dao.user.IUserDao;
import com.sd.uni.labpatologia.dao.user.UserDaoImpl;
import com.sd.uni.labpatologia.domain.user.UserDomain;
import com.sd.uni.labpatologia.dto.user.UserDTO;
import com.sd.uni.labpatologia.dto.user.UserResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;
import com.sd.uni.labpatologia.service.doctor.DoctorServiceImpl;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserDTO, UserDomain, UserDaoImpl, UserResult>
		implements IUserService {
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IRolDao rolDao;
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Override
	@Transactional

	//@CacheEvict(value= "lab-patologia-platform-cache",key = "'users'")
	@CachePut(value = "lab-patologia-platform-cache", key = "'user_' + #dto.id", condition="#dto.id!=null")
	public UserDTO save(UserDTO dto) {
		try{
		final UserDomain domain = convertDtoToDomain(dto);
		final UserDomain user = userDao.save(domain);
		final UserDTO newDto = convertDomainToDto(user);
		if (dto.getId() == null) {
			getCacheManager().getCache("lab-patologia-platform-cache").put("user_" + user.getId(), newDto);
		}
		return newDto;
		}catch(PatologyException ex){
			 logger.error(ex);
			 throw new RuntimeException("Error"+UserServiceImpl.class+"" + ex.getMessage(), ex); 
		}
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "lab-patologia-platform-cache", key = "'user_' + #id")
	public UserDTO getById(Integer id) throws PatologyException {
		final UserDomain domain = userDao.getById(id);
		final UserDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	//@Cacheable(value = "lab-patologia-platform-cache", key = "'users'")
	public UserResult getAll() {
		final List<UserDTO> user = new ArrayList<>();
		for (UserDomain domain : userDao.findAll()) {
			final UserDTO dto = convertDomainToDto(domain);
			user.add(dto);
		}
		final UserResult userResult = new UserResult();
		userResult.setUsers(user);
		return userResult;
	}

	@Override
	@Transactional(readOnly = true)
	public UserResult find(String textToFind, int page, int maxItems) throws PatologyException {
		final List<UserDTO> users = new ArrayList<>();
		for (UserDomain domain : userDao.find(textToFind, page, maxItems)) {
			final UserDTO dto = convertDomainToDto(domain);
			users.add(dto);
		}
		final UserResult usuarioResult = new UserResult();
		usuarioResult.setUsers(users);
		return usuarioResult;
	}
	
	@Cacheable(value="lab-patologia-platform-cache", key="'user_' + #username")
	@Transactional(readOnly = true)
	public UserDTO getByUsername(String username) {
		final UserDomain userDomain = userDao.getByUsername(username);
		return convertDomainToDto(userDomain);
	}

	@Override
	protected UserDTO convertDomainToDto(UserDomain domain){
		final UserDTO dto = new UserDTO();
		dto.setId(domain.getId());
		dto.setName(domain.getName());
		dto.setUserName(domain.getUserName());
		dto.setLastName(domain.getLastName());
		dto.setSex(domain.getSex());
		dto.setPassword(domain.getPassword());
		dto.setRolId(domain.getRol().getId());
		dto.setRegistrationNumber(domain.getRegistrationNumber());
		return dto;
	}

	@Override
	protected UserDomain convertDtoToDomain(UserDTO dto)throws PatologyException  {
		final UserDomain domain = new UserDomain();
		domain.setId(dto.getId());
		domain.setName(dto.getName());
		domain.setUserName(dto.getUserName());
		domain.setLastName(dto.getLastName());
		domain.setSex(dto.getSex());
		domain.setPassword(dto.getPassword(), dto.getId());
		domain.setRegistrationNumber(dto.getRegistrationNumber());
		
		try {
			domain.setRol(rolDao.getById(dto.getRolId()));
		} catch (PatologyException e) {
			e.printStackTrace();
		}
		
		return domain;
	}

}
