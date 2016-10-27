package com.sd.uni.labpatologia.service.laboratorio;

import com.sd.uni.labpatologia.dao.laboratorio.LaboratorioDaoImpl;

import com.sd.uni.labpatologia.domain.laboratorio.LaboratorioDomain;
import com.sd.uni.labpatologia.dto.laboratorio.LaboratorioDto;
import com.sd.uni.labpatologia.dto.laboratorio.LaboratorioResult;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface ILaboratorioService extends IBaseService<LaboratorioDto, LaboratorioDomain, LaboratorioDaoImpl, LaboratorioResult>{
	public LaboratorioResult find(String textToFind);
}
