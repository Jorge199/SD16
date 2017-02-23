package com.sd.uni.labpatologia.util;


public enum StatusEnum {
	RECIBIDO("Recibido"),
	PROCESO("Proceso"),
	PROCESADO("Procesado"),
	TERMINADO("Terminado"),
	RETIRADO("Retirado");
	
	final String _value;
	private StatusEnum(String value){
		_value = value;
	}
	
	public String toString(){
		return _value;
	}
	public String getKey(){
		return name();
	}
	//public static final EnumSet<StatusEnum> allStatus = EnumSet.of(RECIBIDO, PROCESO, PROCESADO, TERMINADO, RETIRADO);
	
}
