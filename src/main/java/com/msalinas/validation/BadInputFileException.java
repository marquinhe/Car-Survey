package com.msalinas.validation;


/**
 * Custome exception
 * 
 * 
 *
 * @author MSALINAS
 * @version 1.0
 * @since 2015-07-17
 */

public class BadInputFileException extends Exception {
	
	private static final long serialVersionUID = 1997753363232807009L;

	public BadInputFileException()
	{
		super("Invalid data");
		
		//TODO reporting on line number
	}

	

}
