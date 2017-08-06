package junit;
import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import com.ruch.calc.Operator;
import com.ruch.calc.CalculatorException;


public class OperatorTest {

	Random r;
	double firstOperand;
	double secondOperand;

	@Test
	public void testCalculateAdd() throws CalculatorException {
		r = new Random();
		firstOperand = r.nextDouble();
		secondOperand = r.nextDouble();
		assertEquals(secondOperand + firstOperand, Operator.ADD.calculate(firstOperand, secondOperand), 0);
	}

	@Test
	public void testCalculateSubtract() throws CalculatorException {
		r = new Random();
		firstOperand = r.nextDouble();
		secondOperand = r.nextDouble();
		assertEquals(firstOperand - secondOperand, Operator.SUBSTRACT.calculate(firstOperand, secondOperand), 0);
	}

	@Test
	public void testCalculateMultiply() throws CalculatorException {
		r = new Random();
		firstOperand = r.nextDouble();
		secondOperand = r.nextDouble();
		assertEquals(secondOperand * firstOperand, Operator.MULTIPLY.calculate(firstOperand, secondOperand), 0);
	}

	@Test
	public void testCalculateDivide() throws CalculatorException {
		r = new Random();
		firstOperand = r.nextDouble();
		secondOperand = r.nextDouble();
		assertEquals(firstOperand / secondOperand, Operator.DIVIDE.calculate(firstOperand, secondOperand), 0);
	}

	@Test(expected = CalculatorException.class)
	public void testDivideByZero() throws CalculatorException {
		Operator.DIVIDE.calculate(0.0, 0.0);
	}

}