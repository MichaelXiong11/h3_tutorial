package com.virtualpairprogrammers.isbntools;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidateISBNTest {

	@Test
	public void checkAValidISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449116");
		assertTrue(result);
		result = validator.checkISBN("0140177396");
		assertTrue(result);
	}
	
	@Test
	public void checkAnInvalidISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449117");
		assertFalse(result);
	}

	@Test
	public void nineDigitIsNotAllowed() {
		fail();
	}
}
