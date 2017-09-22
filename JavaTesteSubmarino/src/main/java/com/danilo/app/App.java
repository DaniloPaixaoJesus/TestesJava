package com.danilo.app;

import com.danilo.app.bo.Submarino;
import com.danilo.app.exception.SubmarinoInvalidoException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SubmarinoInvalidoException
    {
        
    	String retornoExecutado = null;
    	String comando = null;
    			
    	Submarino submarino1 = new Submarino();        
        comando = "RRMLLMUMM";
        retornoExecutado = submarino1.executar(comando);
		System.out.println(retornoExecutado);
		
        comando = "RMMLMMMDDLL";
        Submarino submarino2 = new Submarino();
		retornoExecutado = submarino2.executar(comando);
		System.out.println(retornoExecutado);
		
    }
}
