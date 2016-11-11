package com.sd.uni.labpatologia.service.laboratory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.labpatologia.beans.laboratory.LaboratoryB;
import com.sd.uni.labpatologia.beans.report.ReportB;
import com.sd.uni.labpatologia.dto.laboratory.LaboratoryDto;
import com.sd.uni.labpatologia.dto.laboratory.LaboratoryResult;
import com.sd.uni.labpatologia.dto.report.ReportDTO;
import com.sd.uni.labpatologia.dto.report.ReportResult;
import com.sd.uni.labpatologia.rest.laboratory.ILaboratoryResource;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service("laboratoryService")
public class LaboratoryServiceImpl extends BaseServiceImpl<LaboratoryB, LaboratoryDto> implements ILaboratoryService{
	@Autowired
	private ILaboratoryResource _laboratoryResource;
	
	public LaboratoryServiceImpl() {
		
	}
	@Override
	public LaboratoryB save(LaboratoryB bean) {
		final LaboratoryDto laboratory = convertBeanToDto(bean);
		final LaboratoryDto dto = _laboratoryResource.save(laboratory);
		final LaboratoryB laboratoryB = convertDtoToBean(dto);
		return laboratoryB;
	}

	@Override
	public List<LaboratoryB> getAll() {
		final LaboratoryResult result = _laboratoryResource.getAll();
		final List<LaboratoryDto> laboratoryList = null == result.getLaboratories() ? new ArrayList<LaboratoryDto>()
				: result.getLaboratories();

		final List<LaboratoryB> laboratories = new ArrayList<LaboratoryB>();
		for (LaboratoryDto dto : laboratoryList) {
			final LaboratoryB bean = convertDtoToBean(dto);
			laboratories.add(bean);
		}
		return laboratories;
	}

	@Override
	public LaboratoryB getById(Integer id) {
		final LaboratoryDto dto = _laboratoryResource.getById(id);
		final LaboratoryB bean = convertDtoToBean(dto);

		return bean;
	}

	@Override
	protected LaboratoryB convertDtoToBean(LaboratoryDto dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("name", dto.getName());
		params.put("address", dto.getAddress());
		params.put("email", dto.getEmail());
		params.put("phone", dto.getPhone());
		final LaboratoryB laboratoryB = new LaboratoryB(params);
		return laboratoryB;
	}

	@Override
	protected LaboratoryDto convertBeanToDto(LaboratoryB bean) {
		final LaboratoryDto dto = new LaboratoryDto();
		dto.setId(bean.getId());
		dto.setAddress(bean.getAddress());
		dto.setEmail(bean.getEmail());
		dto.setName(bean.getName());
		dto.setPhone(bean.getPhone());
		return dto;
	}
	@Override
	public List<LaboratoryB> find(String textToFind, int maxItems, int page) {
		final LaboratoryResult result = _laboratoryResource.find(textToFind, maxItems, page);
		final List<LaboratoryDto> rList = null == result.getLaboratories() ? new ArrayList<LaboratoryDto>()
				: result.getLaboratories();

		final List<LaboratoryB> laboratories = new ArrayList<LaboratoryB>();
		for (LaboratoryDto dto : rList) {
			final LaboratoryB bean = convertDtoToBean(dto);
			laboratories.add(bean);
		}
		return laboratories;
	}

}
