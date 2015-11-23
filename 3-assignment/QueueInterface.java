public interface QueueInterface<T> {
	T dequeue() throws Exception;
		//Throws QueueUnderflowException if queue is empty
		//Otherwise removes front element from queue and returns it
	boolean isEmpty();
		//returns true if this queue is empty otherwise returns false
	void enqueue(T element);
		//adds element to the rear of this queue
}