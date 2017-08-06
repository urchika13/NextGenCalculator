package com.ruch.calc;

import com.ruch.calc.Operator;
import com.ruch.calc.CalculatorException;

public class Calculator {

	
	/**
	 * This method is used to compute the calculation
	 * on the input arguments
	 * @param inputArgs
	 * @return
	 * @throws CalculatorException
	 */
	public Double compute(String[] inputArgs) throws CalculatorException {
		
		Double firstOperand = null ,secondOperand = null, result = null;
		int noOfOperands = 0;
		Operator operator = null;
		String token = null;
		
		for (int itr = 0; itr<inputArgs.length; itr++) {
			//Fetch the argument
			token = inputArgs[itr];
			
			//Search for an operator
			operator = Operator.getEnum(token);
			
			//If no operator found
			if(operator == null){
				//Get the first operand value
				if(firstOperand == null){
					firstOperand = getOperandValue(token);
					noOfOperands++;
				}
				else{
					//To check if the input is a valid one
					getOperandValue(token);
					throw new CalculatorException(CalculatorException.INVALID_INPUT_SEQUENCE);
				}
			}
			//If operator found
			else{
				// To get the next element
				itr++;
				
				if(firstOperand == null){
					firstOperand = getOperandValue(inputArgs[itr]);
					itr++;
					noOfOperands++;
				}
				else if(itr < inputArgs.length){
					secondOperand = getOperandValue(inputArgs[itr]);
					noOfOperands++;
				}
				
				switch (operator) {
				case ADD:
				case SUBSTRACT:
				case MULTIPLY:
				case DIVIDE:
				default:
					if(checkSufficientParams(operator,noOfOperands)){
						result = operator.calculate(firstOperand, secondOperand);
						firstOperand = result;
						operator = null;
					}
					break;
				}
			}
		}
		return result;
	}

	/**
	 * This method returns the operand value for a valid input
	 * and returns an exception for invalid input
	 * @param operand
	 * @return
	 * @throws CalculatorException
	 */
	private Double getOperandValue(String operand) throws CalculatorException{
		try {
			return Double.parseDouble(operand);
		} catch (NumberFormatException nfe) {
			throw new CalculatorException(String.format(CalculatorException.INVALID_INPUT,operand));
		}

	}

	/**
	 * This method is used to check if there are enough 
	 * operand for the operation
	 * @param operator
	 * @param noOfOperands
	 * @return
	 * @throws CalculatorException
	 */
	private boolean checkSufficientParams(Operator operator, int noOfOperands) throws CalculatorException {
		if (operator.getNoOfOperants() > noOfOperands) {
			throw new CalculatorException(String.format(CalculatorException.INSUFFICIENT_PARAMS, operator));
		}
		else{
			return true;
		}
	}

}