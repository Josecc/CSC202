import model.*;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		boolean acceptable = false;
		Scanner keyboard = new Scanner(System.in);
		while(!acceptable){
			System.out.println("Hello! Would you like to run (1) the simpulator or (2) the GUI?");
			try{
				int answer = keyboard.nextInt();
				if((!answer > 0) || (!answer < 3))
					throw new InputMismatchException;
				acceptable = true;
			} catch(InputMismatchException e) {
				System.out.println("Please enter either a '1' or a '2'.");
			}
		}

		if(answer == 1){
			//run simulator CLI
		} else {
			//run GUI
		}

		//save stuff?

	}
}