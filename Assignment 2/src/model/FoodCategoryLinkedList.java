/*
* Author: Jose Canahui
*/

package model;

public class FoodCategoryLinkedList {
	private FoodCategoryNode head;

	public FoodCategoryLinkedList(FoodCategoryNode head) {
		this.head = head;
	}

	public FoodCategoryLinkedList() {
		this.head = null;
	}

	public void add(FoodCategoryNode toAdd){
		if(this.head != null)
			setNext(toAdd, this.head);
		else
			this.head = toAdd;
	}

	public void add(String category, FoodItemLinkedList items){
		this(new FoodCategoryNode(category, items));
	}

	public void add(String category){
		FoodCategoryNode toAdd = new FoodCategoryNode(category);
		this(toAdd);
	}

	public boolean delete(String category){
		//search and delete node
	}

	/*
	* Utility
	*/
	public void setNext(FoodCategoryNode toAdd, FoodCategoryNode current){
		curent = current.getNext();
		if(current.getNext() = null)
			current.setNext(item);
		else
			setNext(item, current);
	}
}