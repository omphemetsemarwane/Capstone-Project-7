//Software Engineering Task 24 - Capstone Project III.

// Importing java classes for use in the program.
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * NewProject is a subclass that inherits methods from the PoisedInputChecks superclass.
 * <p>
 * This class contains variables and a method for adding a new project object to the Poised Management System.
 * The PoisedMenu class, which runs the main program, calls on methods from this class to add new projects.
 * @author Danielle Bussy 
 */
public class NewProject extends PoisedInputChecks {
		// Listing variable attributes for the 'NewProject' class.
		private int projectNumber;
		private String projectName;
		private String buildingType;
		private String address;
		private String erfNumber;
		private double totalFee;
		private double amountPaid;
		private String deadline;
		private String Completion;
		private String Status;
		
		/**
		 * The addProject method is used to add a new project object to the Poised Management System.
		 * <p>
		 * It prompts the user to enter information related to project details which is then verified with methods from
		 * the superclass PoisedInputChecks, and stored in variables related to the project object.
		 * It displays the new project object created and writes the project info to the CurrentProjects.txt file.
		 */
		public void addProject() {
			// Completion and Status variables set to negative as this is a newly added project.
			Completion = "None";  
			Status = "Not finalised";
			
			// User prompted for input regarding project information.
			System.out.println("\nPlease enter the project number: ");
			projectNumber = intCheck("project number");
			
			System.out.println("Please enter the project name: ");
			projectName = stringCheck("project name");

			System.out.println("Please enter the building type: ");
			buildingType = stringCheck("building type");
			
			System.out.println("Please enter the physical address for the project: ");
			address = stringCheck("physical address");
			
			System.out.println("Please enter the ERF number: ");
			erfNumber = stringCheck("ERF number");
			
			System.out.println("Please enter the total fee charged for the project: ");
			totalFee = doubleCheck("total fee");
			
			System.out.println("Please enter the total amount paid to date: ");
			amountPaid = doubleCheck("total amount");
			
			System.out.println("Please enter the project deadline (e.g. day, month, year: 3 November 2020) : ");
			deadline = stringCheck("project deadline");
			
			// New project object dispayed to the user.
			System.out.println("\nProject Number: " + projectNumber + "\nProjectName: " + projectName
					+ "\nBuilding Type: " + buildingType + "\nPhysical Address: " + address + "\nERF Number: " + erfNumber + "\nTotal Fee: R" 
					+ totalFee + "\nAmount Paid: R" + amountPaid + "\nDeadline: " + deadline + "\nCompletion Date: " + Completion + "\nProject Status: " + Status);
			
			String projectInfo = projectNumber + ", " + projectName + ", " + buildingType + ", " + address 
					+ ", " + erfNumber + ", " + totalFee + ", " + amountPaid + ", " + deadline + ", " + Completion
					+ ", " + Status;
			
			// Writing the string 'projectInfo' to the CurrentProjects.txt file.
			// Try-catch block used to deal with any errors encountered.
			try {   
	            BufferedWriter out = new BufferedWriter( 
	                   new FileWriter("C:\\CurrentProjects.txt", true)); 
	            
	            out.write(projectInfo + "\r\n"); 
	            out.close(); 
	            System.out.println("Your project was successfully added.");
	            
	        } 
	        catch (IOException e) { 
	            System.out.println("exception occoured" + e); 
	            
	        } 
		}

}