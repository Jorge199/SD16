/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sd.uni.labpatologia.service.diagnostic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.labpatologia.beans.diagnostic.DiagnosticB;
import com.sd.uni.labpatologia.dto.diagnostic.DiagnosticDto;
import com.sd.uni.labpatologia.dto.diagnostic.DiagnosticResult;
import com.sd.uni.labpatologia.rest.diagnostic.IDiagnosticResource;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service("diagnosticService")
public class DiagnosticServiceImpl extends BaseServiceImpl<DiagnosticB, DiagnosticDto>
implements IDiagnosticService {

	@Autowired
	private IDiagnosticResource _diagnosticResource;

	public DiagnosticServiceImpl() {
	}

	@Override
	public DiagnosticB save(DiagnosticB bean) {
		final DiagnosticDto diagnostic = convertBeanToDto(bean);
		final DiagnosticDto dto = _diagnosticResource.save(diagnostic);
		final DiagnosticB diagnosticB = convertDtoToBean(dto);
		return diagnosticB;
	}

	@Override
	public List<DiagnosticB> getAll() {
		final DiagnosticResult result = _diagnosticResource.getAll();
		final List<DiagnosticDto> rList = null == result.getDiagnostics() ? new ArrayList<DiagnosticDto>()
				: result.getDiagnostics();

		final List<DiagnosticB> diagnostics = new ArrayList<DiagnosticB>();
		for (DiagnosticDto dto : rList) {
			final DiagnosticB bean = convertDtoToBean(dto);
			diagnostics.add(bean);
		}
		return diagnostics;
	}


	
	@Override
	public DiagnosticB getById(Integer id) {
		final DiagnosticDto dto = _diagnosticResource.getById(id);
		final DiagnosticB bean = convertDtoToBean(dto);
		return bean;
	}

	@Override
	protected DiagnosticB convertDtoToBean(DiagnosticDto dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("name", dto.getName());
		params.put("description", dto.getDescription());

		final DiagnosticB diagnosticB = new DiagnosticB(params);
		return diagnosticB;
	}

	@Override
	protected DiagnosticDto convertBeanToDto(DiagnosticB bean) {
		final DiagnosticDto dto = new DiagnosticDto();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		dto.setDescription(bean.getDescription());
		return dto;
	}

	@Override
	public List<DiagnosticB> find(String textToFind, int maxItems, int page) {
		final DiagnosticResult result = _diagnosticResource.find(textToFind, maxItems, page);
		final List<DiagnosticDto> rList = null == result.getDiagnostics() ? new ArrayList<DiagnosticDto>()
				: result.getDiagnostics();

		final List<DiagnosticB> diagnostics = new ArrayList<DiagnosticB>();
		for (DiagnosticDto dto : rList) {
			final DiagnosticB bean = convertDtoToBean(dto);
			diagnostics.add(bean);
		}
		return diagnostics;
	}
}
