package com.sd.uni.labpatologia.rest.rol;


//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
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
	//@CacheEvict(value = CACHE_REGION, key = "'rol_' + #dto.id", condition = "#dto.id!=null")
	public RolDTO save(RolDTO dto) {
		final RolDTO rol = getWebResource().entity(dto).post(getDtoClass());
		return rol;
	}

	//@Cacheable(value = CACHE_REGION, key = "'country_' + #id")
	@Override
	public RolDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	public RolResult getAll() {
		RolResult rols = getWebResource().get(RolResult.class);
		/*for (RolDTO rol : rols.getRols()) {
			getCacheManager().getCache(CACHE_REGION).put("rol_" + rol.getId(), rol);
		}*/
		return rols;
	}
}
