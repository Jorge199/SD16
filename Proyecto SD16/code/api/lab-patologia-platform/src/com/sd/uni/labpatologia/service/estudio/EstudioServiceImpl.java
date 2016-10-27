package com.sd.uni.labpatologia.service.estudio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.estudio.EstudioDaoImpl;
import com.sd.uni.labpatologia.dao.estudio.IEstudioDao;
import com.sd.uni.labpatologia.domain.estudio.EstudioDomain;
import com.sd.uni.labpatologia.dto.estudio.EstudioDTO;
import com.sd.uni.labpatologia.dto.estudio.EstudioResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service
public class EstudioServiceImpl extends BaseServiceImpl<EstudioDTO, EstudioDomain, EstudioDaoImpl, EstudioResult> implements IEstudioService {
	@Autowired
	private IEstudioDao estudioDao;

	@Override
	@Transactional
	public EstudioDTO save(EstudioDTO dto) {
		final EstudioDomain domain = convertDtoToDomain(dto);
		final EstudioDomain estudioDomain = estudioDao.save(domain);
		return convertDomainToDto(estudioDomain);
	}

	@Override
	@Transactional
	public EstudioDTO getById(Integer id) throws PatologyException {
		final EstudioDomain domain = estudioDao.getById(id);
		final EstudioDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public EstudioResult getAll() {
		final List<EstudioDTO> estudios = new ArrayList<>();
		for (EstudioDomain domain : estudioDao.findAll()) {
			final EstudioDTO dto = convertDomainToDto(domain);
			estudios.add(dto);
		}
		final EstudioResult estudioResult = new EstudioResult();
		estudioResult.setEstudios(estudios);
		return estudioResult;
	}

	@Override
	protected EstudioDTO convertDomainToDto(EstudioDomain domain) {
		final EstudioDTO dto = new EstudioDTO();
		dto.setId(domain.getId());
		dto.setName(domain.getName());
		return dto;
	}

	@Override
	protected EstudioDomain convertDtoToDomain(EstudioDTO dto) {
		final EstudioDomain domain = new EstudioDomain();
		domain.setId(dto.getId());
		domain.setName(dto.getName());
		return domain;
	}

	@Override
	public EstudioResult find(String textToFind) throws PatologyException {
		// TODO Auto-generated method stub
		return null;
	}

}
