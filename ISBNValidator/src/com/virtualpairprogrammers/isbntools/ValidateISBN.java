package com.virtualpairprogrammers.isbntools;

public class ValidateISBN {

	private static final int Long_ISBN_Multiplier = 10;
	private static final int Short_ISBN_Multiplier = 11;
	private static final int Short_ISBN_Length = 10;
	private static final int Long_ISBN_Length = 13;

	public boolean checkISBN(String isbn) {
		 
		if(isbn.length() == Long_ISBN_Length) {
			return isThisValid13NumberISBN(isbn);
		} 
		else {
		
		if(isbn.length() != Short_ISBN_Length) throw new NumberFormatException("ISBN number must be 10 digits long");
		
		return IsThisAValid10DigitISBN(isbn);
		}
	}

	private boolean IsThisAValid10DigitISBN(String isbn) {
		int total = 0;
		
		for(int i = 0; i < Short_ISBN_Length; i++) 
		{
			if(!Character.isDigit(isbn.charAt(i))) {
				if(i == 9 && isbn.charAt(i) == 'X'){
					total += 10;
				}else {
				throw new NumberFormatException("ISBN number can only cantain numeric");
				}
			}else {
				
				total += Character.getNumericValue(isbn.charAt(i)) * (Short_ISBN_Length -i);
			}
		}
		
		if (total % Short_ISBN_Multiplier == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	private boolean isThisValid13NumberISBN(String isbn) {
		int total =0;
		
		for(int i = 0; i < Long_ISBN_Length; i++) {
			if(i % 2 == 0) {
				total += Character.getNumericValue(isbn.charAt(i));
			}else {
				total += Character.getNumericValue(isbn.charAt(i)) * 3;
			}
		}
		if (total % Long_ISBN_Multiplier == 0) {
			return true;
		}
		else {
			return false;
		}
	}

}
