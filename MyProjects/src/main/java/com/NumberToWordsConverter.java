package com;

import java.text.NumberFormat;
import java.util.Scanner;

import exception.MyException;

public class NumberToWordsConverter {

	public static final String[] units = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };
	public static final String[] tens = { "", // 0
			"", // 1
			"Twenty", // 2
			"Thirty", // 3
			"Forty", // 4
			"Fifty", // 5
			"Sixty", // 6
			"Seventy", // 7
			"Eighty", // 8
			"Ninety" // 9
	};

	public static String convert(final int n) {
		if (n < 0) {
			return "Minus " + convert(-n);
		}

		if (n < 20) {
			return units[n];
		}

		if (n < 100) {
			return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
		}

		if (n < 1000) {
			return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
		}

		if (n < 100000) {
			return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
		}

		if (n < 10000000) {
			return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
		}

		return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
	}

	static void validate(int input) throws MyException {
		if (input < 0)
			throw new MyException("Negative Number");
	}

	static void validateStr(String str) throws MyException {
		if (str.matches("[a-zA-z0-9]*"))
			
			throw new MyException("Alphanumeric");

	}

	public static void main(final String[] args) {
		
			
			int n;
			
			Scanner input = new Scanner(System.in);
			System.out.println("Enter a number to convert into word format");

			while (input.hasNextLine()) {
				System.out.println("please enter an input");
				try {
				
				if (input.hasNextInt()) {

					n = input.nextInt();
					validate(n);
					System.out.println(NumberFormat.getInstance().format(n) + "='" + convert(n) + "'");
				} else if (input.hasNext()) {
					input.nextLine();
					String str = input.nextLine();
					validateStr(str);
				
				}

			}
			 catch (MyException m) {
				System.out.println(m.getMessage());
			}
	}
	}
}
