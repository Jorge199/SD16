package com.sd.uni.labpatologia.util;

import java.util.EnumSet;

public enum StatusEnum {
	RECIBIDO,
	PROCESO,
	PROCESADO,
	TERMINADO,
	RETIRADO;
	
	public static final EnumSet<StatusEnum> allStatus = EnumSet.of(RECIBIDO, PROCESO, PROCESADO, TERMINADO, RETIRADO);
	
}
