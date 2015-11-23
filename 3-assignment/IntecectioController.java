import java.lang.Math;
import java.util.TimerTask;

public class IntecectioController extends TimerTask {
	private LinkedQueue<Car> intersection;

	public IntecectioController(LinkedQueue intersection){
		this.intersection = intersection;
	}

	public void run(){
		Car crossedCar = null;
		try {
			crossedCar = this.intersection.dequeue();
			System.out.println(crossedCar);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}