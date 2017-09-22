package com.danilo.app.enumeration;

public enum ComandoEnum {
	L, R, M, U, D;
	
	public boolean isDirecional(){
		if(this != M) return true;
		return false;
	}
	
	public boolean isMovimentacao(){
		if(this == M) return true;
		return false;
	}
	
	public static ComandoEnum getComandoEnum(char comando){
		switch (comando) {
		case 'L':
			return ComandoEnum.L;
		case 'R':
			return ComandoEnum.R;
		case 'M':
			return ComandoEnum.M;
		case 'U':
			return ComandoEnum.U;
		case 'D':
			return ComandoEnum.D;
		}
		return null;
	}
}
