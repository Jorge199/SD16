/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sd.uni.labpatologia.service.statistic;

/**
 *
 * @author Jorge Esquivel
 */
import java.util.List;

import com.sd.uni.labpatologia.beans.statistic.StatisticB;
import com.sd.uni.labpatologia.dto.statistic.StatisticDTO;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface IStatisticService extends IBaseService<StatisticB, StatisticDTO> {

	List<StatisticB> find(String textToFind);

}
