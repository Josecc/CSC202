/*
* Author: Jose Canahui
*/

package model;

public class FoodCategoryNode {
	private String category;
	private FoodItemLinkedList foodItems;
	private FoodCategoryNode next;

	public FoodCategoryNode(String category, FoodItemLinkedList foodItems, FoodCategoryNode next){
		this.category = category;
		this.foodItems = foodItems;
		this.next = next;
	}

	public FoodCategoryNode(String category, FoodItemLinkedList foodItems){
		this.category = category;
		this.foodItems = foodItems;
		this.next = null;
	}

	public FoodCategoryNode(String category){
		this.category = category;
		this.foodItems = new FoodItemLinkedList();
		this.next = next;
	}

	public String toString(){
		return category
	}

	public FoodCategoryNode getNext() {
		return this.next;
	}

	public FoodCategoryNode getFoodItems() {
		return foodItems;
	}
}