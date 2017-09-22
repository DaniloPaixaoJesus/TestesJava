package com.danilo.app.enumeration;

public enum ComandoEnum {
	L, R, M, U, D;
	
	public boolean isDirecional(){
		return false;
	}
	
	public boolean isMovimentacao(){
		return true;
	}
	
	public static ComandoEnum getComandoEnum(char comando){
		return L;
	}
}
