public class LinkedQueue<T> implements QueueInterface<T>{
	protected LLNode<T> front;
	protected LLNode<T> rear;

	public LinkedQueue(){
		front = null; //reference to the front of this queue
		rear = null; //reference to the rear of this queue
	}

	public void enqueue(T element){
		LLNode<T> newNode = new LLNode<T>(element);
		if(rear == null){
			front = newNode;
			rear = newNode;
		}
		else{
			rear.setLink(newNode);
			rear = rear.getLink();
		}
	}

	public T dequeue() throws Exception{
		if(isEmpty())
			throw new Exception("Dequeue attempted on an empty queue");
		else {
			T element = front.getInfo();
			front = front.getLink();
			if(front == null)
				rear = null;
			return element;
		}
	}

	public LLNode<T> peek() throws Exception{
		if(isEmpty())
			throw new Exception("Peek attempted on an empty queue");
		else {
			return front;
		}
	}

	public boolean isEmpty(){
		return front == null;
	}
}