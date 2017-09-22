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
        Submarino submarino1 = new Submarino();
        Submarino submarino2 = new Submarino();
        
        submarino1.executar("RRMLLMUMM");
        submarino1.executar("SRMLRMDM");
    }
}
