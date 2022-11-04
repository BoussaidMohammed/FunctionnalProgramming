package org.mql.java.fp.functional_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

import javax.swing.JButton;

import org.mql.java.fp.method_referecence.Logger;



public class FunctionalInterface {
	public FunctionalInterface() {
		exp01();
	}
	
	void exp01() {
		String t[] = {"D","A","a","D","E","B","b","C","a","*","+","D",";"};
		Arrays.stream(t)
			.filter(s -> s.charAt(0) >= 'A')
			.filter(s -> s.charAt(0) <= 'z')
			.map(String::toUpperCase)
			.distinct()
			.sorted((String::compareTo))
			.forEach(System.out::println);
	}
	
	void exp02() {
		String t[] = {"D","A","a","D","E","B","b","C","a","*","+","D",";"};
		List<String> list = Arrays.stream(t)
			.filter(s -> s.charAt(0) >= 'A')
			.filter(s -> s.charAt(0) <= 'z')
			.map(String::toUpperCase)
			.distinct()
			.sorted((String::compareTo))
			.collect(Collectors.toList());
		System.out.println(list);
	}
	
	void exp03() {
		String t[] = {"D","A","a","D","E","B","b","C","a","*","+","D",";"};
		Arrays.stream(t)
			.filter(s -> s.charAt(0) >= 'A')
			.filter(s -> s.charAt(0) <= 'z')
			.map(String::toUpperCase)
			.distinct()
			.sorted((String::compareTo))
			.findFirst()
			.ifPresent(System.out::println);
	}
	
	void exp04() {
		JButton b = new JButton();
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		b.addActionListener(e -> System.exit(0));
		Logger logger = new Logger() {
			
			@Override
			public void log(String msg) {
				System.out.println("###"+msg);
			}
		};
		logger.log("un message");
		logger = msg -> System.out.println("*** " + msg + " ***" );
		Consumer<String> consumer =  msg -> System.out.println("*** " + msg + " ***" );
		consumer.accept("un message");
	}
	
	class A implements Consumer{

		@Override
		public void accept(Object t) {
			// TODO Auto-generated method stub
			
		}

		
		
	}
	
	void exp05() {
		//Function<? ,? > f1;
		BiFunction<?, ?, ?> f2;
		Predicate<?> p1; // retourne boolean;
		BiPredicate<?, ?> p2;//boolean
		Consumer<?> c1;
		BiConsumer<?, ?> c2;
		Supplier<?> s1;
		BinaryOperator<?> op1;
		UnaryOperator<?>  op2;
		BiFunction<Integer, Integer, Integer> f1 = (e1, e2) -> e1 + e2;
		int som = f1.apply(5, 4);System.out.println(som);
	}
	

	
	void print(Logger logger) {
		
	}
	
	public static void main(String[] args) {
		new FunctionalInterface();
	}
}
