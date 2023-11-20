package org.unibl.etf.tks;

public class CalculatorAdvanced extends Calculator {

	public void calculateAdvanced(char action) throws NumberNotInAreaException, NotSupportedOperationException {
		if (!((action >= '0' && action <= '9') || action == '!')) {
			throw new NotSupportedOperationException();
		}
		int parsedValue = (int) Math.floor(getCurrentValue());
		if (action >= '0' && action <= '9') {
			int pow = (int) action;

			setCurrentValue((double) power(parsedValue, pow));
		} else {
			if (getCurrentValue() < 0 || getCurrentValue() > 10) {
				throw new NumberNotInAreaException();
			} else {
				setCurrentValue((double) factoriel(parsedValue));
			}

		}
	}

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

	private int power(int parsedValue, int pow) {
		int temp = 1;
		for (int i = 0; i < pow; i++) {
			temp *= parsedValue;
		}
		return temp;
	}

	private int factoriel(int parsedValue) {
		int temp = 1;
		for (int i = 1; i <= parsedValue; i++) {
			temp *= i;
		}
		return temp;
	}

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

	private int countNumOfDigits(int value) {
		int num = 0;
		while (value > 0) {
			num++;
			value /= 10;
		}
		return num;
	}

}
