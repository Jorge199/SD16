package com.sd.uni.labpatologia.service.study_type;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.study_type.IStudyTypeDao;
import com.sd.uni.labpatologia.dao.study_type.StudyTypeDaoImpl;
import com.sd.uni.labpatologia.domain.study_type.StudyTypeDomain;
import com.sd.uni.labpatologia.dto.report.ReportDTO;
import com.sd.uni.labpatologia.dto.study_type.StudyTypeDTO;
import com.sd.uni.labpatologia.dto.study_type.StudyTypeResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service
public class StudyTypeImpl extends BaseServiceImpl<StudyTypeDTO, StudyTypeDomain, StudyTypeDaoImpl, StudyTypeResult> implements IStudyTypeService {
	@Autowired
	private IStudyTypeDao _studyTypeDao;

	@Override
	@Transactional
	@CacheEvict(value = "lab-patologia-platform-cache", key = "'studytype_' + #studytype.id", condition="#dto.id!=null")
	public StudyTypeDTO save(StudyTypeDTO dto) {
		final StudyTypeDomain domain = convertDtoToDomain(dto);
		final StudyTypeDomain study = _studyTypeDao.save(domain);
		final StudyTypeDTO newDto = convertDomainToDto(study);
		if (dto.getId() == null) {
			getCacheManager().getCache("lab-patologia-platform-cache").put("studytype_" + study.getId(), newDto);
		}
		return newDto;
	}

	@Override
	@Transactional
	@Cacheable(value = "lab-patologia-platform-cache", key = "'studytype_' + #id")
	public StudyTypeDTO getById(Integer id) throws PatologyException {
		final StudyTypeDomain domain = _studyTypeDao.getById(id);
		final StudyTypeDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	@Cacheable(value = "lab-patologia-platform-cache", key = "'studiestypes'")
	public StudyTypeResult getAll() {
		final List<StudyTypeDTO> estudios = new ArrayList<>();
		for (StudyTypeDomain domain : _studyTypeDao.findAll()) {
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
		dto.setDescription(domain.getDescription());
		return dto;
	}

	@Override
	protected StudyTypeDomain convertDtoToDomain(StudyTypeDTO dto) {
		final StudyTypeDomain domain = new StudyTypeDomain();
		domain.setId(dto.getId());
		domain.setName(dto.getName());
		domain.setDescription(dto.getDescription());
		return domain;
	}

	@Override
	@Transactional
	public StudyTypeResult find(String textToFind, int page, int maxItems) throws PatologyException {
		final List<StudyTypeDTO> studies = new ArrayList<>();
		for (StudyTypeDomain domain : _studyTypeDao.find(textToFind, page, maxItems)) {
			final StudyTypeDTO dto = convertDomainToDto(domain);
			studies.add(dto);
		}
		final StudyTypeResult studyResult = new StudyTypeResult();
		studyResult.setStudies(studies);
		return studyResult;
	}

}
