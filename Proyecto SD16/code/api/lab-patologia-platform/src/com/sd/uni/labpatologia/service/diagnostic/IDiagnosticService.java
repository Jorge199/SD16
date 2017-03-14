package com.sd.uni.labpatologia.service.diagnostic;

import com.sd.uni.labpatologia.dao.diagnostic.DiagnosticDaoImpl;
import com.sd.uni.labpatologia.domain.diagnostic.DiagnosticDomain;
import com.sd.uni.labpatologia.dto.diagnostic.DiagnosticDto;
import com.sd.uni.labpatologia.dto.diagnostic.DiagnosticResult;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface IDiagnosticService extends IBaseService<DiagnosticDto, DiagnosticDomain, DiagnosticDaoImpl, DiagnosticResult>{
}