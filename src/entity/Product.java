package entity;

public class Product {
	private int id;
	private String name;
	private String description;
	private double price;
	private int stock;
	private boolean shippingIncluded;
	
	/*
	 * Getters
	 */
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public double getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	public boolean isShippingIncluded() {
		return shippingIncluded;
	}
	
	/*
	 * Setters
	 */
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setShippingIncluded(boolean shippingIncluded) {
		this.shippingIncluded = shippingIncluded;
	}
	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", description=" + description;
	}
}
