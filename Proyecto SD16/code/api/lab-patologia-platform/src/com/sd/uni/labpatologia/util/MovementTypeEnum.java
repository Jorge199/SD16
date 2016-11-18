package com.sd.uni.labpatologia.util;

public enum MovementTypeEnum {
	
	ENTRADA("entrada"), SALIDA("salida");
	
	final String _value;

	private MovementTypeEnum(String value) {
		_value = value;
	}

	public String toString() {
		return _value;
	}

	public String getKey() {
		return name();
	}
}
