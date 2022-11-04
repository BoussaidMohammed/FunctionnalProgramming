package org.mql.java.fp.streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {
	public StreamExamples() {
		exp07();
	}
	
	void exp01() {
		List<Integer> list1 = List.of(20, 11, 9,30, 10, 12, 40, 50, 8, 15);
		List<Integer> list2 = Arrays.asList(20, 11, 9,30, 10, 12, 40, 50, 8, 15);
		System.out.println("list1 = "+list1);
		System.out.println("list2 = "+list2);
		
		Stream<Integer> s1 = list1.stream().filter(e -> {
			System.out.println("Filter("+ e+ ")");
			return e >= 20;}).map(e -> {
				System.out.println("map("+e+")");
				return e + 100;
			}).limit(3);
		//execution des stream retarder et optimiser
		//si on a pas une fonction terminal les fonction intermediares seront pas invoquer
		//si on atteint limit 3, le stream s'arrete (optimiser)
		List <Integer> list3 = s1.collect(Collectors.toList());
		System.out.println("list3 = "+list3);
	}
	
	void exp02() {
		List<Integer> list = IntStream.range(0, 26).
				boxed().collect(Collectors.toList());
		System.out.println("list = "+list);
		
		List<Character> list2 = IntStream
				.range(0, 26).boxed().map(e -> (char)(e + 'A')).collect(Collectors.toList());
		System.out.println("list2 = "+list2);
		
		int s = IntStream.range(1, 10)
			.boxed().reduce(0,(e1,e2) -> e1 + e2);
		System.out.println("somme = " + s);
	}
	
	void exp03() {
		List<Integer> list1 = List.of(56, 30, 40, 76,12, 45);
		Integer t[] = list1.stream().sorted().toArray(Integer[]::new);//constructeur reference
		System.out.println(Arrays.toString(t));
	}
	
	void exp04() {
		FileReader reader = null;
		try {
			reader = new FileReader("org/mql/java/fp/functional_interface/FunctionalInterface.java");
		} catch (Exception e) {
			System.out.println("Erreur: "+e.getMessage());
		}
		BufferedReader in = new BufferedReader(reader);
		in.lines().filter(line -> line.contains("->")).map(String::trim).map(String::trim)
		.forEach(System.out::println);
	}
	
	void exp05() {
		Stream<String> rows = null;
		try {
			rows = Files.lines(Path.of("resources/products.txt"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		  List<Product> products = rows.map(row -> new Product(row)).filter(p ->
		p.getQuantity() > 0).sorted(/*
									 * (a , b) -> { return a.getName().compareTo(b.getName()); }
									 */) .collect(Collectors.toList());
		  System.out.println("products" + products); products.forEach(p ->
		  System.out.println(p.getName()));
		 
	}
	
	void exp05_02() {
		Stream<String> rows = null;
		try {
			rows = Files.lines(Path.of("resources/products.txt"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Produits tries par order decroissant des prix: ");
		rows.map(row -> new Product(row)).sorted(Comparator.comparing(Product::getPrice).reversed())
		.forEach(System.out::println);
		
	}

	
	void exp06() {
		Random rnd = new Random();
		PrintWriter out  = null;
		try {
			out = new PrintWriter("resources/products2.txt");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Stream.generate(
				() -> new Product("p" + (rnd.nextInt(900) + 100),rnd.nextDouble() * 10000, rnd.nextInt(100))
				).limit(100).forEach(out::println);
		out.close();
		System.out.println("done");
	}
	
	void exp07() {
		List<Integer> list = List.of(99,34,12,34);
		List<String> listString = list.stream().map(String::valueOf).collect(Collectors.toList());
		System.out.println(listString);
	}
	public static void main(String[] args) {
		new StreamExamples();
	}
}
