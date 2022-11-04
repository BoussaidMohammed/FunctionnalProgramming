package org.mql.java.fp.method_referecence;

import java.awt.Dimension;
import java.awt.Point;
import java.lang.reflect.Method;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/*
 * 1.Static Method reference: reference de methodes statiques
 * 2.Particular: Instance Method reference: reference de methode d'instance sur un objet particulier
 * 3.Arbitrary Instance Method reference: reference de methode d'instance sur un objet arbitraire
 * 4.Consturcteur reference: reference d'un constructeur
*/
public class MethodReference {
	private Logger logger;
	
	public MethodReference() {
		exp03();
	}
	
	public void test() {
		Method m[] = MethodReference.class.getDeclaredMethods();
		for (int i = 0; i < m.length; i++) {
			System.out.println(" - "+ m[i].getName());
		}
		
	}
	
	public double getDouble(Supplier<Double> s) {
		return s.get();
	}
	
	void exp01() {
		Supplier<Double> s1 = Math::random;
		double x = s1.get();System.out.println("x = " + x);
		
		double y = getDouble(Math::random); //meilleur methode
		System.out.println("y = "+y);
		
	}
	
	void exp02_1() {
		DataManager manager = new DataManager(msg -> System.out.println("### " + msg));
		manager.print("Lambda Expression");
	}

	void exp02_2() {
		DataManager manager =  new DataManager(System.out::println);
		manager.print("Instance Method reference");
	}
	//method generic
	static <T> T create(int x, int y, BiFunction<Integer, Integer, T> f) {
		return f.apply(x, y);
	}
	
	//Constructor reference
	void exp04_1() {
		Point p1 = create(20,34, Point::new);
		Dimension d1 = create(20,30, Dimension::new);
		System.out.println(p1);
		System.out.println(d1);
	}
	
	void exp03() {
		String arbirary  = "Functional Interfaces";
		Service s1 = String::charAt;
		int c1 = s1.apply(arbirary, 0);
		//arbitrary c'est l'objet sur lequel charAt sera invoquer
		System.out.println("c1 = "+ (char)c1);
		
		Service s2 = String::indexOf;
		int c2 = s2.apply(arbirary, 'I');
		System.out.println("c2 = "+c2);
		
		//Particular instance methode: 
		String particular = "Une chaine";
		Service s3 = particular::indexOf;//index est appeler ici sur l'objet
		int index = s3.apply("n", 3);//donc la chaine 1 n'est plus considerer comme objet, mais comme un nouveau a communiquer
		System.out.println("index : "+index);
		
	}
	
	void exp04_2() {
		Factory<Point> f1 = Point::new;//Point::new a la meme signature avec create de factory.
		Factory<Dimension> f2 = Dimension::new;
		System.out.println(f1.create(20, 30));
		System.out.println(f2.create(3, 1));
	}
	
	
	
	public static void main(String[] args) {
		new MethodReference();
	}
}
