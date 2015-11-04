/*
* Author: Jose Canahui
*/
e
package model;

public class FoodItem {
	private String name;
	private double price;
	private int quantity;
	private String descripion;
	private boolean specialOrder;

	public FoodItem(String name, double price, int quantity, String descripion, boolean specialOrder) {
		this.name = name;
		this.price = price; 
		this.quantity = quantity;
		this.descripion = descripion;
		this.specialOrder = specialOrder;
	}

	/*
	* Setters And Getters
	*/
	public String getName() {
		return this.name;
	}
	public double getPrice() {
		return this.price;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public String getDescription() {
		return this.descripion;
	}
	public boolean getSpecialOrder() {
		return this.specialOrder;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setDescription(String description) {
		this.descripion = descripion;
	}
	public void setSpecialOrder(boolean specialOrder) {
		this.specialOrder = specialOrder;
	}

	/*
	* ToString default method
	*/
	public String toString() {
		return "Name: " + this.name + " | Price: " + this.price + " | Quantity: " + this.quantity + " | Description: " + this.descripion + " | Special Order: " + this.specialOrder;
	}

}