package com.sd.uni.labpatologia.util;

public enum SexEnum {

	FEMENINO("Femenino"), MASCULINO("Masculino");

	final String _value;

	private SexEnum(String value) {
		_value = value;
	}

	public String toString() {
		return _value;
	}

	public String getKey() {
		return name();
	}
}
