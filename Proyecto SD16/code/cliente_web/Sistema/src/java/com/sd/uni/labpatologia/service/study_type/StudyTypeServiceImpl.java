package com.sd.uni.labpatologia.service.study_type;

import com.sd.uni.labpatologia.beans.study_type.StudyTypeB;
import com.sd.uni.labpatologia.dto.study_type.StudyTypeDTO;
import com.sd.uni.labpatologia.dto.study_type.StudyTypeResult;
import com.sd.uni.labpatologia.rest.study_type.IStudyTypeResource;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clientService")
public class StudyTypeServiceImpl extends BaseServiceImpl<StudyTypeB, StudyTypeDTO> 
                                    implements IStudyTypeService {
    
    @Autowired
    private IStudyTypeResource _studyTypeResource;
    @Autowired
    private IStudyTypeService _studyTypeService;
    
    public StudyTypeServiceImpl() {
    }
    
    @Override
    public StudyTypeB save(StudyTypeB bean) {
        final StudyTypeDTO studyType = convertBeanToDto(bean);
        final StudyTypeDTO dto = _studyTypeResource.save(studyType);
        final StudyTypeB studyTypeB = convertDtoToBean(dto);
        return studyTypeB;
    }

    @Override
    protected StudyTypeB convertDtoToBean(StudyTypeDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
	params.put("id", String.valueOf(dto.getId()));
	params.put("name", dto.getName());
	params.put("description", dto.getDescription());
        final StudyTypeB studyTypeB = new StudyTypeB(params);
	return studyTypeB;
    }

    @Override
    protected StudyTypeDTO convertBeanToDto(StudyTypeB bean) {
        final StudyTypeDTO dto = new StudyTypeDTO();
        dto.setId(bean.getId());
        dto.setName(bean.getName());
        dto.setDescription(bean.getDescription());
        return dto;
    }

    @Override
    public List<StudyTypeB> getAll() {
        final StudyTypeResult result = _studyTypeResource.getAll();
        final List<StudyTypeDTO> eList = null == result.getStudies() ? new ArrayList<StudyTypeDTO>()
                : result.getStudies();

        final List<StudyTypeB> studies = new ArrayList<StudyTypeB>();
        for (StudyTypeDTO dto : eList) {
            final StudyTypeB bean = convertDtoToBean(dto);
            studies.add(bean);
        }
        return studies;
    }

    @Override
    public StudyTypeB getById(Integer id) {
        final StudyTypeDTO dto = _studyTypeResource.getById(id);
        final StudyTypeB bean = convertDtoToBean(dto);

        return bean;
    }

}
