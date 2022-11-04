package org.mql.java.fp;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.swing.JOptionPane;

public class Examples {

	public Examples() {
		exp08();
	}

	private void exp01() {
		/*
		 * Instanciation on utilisant la classe interne créé qui prend un entier comme
		 * paramétre et retourne un entier
		 */
		Function<Integer, Integer> f = new FuncImp();
		int n = 3;
		int somme = f.apply(n);
		System.out.println("somme de " + n + " = " + somme);
	}

	class FuncImp implements Function<Integer, Integer> {
		@Override
		public Integer apply(Integer n) {
			if (n == 0)
				return 0;
			else
				return apply(n - 1) + n;
		}
	}

	void exp02() {
		Function<Integer, Integer> f = (n) -> {
			int som = 0;
			for (int i = 0; i <= n; i++)
				som += i;
			return som;
		};
		int n = 5;
		System.out.println("somme de " + n + " = " + f.apply(n));
	}

	void exp03() {
		//En utilisant methode static
		/*
		 * Function<Integer, Integer> f = Examples::somme; int n = 5;
		 * System.out.println("somme de " + n + " = " + f.apply(n));
		 */		//En utilisant une methode normale, ce qui implique de passe par une instance
		Function<Integer, Integer> f2 = new Examples()::somme2;
		int n2 = 5;
		System.out.println("somme de " + n2 + " = " + f2.apply(n2));	
	}

	public static int somme(int n) {
		return (n == 0) ? 0 : somme(n - 1) + n;
	}
	
	public  int somme2(int n) {
		return (n == 0) ? 0 : somme2(n - 1) + n;
	}
	
	void exp04() {
		BiFunction<String, String, String> bF = null;
		String s1 = "chaine 1";
		String s2 = "chaine 2";
		String res = "";
		//En utilisant expressions lambda
		bF = (a, b) -> a+ " " +b;
		res = bF.apply(s1,s2);
		System.out.println("resultat de concatenation en utilisant lambda: "+res);
		//En utilisant methode reference, comme premiere parametre objet appelant
		bF = String::concat;
		res = bF.apply(s1, " "+ s2);
		System.out.println("resultat de concatenation en utilisant methode referecence: "+res);
	}
	void exp06() {
		Predicate<String> isValid = null;
		//En utilisant expression lambda
		isValid = (s) -> s.length() <= 32;
		System.out.println(isValid.test("45"));
	}

	void exp07() {
		BinaryOperator<Integer> plus = null;
		//En utilisant expression lambda
		plus = (a, b) -> a + b;
		System.out.println(plus.apply(4, 9));
	}
	
void exp08() {
	Supplier<Integer> s = null;
	//En utilisant une expression lambda
	s = () -> (int)(Math.random()*100);
	int res = s.get();
	System.out.println("Nombre aleatoire entre 0 et 100: "+res);
}
	
	interface Logger {
		void log(String msg);
	}
	
	class LoggerImp implements Logger{
		@Override
		public void log(String msg) {
			System.out.println(msg);
		}
	}
	
	void exp1() {
		Logger logger = null;
		//En utilison la class LoggerImp
		logger = new LoggerImp();
		logger.log("En utilsation Implementation LoggerImp");
		//En utilisaon class anonyme
		logger = new Logger() {
			@Override
			public void log(String msg) {
				JOptionPane.showMessageDialog(null, msg);
			}
		};
		logger.log("En utilsation Implementation anonyme");
		//En utilisant expression lamba
		logger = (msg) -> System.out.println(msg);
		logger.log("En utilsation Expression lambda");
		//En utilisant méthode de reférence 
		logger = System.out::println;
		logger.log("En utilisant méthode de reférence");
	}

	public static void main(String[] args) {
		new Examples();
	}

}
