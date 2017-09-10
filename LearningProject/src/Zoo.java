
public class Zoo {
//will have the main method.  Entry point into the application
	//need three instances of animals
	public static void main(String args[]){
		Animal animal1 = new Animal("Loli", 5, "blue", "female", "small", "seeds", "Parrot");
		Animal animal2 = new Animal("King", 10, "yellow", "male", "big", "meat", "Lion");
		Fish animal3 = new Fish("Nemo", 3, "orange", "male", "small", "seaweed", "Fish");
		
		animal1.eat();
		animal1.sleep();
		animal2.eat();
		animal2.sleep();
		animal3.eat();
		animal3.swim();
	}
}
