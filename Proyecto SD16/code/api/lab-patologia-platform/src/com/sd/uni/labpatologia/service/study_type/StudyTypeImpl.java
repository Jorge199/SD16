package com.sd.uni.labpatologia.service.study_type;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.study_type.IStudyTypeDao;
import com.sd.uni.labpatologia.dao.study_type.StudyTypeDaoImpl;
import com.sd.uni.labpatologia.domain.study_type.StudyTypeDomain;
import com.sd.uni.labpatologia.dto.study_type.StudyTypeDTO;
import com.sd.uni.labpatologia.dto.study_type.StudyTypeResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service
public class StudyTypeImpl extends BaseServiceImpl<StudyTypeDTO, StudyTypeDomain, StudyTypeDaoImpl, StudyTypeResult> implements IStudyTypeService {
	@Autowired
	private IStudyTypeDao estudioDao;

	@Override
	@Transactional
	public StudyTypeDTO save(StudyTypeDTO dto) {
		final StudyTypeDomain domain = convertDtoToDomain(dto);
		final StudyTypeDomain estudioDomain = estudioDao.save(domain);
		return convertDomainToDto(estudioDomain);
	}

	@Override
	@Transactional
	public StudyTypeDTO getById(Integer id) throws PatologyException {
		final StudyTypeDomain domain = estudioDao.getById(id);
		final StudyTypeDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public StudyTypeResult getAll() {
		final List<StudyTypeDTO> estudios = new ArrayList<>();
		for (StudyTypeDomain domain : estudioDao.findAll()) {
			final StudyTypeDTO dto = convertDomainToDto(domain);
			estudios.add(dto);
		}
		final StudyTypeResult estudioResult = new StudyTypeResult();
		estudioResult.setStudies(estudios);
		return estudioResult;
	}

	@Override
	protected StudyTypeDTO convertDomainToDto(StudyTypeDomain domain) {
		final StudyTypeDTO dto = new StudyTypeDTO();
		dto.setId(domain.getId());
		dto.setName(domain.getName());
		return dto;
	}

	@Override
	protected StudyTypeDomain convertDtoToDomain(StudyTypeDTO dto) {
		final StudyTypeDomain domain = new StudyTypeDomain();
		domain.setId(dto.getId());
		domain.setName(dto.getName());
		return domain;
	}

	@Override
	public StudyTypeResult find(String textToFind) throws PatologyException {
		// TODO Auto-generated method stub
		return null;
	}

}
