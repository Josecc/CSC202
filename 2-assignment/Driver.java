import model.*;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.HPos;

public class Driver extends Application{
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Assignmnent 2");
		VBox root = new VBox();
		HBox toolBar = new HBox(12);
		Scene scene = new Scene(root, 600, 500, Color.GRAY);

		//File menu Bar
		final Menu fileMenu = new Menu("File");
		MenuBar menuBar = new MenuBar();

		//Search Box
		HBox search = new HBox();
		TextField searchField = new TextField();
		searchField.setPromptText("Search");
		Button searchButton = new Button(">");
		search.getChildren().addAll(searchField, searchButton);
		HBox.setMargin(search, new Insets(0,0,0,248));

		//editButton
		Button editButton = new Button("Edit");

		//removeButton
		Button removeButton = new Button("Remove");
		
		//Toolbar
		toolBar.setPadding(new Insets(12));
		toolBar.getChildren().addAll(editButton, removeButton, search);

		//Table
		GridPane table = new GridPane();
		table.setPadding(new Insets(5));
		table.setHgap(10);
		table.setVgap(10);
		ColumnConstraints categoryColumn = new ColumnConstraints(150, 150, Double.MAX_VALUE);
		ColumnConstraints foodItemColumn = new ColumnConstraints(300, 300, Double.MAX_VALUE);
		table.getColumnConstraints().addAll(categoryColumn, foodItemColumn);

		//Category
		Label categoryLabel = new Label("Category");
		table.setHalignment(categoryLabel, HPos.CENTER);
		table.add(categoryLabel, 0, 0);


		//FoodItem
		Label foodItemLabel = new Label("Food Item");
		table.setHalignment(foodItemLabel, HPos.CENTER);
		table.add(foodItemLabel, 1, 0);

		fileMenu.getItems().add(new MenuItem("Save"));
		fileMenu.getItems().add(new MenuItem("Load"));
		menuBar.getMenus().add(fileMenu);
		root.getChildren().addAll(menuBar, toolBar, table);

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