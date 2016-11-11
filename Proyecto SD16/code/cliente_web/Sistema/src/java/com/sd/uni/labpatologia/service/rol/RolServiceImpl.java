package com.sd.uni.labpatologia.service.rol;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.labpatologia.beans.rol.RolB;
import com.sd.uni.labpatologia.dto.rol.RolDTO;
import com.sd.uni.labpatologia.dto.rol.RolResult;
import com.sd.uni.labpatologia.rest.rol.IRolResource;
import com.sd.uni.labpatologia.rest.rol.RolResourceImpl;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service("rolService")
public class RolServiceImpl extends BaseServiceImpl<RolB, RolDTO>
		implements IRolService {
	@Autowired
	private IRolResource _rolResource=new RolResourceImpl();
	
	
	public RolServiceImpl() {
	}

	@Override
	public RolB save(RolB bean) {
		final RolDTO dto = convertBeanToDto(bean);
		final RolDTO rolDTO = _rolResource.save(dto);
		return convertDtoToBean(rolDTO);
	}

	@Override
	public List<RolB> getAll() {
		final RolResult result = _rolResource.getAll();
		final List<RolDTO> rList = null == result.getRols() ? new ArrayList<RolDTO>()
				: result.getRols();
		final List<RolB> rols = new ArrayList<RolB>();

		for (RolDTO dto : rList) {
			final RolB rolB = convertDtoToBean(dto);
			rols.add(rolB);
		}
		return rols;
	}

	@Override
	public RolB getById(Integer id) {
		final RolDTO dto = _rolResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected RolB convertDtoToBean(RolDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("name", dto.getName());
		final RolB rolB = new RolB(params);
		return rolB;
	}

	@Override
	protected RolDTO convertBeanToDto(RolB bean) {
		final RolDTO dto = new RolDTO();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		return dto;
	}

	@Override
	public List<RolB> find(String textToFind, int maxItems, int page) {
		// TODO Auto-generated method stub
		return null;
	}

}