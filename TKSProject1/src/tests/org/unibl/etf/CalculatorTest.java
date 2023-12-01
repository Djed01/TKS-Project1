package tests.org.unibl.etf;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.unibl.etf.tks.Calculator;
import org.unibl.etf.tks.DivisionByZeroException;
import org.unibl.etf.tks.NotSupportedOperationException;

class CalculatorTest {
	
	private Calculator calculator = new Calculator();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void initialTest() {
		Calculator calculator = new Calculator();
		assertThat(calculator, notNullValue());
		assertThat(calculator.getCurrentValue(), equalTo(0.0));
	}
	
	
	@ParameterizedTest
	@MethodSource("mulParamCalculateTest")
	public void mulParamCalculateTest(Double currentValue, Double value, char option, Double result) throws DivisionByZeroException, NotSupportedOperationException {
		calculator.setCurrentValue(currentValue);
		calculator.calculate(value, option);
		assertThat(result,is(closeTo(calculator.getCurrentValue(),0.000001)));
	}
	
	
	private static Stream<Arguments> mulParamCalculateTest() {
		return Stream.of(
				Arguments.of(0.0,7.0,'+',7.0),
				Arguments.of(0.0, 7.0, '-', -7.0),
				Arguments.of(0.0, 7.0, '*', 0.0),
				Arguments.of(2.0, 7.0, '*', 14.0),
				Arguments.of(0.0, 7.0, '/', 0.0),
				Arguments.of(12.0, 4.0, '/', 3.0));
	}
	
	@ParameterizedTest
	@MethodSource("mulParamExceptionTest")
	public void mulParamCalculateTest(Double currentValue, Double value, char option, Class<? extends Exception> exceptionType) throws DivisionByZeroException, NotSupportedOperationException {
		calculator.setCurrentValue(currentValue);
		assertThrows(exceptionType, () -> calculator.calculate(value, option));
	}
	
	
	private static Stream<Arguments> mulParamExceptionTest() {
		return Stream.of(
				Arguments.of(0.0, 7.0, '#', NotSupportedOperationException.class),
				Arguments.of(7.0, 0.0, '/', DivisionByZeroException.class)
				);
	}
	

}
