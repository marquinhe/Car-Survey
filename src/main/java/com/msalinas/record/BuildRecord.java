package com.msalinas.record;

import java.util.Queue;

import com.msalinas.load.ReadingParser;
import com.msalinas.validation.BadInputFileException;


/**
 * Build a single record 
 * 
 * 
 *
 * @author MSALINAS
 * @version 1.0
 * @since 2015-07-17
 */



public class BuildRecord{
	
	
	ReadingParser parser = new ReadingParser();

	/**
	 * Builds a record after being validated. 
	 * @param tempRecord
	 * @return
	 */
	public Record<?> build(Queue<String> tempRecord) {
		 Record<?> record = new Record(); 
		if (tempRecord.size() == 2) {
			try {
				record.setFrontTireFirstHose(parser.parse(tempRecord.remove()));
				record.setBackTireFirstHose(parser.parse(tempRecord.remove()));
				record.setDirection(Direction.A);
				
			} catch (BadInputFileException e) {
				e.printStackTrace();
			}
			
		} else if (tempRecord.size() == 4) {
			try {
				record.setFrontTireFirstHose(parser.parse(tempRecord.remove()));
				parser.parse(tempRecord.remove());
				record.setBackTireFirstHose(parser.parse(tempRecord.remove()));
				record.setDirection(Direction.B);
				//System.out.println("- NORTH: Record Speed:" + record.speed()+" -:Distance:" + record.distanceLastCar());

				
			} catch (BadInputFileException e) {
				e.printStackTrace();
			}
			
		}
		return record;
	}



	/**
	 * Build a record with information related to previous record. 
	 * @param tempRecord
	 * @param lastValidRecord
	 * @return
	 */
	
	
	public Record<?> build(Queue<String> tempRecord, Record<? extends Record> lastValidRecord) {
		Record<?> record = new Record(); 
		if (tempRecord.size() == 2) {
			try {
				record.setFrontTireFirstHose(parser.parse(tempRecord.remove()));
				record.setBackTireFirstHose(parser.parse(tempRecord.remove()));
				record.setDirection(Direction.A);
				record.setLastValidRecordA(lastValidRecord);
				//System.out.println("- NORTH: Record Speed:" + record.speed()+" -:Distance:" + record.distanceLastCar());
				
			} catch (BadInputFileException e) {
				e.printStackTrace();
			}
			
		}else if (tempRecord.size() == 4) {
			try {
				record.setFrontTireFirstHose(parser.parse(tempRecord.remove()));
				parser.parse(tempRecord.remove());
				record.setBackTireFirstHose(parser.parse(tempRecord.remove()));
				record.setDirection(Direction.B);
				record.setLastValidRecordB(lastValidRecord);
				//System.out.println("- NORTH: Record Speed:" + record.speed()+" -:Distance:" + record.distanceLastCar());

				
			} catch (BadInputFileException e) {
				e.printStackTrace();
			}
		}
		
		return record; 
	}


	
	

}
