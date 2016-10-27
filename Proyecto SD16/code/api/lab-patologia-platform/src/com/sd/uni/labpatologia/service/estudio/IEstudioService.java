package com.sd.uni.labpatologia.service.estudio;

import com.sd.uni.labpatologia.dao.estudio.EstudioDaoImpl;
import com.sd.uni.labpatologia.domain.estudio.EstudioDomain;
import com.sd.uni.labpatologia.dto.estudio.EstudioDTO;
import com.sd.uni.labpatologia.dto.estudio.EstudioResult;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface IEstudioService extends IBaseService<EstudioDTO, EstudioDomain, EstudioDaoImpl, EstudioResult> {

}
