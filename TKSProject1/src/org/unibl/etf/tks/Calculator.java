package org.unibl.etf.tks;

/**
 * Simple calculator class that offers a method for basic calculating operations such as addition, subtraction, multiplication and division.
 * @author Gordan Letic
 * @since 28.11.2023.
 * @version 1.0
 */
public class Calculator {
	
	/**
	 * Represents the current value of the calculator.
	 * Inital value is zero.
	 */
	private Double currentValue = 0.0;
	
	
	/**
	 * Gets the current value of the calculator
	 * @return current value of calculator.
	 */
	public Double getCurrentValue() {
		return currentValue;
	}

	/**
	 * Sets the current value of the calculator.
	 * @param currentValue the value that will be set as the new current value of the calculator.
	 */
	public void setCurrentValue(Double currentValue) {
		this.currentValue = currentValue;
	}
	
	/**
	 * Method for performing simple calculating operations such as addition, subtraction, multiplication and division.
	 * The operation is performed with the current value of the calculator and the provided value.
	 * The result is saved to the currentValue variable.
	 * @param value Second operand in the operation.
	 * @param operator Symbol of the operation.
	 * @throws DivisionByZeroException Exception for dividing with zero.
	 * @throws NotSupportedOperationException Exception that throws if the operator is unexpected.
	 */
	public void calculate(Double value, char operator) throws DivisionByZeroException, NotSupportedOperationException {
		switch(operator){
			case '+':
				currentValue += value;
				break;
			case '-':
				currentValue -= value;
				break;
			case '*':
				currentValue *= value;
				break;
			case '/':
				if(value == 0) {
					throw new DivisionByZeroException();
				}
				currentValue /= value;
				break;
			default:
				throw new NotSupportedOperationException();
		
		}
	}
	
}
