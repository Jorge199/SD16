/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sd.uni.labpatologia.rest.statistic;

/**
 *
 * @author User
 */
import com.sd.uni.labpatologia.dto.statistic.StatisticDTO;
import com.sd.uni.labpatologia.dto.statistic.StatisticResult;
import com.sd.uni.labpatologia.rest.base.IBaseResource;

public interface IStatisticResource extends IBaseResource<StatisticDTO> {

	public StatisticResult getAll();
	public StatisticResult find(String textToFind, int maxItems, int page);
	public StatisticResult find(String textToFind);
}
