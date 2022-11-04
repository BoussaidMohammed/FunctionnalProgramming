package org.mql.java.fp.streams;

public class Product implements Comparable<Product> {
	private String name;
	private double price;
	private int quantity;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Product(String row) {
		String t[] = row.split(",");
		this.name = t[0];
		this.price = Double.parseDouble(t[1]);
		this.quantity = Integer.parseInt(t[2]);
	}
	

	@Override
	public String toString() {
		return name + ", " + String.format("%.0f",price) + ", " + quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int compareTo(Product p) {
		return name.compareTo(p.name);
	}
	
	
}
