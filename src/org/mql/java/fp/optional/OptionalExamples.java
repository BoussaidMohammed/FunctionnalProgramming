package org.mql.java.fp.optional;

import java.util.Optional;

public class OptionalExamples {
	public static void main(String[] args) {
		new OptionalExamples();
	}
	
	public OptionalExamples() {
		exp02();
	}

	private void exp01() {
		String s1 = "293";
		getInt(s1).ifPresentOrElse(System.out::println, () -> System.out.println("Entier non valide"));
		String s2 = "293s";
		getInt(s2).ifPresentOrElse(System.out::println, () -> System.out.println("Entier non valide"));
		System.out.println(getInt("34332").get());
		
	}
	
	public Optional<Integer> getInt(String s) {
		try {
			int value = Integer.parseInt(s);
			Optional op = Optional.of(value);
			return op;
		} catch (Exception e) {
			return Optional.empty();
		}
	}
	
	void exp02() {
		String s1 = null;
		Optional<String> op1 = Optional.ofNullable(s1);
		System.out.println(op1);
		Optional<String> op2 = Optional.of(s1);
		System.out.println(op2);
	}
	
}
