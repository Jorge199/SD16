package com.sd.uni.labpatologia.rest.study_type;

import com.sd.uni.labpatologia.dto.study_type.StudyTypeDTO;
import com.sd.uni.labpatologia.dto.study_type.StudyTypeResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;


@Repository("studyTypeResource")
public class StudyTypeResourceImpl extends BaseResourceImpl<StudyTypeDTO> implements IStudyTypeResource {

    public StudyTypeResourceImpl() {
        super(StudyTypeDTO.class, "/study_type");
    }

    @Override
    public StudyTypeResult getAll() {
        final StudyTypeResult result = getWebResource().get(StudyTypeResult.class);
        return result;
    }

    @Override
    public StudyTypeResult find(String textToFind) {
        final StudyTypeResult result = findWR(textToFind).get(StudyTypeResult.class);
        return result;
    }
}
