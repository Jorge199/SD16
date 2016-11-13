package com.sd.uni.labpatologia.rest.rol;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dto.rol.RolDTO;
import com.sd.uni.labpatologia.dto.rol.RolResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;

@Repository("rolResource")
public class RolResourceImpl extends BaseResourceImpl<RolDTO> implements
		IRolResource {

	public RolResourceImpl() {
		super(RolDTO.class, "/rol");
	}

	@Override
	@CacheEvict(value = CACHE_REGION, key = "'roles'")
	@CachePut(value = CACHE_REGION, key = "'rol_' + #rol.id", condition = "#rol.id!=null")
	public RolDTO save(RolDTO rol) {
		RolDTO newDto = super.save(rol);
		if (null == rol.getId()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"rol_" + newDto.getId(), newDto);
		}
		return newDto;
	}

	@Cacheable(value = CACHE_REGION, key = "'rol_' + #id")
	@Override
	public RolDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'roles'")
	public RolResult getAll() {
		RolResult rols = getWebResource().get(RolResult.class);
		return rols;
	}
}
