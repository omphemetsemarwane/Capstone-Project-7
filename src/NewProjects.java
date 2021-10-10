//NewProjects class is created to create type of new project object with certain attributes

//The PoisedMenu class is used to call this class

//A class is a blueprint from which objects are made (It consists of both data and the code that manipulates the data)

//A public modifier was assigned to the class for easy direct access

//Specific attributes (the data that the class stores) about the object were collected

//Attributes are features that an object can take on

//Different java classes from the java.io package to use in the program were imported

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The NewProjects is a subclass that inherits methods from the PoisedChecks(superclass).
 * <p>
 * NewProjects class contains variables and a method used to add a new project object to Poised Firm Menu.
 * PoisedMenu class, which runs the main program, calls on methods from this class(NewProjects) to add new projects.
 * @author Omphemetse Marwane
 */
public class NewProjects extends PoisedCheck {  //A NewProjects class which extends PoisedCheck is declaired
	
		//Attributes for the "NewProjects" class.
		private int projectnumber;
		private String projectname;
		private String typeofbuilding;
		private String physicaladdress;
		private String ERFNumber;
		private double projectcost;
		private double amountpaid;
		private String deadline;
		private String Completion;
		private String Status;
		
		/**
		 * addproject() method is used to add a new project object to the PoisedMenu Class.
		 * <p>
		 * The user is asked to enter information about the project's details which is then checked using methods from PoisedCheck class
		 * The information about the project is stored in variables related to the project object.
		 * The new project object created is shown to the user in the friendly-manner
		 * The project's information is then written to the "currentprojects.txt" file.
		 */
		
		public void addproject() {
			
			//The Completion and Status variables are set to negative because a new project is added.
			Completion = "None";  
			Status = "Not finalised";
			
			//The User input's are collected about the project information.
			System.out.println("\nEnter the project number: "); //The user input the project number
			projectnumber = integerCheck("Project Number");
			
			System.out.println("Enter the project name: "); //The user input the project name
			projectname = stringCheck("Project Name");

			System.out.println("Enter the type of building: "); //The user input the type of building
			typeofbuilding = stringCheck("Type of Building");
			
			System.out.println("Enter the physical address for the project: "); //The user input the physical address of the project
			physicaladdress = stringCheck("Physical Address");
			
			System.out.println("Enter the ERF number: "); //The user input the ERF number
			ERFNumber = stringCheck("ERF number");
			
			System.out.println("Enter the cost of the project: "); //The user input the cost of the project
			projectcost = doubleCheck("Project Cost");
			
			System.out.println("Enter the total amount paid to date: "); //The user input the amount paid by the customer to date
			amountpaid = doubleCheck("Total Amount");
			
			System.out.println("Enter the project deadline (e.g. day, month, year: 26 February 2021) : "); //The user input the deadline of the project
			deadline = stringCheck("Project Deadline");
			
			//The new project object is shown to the user.
			System.out.println("\nProject Number: " + projectnumber + "\nProjectName: " + projectname
					+ "\nBuilding Type: " + typeofbuilding + "\nPhysical Address: " + physicaladdress + "\nERF Number: " + ERFNumber + "\nTotal Fee: R" 
					+ projectcost + "\nAmount Paid: R" + amountpaid + "\nDeadline: " + deadline + "\nCompletion Date: " + Completion + "\nProject Status: " + Status);
			
			String projectinfo = projectnumber + ", " + projectname + ", " + typeofbuilding + ", " + physicaladdress 
					+ ", " + ERFNumber + ", " + projectcost + ", " + amountpaid + ", " + deadline + ", " + Completion
					+ ", " + Status;
			
			//A String "projectinfo" is written to the "currentprojects.txt" file.
			//The try-catch block is used to check for errors
			try {   
	            BufferedWriter out = new BufferedWriter( 
	                   new FileWriter("currentrojects.txt", true)); 
	            
	            out.write(projectinfo + "\r\n"); 
	            out.close(); 
	            System.out.println("You have succeffully added your project.");
	            
	        } 
	        catch (IOException e) { 
	            System.out.println("Exception" + e); 
	            
	        } 
		}

}