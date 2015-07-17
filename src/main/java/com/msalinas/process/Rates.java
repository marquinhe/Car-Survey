package com.msalinas.process;

/**
 * Calculations to records
 * 
 * 
 *
 * @author MSALINAS
 * @version 1.0
 * @since 2015-07-17
 */

public interface Rates {
	
	/**
	 *Calculates speed, returns Km/h 
	 * @return
	 */
	
	public double speed(); 
	
	/**
	 *Calculates distance between two consecutive observations, returns meters 
	 * @return
	 */
	
	public double distanceLastCar(); 
	
	
	/**
	 * Time when the mark is recorded.
	 * @return
	 */
	public int timeRecorded(); 

}
