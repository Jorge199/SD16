package com.sd.uni.labpatologia.rest.laboratory;

import com.sd.uni.labpatologia.dto.laboratory.LaboratoryDto;
import com.sd.uni.labpatologia.dto.laboratory.LaboratoryResult;
import com.sd.uni.labpatologia.dto.report.ReportResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;

import org.springframework.stereotype.Repository;

@Repository("laboratoryResource")
public class LaboratoryResourceImpl extends BaseResourceImpl<LaboratoryDto> implements ILaboratoryResource{
	public LaboratoryResourceImpl(){
		super(LaboratoryDto.class,"/laboratory");
	}

	@Override
	public LaboratoryResult getAll() {
		final LaboratoryResult result = getWebResource().get(LaboratoryResult.class);
		return result;
	}

	@Override
	public LaboratoryResult find(String textToFind) {
		final LaboratoryResult result = findWR(textToFind).get(LaboratoryResult.class);
		return result;
	}

}
