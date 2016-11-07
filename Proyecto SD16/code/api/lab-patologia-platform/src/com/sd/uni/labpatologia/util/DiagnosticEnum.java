package com.sd.uni.labpatologia.util;

public enum DiagnosticEnum {

	CARCINOMA("Carcinoma"), LEUCEMIA("Leucemia"), LINFOMA("Linfoma"), SARCOMA("Sarcoma"), SIN_INDICIOS("Sin indicios");

	final String _value;

	private DiagnosticEnum(String value) {
		_value = value;
	}

	public String toString() {
		return _value;
	}

	public String getKey() {
		return name();
	}
}
