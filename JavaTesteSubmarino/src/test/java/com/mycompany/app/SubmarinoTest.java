package com.mycompany.app;

import org.junit.Before;
import org.junit.Test;

import com.danilo.app.bo.Submarino;
import com.danilo.app.exception.SubmarinoInvalidoException;

import static junit.framework.Assert.assertEquals;


public class SubmarinoTest{
	
	
	Submarino submarino;
	
	@Before
	public void criarSubmarino(){
		this.submarino = new Submarino();
	}
    
	@Test(expected = SubmarinoInvalidoException.class)
    public void testSubmarinoComandoInvalido() throws Exception{
    	submarino.executar("REEEAE");  	
    }
	
	@Test
    public void testSubmarinoComandoVazio() throws Exception{
    	submarino.executar("");
    	
    }
	
	@Test
    public void testSubmarinoComandoValido() throws Exception{

    	String comando = "RMMLMMMDDLL";
		String retornoExecutado = submarino.executar(comando);
		String retornoEsperado = "2 3 -2 SUL";
		assertEquals(retornoExecutado, retornoEsperado);    	
    }
	
	@Test(expected = SubmarinoInvalidoException.class)
    public void testSubmarinoComandoNulo() throws Exception{
    	submarino.executar(null);
    	
    }

	

}
