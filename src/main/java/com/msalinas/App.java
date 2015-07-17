package com.msalinas;

import java.io.Console;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.msalinas.load.LoadData;
import com.msalinas.process.Print;
import com.msalinas.validation.ValidateInput;

/**
 * Vehicle Survey main class 
 * Reads an file with observations of milliseconds and direction since midnight when car ires pass over a hose. 
 * 
 *
 * @author MSALINAS
 * @version 1.0
 * @since 2015-07-17
 */

public class App {

	private static final String EXIT = "EXIT";

	public static void main(String[] args) {
		processMenu(args);
	}

	private static void controller(String input, HashMap allDaysData) {

		ValidateInput validateInput = new ValidateInput(); 
		if (validateInput.isValid(input)){
			
			int interval =  calculateInterval(input);
			Print pt = new Print(allDaysData, interval); 
			
		}else{
			
			System.out.println("Please enter valid interval, ie: 4h, 12h, 15m");
		}
		
	}
	

	/**
	 * Calculates the numbers of milliseconds on the user input. 
	 * Expects a format numbercharacter as in 12m or 4h > m for minutes h for hours
	 * @param input 
	 * @return milliseconds
	 */
	private static int calculateInterval(String input) {
		String suffix = "" +   input.substring(input.trim().length() - 1);
		suffix = suffix.toUpperCase();
		String number = input.substring(0, input.length() - 1);
		
		int inputNumber = Integer.parseInt(number.trim());
		int milis = 0; 
		
		switch(suffix)
		{
		case "M":
			milis = inputNumber * 60000; 
			break;
		case "H":
			milis = inputNumber * 3600000; 
			break;
		case "DAYVSNIGHT":
			milis = 43200000; 
			break;
		}
		return milis;
	}

	
	/**
	 * Menu options
	 * @param args
	 */
	
	static void processMenu(String[] args) {

		boolean keepRunning = true;
		Console console = System.console();

		if (console == null) {
			System.err
					.println("Please run using console for time interval input.");
			System.exit(1);
		}

		System.out
				.println("------------------------------------------------------------------------");
		System.out.println("Welcome to Vehicle Survey");
		System.out
				.println("-----------------------------------------------------------------------");

		HashMap<String, Set> allDaysData = LoadData.load(args[0]);
		
		while (keepRunning) {

			System.out.println("Reading File: " + args[0]);
			

			
			System.out
			.println("------------------------------------------------------------------------");
	System.out.println("Enter a time interval for report (ie 15m, 20m, 30m, 4h, 12h, 24h or exit");

			String input = console.readLine();

			if (EXIT.equals(input.toUpperCase())) {
				keepRunning = false;
			}else{
				controller(input, allDaysData);
			}

		}

		System.exit(0);
	}
	


}
