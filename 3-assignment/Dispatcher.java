import java.lang.Math;
import java.util.TimerTask;

public class Dispatcher extends TimerTask{
	private LinkedQueue<Car> intersection;

	public Dispatcher(LinkedQueue<Car> intersection){
		this.intersection = intersection;
	}

	public void run(){
		try {
			int drivingTime = (int)(Math.random() * 3);
			Thread.sleep( drivingTime * 1000);
		} catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
        	intersection.peek();
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    	LLNode<Car> current = null;
    	if(!intersection.isEmpty()){
	    	try{
	    		current = intersection.peek();
			} catch(Exception e){
				System.out.println(e);
			}
	    	while(current != null) {
	    		Car data = current.getInfo();
	    		data.increaseWaitingTime();
	    		current = current.getLink();
	    	}
	    }
		Car myCar = CreateCar();
		System.out.println("New car created! Coming from Lane " + myCar.getFromDirection() + " to " + myCar.getToDirection());
		intersection.enqueue(myCar);
	}

	private Car CreateCar(){
		int toDirection = (int)(Math.random() * 2);
		int fromDirection = (int)(Math.random() * 2);

		return new Car(toDirection, fromDirection);
	}
}