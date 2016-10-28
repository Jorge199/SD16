package com.sd.uni.labpatologia.service.rol;

import com.sd.uni.labpatologia.dao.rol.RolDaoImpl;
import com.sd.uni.labpatologia.domain.rol.RolDomain;
import com.sd.uni.labpatologia.dto.rol.RolDTO;
import com.sd.uni.labpatologia.dto.rol.RolResult;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface IRolService extends IBaseService<RolDTO, RolDomain, RolDaoImpl, RolResult> {

	public RolResult find(String textToFind);
}
