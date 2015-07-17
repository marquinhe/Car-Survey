package com.msalinas.load;

import com.msalinas.validation.BadInputFileException;

/**
 * Loads data
 * 
 * 
 *
 * @author MSALINAS
 * @version 1.0
 * @since 2015-07-17
 */

public class ReadingParser {

	
	/**
	 * Parses observations from file.
	 * 
	 * @param reading
	 * @return
	 * @throws BadInputFileException
	 */
	public int parse(String reading) throws BadInputFileException {

		try {
			return Integer.parseInt(reading.substring(1));
		} catch (NumberFormatException e) {
			return -1;
		}

	}
}
