import java.util.Arrays;

public class Food implements Comparable<Food>{
	String name;
	String[] ingredients = new String[5];

	public Food(String name, String[] ingredients){
		this.name = name;
		this.ingredients = ingredients;
	}

	public Food(String name){
		this.name = name;
		this.ingredients[0] = "unknown";
	}

	public String getName(){
		return this.name;
	}

	public String[] getIngredients(){
		return this.ingredients;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setIngredient(String[] ingredients){
		this.ingredients = ingredients;
	}

	public int compareTo(Food other){
		return this.name.compareTo(other.getName());
	}

	public String toString(){
		return name + " is made with " + Arrays.toString(ingredients);
	}

	public String write(){
		return name+"-"+ingredients[0]+","+ingredients[1]+","+ingredients[2]+","+ingredients[3]+","+ingredients[4];
	}
}