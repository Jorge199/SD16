package com.sd.uni.labpatologia.service.laboratorio;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.laboratorio.ILaboratorioDao;
import com.sd.uni.labpatologia.dao.laboratorio.LaboratorioDaoImpl;
import com.sd.uni.labpatologia.domain.laboratorio.LaboratorioDomain;
import com.sd.uni.labpatologia.dto.laboratorio.LaboratorioDto;
import com.sd.uni.labpatologia.dto.laboratorio.LaboratorioResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;


@Service
public class LaboratorioServiceImpl extends BaseServiceImpl<LaboratorioDto, LaboratorioDomain, LaboratorioDaoImpl, LaboratorioResult> implements ILaboratorioService{
	@Autowired
	private ILaboratorioDao _labDao;
	
	@Override
	@Transactional
	public LaboratorioDto save(LaboratorioDto dto) {
		final LaboratorioDomain labDomain = convertDtoToDomain(dto);
		final LaboratorioDomain lab = _labDao.save(labDomain);
		return convertDomainToDto(lab);
	}

	@Override
	@Transactional
	public LaboratorioDto getById(Integer id) throws PatologyException {
		final LaboratorioDomain labDomain = _labDao.getById(id);
		final LaboratorioDto labDTO = convertDomainToDto(labDomain);
		return labDTO;
	}

	@Override
	@Transactional
	public LaboratorioResult getAll() {
		final List<LaboratorioDto> labs = new ArrayList<>();
		for (LaboratorioDomain domain : _labDao.findAll()) {
			final LaboratorioDto lab = convertDomainToDto(domain);
			labs.add(lab);
		}

		final LaboratorioResult labResult = new LaboratorioResult();
		labResult.setLaboratories(labs);
		return labResult;
	}

	@Override
	protected LaboratorioDto convertDomainToDto(LaboratorioDomain domain) {
		final LaboratorioDto lab = new LaboratorioDto();
		lab.setId(domain.getId());
		lab.setName(domain.getName());
		lab.setAddress(domain.getAddress());
		lab.setEmail(domain.getEmail());
		lab.setPhone(domain.getPhone());
		lab.setLogo(domain.getLogo());
		return lab;
	}

	@Override
	protected LaboratorioDomain convertDtoToDomain(LaboratorioDto dto) {
		final LaboratorioDomain lab = new LaboratorioDomain();
		lab.setId(dto.getId());
		lab.setName(dto.getName());
		lab.setAddress(dto.getAddress());
		lab.setEmail(dto.getEmail());
		lab.setPhone(dto.getPhone());
		lab.setLogo(dto.getLogo());
		return lab;
	}

	@Override
	@Transactional
	public LaboratorioResult find(String textToFind) throws PatologyException {
		final List<LaboratorioDto> labs = new ArrayList<>();
		for (LaboratorioDomain domain : _labDao.find(textToFind)) {
			final LaboratorioDto dto = convertDomainToDto(domain);
			labs.add(dto);
		}
		final LaboratorioResult labResult = new LaboratorioResult();
		labResult.setLaboratories(labs);
		return labResult;
	}

	

}
