package org.unibl.etf.tks;


/**
 *  Class that extends the basic calculator and implements operations such as power and factorial functions.
 *  Implements methods to check if a number is pime or Armstrong's.
 *  @author Gordan Letic
 *  @since 28.11.2023.
 *  @version 1.0
 */

public class CalculatorAdvanced extends Calculator {
	
	/**
	 * Performs power or factorial of the current value depending on the provided parameter.
	 * If the parameter is in range between 0 and 9 it calculates the integer part of the current value to the power of the provided parameter.
	 * If the parameter is ! it calculates factorial of the integer part of the current value.
	 * @param action Character representing the type of operation. Allowed values are 0-9 and !.
	 * @throws NumberNotInAreaException Exception that throws when calculating the factorial of a value that is not between 0 and 10.
	 * @throws NotSupportedOperationException Exception that throws if the action is unexpected.
	 */
	public void calculateAdvanced(char action) throws NumberNotInAreaException, NotSupportedOperationException {
		if (!((action >= '0' && action <= '9') || action == '!')) {
			throw new NotSupportedOperationException();
		}
		int parsedValue = (int) Math.floor(getCurrentValue());
		if (action >= '0' && action <= '9') {
			int pow = Character.getNumericValue(action);

			setCurrentValue((double) power(parsedValue, pow));
		} else {
			if (getCurrentValue() < 0 || getCurrentValue() > 10) {
				throw new NumberNotInAreaException();
			} else {
				setCurrentValue((double) factoriel(parsedValue));
			}

		}
	}
	
	/**
	 * Checks if the integer part of the current value is prime or Armstrong's number depending on the provided parameter.
	 * @param value Character that represents if the method checks if the number is prime ("P") or Armstrong's ("S").
	 * @return true if the integer value of the current value is prime or Armstrong's.
	 * @throws NotSupportedOperationException Exception that throws if the provided parameter is unexpected.
	 * @throws NumberNotInAreaException Theows if the integer value of the current value is less than 1.
	 */
	public Boolean hasCharacteristic(char value) throws NotSupportedOperationException, NumberNotInAreaException {
		if (value != 'A' && value != 'P') {
			throw new NotSupportedOperationException();
		}
		int parsedValue = (int) Math.floor(getCurrentValue());
		if (parsedValue < 1) {
			throw new NumberNotInAreaException();
		}
		if (value == 'A' && isArmstrong(parsedValue)) {
			return true;
		}
		if (value == 'P' && isPerfect(parsedValue)) {
			return true;
		}
		return false;
	}

	/**
	 * Calculates the power of a number.
	 * @param parsedValue Base number of the power function.
	 * @param pow Exponent for the power function.
	 */
	private int power(int parsedValue, int pow) {
		int temp = 1;
		for (int i = 0; i < pow; i++) {
			temp *= parsedValue;
		}
		return temp;
	}
	
	/**
	 * Calculates the factorial of a number.
	 * @param parsedValue The number which factorial is calculating.
	 * @return returns the factorial value.
	 */
	private int factoriel(int parsedValue) {
		int temp = 1;
		for (int i = 1; i <= parsedValue; i++) {
			temp *= i;
		}
		return temp;
	}

	/**
	 * Checks if the provided number is perfect.
	 * @param value the number that is being checked.
	 * @return true if the nmber is perfect.
	 */
	private boolean isPerfect(int value) {
		int sum = 0;
		for (int i = 1; i <= value / 2; i++)
			if (value % i == 0)
				sum += i;

		if (sum == value) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if a number is Armstrong's.
	 * @param value the number that is being checked.
	 * @return true if the number is Armstrong's.
	 */
	private boolean isArmstrong(int value) {

		int numOfDigits = countNumOfDigits(value);

		int temp = value;
		int sum = 0;
		while (temp > 0) {
			sum += power(temp % 10, numOfDigits);
			temp /= 10;
		}
		if (sum == value) {
			return true;
		}
		return false;
	}

	/**
	 * Helper method that counts the number of digits in a number.
	 * @param value number whose digits are counted.
	 * @return number of digits of the provided number.
	 */
	private int countNumOfDigits(int value) {
		int num = 0;
		while (value > 0) {
			num++;
			value /= 10;
		}
		return num;
	}

}
