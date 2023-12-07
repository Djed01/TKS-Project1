package tests;

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
import org.unibl.etf.tks.CalculatorAdvanced;
import org.unibl.etf.tks.DivisionByZeroException;
import org.unibl.etf.tks.NotSupportedOperationException;
import org.unibl.etf.tks.NumberNotInAreaException;

/**
 * JUnit test class for the CalculatorAdvanced class.
 */
class CalculatorAdvancedTest {
	
	private CalculatorAdvanced calculator = new CalculatorAdvanced();

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

	 /**
     * Test method for the initial state of the CalculatorAdvanced.
     */
	@Test
	void initialTest() {
		CalculatorAdvanced calculator = new CalculatorAdvanced();
		assertThat(calculator,notNullValue());
		assertThat(calculator.getCurrentValue(), equalTo(0.0));
	}
	
	 /**
     * Parameterized test for the calculateAdvanced method with valid input.
     * @param currentValue Initial value of the calculator.
     * @param option Operator for the advanced calculation.
     * @param result Expected result after the advanced calculation.
     * @throws NotSupportedOperationException if the operation is not supported.
     * @throws NumberNotInAreaException if the number is not in the valid range.
     * @throws DivisionByZeroException if division by zero occurs.
     */
	@ParameterizedTest
	@MethodSource("mulParamCalculateAdvancedTest")
	void calculateAdvancedTest(Double currentValue, char option, Double result) throws NotSupportedOperationException, NumberNotInAreaException, DivisionByZeroException {
		calculator.setCurrentValue(currentValue);
		calculator.calculateAdvanced(option);
		assertThat(result, is(calculator.getCurrentValue()));
	}
	
	/**
     * Provides arguments for the calculateAdvancedTest method.
     * @return Stream of Arguments containing test input and expected output.
     */
	private static Stream<Arguments> mulParamCalculateAdvancedTest() {
		return Stream.of(
				Arguments.of(0.0, '0', 1.0),
				Arguments.of(7.0, '0', 1.0),
				Arguments.of(0.0, '9', 0.0),
				Arguments.of(-7.0, '2', 49.0),
				Arguments.of(7.0, '1', 7.0),
				Arguments.of(2.0, '8', 256.0),
				Arguments.of(0.0, '!', 1.0),
				Arguments.of(7.0,'!',5040.0),
				Arguments.of(10.0, '!', 3628800.0));
	}
	
	 /**
     * Parameterized test for the calculateAdvanced method with invalid input causing exceptions.
     * @param currentValue Initial value of the calculator.
     * @param option Operator for the advanced calculation.
     * @param exceptionClass Expected exception type.
     * @throws NotSupportedOperationException if the operation is not supported.
     * @throws NumberNotInAreaException if the number is not in the valid range.
     * @throws DivisionByZeroException if division by zero occurs.
     */
	@ParameterizedTest
	@MethodSource("mulParamCalculateAdvancedTestException")
	void calculateAdvancedTest(Double currentValue, char option, Class<? extends Exception> exceptionClass) throws NotSupportedOperationException, NumberNotInAreaException, DivisionByZeroException {
		calculator.setCurrentValue(currentValue);
		Exception exception = assertThrows(exceptionClass, () -> calculator.calculateAdvanced(option));
		assertThat(exception, is(instanceOf(exceptionClass)));
	}
	
	 /**
     * Provides arguments for the calculateAdvancedTestException method.
     * @return Stream of Arguments containing test input and expected exception type.
     */
	private static Stream<Arguments> mulParamCalculateAdvancedTestException() {
		return Stream.of(Arguments.of(0.0, 'x', NotSupportedOperationException.class),
				Arguments.of(-0.01, '!', NumberNotInAreaException.class),
				Arguments.of(10.01, '!', NumberNotInAreaException.class));
	}
	
	 /**
     * Parameterized test for the hasCharacteristic method.
     * @param value Value to check for characteristics.
     * @param option Characteristic option.
     * @param result Expected result of the hasCharacteristic method.
     * @throws NotSupportedOperationException if the operation is not supported.
     * @throws NumberNotInAreaException if the number is not in the valid range.
     */
	@ParameterizedTest
	@MethodSource("hasCharacteristicsTests")
	void hasCharacteristicsTest(Double value, char option, Boolean result) throws NotSupportedOperationException, NumberNotInAreaException {
		calculator.setCurrentValue(value);
		assertThat(result, is(calculator.hasCharacteristic(option)));
	}
	
	/**
     * Provides arguments for the hasCharacteristicsTest method.
     * @return Stream of Arguments containing test input and expected output.
     */
	private static Stream<Arguments> hasCharacteristicsTests() {
		return Stream.of(
				Arguments.of(153.0, 'A', true),
				Arguments.of(154.0, 'A', false),
				Arguments.of(370.0, 'A', true),
				Arguments.of(371.0, 'A', true),
				Arguments.of(6.0, 'P', true),
				Arguments.of(7.0, 'P', false),
				Arguments.of(28.0, 'P', true),
				Arguments.of(29.0, 'P', false),
				Arguments.of(1.0, 'P', false));
	}
	
	
	 /**
     * Parameterized test for the hasCharacteristic method with invalid input causing exceptions.
     * @param value Value to check for characteristics.
     * @param option Characteristic option.
     * @param exceptionClass Expected exception type.
     * @throws NotSupportedOperationException if the operation is not supported.
     * @throws NumberNotInAreaException if the number is not in the valid range.
     */
	@ParameterizedTest
	@MethodSource("hasCharacteristicsTestsException")
	void hasCharacteristicsExceptionsTest(Double value, char option, Class<? extends Exception> exceptionClass) throws NotSupportedOperationException, NumberNotInAreaException {
		calculator.setCurrentValue(value);
		Exception exc = assertThrows(exceptionClass, () -> calculator.hasCharacteristic(option));
		assertThat(exc, is(instanceOf(exceptionClass)));
	}
	
	/**
     * Provides arguments for the hasCharacteristicsTestsException method.
     * @return Stream of Arguments containing test input and expected output.
     */
	private static Stream<Arguments> hasCharacteristicsTestsException() {
		return Stream.of(
				Arguments.of(7.0, 'a', NotSupportedOperationException.class),
				Arguments.of(0.99, 'P', NumberNotInAreaException.class));
	}
	
	
	
	

}
