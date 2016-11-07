package com.sd.uni.labpatologia.rest.rol;


import com.sd.uni.labpatologia.dto.rol.RolDTO;
import com.sd.uni.labpatologia.dto.rol.RolResult;
import com.sd.uni.labpatologia.rest.base.IBaseResource;

public interface IRolResource extends IBaseResource<RolDTO> {
	public RolResult getAll();
}