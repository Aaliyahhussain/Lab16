package lab16;



import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
	public static int getInt(Scanner scnr, String prompt) {

		System.out.print(prompt);
		try {
			int num = scnr.nextInt();
			scnr.nextLine();
			return num;
		} catch (InputMismatchException e) {
			scnr.nextLine();
			return getInt(scnr, prompt);
		}
	}


	public static double getDouble(Scanner scnr, String prompt) {
	
		boolean isValid = false;
		do {
			System.out.print(prompt);
			isValid = scnr.hasNextDouble();
			if (!isValid) {
				scnr.nextLine();
			}
		} while (!isValid);
		
		double number = scnr.nextDouble();
		scnr.nextLine();
		return number;
	}
	
	public static String getString(Scanner scnr, String prompt) {
		// This approach uses exception handling.
		System.out.print(prompt);
		return scnr.nextLine();
	}
	
	
	public static int getInt(Scanner scnr, String prompt, int min, int max) {
		boolean isValid = false;
		int number;
		do {
			number = getInt(scnr, prompt);
			
			if (number < min) {
				isValid = false;
			} else if (number > max) {
				isValid = false;
			} else {
				isValid = true;
			}
			
		} while (!isValid);
		return number;
	}
	
	
	public static double getDouble(Scanner scnr, String prompt, double min, double max) {
		boolean isValid = false;
		double number;
		do {
			number = getDouble(scnr, prompt);
			
			if (number < min) {
				isValid = false;
			} else if (number > max) {
				isValid = false;
			} else {
				isValid = true;
			}
			
		} while (!isValid);
		return number;
	}
	
	
	public static String getStringMatchingRegex(Scanner scnr, String prompt, String regex) {
		boolean isValid = false;
		String input;
		do {
			input = getString(scnr, prompt);
			
			if (input.matches(regex)) {
				isValid = true;
			} else {
				isValid = false;
			}
			
		} while (!isValid);
		return input;
	}


	public static long getLong(Scanner scnr, String prompt) {
		System.out.print(prompt);
		try {
			long num = scnr.nextInt();
			scnr.nextLine();
			return num;
		} catch (InputMismatchException e) {
			scnr.nextLine();
			return getInt(scnr, prompt);
		}
	}

}

