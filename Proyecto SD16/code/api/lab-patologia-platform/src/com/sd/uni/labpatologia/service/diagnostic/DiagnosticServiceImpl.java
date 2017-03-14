package com.sd.uni.labpatologia.service.diagnostic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.diagnostic.DiagnosticDaoImpl;
import com.sd.uni.labpatologia.dao.diagnostic.IDiagnosticDao;
import com.sd.uni.labpatologia.domain.diagnostic.DiagnosticDomain;
import com.sd.uni.labpatologia.dto.diagnostic.DiagnosticDto;
import com.sd.uni.labpatologia.dto.diagnostic.DiagnosticResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;


@Service
public class DiagnosticServiceImpl extends BaseServiceImpl<DiagnosticDto, DiagnosticDomain, DiagnosticDaoImpl, DiagnosticResult> implements IDiagnosticService{
	@Autowired
	private IDiagnosticDao _diagnosticDao;
	
	private static Logger logger = Logger.getLogger(DiagnosticServiceImpl.class);
	
	@Override
	@Transactional
	@CachePut(value = "lab-patologia-platform-cache", key = "'diagnostic_' + #dto.id", condition="#dto.id!=null")
	public DiagnosticDto save(DiagnosticDto dto) {
		try { 
		    // Lanzo exepcion de tipo runtime para realizar rollback
			final DiagnosticDomain diagnosticDomain = convertDtoToDomain(dto);
			final DiagnosticDomain diagnostic = _diagnosticDao.save(diagnosticDomain);
			final DiagnosticDto newDto = convertDomainToDto(diagnostic);
			if (dto.getId() == null) {
				getCacheManager().getCache("lab-patologia-platform-cache").put("diagnostic_" + diagnostic.getId(), newDto);
			}
			return newDto;
		} catch(PatologyException ex) { 
			 logger.error(ex);
			 throw new RuntimeException("Error"+DiagnosticServiceImpl.class+"" + ex.getMessage(), ex); 
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "lab-patologia-platform-cache", key = "'diagnostic_' + #id")
	public DiagnosticDto getById(Integer id) throws PatologyException {
		final DiagnosticDomain diagnosticDomain = _diagnosticDao.getById(id);
		final DiagnosticDto diagnosticDTO = convertDomainToDto(diagnosticDomain);
		return diagnosticDTO;
	}

	@Override
	@Transactional(readOnly = true)
	//@Cacheable(value = "lab-patologia-platform-cache", key = "'diagnostics'")
	public DiagnosticResult getAll() {
		final List<DiagnosticDto> diagnostics = new ArrayList<>();
		for (DiagnosticDomain domain : _diagnosticDao.findAll()) {
			final DiagnosticDto diagnostic = convertDomainToDto(domain);
			diagnostics.add(diagnostic);
		}

		final DiagnosticResult diagnosticResult = new DiagnosticResult();
		diagnosticResult.setDiagnostics(diagnostics);
		return diagnosticResult;
	}

	@Override
	protected DiagnosticDto convertDomainToDto(DiagnosticDomain domain) {
		final DiagnosticDto diagnostic = new DiagnosticDto();
		diagnostic.setId(domain.getId());
		diagnostic.setName(domain.getName());
		diagnostic.setDescription(domain.getDescription());
		return diagnostic;
	}

	@Override
	protected DiagnosticDomain convertDtoToDomain(DiagnosticDto dto) throws PatologyException{
		final DiagnosticDomain diagnostic = new DiagnosticDomain();
		diagnostic.setId(dto.getId());
		diagnostic.setName(dto.getName());
		diagnostic.setDescription(dto.getDescription());
		return diagnostic;
	}

	@Override
	@Transactional(readOnly = true)
	public DiagnosticResult find(String textToFind, int page, int maxItems) throws PatologyException {
		final List<DiagnosticDto> diagnostics = new ArrayList<>();
		for (DiagnosticDomain domain : _diagnosticDao.find(textToFind, page, maxItems)) {
			final DiagnosticDto dto = convertDomainToDto(domain);
			diagnostics.add(dto);
		}
		final DiagnosticResult diagnosticResult = new DiagnosticResult();
		diagnosticResult.setDiagnostics(diagnostics);
		return diagnosticResult;
	}

}