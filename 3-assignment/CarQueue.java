import java.util.NoSuchElementException;

public class CarQueue() {
	private CarNode first;
	private CarNode last;
	private int size;

	public CarQueue() {
		first = null;
		last = null;
		size = 0;
	}

	public boolean isEmpty(){
		return first == null;
	}

	public int size() {
		return size;
	}

	public Car peek() {
		if (isEmpty())
			throw new NoSuchElementException("Queue Underflow");
		return first.data;
	}

	public void enqueue(CarNode toAdd) {
		CarNode prevLast = last;
		last = toAdd;
		if(isEmpty())
			first = toAdd;
		Size++;
	}

	public CarNode dequeue() {
		if(isEmpty())
			return NoSuchElementException("Underflow Exception");
		CarNode dequeue = first;
		first = first.next();
		size--;
		if(isEmpty())
			last = null;
		return dequeue;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
        for (CarNode item : this)
            s.append(item + " ");
        return s.toString();
	}
}