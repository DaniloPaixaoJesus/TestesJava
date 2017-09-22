package com.danilo.app.enumeration;

public enum DirecaoEnum {
	NORTE(false), SUL(false), LESTE(false), OESTE(false), CIMA(true), BAIXO(true);
	boolean vertical;
	
	DirecaoEnum(boolean vertical){
		this.vertical =  vertical;
	}
	
	public boolean isVertical(){
		return vertical;
	}
}
