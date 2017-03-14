/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sd.uni.labpatologia.rest.diagnostic;


import com.sd.uni.labpatologia.dto.diagnostic.DiagnosticDto;
import com.sd.uni.labpatologia.dto.diagnostic.DiagnosticResult;
import com.sd.uni.labpatologia.rest.base.IBaseResource;

public interface IDiagnosticResource extends IBaseResource<DiagnosticDto> {

	public DiagnosticResult getAll();
	public DiagnosticResult find(String textToFind, int maxItems, int page);
}
