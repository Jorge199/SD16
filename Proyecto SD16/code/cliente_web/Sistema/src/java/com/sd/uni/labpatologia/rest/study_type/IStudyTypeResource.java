package com.sd.uni.labpatologia.rest.study_type;

import com.sd.uni.labpatologia.dto.study_type.StudyTypeDTO;
import com.sd.uni.labpatologia.dto.study_type.StudyTypeResult;
import com.sd.uni.labpatologia.rest.base.IBaseResource;

/**
 * @author Alex Jiñes
 */
public interface IStudyTypeResource extends IBaseResource<StudyTypeDTO> {
    
    public StudyTypeResult getAll();
    public StudyTypeResult find(String textToFind);

}
