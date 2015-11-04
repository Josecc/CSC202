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
		FoodCategoryNode current = head;

		while(current.getNext()!= null) {
			current = current.getNext();
		}

		current.setNext(toAdd);
	}

	public void add(String category, FoodItemLinkedList items){
		FoodCategoryNode toAdd = new FoodCategoryNode(category, items);
		FoodCategoryNode current = head;

		while(current.getNext()!= null) {
			current = current.getNext();
		}

		current.setNext(toAdd);
	}

	public void add(String category){
		FoodCategoryNode toAdd = new FoodCategoryNode(category);
		FoodCategoryNode current = head;

		while(current.getNext()!= null) {
			current = current.getNext();
		}

		current.setNext(toAdd);
	}

	public FoodCategoryNode get(int index) {
		if (index <= 0)
            return null;
        FoodCategoryNode current = head.getNext();
        for (int i = 1; i < index; i++) {
        	if(curent.getNext() == null)
        		return null;
        	current = current.getNext();
        }
        return current;
	}

	public boolean delete(int index){
		if (index < 1 || index > size())
			return false

		FoodCategoryNode current = head;
		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return false;
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		return true;
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