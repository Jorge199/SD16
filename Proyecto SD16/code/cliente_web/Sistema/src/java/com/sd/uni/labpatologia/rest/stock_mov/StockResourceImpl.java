package com.sd.uni.labpatologia.rest.stock_mov;

//import com.sd.uni.labpatologia.dto.stock_mov.StockDTO;

//import com.sd.uni.labpatologia.dto.stock_mov.StockResult;
import org.springframework.stereotype.Repository;

@Repository("stockResource")
public class StockResourceImpl{ //extends BaseResourceImpl<StockDTO> implements IStockResource{
	public StockResourceImpl(){
		//super(StockDTO.class,"/stock");
	}

/*	@Override
	public StockResult getAll() {
		setWebResourceBasicAuthFilter();
		final StockResult result = getWebResource().get(StockResult.class);
		return result;
	}*/
}
