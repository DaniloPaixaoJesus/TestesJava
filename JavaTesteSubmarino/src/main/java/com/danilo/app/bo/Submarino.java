package com.danilo.app.bo;

import com.danilo.app.enumeration.ComandoEnum;
import com.danilo.app.enumeration.DirecaoEnum;

public class Submarino {

	long eixoX;
	long eixoY;
	long eixoZ;
	DirecaoEnum direcao;

	Submarino() {
		this.eixoX = 0;
		this.eixoY = 0;
		this.eixoZ = 0;
		this.direcao = DirecaoEnum.NORTE;
	}
	
	public String executar(String comando){
		validarLinhaComando(comando);
		char[] arrString = comando.toCharArray();
		for (int i = 0; i < arrString.length; i++) {
			ComandoEnum comandoEnum = ComandoEnum.getComandoEnum(arrString[i]);
			executarComando(comandoEnum);
		}
		return "resultado do comando";
	}

	private void validarLinhaComando(String comando) {
		// verificar se nulo
		// verificar se diferente de vazio
		// verificar se existe algo diferente de L-R-M-U-D
	}


	private void executarComando(ComandoEnum comando) {
		if (comando.isDirecional()) {
			switch (comando) {
			case R:
				comandoR();
				break;
			case L:
				comandoL();
				break;
			case U:
				break;
			case D:
				break;
			default:
				break;
			}
		} else if (comando.isMovimentacao()) {
			movimentar();
		}
	}

	private void movimentar() {
		switch (direcao) {
		case NORTE:
			this.eixoY++;
			break;
		case SUL:
			this.eixoY--;
			break;
		case LESTE:
			this.eixoX++;
			this.eixoY++;
			break;
		case OESTE:
			this.eixoX++;
			this.eixoY--;
			break;
		case CIMA:
			this.eixoZ++;
			break;
		case BAIXO:
			this.eixoZ--;
			break;
		default:
			break;
		}
	}
	

	private void comandoR() {
		switch (direcao) {
		case NORTE:
			this.direcao = DirecaoEnum.LESTE;
			break;
		case LESTE:
			this.direcao = DirecaoEnum.SUL;
			break;
		case SUL:
			this.direcao = DirecaoEnum.OESTE;
			break;
		case OESTE:
			this.direcao = DirecaoEnum.NORTE;
			break;
		default:
			break;
		}
	}

	private void comandoL() {
		switch (direcao) {
		case NORTE:
			this.direcao = DirecaoEnum.OESTE;
			break;
		case OESTE:
			this.direcao = DirecaoEnum.SUL;
			break;
		case SUL:
			this.direcao = DirecaoEnum.LESTE;
			break;
		case LESTE:
			this.direcao = DirecaoEnum.NORTE;
			break;
		default:
			break;
		}
	}

	private void comandoU() {
		this.direcao = DirecaoEnum.CIMA;
	}

	private void comandoD() {
		this.direcao = DirecaoEnum.BAIXO;
	}

}
