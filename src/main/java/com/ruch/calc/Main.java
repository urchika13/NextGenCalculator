package com.ruch.calc;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	//Format the digits to 10 decimal places
	private static DecimalFormat outputFrmt = new DecimalFormat("0.##########");

	public static void main(String[] args) {

		System.out.println("Let's Calculate!! \n");

		if(args.length<2){
			System.err.println("Please provide some valid inputs!\n We require atleast one operand and one operator.");
			System.exit(1);
		}
		else {
			Calculator calculator = new Calculator();
			Double result = null;
			try {
				System.out.print("Input: ");
				for(String token:args)
					System.out.print(token+" ");
				result = calculator.compute(args);
				printResult(result);

			} catch (CalculatorException e) {
				System.out.println("\nError Description:"+e.getMessage());
			} catch (Exception e) {
				System.out.println("\nAn Error has occured!!:"+e.getMessage());
			}

		}
	}

	/**
	 * This method is used to print the result of the calculation on the console
	 * @param result
	 */
	private static void printResult(Double result){
		System.out.print("\nOutput: "+outputFrmt.format(result));
	}
}