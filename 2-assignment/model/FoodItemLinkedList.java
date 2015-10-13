/*
* Author: Jose Canahui
*/

package model;

public class FoodItemLinkedList {
	private FoodNode head;

	public FoodItemLinkedList(FoodNode head){
		this.head = head;
	}

	public FoodItemLinkedList() {
		this.head = null;
	}

	public void add(FoodItem food) {
		FoodNode item = new FoodNode(food);
		if(this.head = null)
			this.head = item;
		else
			setNext(item, head);
	}

	public void delete(int index) {
		//traverse through & finde the index
	}

	public FoodItem search(String name) {
		//Return FoodItem
	}

	public String toString() {
		//traverse through linked list and print all.
	}

	public boolean isEmpty() {
		return this.head = null;
	}

	/*
	* Utility
	*/
	public void setNext(FoodNode item, FoodNode current){
		curent = current.getNext();
		if(current.getNext() = null)
			current.setNext(item);
		else
			setNext(item, current);
	}
}