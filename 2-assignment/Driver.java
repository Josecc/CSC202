import model.*;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Driver extends Application{
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Assignmnent 2");

		Group root = new Group();
		Scene scene = new Scene(root, 600, 500, Color.GRAY);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main (String[] args) {
		boolean acceptable = false;
		Scanner keyboard = new Scanner(System.in);
		int answer = 0;
		while(!acceptable){
			System.out.println("Hello! Would you like to run (1) the simpulator or (2) the GUI?");
			try{
				answer = keyboard.nextInt();
				if((answer < 1) || (answer > 2))
					throw new Exception();
				acceptable = true;
			} catch(Exception e) {
				System.out.println("Please enter either a '1' or a '2'.");
				keyboard.next();
			}
		}

		if(answer == 1){
			
		} else {
			launch(args);
		}

		//save stuff?

	}
}