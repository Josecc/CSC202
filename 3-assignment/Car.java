public class Car {
	private int toDirection;
	private int fromDirection;
	private int waitingTime;

	public Car(int toDirection, int fromDirection){
		this.toDirection = toDirection;
		this.fromDirection = fromDirection;
		waitingTime = 0;
	}

	public int getToDirection(){
		return this.toDirection;
	}

	public int getFromDirection(){
		return this.fromDirection;
	}

	public int getWaitingTime(){
		return this.waitingTime;
	}

	public void increaseWaitingTime(){
		this.waitingTime++;
	}

	public String toString(){
		return "This car is going from lane " + fromDirection + " to lane " + toDirection + ".\n It waited for " + waitingTime + "s.\n-----------";
	}
}