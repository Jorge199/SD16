package com.sd.uni.labpatologia.exception;

public class PatologyException extends Exception {

	public PatologyException(String string, ArrayIndexOutOfBoundsException e) {
		super(string, e);
	}

	public PatologyException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
