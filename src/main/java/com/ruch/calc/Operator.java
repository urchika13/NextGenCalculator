package com.ruch.calc;

import java.util.HashMap;
import java.util.Map;


public enum Operator {

	ADD("+", 2) {
		public Double calculate(Double firstOperand, Double secondOperand) throws CalculatorException {
			return firstOperand + secondOperand;
		}
	},

	SUBSTRACT("-", 2) {
		public Double calculate(Double firstOperand, Double secondOperand) {
			return firstOperand - secondOperand;
		}
	},

	MULTIPLY("*", 2) {
		public Double calculate(Double firstOperand, Double secondOperand) {
			return firstOperand * secondOperand;
		}
	},

	DIVIDE("/", 2) {
		public Double calculate(Double firstOperand, Double secondOperand) throws CalculatorException {
			if (secondOperand == 0)
				throw new CalculatorException("Cannot divide by zero.");
			return firstOperand / secondOperand;
		}
	},

	SINE("sin", 1) {
		//To be implemented later
		public Double calculate(Double firstOperand, Double secondOperand) {
			return null;
		}
	},
	
	COSINE("cosine", 1) {
		//To be implemented later
		public Double calculate(Double firstOperand, Double secondOperand) {
			return null;
		}
	};

	private String sign;
	private int noOfOperants;

	Operator(String sign, int noOfOperants) {
		this.sign = sign;
		this.noOfOperants = noOfOperants;
	}

	public abstract Double calculate(Double firstOperand, Double secondOperand) throws CalculatorException;

	private static final Map<String, Operator> lookUp = new HashMap<String, Operator>();

	static {
		for (Operator o : values()) {
			lookUp.put(o.getSign(), o);
		}
	}

	//Method to lookup valid values of Enum
	public static Operator getEnum(String value) {
		return lookUp.get(value);
	}

	public String getSign() {
		return sign;
	}

	public int getNoOfOperants() {
		return noOfOperants;
	}

	@Override
	public String toString() {
		return sign;
	}
}