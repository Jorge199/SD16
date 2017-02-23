package com.sd.uni.labpatologia.service.rol;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.rol.IRolDao;
import com.sd.uni.labpatologia.dao.rol.RolDaoImpl;
import com.sd.uni.labpatologia.domain.rol.RolDomain;
import com.sd.uni.labpatologia.dto.rol.RolDTO;
import com.sd.uni.labpatologia.dto.rol.RolResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service
public class RolServiceImpl extends BaseServiceImpl<RolDTO, RolDomain, RolDaoImpl, RolResult> implements IRolService {
	@Autowired
	private IRolDao rolDao;
	private static Logger logger = Logger.getLogger(RolServiceImpl.class);
	@Override
	@Transactional
	
	//@CacheEvict(value = "lab-patologia-platform-cache", key = "'roles'")
	@CachePut(value = "lab-patologia-platform-cache", key = "'rol_' + #dto.id", condition = "#dto.id!=null")
	public RolDTO save(RolDTO dto) {
		try{
		final RolDomain domain = convertDtoToDomain(dto);
		final RolDomain rol = rolDao.save(domain);
		final RolDTO newDto = convertDomainToDto(rol);
		if (dto.getId() == null) {
			getCacheManager().getCache("lab-patologia-platform-cache").put("rol_" + rol.getId(), newDto);
		}
		return newDto;
		}catch(PatologyException ex){
			logger.error(ex);
			throw new RuntimeException("Error"+RolServiceImpl.class+"" + ex.getMessage(), ex);
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "lab-patologia-platform-cache", key = "'rol_' + #id")
	public RolDTO getById(Integer id) throws PatologyException {
		final RolDomain domain = rolDao.getById(id);
		final RolDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	//@Cacheable(value = "lab-patologia-platform-cache", key = "'roles'")
	public RolResult getAll() {
		final List<RolDTO> rols = new ArrayList<>();
		for (RolDomain domain : rolDao.findAll()) {
			final RolDTO dto = convertDomainToDto(domain);
			rols.add(dto);
		}
		final RolResult rolResult = new RolResult();
		rolResult.setRols(rols);
		return rolResult;
	}

	@Override
	@Transactional(readOnly = true)
	public RolResult find(String textToFind, int page, int maxItems) throws PatologyException {
		final List<RolDTO> rols = new ArrayList<>();
		for (RolDomain domain : rolDao.find(textToFind, page, maxItems)) {
			final RolDTO dto = convertDomainToDto(domain);
			rols.add(dto);
		}
		final RolResult rolResult = new RolResult();
		rolResult.setRols(rols);
		return rolResult;
	}

	@Override
	protected RolDTO convertDomainToDto(RolDomain domain) {
		final RolDTO dto = new RolDTO();
		dto.setId(domain.getId());
		dto.setName(domain.getName());
		return dto;
	}

	@Override
	protected RolDomain convertDtoToDomain(RolDTO dto)  throws PatologyException{
		final RolDomain domain = new RolDomain();
		domain.setId(dto.getId());
		domain.setName(dto.getName());
		return domain;
	}

}
