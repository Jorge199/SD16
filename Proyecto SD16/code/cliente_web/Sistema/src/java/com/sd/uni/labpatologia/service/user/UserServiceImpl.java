package com.sd.uni.labpatologia.service.user;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.labpatologia.beans.laboratory.LaboratoryB;
import com.sd.uni.labpatologia.beans.user.UserB;
import com.sd.uni.labpatologia.dto.laboratory.LaboratoryDto;
import com.sd.uni.labpatologia.dto.laboratory.LaboratoryResult;
import com.sd.uni.labpatologia.dto.user.UserDTO;
import com.sd.uni.labpatologia.dto.user.UserResult;
import com.sd.uni.labpatologia.rest.user.IUserResource;
import com.sd.uni.labpatologia.rest.user.UserResourceImpl;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;
import com.sd.uni.labpatologia.service.rol.IRolService;
import com.sd.uni.labpatologia.service.rol.RolServiceImpl;
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserB, UserDTO> implements IUserService {
	@Autowired
	private  IUserResource _userResource = new UserResourceImpl();
	@Autowired
	private IRolService _rolService = new RolServiceImpl();

	public UserServiceImpl() {
	}

	@Override
	public UserB save(UserB bean) {
		final UserDTO dto = convertBeanToDto(bean);
		final UserDTO userDTO = _userResource.save(dto);
		return convertDtoToBean(userDTO);
	}

	@Override
	public List<UserB> getAll() {
		final UserResult result = _userResource.getAll();
		final List<UserDTO> uList = null == result.getUsers() ? new ArrayList<UserDTO>() : result.getUsers();
		final List<UserB> users = new ArrayList<UserB>();

		for (UserDTO dto : uList) {
			final UserB user = convertDtoToBean(dto);
			users.add(user);
		}
		return users;
	}

	@Override
	public UserB getById(Integer id) {
		final UserDTO dto = _userResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected UserB convertDtoToBean(UserDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		
		params.put("id", String.valueOf(dto.getId()));
		params.put("name", dto.getName());
		params.put("password", dto.getPassword());
		params.put("doctor", String.valueOf(dto.getDoctor()));
		params.put("matricula", dto.getMatricula());
		final UserB user = new UserB(params);
		user.setRol(_rolService.getById(dto.getRolId()));
		
		return user;
		
	}

	@Override
	protected UserDTO convertBeanToDto(UserB bean) {
		final UserDTO dto = new UserDTO();
		dto.setId(bean.getId());
		dto.setRolId(bean.getRol().getId());
		dto.setName(bean.getName());
		dto.setPassword(bean.getPassword());
		//modificar
		dto.setDoctor(bean.getDoctor());
		dto.setMatricula(bean.getMatricula());
		return dto;
	}

	@Override
	public List<UserB> find(String textToFind) {
		final UserResult result = _userResource.find(textToFind);
		final List<UserDTO> rList = null == result.getUsers() ? new ArrayList<UserDTO>()
				: result.getUsers();

		final List<UserB> users = new ArrayList<UserB>();
		for (UserDTO dto : rList) {
			final UserB bean = convertDtoToBean(dto);
			users.add(bean);
		}
		return users;
	}

}