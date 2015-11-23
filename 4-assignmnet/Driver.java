import java.util.Scanner;
import java.io.PrintWriter;

public class Driver {
	private static Scanner keyboard = new Scanner(System.in);
	private static BinarySearchTree<Food> food = new BinarySearchTree<Food>();
	private static boolean read = false;

	public static void main(String[] args){
		// System.out.println(hello.size());
		// hello.add("hi");
		// hello.add("what"); 
		// System.out.println(hello.size());
		Boolean finished = false;
		while(!finished){
			switch(MoralSupport.menu(new String[] {"Read From Storage", "Search", "Save", "Exit"})){
				case 1:
					readFile();
					break;
				case 2:
					search();
					break;
				case 3:
					save();
					break;
				case 4:
					finished = true;
					break;
				default:
					System.out.println("Please enter number 1 - 4");
			}
		}
	}

	private static void readFile() {
		if(!read){
			Scanner file = MoralSupport.getFile("Food");
			while(file.hasNext()){
				Scanner line = new Scanner(file.nextLine()).useDelimiter("-|\n");
				String name = line.next();
				String rawIngredients = line.next();
				Scanner ingredientScanner = new Scanner(rawIngredients).useDelimiter(",|\n");
				String[] ingredients = new String[10];
				int index = 0;
				while(ingredientScanner.hasNext()){
					ingredients[index] = ingredientScanner.next();
					index++;
				}
				Food myFood = new Food(name, ingredients);
				food.add(myFood);
				System.out.println(food.size());
				food.reset(2);
			}
			read = true;
		} else if ( MoralSupport.menu(new String[] {"Lose modified data & re-read","Keep modified data and don't read"}) == 1){
			Scanner file = MoralSupport.getFile("Food");
			food = new BinarySearchTree<Food>();
			while(file.hasNextLine()){
				Scanner line = new Scanner(file.nextLine()).useDelimiter("-|\n");
				String name = line.next();
				String rawIngredients = line.next();
				Scanner ingredientScanner = new Scanner(rawIngredients).useDelimiter(",|\n");
				String[] ingredients = new String[10];
				int index = 0;
				while(ingredientScanner.hasNext()){
					ingredients[index] = ingredientScanner.next();
					index++;
				}
				Food myFood = new Food(name, ingredients);
				food.add(myFood);
				System.out.println(food.size());
				food.reset(2);
			}
		}
	}

	private static void search() {
		String query = MoralSupport.queryString("Enter the name of food you want to search:", false);
		Food result = food.get(new Food(query));
		if(result != null){
			System.out.println("Item found!");
			switch(MoralSupport.menu(new String[] {"Print Ingredients", "Remove"})){
				case 1:
					System.out.println(result);
					break;
				case 2:
					food.remove(result);
					break;
				default:
					System.out.println("Please enter number 1 - 2");
			}
		} else {
			System.out.println("Item not found :( would you like to add it?");
			switch(MoralSupport.menu(new String[] {"Yes", "No"})){
				case 1:
					food.add(new Food(query));
					break;
				case 2:
					break;
				default:
					System.out.println("Please enter number 1 - 2");
			}
		}
	}

	private static void save() throws QueueUnderflowException{
		PrintWriter writer = null;
		try{
			writer = new PrintWriter("Food.txt", "UTF-8");
		} catch(Exception e){
			System.out.println("File not found...");
		}
		Food myFood = null;	
		try{
			food.reset(1);
			myFood = food.getNext(1);
		}catch ( Exception e){
			
		}
		while(myFood != null){
			writer.println(myFood.write());
			try{
				myFood = food.getNext(1);
			} catch (Exception e){
				myFood = null;
				writer.close();
			}

		}
	}
}