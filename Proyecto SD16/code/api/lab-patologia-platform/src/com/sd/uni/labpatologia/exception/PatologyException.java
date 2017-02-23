package com.sd.uni.labpatologia.exception;


public class PatologyException extends Exception {

	public PatologyException(String string, ArrayIndexOutOfBoundsException e) {
		super(string, e);
	}

	public PatologyException(String string) {
		super(string);
	}

	public PatologyException(String string, Exception e) {
		super(string, e);
	}

	private static final long serialVersionUID = 1L;

}
