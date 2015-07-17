package com.msalinas.record;

import com.msalinas.process.Rates;

public class RecordSouth extends Record implements Rates{
	
	/**
	 * Records data for second hose
	 * 
	 * 
	 *
	 * @author MSALINAS
	 * @version 1.0
	 * @since 2015-07-12
	 */
	
	
	int firstTireSecondHose; 
	int backTireSecondHose; 
	
	
	public int getFirstTireSecondHose() {
		return firstTireSecondHose;
	}


	public void setFirstTireSecondHose(int firstTireSecondHose) {
		this.firstTireSecondHose = firstTireSecondHose;
	}


	public int getBackTireSecondHose() {
		return backTireSecondHose;
	}


	public void setBackTireSecondHose(int backTireSecondHose) {
		this.backTireSecondHose = backTireSecondHose;
	}


}
