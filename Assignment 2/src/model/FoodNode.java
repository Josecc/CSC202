/*
* Author: Jose Canahui
*/

package model;

public class FoodNode {
	private FoodItem data;
	private FoodNode next;

	public FoodNode(FoodItem data, FoodNode next) {
		this.data = data;
		this.next = next;
	}

	public FoodNode(FoodItem data) {
		this.data = data;
		this.next = null;
	}

	public String toString(){
		return data.toString();
	}

	public FoodNode getNext(){
		return next;
	}
}