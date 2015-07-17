package com.msalinas.process;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.msalinas.record.Direction;
import com.msalinas.record.Record;


/**
 * Print a table of data distribution according to an interval of milliseconds. 
 * TableData is Set of multiple fixed-length columns, described by a String Array of 6 columns.
 * 
 * @author MSALINAS
 * @version 1.0
 * @since 2015-07-17
 * 
 */


public class Print {

	public Print(HashMap<String, Set> allDaysData, int interval) {
		HashSet<String[]> dataSet = breakIntoInterval(allDaysData, interval);
		doPrint(dataSet, interval);

	}

	
	/**
	 * Table layout
	 * 
	 * @param tableData
	 * @param interval
	 */
	
	public void doPrint(HashSet<String[]> tableData, int interval) {

		String leftAlignFormat = "| %-4s | %-5s | %-6s | %-6s | %-6s | %-6s %n";

		System.out
				.format("+-----------------------------------------------------+%n");
		System.out
				.printf("| Day  | Block  |   Dir  | Count  |  Speed | Distance %n");
		System.out
				.format("+-----------------------------------------------------+%n");
		for (String[] col : tableData) {
			if (col.length == 6) {
				System.out.format(leftAlignFormat, col[0],
						formatTime(col[1], interval), col[2], col[3], col[4],
						col[5]);
			}
		}
		System.out
				.format("+-------------------------------------------------+%n");

	}
	
	/**
	 * Breaks data dividing it into multiples block (intervales) of x milliseconds, per day.
	 * 
	 * @param allDaysData
	 * @param interval
	 * @return
	 */

	public HashSet breakIntoInterval(HashMap allDaysData, int interval) {

		int day;
		HashSet<String[]> lineData = new LinkedHashSet<String[]>();

		for (int i = 1; i <= allDaysData.size(); i++) {
			HashSet<Record> daySet = (HashSet) allDaysData.get("day" + i);

			day = i;

			int count = 0;
			double speed = 0;
			double distance = 0;

			int countSouth = 0;
			double speedSouth = 0;
			double distanceSouth = 0;

			double speedAv = 0;
			double distanceAv = 0;

			double speedAvSouth = 0;
			double distanceAvSouth = 0;

			boolean started = false;

			int rounds = (86400000 / interval) + 1;
			for (int ii = 0; ii < rounds; ii++) {

				if (started) {
					started = false;

					String[] columns = new String[6];
					columns[0] = ("" + day);
					if (count > 0) {
						speedAv = speed / count;
						distanceAv = distance / count;
					}
					columns[1] = ("" + ii);
					columns[2] = ("North");
					columns[3] = ("" + count);
					columns[4] = (format(speedAv));
					columns[5] = (format(distanceAv));
					lineData.add(columns);
					count = 0;
					speed = 0;
					distance = 0;

					String[] columnsSouth = new String[6];
					columnsSouth[0] = ("" + day);
					if (countSouth > 0) {
						speedAvSouth = speedSouth / countSouth;
						distanceAvSouth = distanceSouth / countSouth;
					}
					columnsSouth[1] = ("" + ii);
					columnsSouth[2] = ("South");
					columnsSouth[3] = ("" + countSouth);
					columnsSouth[4] = (format(speedAvSouth));
					columnsSouth[5] = (format(distanceAvSouth));
					lineData.add(columnsSouth);
					countSouth = 0;
					speedSouth = 0;
					distanceSouth = 0;
				}

				for (Record record : daySet) {

					if (record.timeRecorded() > (interval * ii)
							&& record.timeRecorded() < (interval * (ii + 1))) {
						String direction = record.getDirection().toString();
						if (direction.equals("A")) {
							count++;
							speed += record.speed();
							distance += record.distanceLastCar();
						} else {
							countSouth++;
							speedSouth += record.speed();
							distanceSouth += record.distanceLastCar();
						}

					}
				}

				started = true;

			}
		}

		return lineData;

	}

	/**
	 * Print format for double value with two decimals.
	 * @param speedAv
	 * @return
	 */
	
	private String format(double speedAv) {

		return String.format("%.2f", speedAv);
	}

	/**
	 * Print format for time of interval ie 7:00
	 * 
	 * @param string
	 * @param interval
	 * @return
	 */
	
	private Object formatTime(String string, int interval) {

		String timeValue = "";
		try {

			int value = Integer.parseInt(string);
			int minutes = (value * interval / (1000 * 60)) % 60;
			int hour = (value * interval / (1000 * 60 * 60));
			if (minutes == 0)
				timeValue = "" + hour + ":" + minutes + "0";
			else
				timeValue = "" + hour + ":" + minutes;
			// System.out.println("value="+value + " interval:"+interval);
		} catch (NumberFormatException e) {
			timeValue = "invalid";
		}
		return timeValue;
	}

}
