package com.virtualpairprogrammers.isbntools;

public class ValidateISBN {

	private static final int Long_ISBN_Multiplier = 10;
	private static final int Short_ISBN_Multiplier = 11;
	private static final int Short_ISBN_Length = 10;
	private static final int Long_ISBN_Length = 13;

	public boolean checkISBN(String isbn) {
		 
		if(isbn.length() == Long_ISBN_Length) {
			return isThisValidLongNumberISBN(isbn);
		} 
		else if (isbn.length() == Short_ISBN_Length) {
			return IsThisAValidShortDigitISBN(isbn);
		}
		throw new NumberFormatException("ISBN numbers must be 10 or 13 digits long");
	}

	private boolean IsThisAValidShortDigitISBN(String isbn) {
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
		
		return (total % Short_ISBN_Multiplier == 0); 
		
	}

	private boolean isThisValidLongNumberISBN(String isbn) {
		int total =0;
		
		for(int i = 0; i < Long_ISBN_Length; i++) {
			if(i % 2 == 0) {
				total += Character.getNumericValue(isbn.charAt(i));
			}else {
				total += Character.getNumericValue(isbn.charAt(i)) * 3;
			}
		}
		return (total % Long_ISBN_Multiplier == 0); 
	}

}
