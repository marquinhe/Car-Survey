package com.salinas.record;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.msalinas.record.BuildRecord;
import com.msalinas.record.Direction;
import com.msalinas.record.Record;

public class RecordTest {

private Record recordNorth = new Record(); 
private Record secondRecordNorth = new Record();
private Record recordSouth = new Record(); 
	
	
	@BeforeClass
	public static void oneTimeSetUp() {
		System.out.println("Ini: " + System.currentTimeMillis());
	}

	@AfterClass
	public static void oneTimeTearDown() {
		System.out.println("End: " + System.currentTimeMillis());
	}

	@Before
	public void setUp() {
		
		Queue<String> tempRecord = new LinkedList<String>();
		Queue<String> tempRecordNorth = new LinkedList<String>();
		Queue<String> tempRecordSouth = new LinkedList<String>();
		
		String dataReading1 = "A98186";
		String dataReading2 = "A98333";
		
		String dataReading3 = "A638379";
		String dataReading4 = "B638382";
		String dataReading5 = "A638520";
		String dataReading6 = "B638523";
		
		String dataReading7 = "A499718"; 
		String dataReading8 = "A499886";
		
		tempRecordNorth.add(dataReading7);
		tempRecordNorth.add(dataReading8);
		
		tempRecord.add(dataReading1);
		tempRecord.add(dataReading2);
		
		tempRecordSouth.add(dataReading3);
		tempRecordSouth.add(dataReading4);
		tempRecordSouth.add(dataReading5);
		tempRecordSouth.add(dataReading6);
		
		BuildRecord rb = new BuildRecord();
		
		
		this.recordNorth = rb.build(tempRecord);
		this.recordSouth = rb.build(tempRecordSouth);
		this.secondRecordNorth = rb.build(tempRecordNorth,recordNorth);
		
	}

	@Test
	public void recordNotNull() {

		assertNotNull(recordNorth);
		assertNotNull(recordSouth);
		
	}
	
	@Test
	public void recordDirection () {

		assertEquals(recordNorth.getDirection().toString(), Direction.A.toString());
		assertEquals(recordSouth.getDirection().toString(), Direction.B.toString());
		recordNorth.getFrontTireFirstHose();
		recordNorth.speed();
		recordNorth.distanceLastCar();
		recordNorth.timeRecorded();
		
	}
	
	@Test
	public void timeRecorded () {

		assertEquals(recordNorth.timeRecorded(),98186);
		assertEquals(recordSouth.timeRecorded(),638379);
		
	}
	
	@Test
	public void speed () {

		double speedNorth = 2.5 * 1000 / (recordNorth.getBackTireFirstHose() - recordNorth.getFrontTireFirstHose()) * 3.6;
		double speedSouth = 2.5 * 1000 / (recordSouth.getBackTireFirstHose() - recordSouth.getFrontTireFirstHose()) * 3.6;
		assertEquals(recordNorth.speed(),speedNorth, 0.0002);
		assertEquals(recordSouth.speed(),speedSouth, 0.0002);
		
	}
	
	@Test
	public void distance () {
		
		int timeDifference  = secondRecordNorth.getFrontTireFirstHose() - secondRecordNorth.getLastValidRecordA().getBackTireFirstHose();
		double distance = (secondRecordNorth.speed() * 0.2777777777778) * timeDifference/1000;
		assertEquals(secondRecordNorth.distanceLastCar(), distance, 0.0002);
		
	}
	
	@Test
	public void frontTire () {
		
		assertEquals(secondRecordNorth.getFrontTireFirstHose(), 499718);
		
	}
	
	@Test
	public void backTire () {
		
		assertEquals(secondRecordNorth.getBackTireFirstHose(), 499886);
		
	}
	
	

}
