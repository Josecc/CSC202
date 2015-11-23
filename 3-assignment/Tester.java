import java.util.Timer;
import java.lang.Math;

public class Tester {
	private static LinkedQueue<Car> intercection = new LinkedQueue<Car>();
	private static Timer timer;
    private static Timer intercectionTimer;
	public static void main(String[] args){
		timer = new Timer();  //At this line a new Thread will be created
        intercectionTimer = new Timer();
		int cars = (int)(Math.random() * 10) + 1;
		timer.scheduleAtFixedRate(new Dispatcher(intercection),  0,1 * 1000);
        IntecectioController controller = new IntecectioController(intercection);
        try{
            Thread.sleep(cars * 1000);
            timer.cancel();
        } catch (Exception e){
            System.out.println(e);
        }
        while(!intercection.isEmpty()){
            controller.run();
            try{
                Thread.sleep(1000);
            } catch(Exception e){
                System.out.println(e);
            }
        }
        controller.cancel();
	}
}