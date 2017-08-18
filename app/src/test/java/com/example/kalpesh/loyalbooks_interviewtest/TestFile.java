package com.example.kalpesh.loyalbooks_interviewtest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
/**
 * Testing the getting values and to check if it has correct values 
 * @author Kalpesh
 *
 */
public class TestFile {
	
	FileParser getFile;
	String[] splitWords;
	
	/**
	 * Setting up before each test, to remove duplicate code.
	 */
	@Before
	public void setup(){
		getFile = new FileParser();
		splitWords = getFile.readWords("Railway-Children-by-E-Nesbit.txt");
		
	}
	
	/**
	 * Cleaning up on method
	 */
	@After
	public void cleanUp() {
		
	}
	
	/**
	 * Ensure correct number of words in file
	 */
	@Test
    public void gettingWordsFromFile() {
		
		Assert.assertEquals(66101, splitWords.length);
    }
	
	/**
	 * Ensure correct number unique of words in file
	 */
	@Test
    public void CountingWords() {		
		Map<String, Integer> occurrences = Controller.getOccurrences(splitWords);
		
		Assert.assertEquals(4705, occurrences.size());
    }
	/**
	 * Ensure correct number unique of words in file and count
	 */
	@Test
    public void gettingCorrectCountedWords() {
				
		Map<String, Integer> occurrences = Controller.getOccurrences(splitWords);
		
		Assert.assertEquals(4705, occurrences.size());
		
		Assert.assertEquals(3366, occurrences.get("the").intValue());
		Assert.assertEquals(2473, occurrences.get("and").intValue());
		Assert.assertEquals(1181, occurrences.get("a").intValue());
		Assert.assertEquals(1161, occurrences.get("it").intValue());
    }

}
