package com.msalinas.record;

import com.msalinas.process.Rates;

public class Record<T> extends AbstractRecord implements Rates{
	
	/**
	 * Vehicle Survey class 
	 * 
	 * 
	 *
	 * @author MSALINAS
	 * @version 1.0
	 * @since 2015-07-12
	 */
	
	
	@Override
	public double speed() {
		
		return 2.5 * 1000 / (getBackTireFirstHose() - getFrontTireFirstHose()) * 3.6;
	}


	@Override
	public double distanceLastCar() {

			if (getDirection() == Direction.A) {
				if (getLastValidRecordA() != null) {
					int timeDifference  = getFrontTireFirstHose() - getLastValidRecordA().getBackTireFirstHose();
					double distance = (speed() * 0.2777777777778) * timeDifference/1000;
					return distance;
				}
				return 0;
			}else {
				if (getLastValidRecordB() != null) {
					int timeDifference  = getLastValidRecordB().getBackTireFirstHose() - getFrontTireFirstHose();
					double distance = (speed() * 0.2777777777778) * timeDifference/1000;
					return distance;
				}
				return 0;
		
			}

	}


	@Override
	public int timeRecorded() {
		return getFrontTireFirstHose();
	}

}
