package com.msalinas.input;

import static org.junit.Assert.*;

import org.junit.Test;

import com.msalinas.load.ReadingParser;
import com.msalinas.validation.BadInputFileException;

public class ReadingParserTest {

	@Test
	public void testValidInput() {
		
		ReadingParser rp = new ReadingParser();
		int milis = 0;
		
		try {
			milis = rp.parse("A638379");
		} catch (BadInputFileException e) {
			// TODO Exception
			e.printStackTrace();
			milis = -1; 
		}
		assertEquals(milis, 638379);
		
	}
	
	@Test
	public void testWrongInput() {

		ReadingParser rp = new ReadingParser();
		int milis = 0;
		try {
			milis = rp.parse("wrong");
		} catch (BadInputFileException e) {

			e.printStackTrace();
		}
		assertEquals(milis, -1);

	}

}
