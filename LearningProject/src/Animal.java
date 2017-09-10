
public class Animal {
	//animals will have characteristics like age, color, genders, weight, size 
	String name;
	int age;
	String color;
	String gender;
	String size; //e.g. large, small or medium
	String food; //e.g. carrots, corn, grass, etc
	String type; //e.g. lion, cow, bird, etc
	
	//using a constructor to make this class type more dynamic
	public Animal(String name, int age, String color, String gender, String size, String food, String type) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
		this.gender = gender;
		this.size = size;
		this.food = food;
		this.type = type;
	}
	
	//animals will have behaviors eat and sleep
	public void eat(){
		System.out.println("My name is " + name + " and I am a " + type);
		System.out.println("I am going to eat my delicious " + food + " Yum! Yum! Yum!");
	}
	public void sleep(){
		System.out.println("After eating so much I feel so tired zzzzzzzz....");
	}

	//create two classes bird and fish to give them characteristics and behaviors like fly and swim

}
