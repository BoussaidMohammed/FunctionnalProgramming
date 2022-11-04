package org.mql.java.fp.functional_interface;

import java.util.Hashtable;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Operation {
	private static Hashtable<String, BinaryOperator<Double>> operations;
	
	static {
		operations = new Hashtable<String, BinaryOperator<Double>>();
		operations.put("+", new A());
		operations.put("-", (a,b) -> a - b);
		operations.put("*", (a,b) -> a * b);
		operations.put("/", (a,b) -> a / b);
		
	}
	
	static class A implements BinaryOperator<Double>{
		@Override
		public Double apply(Double t, Double u) {
			return t+u;
		}
		
	}
	
	public Operation() {
		// TODO Auto-generated constructor stub
	}
	
	public static double value(double x, double y, String op) {
		return operations.get(op).apply(x, y);
	}
	
	public void exp04() {
		double x = Operation.value(3,3,"*");
	}
}
