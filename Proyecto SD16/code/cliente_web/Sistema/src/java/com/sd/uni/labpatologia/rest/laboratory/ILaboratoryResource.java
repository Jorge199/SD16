package com.sd.uni.labpatologia.rest.laboratory;

import com.sd.uni.labpatologia.dto.laboratory.LaboratoryDto;
import com.sd.uni.labpatologia.dto.laboratory.LaboratoryResult;
import com.sd.uni.labpatologia.rest.base.IBaseResource;

public interface ILaboratoryResource extends IBaseResource<LaboratoryDto> {
	public LaboratoryResult getAll();
	public LaboratoryResult find(String textToFind, int maxItems, int page);
}
