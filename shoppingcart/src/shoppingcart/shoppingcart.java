package shoppingcart;

public class shoppingcart {

	public static void main(String[] args){
		//Create an integer variable
		int int1;
		
		//Declare and initialize variables of type long, float
		// and char
		long long1 = 99_000_000_000L;
		float flt1 = 13.5F;
		char ch1 = 'U';
		
		//Print the long variable
		System.out.println("long1: " + long1);
		
		//Assign the long to the int and print the int variable
		int1 = (int)long1;
		System.out.println("Long assigned to int variable: " + int1);
		
		
		
		/*Second Example 
		//Manupulating strings and using StringBuilder
		String custName = "Sally Smith";
		String firstName;
		int spaceIndex;
		StringBuilder sb; //initializing a stringbuilder variable
		
		// Get the index of the space character ""
		spaceIndex = custName.indexOf(" ");
		
		//Use the substring method to locate the first name
		firstName = custName.substring(0, spaceIndex);
		System.out.println(firstName);
		
		//Instantiate and initialize sb to firstName
		sb = new StringBuilder(firstName);
		System.out.println(sb);
		
		/*Put the full name back together using StringBuilder append
		 * method. We're just entering the String literal for the 
		 * last name and then printing the full name
		 
		sb.append(" Smith");
		System.out.println(sb);
		*/
		
		/**First Example [instantiating, initializing, 
		 * applying methods to objects and printing the result
		//Instantiate 2 Item objects
		Item item1, item2;
		item1 = new Item();
		item2 = new Item();
		
		//Assign values to fields
		item1.desc = "Shirt";
		item1.itemID = 123456;
		item2.desc = "Pants";
		item2.itemID = 654321;
		
		//Display items
		System.out.println("Item1 = " + item1.desc + " " + item1.itemID);
		System.out.println("Item2 = " + item2.desc + " " + item2.itemID);
		
		//Assign one item to another and run it again
		item1 = item2;
		System.out.println("Item1 = " + item1.desc + " " + item1.itemID);
		System.out.println("Item2 = " + item2.desc + " " + item2.itemID);
		 */
	}
}
