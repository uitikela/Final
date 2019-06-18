package com;

import java.text.NumberFormat;
import java.util.Scanner;
import validations.Validate;
import constant.NumberTypes;
import exception.MyException;

public class NumberToWordsConverter {

	

	public static String convert(final int n) {
		if (n < 0) {
			return "Minus " + convert(-n);
		}

		if (n < 20) {
			return NumberTypes.units[n];
		}

		if (n < 100) {
			return NumberTypes.tens[n / 10] + ((n % 10 != 0) ? " " : "") + NumberTypes.units[n % 10];
		}

		if (n < 1000) {
			return NumberTypes.units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
		}

		if (n < 100000) {
			return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
		}

		if (n < 10000000) {
			return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
		}

		return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
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
					Validate.validate(n);
					System.out.println(NumberFormat.getInstance().format(n) + "='" + convert(n) + "'");
				} else if (input.hasNext()) {
					input.nextLine();
					String str = input.nextLine();
					Validate.validateStr(str);
				
				}

			}
			 catch (MyException m) {
				System.out.println(m.getMessage());
			}
	}
	}
}
