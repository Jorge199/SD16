package com.sd.uni.labpatologia.exception;

import java.text.ParseException;

public class StockException extends Exception {

	public StockException(String string, ArrayIndexOutOfBoundsException e) {
		super(string, e);
	}

	public StockException(String string) {
		super(string);
	}

	public StockException(String string, Exception e) {
		super(string, e);
	}

	private static final long serialVersionUID = 1L;

}
