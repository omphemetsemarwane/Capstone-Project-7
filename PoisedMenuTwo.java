//Software Engineering Task 24 - Capstone Project III.
// This is the main menu class which runs the program.
// It works with information from the two external text files, 'CurrentProjects.txt' and 'CompletedProjects.txt'.

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Date; 
import java.text.ParseException; 
import java.text.SimpleDateFormat;
import java.io.*;

/**
 * PoisedMenu is a subclass that inherits methods from the PoisedInputCheck superclass.
 * <p>
 * This class runs the main program method and calls other methods from the NewProject, NewPerson and ExistingProjects classes.
 * It displays a main menu to the user with options for the Poised Management System.
 * @author Danielle Bussy
 */
public class PoisedMenuTwo extends PoisedInputChecks {  // Class declaration.
	/**
	 * This is the main method which runs the Poised Management System program.
	 * <p>
	 * @param args java command line arguments 
	 * @throws ParseException occurs if a date string is in the wrong format to be parsed 
	 */
	public static void main(String[] args) throws ParseException {  // Main method declaration.
		
		/* A welcome message is displayed for the user.
		 * Thereafter, the system creates a 'CurrentProjects.txt.' file to store project info, if it does not exist already.
		 */
		System.out.println("Welcome to the Poised Management System \n");
		
		try {
			File newFile = new File("C:\\CurrentProjects.txt");
			
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
		
		/* The main menu is then displayed to the user with various options.
		 * A file check is run to determine if there are existing projects and, if not, the user is prompted
		 * to choose option '2' to create a new project object.
		 * Various methods from the NewProject, NewPerson, and ExistingProjects classes are called on, depending on the
		 * user's selected option. For example, the addProject() method from NewProject class is called on for option '2'.
		 * The user will return to the main menu after each option, unless they choose '8' to exit the program.
		 */
		while (true) {
			System.out.println("\nPlease choose a number option from the menu below: "
					+ "\n1. View Existing Projects"
					+ "\n2. Add a New Project"
					+ "\n3. Update Existing Project Info"
					+ "\n4. Finalize a Project"
					+ "\n5. View Incomplete Projects"
					+ "\n6. View Overdue Projects"
					+ "\n7. Find a Project"
					+ "\n8. Exit program");
			
			int userChoice = intCheck("menu choice");  // Checking integer input with method from the PoisedInputChecks class.
			boolean projects = fileCheck();
			
			if ((projects == false) && ((userChoice == 1) || (userChoice == 3) || (userChoice == 4) || (userChoice == 5) 
					|| (userChoice == 6) || (userChoice == 7) )) {
				System.out.println("There are no existing projects. \nPlease choose option '2' from the menu to add a new project.");
				
			} else if ((projects == true) && (userChoice == 1)) {  // Option 1 allows the user to view projects.
				ExistingProjects object = new ExistingProjects();
				object.viewProjects();
				
			} else if (userChoice == 2) {  // Option 2 allows the user to add a new project.
				NewProject setNew = new NewProject();
				setNew.addProject();
				
			} else if ((projects == true) && (userChoice == 3)) {  // Option 3 allows the user to edit a project.
				
				System.out.println("Please enter the project number or name of the project you wish to update: \n");
				String projectInfo = stringCheck("project number");
				System.out.println("Would you like to:" + 
						"\n1. Edit the project due date or" +
						"\n2. Edit the total amount paid of the fee to date?" +  // Edit options displayed.
						"\nChoose either 1 or 2");
				
				int editChoice = intCheck("edit choice");
				ExistingProjects obj1 = new ExistingProjects();
				int lineCount = obj1.findProject(projectInfo);
				obj1.updateProject(editChoice, lineCount);  // findProject() and updateProject() methods called on from ExistingProjects class.
				
			} else if ((projects == true) &&  (userChoice == 4)) {  // Option 4 allows the user to finalise a project.
																	// Finalised projects are stored in a new text file 'CompletedProjects.txt'.
																	// Specify the file path for this file in the finaliseProject() method in ExistingProjects class.
				
				System.out.println("Please enter the project number or name of the project you wish to finalise: \n");
				String projectInfo = stringCheck("project name OR number");
				ExistingProjects obj2 = new ExistingProjects();
				int lineCount = obj2.findProject(projectInfo);
				obj2.finaliseProject(lineCount);
				
			} else if ((projects == true) && (userChoice == 5)) {  // Option 5 allows the user to view incomplete projects.
				ExistingProjects obj3 = new ExistingProjects();
				obj3.dateCheck("incomplete");
				
			} else if ((projects == true) && (userChoice == 6)) {  // Option 6 allows the user to view overdue projects.
				ExistingProjects obj4 = new ExistingProjects();
				obj4.dateCheck("overdue");
				
			} else if ((projects == true) && (userChoice == 7)) {  // Option 7 allows the user to find a project to view.
				
				System.out.println("Please enter the name or project number of the project you wish to find: ");
				String projectInfo = stringCheck("project name OR number");
				ExistingProjects obj5 = new ExistingProjects();
				int lineCount = obj5.findProject(projectInfo);  // This method returns a line count integer for the project.
				
				String[] info = new String[10];  // Setting a string array to store info from the project's line in the text file.
				int findLine = 0;  // Setting an integer variable to match the returned line count value.
				
				try {
					File searchFile = new File("C:\\CurrentProjects.txt");
					Scanner projectFile = new Scanner(searchFile);
					
					while (projectFile.hasNextLine()) {  // Searching for the correct project in the file by line count.
						
						if (findLine == lineCount) {
							info = projectFile.nextLine().split(", ");  // Storing the correct line info into the array.
							
						} else {
							findLine++;
							
						}
					}
				
				} catch (FileNotFoundException e) {
					System.out.println("Error.");
					
				}
				
				// Now storing each element of the built array into separate variables.
				// These will be used to display project information.
				String projectNum = info[0];
				String projectName = info[1];
				String buildingType = info[2];
				String address = info[3];
				String erfNum = info[4];
				String totalFee = info[5];
				String amountPaid = info[6];
				String deadline = info[7];
				String Completion = info[8];
				String Status = info[9];
				
				// Project information displayed in clear format.
				System.out.println("\nProject Number: " + projectNum + "\nProjectName: " + projectName
						+ "\nBuilding Type: " + buildingType + "\nPhysical Address: " + address + "\nERF Number: " + erfNum + "\nTotal Fee: R" 
						+ totalFee + "\nAmount Paid: R" + amountPaid + "\nDeadline: " + deadline + "\nCompletion Date: " + Completion + "\nProject Status: " + Status);
					
			} else if (userChoice == 8) { // Option 8 allows the user to exit the program.
				
				System.out.println("Successfully logged out.");  // Successful logout message displayed.
				break;
			}
		}
	}
	/**
	 * The fileCheck method is run to check for existing projects in the CurrentProjects.txt file.
	 * <p>
	 * It guides the user's menu choices, depending on whether there are existing projects in the text file.
	 * @return returns the boolean value for projectCheck
	 */
	public static boolean fileCheck() {
		
		boolean projectCheck = false;  // Setting boolean value to check the file contents.
		
		try {
			File projects = new File("C:\\CurrentProjects.txt");
			Scanner projectFile = new Scanner(projects);
			
			if (projectFile.hasNextLine()) {  // If the file contains contents for a project, projectCheck is 'true'.
				projectCheck = true;
				
			} else {
				projectCheck = false;  // If the file does not contain projects, projectCheck is 'false'.
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error.");
			
		}
		return projectCheck;  // boolean value returned.
		
	}
}