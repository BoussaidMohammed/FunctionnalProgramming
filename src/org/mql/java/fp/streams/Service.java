package org.mql.java.fp.streams;

public interface Service {
	public void insert();
	public void select();
	public static void print() {
		System.out.println("Methode static dans une interface");
	}
	
	public default int parseInt(String field) {
		try {
			return Integer.parseInt(field);
		}catch (Exception e) {
			return 0;
		}
	}
}
