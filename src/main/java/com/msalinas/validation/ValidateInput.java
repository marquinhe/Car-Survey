package com.msalinas.validation;


/**
 * Validates Input
 * 
 * 
 * @author MSALINAS
 * @version 1.0
 * @since 2015-07-17
 * 
 */

public class ValidateInput {
	
	/**
	 * Returns true when receiving valid input.
	 * @param user input
	 * @return
	 */

	public boolean isValid(String input) {
		
		try {
		String suffix = "" +   input.substring(input.trim().length() - 1);
		suffix = suffix.toUpperCase();
		String number = input.substring(0, input.length() - 1);
		
		int inputNumber = Integer.parseInt(number.trim());
		int milis = 0; 
		
		if(suffix.equals("M") || (suffix.equals("H"))) {
			return true;
		}else {
			return false;
		}				
		} catch(NumberFormatException e){
			//TODO Catch
			return false; 
		}
	}
}
