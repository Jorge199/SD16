package com.sd.uni.labpatologia.service.laboratory;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.laboratory.ILaboratoryDao;
import com.sd.uni.labpatologia.dao.laboratory.LaboratoryDaoImpl;
import com.sd.uni.labpatologia.domain.laboratory.LaboratoryDomain;
import com.sd.uni.labpatologia.dto.laboratory.LaboratoryDto;
import com.sd.uni.labpatologia.dto.laboratory.LaboratoryResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;


@Service
public class LaboratoryServiceImpl extends BaseServiceImpl<LaboratoryDto, LaboratoryDomain, LaboratoryDaoImpl, LaboratoryResult> implements ILaboratoryService{
	@Autowired
	private ILaboratoryDao _laboratoryDao;
	
	@Override
	@Transactional
	public LaboratoryDto save(LaboratoryDto dto) {
		final LaboratoryDomain laboratoryDomain = convertDtoToDomain(dto);
		final LaboratoryDomain laboratory = _laboratoryDao.save(laboratoryDomain);
		return convertDomainToDto(laboratory);
	}

	@Override
	@Transactional
	public LaboratoryDto getById(Integer id) throws PatologyException {
		final LaboratoryDomain laboratoryDomain = _laboratoryDao.getById(id);
		final LaboratoryDto laboratoryDTO = convertDomainToDto(laboratoryDomain);
		return laboratoryDTO;
	}

	@Override
	@Transactional
	public LaboratoryResult getAll() {
		final List<LaboratoryDto> laboratories = new ArrayList<>();
		for (LaboratoryDomain domain : _laboratoryDao.findAll()) {
			final LaboratoryDto laboratory = convertDomainToDto(domain);
			laboratories.add(laboratory);
		}

		final LaboratoryResult laboratoryResult = new LaboratoryResult();
		laboratoryResult.setLaboratories(laboratories);
		return laboratoryResult;
	}

	@Override
	protected LaboratoryDto convertDomainToDto(LaboratoryDomain domain) {
		final LaboratoryDto laboratory = new LaboratoryDto();
		laboratory.setId(domain.getId());
		laboratory.setName(domain.getName());
		laboratory.setAddress(domain.getAddress());
		laboratory.setEmail(domain.getEmail());
		laboratory.setPhone(domain.getPhone());
		return laboratory;
	}

	@Override
	protected LaboratoryDomain convertDtoToDomain(LaboratoryDto dto) {
		final LaboratoryDomain laboratory = new LaboratoryDomain();
		laboratory.setId(dto.getId());
		laboratory.setName(dto.getName());
		laboratory.setAddress(dto.getAddress());
		laboratory.setEmail(dto.getEmail());
		laboratory.setPhone(dto.getPhone());
		return laboratory;
	}

	@Override
	@Transactional
	public LaboratoryResult find(String textToFind) throws PatologyException {
		final List<LaboratoryDto> laboratories = new ArrayList<>();
		for (LaboratoryDomain domain : _laboratoryDao.find(textToFind)) {
			final LaboratoryDto dto = convertDomainToDto(domain);
			laboratories.add(dto);
		}
		final LaboratoryResult laboratoryResult = new LaboratoryResult();
		laboratoryResult.setLaboratories(laboratories);
		return laboratoryResult;
	}

	

}
