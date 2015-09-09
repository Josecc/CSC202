import model.*;
import java.util.Random;
import java.util.Scanner;

public class Tester {
    public static void main (String[] arg) {

    	//create a random number for arrival time
		Random rand = new Random();
	    int randomNum = rand.nextInt(5) + 1;
	    User[] clients = new User[randomNum];
	    for (int i = 0; i < randomNum; i++) {
	    	Scanner keyboard = new Scanner(System.in);
			System.out.println("Enter money for client " + (i+1));
			try {
				double money = keyboard.nextDouble();
				clients[i] = new User(money);
				keyboard.nextLine();
			}	catch(Exception e)	{
				System.out.println("Please put in a double.");
			}
	    }

	    VendingMachine machineOne = new VendingMachine(1);
	    VendingMachine machineTwo = new VendingMachine(2);

	    for (int i = 0; i < randomNum; i++) {
	    	//create a random number for arrival time
			Random ran = new Random();
		    int slotNumber = ran.nextInt(10) + 1;
	    	try {
				machineOne.buy(clients[i].getWallet(), slotNumber);
			} catch(Exception e) {
				System.out.println("Not enough money!");
			}
	    }

		try {
			machineOne.save();
			machineTwo.save();
		}	catch(Exception e) {
			System.out.println("Error: " + e);
		}
	}
}