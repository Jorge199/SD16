package com.sd.uni.labpatologia.dao.laboratorio;

import com.sd.uni.labpatologia.dao.base.IBaseDao;

import com.sd.uni.labpatologia.domain.laboratorio.LaboratorioDomain;


import java.util.List;

public interface ILaboratorioDao extends IBaseDao<LaboratorioDomain>{
	public List<LaboratorioDomain>find(String textToFind);
}
