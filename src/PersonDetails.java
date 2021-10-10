//PersonDetails class is created to create type of person details object with certain attributes

//The PoisedMenu class is used to call this class

//A class is a blueprint from which objects are made (It consists of both data and the code that manipulates the data)

//A public modifier was assigned to the class for easy direct access

//Specific attributes (the data that the class stores) about the object were collected

//Attributes are features that an object can take on


/**
 * PersonDetails is a subclass that creates and displays a person details object.
 * <p>
 * PersonDetails class contains variables and a constructor to create person details objects for the PoisedMenu.
 * PersonDetails class also contains a method to display the created person details object.
 * The PoisedMenu class, which runs the main program, calls on methods from this class to add new projects.
 * @author Omphemetse Marwane
 */
public class PersonDetails {  //A class PersonDetails is declared
	
	// Attribute variables for "PersonDetails" class are declared.
	// The private modifier is used to ensure weak coupling between classes, not for easy access
	private String typeofperson;
	private String name;
	private int number;
	private String email;
	private String address;
	
	/**
	 * The constructor method PersonDetails creates a new person details object.
	 * <p>
	 * The person details object will contain information and contact details of someone responsible with the project 
	 * @param typeofperson typeofperson explains the title of the person object created (e.g. customer, contractor, architect etc.)
	 * @param name name full names value for the person
	 * @param number contact numbers for the person
	 * @param email email address for the person 
	 * @param address physical address for the person
	 */
	public PersonDetails(String typeofperson, String name, int number, String email, String address) {
		this.typeofperson = typeofperson;
		this.name = name;
		this.number = number;
		this.email = email;
		this.address = address;  //The person details object is constructed with the provided variable attributes.
		
	}
	
	/**
	 * The method showPersonDetails() shows all the attributes of the person details object in a friendly-manner
	 * @return returns a string output with all person details object information
	 */
	public String showPersonDetails() {
		System.out.println(typeofperson + " details are as follows: \n");
		String output = "Title: " + typeofperson;
		output += "\nName: " + name;
		output += "\nNumber: " + number;
		output += "\nEmail Address: " + email;
		output += "\nPhysical Address: " + address;
		
		return output;  // A String output is returned.
		
	}
}