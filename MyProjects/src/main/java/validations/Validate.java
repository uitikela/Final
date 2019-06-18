package validations;

import exception.MyException;

public class Validate {
	
	public static void validate(int input) throws MyException {
		if (input < 0)
			throw new MyException("Negative Number");
	}

	public static void validateStr(String str) throws MyException {
		if (str.matches("[a-zA-z0-9]*"))
			
			throw new MyException("Alphanumeric");

	}

}
