package com.virtualpairprogrammers.isbntools;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

class ValidateISBNTest {

	private static final String expected  = null;

	@Test
	public void checkAValid10ISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449116");
		assertTrue(result);
		result = validator.checkISBN("0140177396");
		assertTrue(result);
	}
	
	@Test
	public void checkAnInvalid10ISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449117");
		assertFalse(result);
	}
	
	@Test
	public void TenISBNNumbersEndingInAnXAreValid() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("140449117X");
		assertFalse(result);
	}
	
	@Test
	public void ISBNhasThirteenNumbers() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9781853260087");
		assertTrue(result);
		result = validator.checkISBN("9781853267338");
		assertTrue(result);
		
	}
	
	@Test
	public void checkInvalide13ISBNnNumbers() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9781853260087");
		assertTrue(result);
		fail();		
	}
	
	
	/*@Test (expected = NumberFormatException.class)
	public void nineDigitISBNsAreNotAllowed() {
		ValidateISBN validator = new ValidateISBN();
		validator.checkISBN("123456789");
	}*/
	
	/*@Test (expected = NumberFormatException.class)
	public void nonNumbericISBNsAreNotAllowed() {
		ValidateISBN validator = new ValidateISBN();
		validator.checkISBN("helloworld");
	}*/

}
