package com.msalinas.input;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.msalinas.load.LoadData;
import com.msalinas.record.BuildRecord;
import com.msalinas.record.Record;

public class LoadDataTest {
	

	@BeforeClass
	public static void oneTimeSetUp() {
		System.out.println("Ini: " + System.currentTimeMillis());
	}

	@AfterClass
	public static void oneTimeTearDown() {
		System.out.println("End: " + System.currentTimeMillis());
	}

	@Test
	public void load() {
		LoadData ld = new LoadData(); 
		String file = "wrongPath";
		assertNull(LoadData.load(file));
	}
	
	@Test
	public void loadValid() {
		LoadData ld = new LoadData(); 
		String file = "data.txt"; 
	
		assertNotNull(LoadData.load(file));
	}
	
	@Test
	public void notEmpty() {
		LoadData ld = new LoadData(); 
		String file = "data.txt"; 
		assertTrue(LoadData.load(file).size() >0);
		
	}
	
	@Test
	public void loadHashMap() {
		LoadData ld = new LoadData(); 
		String file = "data.txt"; 
		assertTrue(LoadData.load(file).size() >0);
		
	}
	
	

}
