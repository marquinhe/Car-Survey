	package com.msalinas.record;


public class AbstractRecord {
	
	
	/**
	 * Record Model for each 
	 * observations of milliseconds and direction since midnight when car ires pass over a hose. 
	 * 
	 *
	 * @author MSALINAS
	 * @version 1.0
	 * @since 2015-07-17
	 */
	
	private int frontTireFirstHose;
	private int backTireFirstHose;
	private Record<?> lastValidRecordA;
	private Record<?> lastValidRecordB;
	private Direction direction; 
	
	/**
	 * Gets the Direction of the car: North(A) or South(B)
	 * @return
	 */
	
	public Direction getDirection() {
		return direction;
	}

	/**
	 * Sets the Direction of the car: North(A) or South(B)
	 * @return
	 */

	protected void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * Gets the time in milliseconds of front tire whilst passing the hose.
	 * @return
	 */

	public int getFrontTireFirstHose() {
		return frontTireFirstHose;
	}

	/**
	 * Sets the time in milliseconds of front tire whilst passing the hose.
	 * @return
	 */

	protected void setFrontTireFirstHose(int frontTireFirstHose) {
		this.frontTireFirstHose = frontTireFirstHose;
	}

	/**
	 * Gets the time in milliseconds of back tire whilst passing the hose.
	 * @return
	 */

	public int getBackTireFirstHose() {
		return backTireFirstHose;
	}


	/**
	 * Sets the time in milliseconds of back tire whilst passing the hose.
	 * @return
	 */
	protected void setBackTireFirstHose(int backTireFirstHose) {
		this.backTireFirstHose = backTireFirstHose;
	}
	
	/**
	 * Get the previous valid observation in the direction North
	 * @return
	 */
	
	public Record getLastValidRecordA() {
		return lastValidRecordA;
	}
	
	/**
	 * Set the previous valid observation in the direction South
	 * @return
	 */

	protected void setLastValidRecordA(Record lastValidRecord) {
		this.lastValidRecordA = lastValidRecord;
	}
	
	/**
	 * Get the previous valid observation in the direction South
	 * @return
	 */
	
	public Record getLastValidRecordB() {
		return lastValidRecordB;
	}
	
	/**
	 * Set the previous valid observation in the direction South
	 * @return
	 */

	protected void setLastValidRecordB(Record lastValidRecord) {
		this.lastValidRecordB = lastValidRecord;
	}
	

}
