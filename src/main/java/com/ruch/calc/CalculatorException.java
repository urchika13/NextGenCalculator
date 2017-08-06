package com.ruch.calc;

@SuppressWarnings("serial")
public class CalculatorException extends Exception {
	
	public static final String INVALID_INPUT_SEQUENCE = "The input sequence is invalid!";
	public static final String INVALID_INPUT = "'%s' - Is not a valid operator!";
	public static final String INSUFFICIENT_PARAMS = "Operator '%s' has insufficient parameters!";
	
	public CalculatorException(String message) {
        super(message);
    }
}