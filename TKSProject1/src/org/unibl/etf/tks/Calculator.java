package org.unibl.etf.tks;

public class Calculator {
	private Double currentValue = 0.0;

	public Double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(Double currentValue) {
		this.currentValue = currentValue;
	}
	
	
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
