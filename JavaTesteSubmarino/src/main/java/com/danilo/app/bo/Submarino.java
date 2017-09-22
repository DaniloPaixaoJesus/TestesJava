package com.danilo.app.bo;

import com.danilo.app.enumeration.ComandoEnum;
import com.danilo.app.enumeration.DirecaoEnum;
import com.danilo.app.exception.SubmarinoInvalidoException;

public class Submarino {

	long eixoX;
	long eixoY;
	long eixoZ;
	DirecaoEnum direcao;

	public Submarino() {
		this.eixoX = 0;
		this.eixoY = 0;
		this.eixoZ = 0;
		this.direcao = DirecaoEnum.NORTE;
	}

	public String executar(String comando) throws SubmarinoInvalidoException {
		if(comando == null){
			throw new SubmarinoInvalidoException("comando nao deve ser nulo");
		}
		char[] arrString = comando.toCharArray();
		for (int i = 0; i < arrString.length; i++) {
			char comandotmp = arrString[i];
			validarComando(comandotmp);			
			ComandoEnum comandoEnum = ComandoEnum.getComandoEnum(comandotmp);
			executarComando(comandoEnum);
		}
		return eixoX + " " + eixoY + " " + eixoZ + " " + direcao;
	}

	private void validarComando(char comando) throws SubmarinoInvalidoException {
		ComandoEnum comandoEnum = ComandoEnum.getComandoEnum(comando);
		if (comandoEnum == null){
			throw new SubmarinoInvalidoException("comando invalido");
		}
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
				comandoU();
				break;
			case D:
				comandoD();
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
			//this.eixoY++;
			break;
		case OESTE:
			this.eixoX--;
			//this.eixoY--;
			break;
		/*case CIMA:
			this.eixoZ++;
			break;
		case BAIXO:
			this.eixoZ--;
			break;*/
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
		//this.direcao = DirecaoEnum.CIMA;
		this.eixoZ++;
	}

	private void comandoD() {
		//this.direcao = DirecaoEnum.BAIXO;
		this.eixoZ--;
	}

}
