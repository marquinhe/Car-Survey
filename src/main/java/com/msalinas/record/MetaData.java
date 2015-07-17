package com.msalinas.record;

import java.util.HashMap;


/**
 * Vehicle Survey class 
 * 
 * 
 *
 * @author MSALINAS
 * @version 1.0
 * @since 2015-07-17
 */

public class MetaData {
	
	static HashMap<String, Double> metaDataMap = new HashMap<String, Double>(); 
	private static Record lastValidRecord;

	public static void process(Record record) {
		
		processSpeed(record); 
		processDistance(record); 
		incrementCount(record.getDirection());
	}

	private static void incrementCount(Direction direction) {
		String key = "count" + direction.toString();

		if (metaDataMap.get(key) == null) {
			metaDataMap.put(key, 1.0);
		} else {
			metaDataMap.put(key, metaDataMap.get(key) + 1);
		}

	}

	private static void processDistance(Record record) {
		String key = "sumDistance" + record.getDirection().toString();

		if (metaDataMap.get(key) == null)
			metaDataMap.put(key, record.distanceLastCar());
		else
			metaDataMap.put(key, metaDataMap.get(key) + record.distanceLastCar());

	}

	private static void processSpeed(Record record) {
		String key = "sumSpeed" + record.getDirection().toString(); 
		String speedingKey = "speedingCount" + record.getDirection().toString(); 

		if (metaDataMap.get(key) == null)
			metaDataMap.put(key, record.speed());
		else
			metaDataMap.put(key, metaDataMap.get(key) + record.speed());
		
		if (record.speed() > 65){
			if (metaDataMap.get(speedingKey) == null)
				metaDataMap.put(speedingKey, 1.0);
			else
				metaDataMap.put(speedingKey, metaDataMap.get(speedingKey) + 1);
		}
			

	}

	
	public static Record getLastValidRecord() {
		return lastValidRecord;
	}


	public static void setLastValidRecord(Record record) {
		lastValidRecord = record;
	}
	
	
	public static void printSummary() {
		
		System.out.println("Valid Data.");
		System.out.println("");
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("Executive Summary");
		System.out.println("-----------------------");
		System.out.println("");
		System.out.println("");
		System.out.println("Total Car Count:");
		System.out.format("North: %d cars", (metaDataMap.get("count"+Direction.A.toString()).intValue())); 
		System.out.format(" (%.2f%%) ", percentage(Direction.A));
		System.out.format("South: %d cars ", (metaDataMap.get("count"+Direction.B.toString()).intValue()));
		System.out.format(" (%.2f%%) ", percentage(Direction.B));
		System.out.println("");
		System.out.println("");
		System.out.println("Average Car Speed:");
		System.out.format("North: %.2f km/h" , (metaDataMap.get("sumSpeed"+Direction.A)/metaDataMap.get("count"+Direction.A))); 
		System.out.format(" South: %.2f km/h" , (metaDataMap.get("sumSpeed"+Direction.B)/metaDataMap.get("count"+Direction.B))); 
		System.out.println("");
		System.out.println("");
		System.out.println("Average Car Distance:");
		System.out.format("North %.2f m" , (metaDataMap.get("sumDistance"+Direction.A)/metaDataMap.get("count"+Direction.A))); 
		System.out.format(" South %.2f m" , (metaDataMap.get("sumDistance"+Direction.B)/metaDataMap.get("count"+Direction.B))); 
		System.out.println("");
		System.out.println("");
		System.out.println("Total Speeding Cars:");
		System.out.format("North: %d cars", (metaDataMap.get("speedingCount"+Direction.A.toString()).intValue())); 
		System.out.format(" (%.2f%%) ", percentageSpeeding(Direction.A));
		System.out.format(" South: %d cars", (metaDataMap.get("speedingCount"+Direction.B.toString()).intValue()));
		System.out.format(" (%.2f%%) ", percentageSpeeding(Direction.B));
		System.out.println("");
		System.out.println("");
	}

	private static Object percentageSpeeding(Direction direction) {
		return 100 * (metaDataMap.get("speedingCount" + direction.toString()))
				/ (metaDataMap.get("count" + direction.toString()));
	}

	private static Object percentage(Direction direction) {
		return 100 * (metaDataMap.get("count" + direction.toString()))
				/ (metaDataMap.get("count" + Direction.A.toString()) + (metaDataMap
						.get("count" + Direction.B.toString())));
	}





}
