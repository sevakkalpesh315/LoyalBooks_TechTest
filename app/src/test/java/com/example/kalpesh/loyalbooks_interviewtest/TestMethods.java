package com.example.kalpesh.loyalbooks_interviewtest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Testing methods that display prime and none prime words and their counts
 * @author Kalpesh
 *
 */
public class TestMethods {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	Map<String, Integer> occurrences;
	ArrayList<String> resultsTrue;
	ArrayList<String> resultsFalse;
	Controller controller;

	/**
	 * Setting up for getting PrintStream and
	 * added values for results for correct and incorrect values
	 */
	@Before
	public void setUp() {
		controller= new Controller();
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
		occurrences =new HashMap<String, Integer>();
		occurrences.put("the", 3366);
		occurrences.put("was",  840 );
		occurrences.put("i", 1019 );
		occurrences.put("you" , 1039 );
		occurrences.put("of", 1058 );
		occurrences.put("said", 1145 );
		occurrences.put("it", 1161);
		occurrences.put("a", 1181 );
		occurrences.put("to", 1553 );
		occurrences.put("and", 2473 );
		occurrences.put("the", 3366);

		resultsTrue = new ArrayList<>();

		resultsTrue.add("was : 840 Prime? : false");
		resultsTrue.add("i : 1019 Prime? : true");
		resultsTrue.add("you : 1039 Prime? : true");
		resultsTrue.add("of : 1058 Prime? : false");
		resultsTrue.add("said : 1145 Prime? : false");
		resultsTrue.add("it : 1161 Prime? : false");
		resultsTrue.add("a : 1181 Prime? : true");
		resultsTrue.add("to : 1553 Prime? : true");
		resultsTrue.add("and : 2473 Prime? : true");
		resultsTrue.add("the : 3366 Prime? : false");

		resultsFalse = new ArrayList<>();

		resultsFalse.add("was : 840 Prime? : true");
		resultsFalse.add("i : 1019 Prime? : false");
		resultsFalse.add("you : 1039 Prime? : false");
		resultsFalse.add("of : 1058 Prime? : true");
		resultsFalse.add("said : 1145 Prime? : true");
		resultsFalse.add("it : 1161 Prime? : true");
		resultsFalse.add("a : 1181 Prime? : false");
		resultsFalse.add("to : 1553 Prime? : false");
		resultsFalse.add("and : 2473 Prime? : false");
		resultsFalse.add("the : 3366 Prime? : true");
	}

	/**
	 * cleaning up system printStreams after each test
	 */
	@After
	public void cleanUp() {
		System.setOut(null);
		System.setErr(null);
	}
	
	/**
	 * Checking if the isPrimeNumber is working correctly
	 */
	@Test
	public void isPrimeFunctionWorking() {
		Assert.assertEquals(true, controller.isPrime(2));
		Assert.assertEquals(true, controller.isPrime(3));
		Assert.assertEquals(true, controller.isPrime(7));
		Assert.assertEquals(true, controller.isPrime(11));
		Assert.assertEquals(false, controller.isPrime(12));
		Assert.assertEquals(false, controller.isPrime(15));
	}
	
	/**
	 * Testing if displaying correct message with prime number
	 */
	@Test
	public void gettingCorrectCountedPrintedWordsOne() {
		controller.printOccurrences(occurrences);
		assertTrue(outContent.toString().contains("the : 3366 Prime? : false"));
	}
	
	/**
	 * Testing if displaying correct message with prime number for a list of values
	 */
	@Test
	public void gettingCorrectCountedPrintedWordsLoop() {
		controller.printOccurrences(occurrences);
		for(String value:resultsTrue){
			assertTrue("Does not contain: " + value ,outContent.toString().contains(value));
		}
	}

	/**
	 * Testing if displaying incorrect message with prime number for a list of values
	 */
	@Test
	public void gettingIncorrectCountedPrintedWordsLoop() {
		controller.printOccurrences(occurrences);
		for(String value:resultsFalse){
			assertFalse("Does contain: " + value ,outContent.toString().contains(value));
		}
	}

}
