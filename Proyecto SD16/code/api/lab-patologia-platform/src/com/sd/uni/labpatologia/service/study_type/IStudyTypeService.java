package com.sd.uni.labpatologia.service.study_type;

import com.sd.uni.labpatologia.dao.study_type.StudyTypeDaoImpl;
import com.sd.uni.labpatologia.domain.study_type.StudyTypeDomain;
import com.sd.uni.labpatologia.dto.study_type.StudyTypeDTO;
import com.sd.uni.labpatologia.dto.study_type.StudyTypeResult;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface IStudyTypeService extends IBaseService<StudyTypeDTO, StudyTypeDomain, StudyTypeDaoImpl, StudyTypeResult> {

}
