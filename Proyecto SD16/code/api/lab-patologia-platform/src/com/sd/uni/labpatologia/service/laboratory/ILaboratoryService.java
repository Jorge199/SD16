package com.sd.uni.labpatologia.service.laboratory;

import com.sd.uni.labpatologia.dao.laboratory.LaboratoryDaoImpl;
import com.sd.uni.labpatologia.domain.laboratory.LaboratoryDomain;
import com.sd.uni.labpatologia.dto.laboratory.LaboratoryDto;
import com.sd.uni.labpatologia.dto.laboratory.LaboratoryResult;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface ILaboratoryService extends IBaseService<LaboratoryDto, LaboratoryDomain, LaboratoryDaoImpl, LaboratoryResult>{
	
}
