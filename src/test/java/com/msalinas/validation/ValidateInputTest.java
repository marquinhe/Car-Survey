package com.msalinas.validation;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidateInputTest {

	@Test
	public void testValid() {
		
		ValidateInput validateInput = new ValidateInput(); 
		assertTrue(validateInput.isValid("12m"));
		assertTrue(validateInput.isValid("12h"));
		assertTrue(validateInput.isValid("12 m"));
		assertTrue(validateInput.isValid("24 H"));
		
	}
	
	@Test
	public void testInvalid() {
		
		ValidateInput validateInput = new ValidateInput(); 
		assertFalse(validateInput.isValid("m"));
		assertFalse(validateInput.isValid("12h3"));
		assertFalse(validateInput.isValid("20min"));
		assertFalse(validateInput.isValid("24 dH"));
		
	}

}
