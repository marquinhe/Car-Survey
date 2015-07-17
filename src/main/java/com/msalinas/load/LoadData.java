package com.msalinas.load;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.msalinas.record.BuildRecord;
import com.msalinas.record.MetaData;
import com.msalinas.record.Record;

/**
 * Loads data
 * 
 * 
 *
 * @author MSALINAS
 * @version 1.0
 * @since 2015-07-17
 */

public class LoadData {

	
	/**
	 * Read a file with observation
	 * @param filePath
	 * @return
	 */
	public static HashMap load(String filePath) {

		try {
			File myFile = new File(filePath);
			List<String> lines = Files
					.readAllLines(Paths.get(myFile.getAbsolutePath()),
							StandardCharsets.UTF_8);
			return recordEnsambler(lines);

		} catch (IOException e) {
			System.out
					.println("Arrhhrg problem reading your file.. check your path.");
			return null;
		}

	}

	
	/**
	 * Ensembles records according from multiple lines.
	 * @param lines
	 * @return
	 */
	private static HashMap recordEnsambler(List<String> lines) {

		boolean isEntryCompleted = false;
		Queue<String> tempRecord = new LinkedList<String>();
		HashMap<String, Set> days = new HashMap<String, Set>();

		int count = 1;
		String key = "day";
		Record<?> lastRecord = null;
		Set<Record> daySet;

		for (String line : lines) {

			if (isEntryCompleted) {

				Record<?> newRecord = addRecord(tempRecord);

				if (days.get(key + count) == null) {
					daySet = new LinkedHashSet<Record>();
					days.put(key + count, daySet);
				} else {
					daySet = days.get(key + count);
				}

				daySet.add(newRecord);

				if (isNewDay(newRecord, lastRecord)) {
					count++;
				}

				lastRecord = newRecord;

				MetaData.process(newRecord);

				// UseQueue as a temporary constructor
				tempRecord.clear();
				tempRecord.add(line);
				isEntryCompleted = false;
			} else {
				tempRecord.add(line);
				if (isRecordReady((List<String>) tempRecord))
					isEntryCompleted = true;
			}
		}

		MetaData.printSummary();
		System.out.println("Day of data: " + days.size() + " days");
		
		return days;
	}

	
	/**
	 * Identifies a new day within a sequence of readings
	 * 
	 * @param newRecord
	 * @param lastRecord
	 * @return
	 */
	
	
	private static boolean isNewDay(Record<?> newRecord, Record<?> lastRecord) {
		if (lastRecord != null)
			return (lastRecord.timeRecorded() > newRecord.timeRecorded());
		return false;
	}


	/**
	 * Identifies whether a record is complete.
	 * 
	 * @param tempRecord
	 * @return
	 */
	private static boolean isRecordReady(List<String> tempRecord) {

		if (tempRecord.size() == 2) {
			if (tempRecord.get(0).startsWith("A")
					&& tempRecord.get(1).startsWith("A"))
				return true;
		} else if (tempRecord.size() == 4) {
			return true;
		}
		return false;
	}


	/**
	 * Add a record within a static context for immediate Executive Report
	 * 
	 * 
	 * @param tempRecord
	 * @return
	 */
	private static Record<?> addRecord(Queue<String> tempRecord) {

		BuildRecord br = new BuildRecord(); 
		Record record; 

		if (MetaData.getLastValidRecord() != null)
			record = br.build(tempRecord, MetaData.getLastValidRecord());
		else
			record = br.build(tempRecord);

		MetaData.setLastValidRecord(record);
		return record;
	}

}
