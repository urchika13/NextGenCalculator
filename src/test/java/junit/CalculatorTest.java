package junit;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.ruch.calc.Calculator;
import com.ruch.calc.CalculatorException;

public class CalculatorTest {

	Calculator calculator;
	Double result;

	@Before 
	public void initialize() {
		calculator = new Calculator();
	}

	/**
	 * Test no operator provided in input
	 * @throws Exception
	 */
	@Test
	public void testNoOperator() throws Exception {
		try {
			calculator.compute(new String[] {"5","2"});
		} catch (CalculatorException e) {
			assertEquals(CalculatorException.INVALID_INPUT_SEQUENCE, e.getMessage());
		}
	}

	/**
	 * Test invalid input sequence
	 * @throws Exception
	 */
	@Test
	public void testInvalidInputSeq() throws Exception {
		try {
			calculator.compute(new String[] {"5","2","+"});
		} catch (CalculatorException e) {
			assertEquals(CalculatorException.INVALID_INPUT_SEQUENCE, e.getMessage());
		}
	}

	@Test
	public void testAddOperation() throws Exception {
		// Add
		result = calculator.compute(new String[] {"5","+","2"});
		assertEquals(7, result, 0);
	}

	@Test
	public void testSubtractOperation() throws Exception {
		// Subtract
		result = calculator.compute(new String[] {"5","-","9"});
		assertEquals(-4, result, 0);
	}

	@Test
	public void testMultiplyOperation() throws Exception {
		// Multiply
		result = calculator.compute(new String[] {"2.2","*","30"});
		assertEquals(66, result, 0);
	}

	@Test
	public void testDivideOperation() throws Exception {
		// Divide
		result = calculator.compute(new String[] {"9","/","3"});
		assertEquals(3, result, 0);
	}

	@Test
	public void testInsuficientParameters() {
		try {
			calculator.compute(new String[] {"30","+"});
		} catch (CalculatorException e) {
			assertEquals(String.format(CalculatorException.INSUFFICIENT_PARAMS, "+"), e.getMessage());
		}
	}

	@Test
	public void testInvalidCharacters() throws Exception {
		try {
			calculator.compute(new String[] {"10","%","5"});
		} catch (CalculatorException e) {
			assertEquals(String.format(CalculatorException.INVALID_INPUT, "%"), e.getMessage());
		}
	}

	@Test(expected = CalculatorException.class)
	public void testDivideByZero() throws Exception {
		calculator.compute(new String[] {"10","/","0"});
	}

	@Test(expected = CalculatorException.class)
	public void testOnlyOperators() throws Exception {
		calculator.compute(new String[] {"+","-","*"});
	}
	
	@Test
	public void testMultipleNosAddOperation() throws Exception {
		result = calculator.compute(new String[] {"5","+","2","+","2"});
		assertEquals(9, result, 0);
	}
	
	@Test
	public void testCombinationOperation() throws Exception {
		result = calculator.compute(new String[] {"5","+","2","-","1","*","3"});
		assertEquals(18, result, 0);
	}

	public void testSineOperation() throws Exception {
		//To be implemented
	}

	public void testCosineOperation() throws Exception {
		//To be implemented
	}

}