//The PoisedMenu is the main menu class which is created to run the entire program

//Information about the Poised Project is written into external files, "currentprojects.txt and "completedprojects.txt"


import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Date; 
import java.text.ParseException; 
import java.text.SimpleDateFormat;
import java.io.*;

/**
 * PoisedMenu is a subclass(inherits methods) from the superclass(PoisedCheck).
 * <p>
 * The PoisedMenu class runs the main program method and calls other methods from the (NewProjects, PersonDetails and ExistingProjects) classes.
 * PoisedMenu displays the main menu to the user with different options to choose from 
 * @author Omphemetse Marwane
 */

public class PoisedMenu extends PoisedCheck {  //PoisedMenu class which extends PoisedCheck is declared.
	
	/**
	 * PoisedMenu is the main method runs the PoisedMenu.
	 * <p>
	 * @param args is the java command line for arguments 
	 * @throws ParseException occurs if the date is entered in the wrong format
	 */
	
	public static void main(String[] args) throws ParseException {  //The main() method is declared.
		
		/* A welcome message is shown to for the user.
		 * The system then creates a "CurrentProjects.txt" file to store all the information about the project, if the file doesn't exit yet
		 */
		
		System.out.println("Welcome to the Poised Management System \n");
		
		try {
			File newFile = new File("currentrojects.txt");
			
			if (newFile.createNewFile()) {
				System.out.println("File created: " + newFile.getName());
				
			}
			else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			  System.out.println("An error occurred.");
			  e.printStackTrace();
		}
		
		/* The main menu with different options is shown to the user.
		 * After the file check is done to check if there are any existing projects, if not, the user is asked to choose option '2' to create a new project object.
		 * Different methods from (NewProjects, PersonDetails, and ExistingProjects) classes are called out
		 * Depending on the user's chosen option,(e.g addproject() method from NewProjects class is called ouy for option '2'.
		 * The user will return to the main menu after each option, unless they select option '8' to exit the program.
		 */
		
		while (true) {  //While loop is used to encapsulate the main menu
			System.out.println("\nPlease choose a number option from the menu below: "
					+ "\n1. View Existing Projects"
					+ "\n2. Add a New Project"
					+ "\n3. Update Existing Project Infomation"
					+ "\n4. Finalize the Project"
					+ "\n5. View Incomplete Projects"
					+ "\n6. View Overdue Projects"
					+ "\n7. Find a Specific Project"
					+ "\n8. Exit program");
			
			int userOption = integerCheck("menu option");  //Checks if the input is integer (method from PoisedChecks class)
			boolean project = filecheck();
			
			if ((project == false) && ((userOption == 1) || (userOption == 3) || (userOption == 4) || (userOption == 5) 
					|| (userOption == 6) || (userOption == 7) )) {
				System.out.println("There are no Existing Projects. \nChoose option '2' from the main menu to add a new project.");
				
			} else if ((project == true) && (userOption == 1)) {  //If the user choose Option 1 they will be allowed to view projects.
				ExistingProjects object = new ExistingProjects();
				object.viewprojects();
				
			} else if (userOption == 2) {  //If the user choose Option 2 they will be allowed to add a new project.
				NewProjects setnew = new NewProjects();
				setnew.addproject();
				
			} else if ((project == true) && (userOption == 3)) {  //If the user choose Option 3 they will be allowed to edit a project.
				
				System.out.println("Enter the project number or name of the project you want to update: \n");
				String projectinfo = stringCheck("Project Number");
				System.out.println("Do you want to:" + 
						"\n1. Edit the due date of the project or" +
						"\n2. Edit the total amount paid paid to date?" +  //Edit options are shown to the user.
						"\nPlease choose either 1 or 2");
				
				int editOption = integerCheck("Edit Option");
				ExistingProjects object1 = new ExistingProjects();
				int linecount = object1.findproject(projectinfo);
				object1.updateproject(editOption, linecount);  //The findproject() and updateproject() methods from ExistingProjects class are called.
				
				
			} else if ((project == true) &&  (userOption == 4)) {  //If the user choose Option 4 they will be allowed to finalise a project.
				
			// Projects which are finalized are stored in a new text file "completedprojects.txt".
			//The file path for this file is specified in the finaliseproject() method (in ExistingProjects) class.
				
				System.out.println("Enter the project number or name of the project you want to finalise: \n");
				String projectinfo = stringCheck("Project Name OR Number");
				ExistingProjects object2 = new ExistingProjects();
				int linecount = object2.findproject(projectinfo);
				object2.finaliseproject(linecount);
				
			} else if ((project == true) && (userOption == 5)) {  //If the user choose Option 5 they will be allowed to view incomplete projects.
				ExistingProjects object3 = new ExistingProjects();
				object3.datecheck("Incomplete");
				
			} else if ((project == true) && (userOption == 6)) {  //If the user choose Option 6 they will be allowed to view overdue projects.
				ExistingProjects object4 = new ExistingProjects();
				object4.datecheck("Overdue");
				
			} else if ((project == true) && (userOption == 7)) {  //If the user choose Option 7 they will be allowed to find a project to view.
				
				System.out.println("Enter the name or Project Number of the project you want to find: ");
				String projectinfo = stringCheck("Project Name OR Number");
				ExistingProjects object5 = new ExistingProjects();
				int linecount = object5.findproject(projectinfo);  //An line count integer for the project is returned.
				
				String[] infomation = new String[10];  //A string array is created to store information from the project's line in the text file.
				int findline = 0;  //An integer variable is used to match the returned line count value.
				
				try {
					File searchfile = new File("currentrojects.txt");
					Scanner projectFile = new Scanner(searchfile);
					
					while (projectFile.hasNextLine()) {  //The correct project in the file by line count is searched.
						
						if (findline == linecount) {
							infomation = projectFile.nextLine().split(", ");  // The correct line information is stored in the array.
							
						} else {
							findline++;
							
						}
					}
				
				} catch (FileNotFoundException e) {
					System.out.println("Error.");
					
				}
				
				//Each element of the array is stored in separate variables to show the information about the project
			    //Indexing is used 
				String projectnumber = infomation[0];
				String projectname = infomation[1];
				String typeofbuilding = infomation[2];
				String physicaladdress = infomation[3];
				String ERFnumber = infomation[4];
				String projectcost = infomation[5];
				String amountpaid = infomation[6];
				String deadline = infomation[7];
				String Completion = infomation[8];
				String Status = infomation[9];
				
				//The project's information is shown in a friendly-manner.
				System.out.println("\nProject Number: " + projectnumber + "\nProjectName: " + projectname
						+ "\nBuilding Type: " + typeofbuilding + "\nPhysical Address: " + physicaladdress + "\nERF Number: " + ERFnumber + "\nTotal Fee: R" 
						+ projectcost + "\nAmount Paid: R" + amountpaid + "\nDeadline: " + deadline + "\nCompletion Date: " + Completion + "\nProject Status: " + Status);
					
			} else if (userOption == 8) { //If the user choose Option 8 they will be allowed to exit the program.
				
				System.out.println("Successfully logged out.");  //Logout message is shown to the user.
				break;
			}
		}
	}
	
	/**
	 *filecheck() method check for Existing Projects in the "currentprojects.txt" file.
	 * <p>
	 * depending on whether there are existing projects in the "currentproject.txt" file.
	 * @return returns the boolean data type for projectcheck() method
	 */
	public static boolean filecheck() {
		
		boolean projectcheck = false;  //The boolean value is set to check the file("currentprojects.txt") contents.
		
		try {
			File projects = new File("currentrojects.txt");
			Scanner projectfile = new Scanner(projects);
			
			if (projectfile.hasNextLine()) {  //If the "currentprojects.txt" file contains contents for a project, projectcheck() is "True".
				projectcheck = true;
				
			} else {
				projectcheck = false;  // If the "currentprojects.txt" file does not contain projects, projectcheck() is "False".
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("Invalid.");
			
		}
		return projectcheck;  //A boolean data type is returned.
		
	}
}