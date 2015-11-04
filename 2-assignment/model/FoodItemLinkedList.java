/*
* Author: Jose Canahui
*/

package model;

public class FoodItemLinkedList {
	private FoodNode head;
	private FoodItem data;

	public FoodItemLinkedList(FoodNode item){
		this.head = head;
	}

	public FoodItemLinkedList() {
		this.head = null;
	}

	public void add(FoodItem food) {
		FoodNode toAdd = new FoodNode(food);
		FoodNode current = head;

		while(current.getNext()!= null) {
			current = current.getNext();
		}

		current.setNext(toAdd);
	}

	public void delete(int index) {
		if (index < 1 || index > size())
			return false

		FoodNode current = head;
		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return false;
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		return true;
	}

	public FoodItem search(String name) {
		if (name = null)
            return null;
        FoodNode current = head.getNext();
        while (! (current.getItem().getName)) {
        	if(curent.getNext() == null)
        		return null;
        	current = current.getNext();
        }
        return current;
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