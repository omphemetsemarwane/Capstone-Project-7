//Software Engineering Task 24 - Capstone Project III.

// Java classes imported for use in the program.
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Formatter;
import java.util.Date; 
import java.text.ParseException; 
import java.text.SimpleDateFormat;

/**
 * ExistingProjects is a subclass that inherits methods from the PoisedInputChecks superclass.
 * <p>
 * This class contains methods to find, view, update, finalise and do date checks on projects in the Poised
 * Management System. 
 * The Poised Menu class, which runs the main program, calls on methods from this class to perform various
 * functions on projects managed by the Poised Engineering Company.
 * @author Danielle Bussy
 */
public class ExistingProjects extends PoisedInputChecks {
	/**
	 * The find project method runs through project info in the CurrentProjects.txt file to locate a particular 
	 * project object needed.
	 * <p>
	 * It takes in one parameter with string info related to the project and returns an integer to indicate the line
	 * number of the project being located.
	 * @param projectInfo either a project number or project name to identify the project object
	 * @return returns an integer lineCount to indicate the line number of the project in the text file
	 */
	public int findProject(String projectInfo) {
		// String array declared to stored project info from each line in the external text file.
		// A line count set to run through the text file to find the project.
		String[] info = new String[10];  
		int lineCount = 1;  
		
		// A new file object is created and a while loop used to run through lines in the test file.
		// Line info is then split and stored in the array.
		// While loop is exited if the first or second index in the array is equal to the projectInfo parameter,
		// i.e. the project number or project name must match that of the text file line.
		try {
			File projects = new File("C:\\CurrentProjects.txt");  
			Scanner projectFile = new Scanner(projects);
			
			while (projectFile.hasNextLine()) {  
				
				info = projectFile.nextLine().split(", "); 
				
				if ((info[0].equalsIgnoreCase(projectInfo)) || (info[1].equalsIgnoreCase(projectInfo))) {
					break;  
					
				} else {
					lineCount++; // Line count incremented whilst match not made.
					
				}
			}
		} catch (FileNotFoundException e) {  // Try-catch block used to handle errors.
			System.out.println("Error.");
	
		}
		return lineCount;  // Integer line count returned.
	}
	/**
	 * The viewProjects method runs through the CurrentProjects.txt file to display all project objects listed.
	 * <p>
	 * The projects are each displayed in an easy-to-read format.
	 */
	public void viewProjects() {
		String[] info = new String[10];  // String array set to store project info from lines in text file.
		
		// A file object is created and a while loop used to run through each line in the CurrentProjects.txt file.
		// Each line in the file is split, with the info stored in the set string array.
		// Each index in the array is assigned to a variable pertaining to project details, e.g. info[0] = projectNum.
		// Each project is then displayed in a clear format using headings and the split project variables.
		try {
			File searchFile = new File("C:\\CurrentProjects.txt");
			Scanner projectFile = new Scanner(searchFile);
			
			while (projectFile.hasNextLine()) {
					info = projectFile.nextLine().split(", ");
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
					
					// Project info displayed for each line in the file.
					System.out.println("\nProject Number: " + projectNum + "\nProjectName: " + projectName
							+ "\nBuilding Type: " + buildingType + "\nPhysical Address: " + address + "\nERF Number: " + erfNum + "\nTotal Fee: R" 
							+ totalFee + "\nAmount Paid: R" + amountPaid + "\nDeadline: " + deadline + "\nCompletion Date: " + Completion + "\nProject Status: " + Status);
			}
		} catch (FileNotFoundException e) {  // Try-catch block used to handle errors.
			System.out.println("Error.");
			
		}
	}
	/**
	 * The updateProject method is used to edit project information on a particular project object located in the
	 * CurrentProjects.txt file.
	 * <p>
	 * It takes in an editChoice from the main menu in the PoisedMenu class and a result from the called on findProject
	 * method to locate a project object and update the selected information on the project in the text file.
	 * @param editChoice integer choice made by the user in the main menu (either 1 or 2)
	 * @param lineCount integer lineCount returned by the findProject function to locate the project
	 */
	public void updateProject(int editChoice, int lineCount) {
		// An ArrayList is set to store each line (i.e. each project) from the text file with current projects.
		// A string array is used to store elements from a split line in the array.
		// A findLine integer variable is set to match the lineCount for the specified file.
		ArrayList<String> infoArray = new ArrayList<String>();
		String[] info = new String[10];
		int findLine = 1;
		
		// A file object is created and a while loop used to run through each line of the text file.
		// Each line of project information is added to the ArrayList.
		// This is useful because when one project is updated, that line of info can be replaced in the array.
		// The updated array can then be re-written to the CurrentProjects.txt file.
		try {
			File projects = new File("C:\\CurrentProjects.txt");
			Scanner projectFile = new Scanner(projects);
			
			while (projectFile.hasNextLine()) {
				infoArray.add(projectFile.nextLine());  // Each line added to the infoArray.
		
			}
		
		} catch (FileNotFoundException e) {  // try-catch block used to handle errors.
			System.out.println("Error.");
		}
		
		// Another try-catch block is now used to create another file object.
		// Each line of the text file is run through and when the indicated file is found,
		// i.e. the lineCount matches the findLine variable, then the line info is split.
		// That specific split line info is then stored in the info string array.
		try {
			File projects = new File("C:\\CurrentProjects.txt");
			Scanner projectFile = new Scanner(projects);
			
			while (projectFile.hasNextLine()) {
				if (findLine == lineCount) {
					info = projectFile.nextLine().split(", ");
					
				} else if (findLine != lineCount) {  // Line count incremented if match is not made.
					findLine++;
				}
			}
		
		} catch (FileNotFoundException e) {
			System.out.println("Error.");
		}
		
		/* If the user chose edit choice 1, they are prompted for a new due date.
		 * The new due date info is then inserted into index number 7 in the info array, 
		 * to update the old information.
		 * The info array is then converted into a string, with extra characters removed (i.e. '[' trailing characters).
		 * The finalised string 'newLine' is then inserted into the correct index of the infoArray ArrayList (i.e. lineCount -1).
		 * The same process is followed for edit choice '2', except they are prompted for a new total amount, which is replaced at index 6 in the info array.
		 */
		if (editChoice == 1) {
			System.out.println("Please enter a new project due date: ");
			String newDeadline = stringCheck("due date");
			info[7] = newDeadline;
			String newInfo = Arrays.toString(info);
			String changeLine = newInfo.replace("[", "");
			String newLine = changeLine.replace("]", "");
			infoArray.set(lineCount-1, newLine);
			
		} else if (editChoice == 2) {
			System.out.println("Please enter a new total amount of the fee paid to date:");
			double newAmount = doubleCheck("new total amount");
			info[6] = Double.toString(newAmount);
			String newInfo = Arrays.toString(info);
			String changeLine = newInfo.replace("[", "");
			String newLine = changeLine.replace("]", "");
			infoArray.set(lineCount-1, newLine);
			
		}
		
		// Each element, or line of project info, of the updated array
		// is then re-written to the CurrentProjects.txt file.
		try {
			Formatter F = new Formatter("C:\\CurrentProjects.txt");
			for (String element : infoArray) {
				F.format("%s", element + "\r\n");
			}
			System.out.println("Project successfully updated.");  // Successful message displayed.
			F.close();
			
		} catch (Exception e) {
			System.out.println("Error.");  // try-catch block used to handle errors.
			
		}	
	}
	/**
	 * The finaliseProject method finalises a project object by generating an invoice, marking the project as finalised
	 * and adding a completion date to the project info.
	 * <p>
	 * It selects a project object from the CurrentProjects.txt file, determines whether an invoice must be generated
	 * and then marks the project as finalised, and adds a completion date. The finalised project is then stored in a
	 * new text file called CompletedProjects.txt.
	 * @param lineCount integer lineCount determined by the findProject function
	 */
	public void finaliseProject(int lineCount) {
		// An ArrayList is set to store each line (i.e. each project) from the text file with current projects.
		// A string array is used to store elements from a split line in the array.
		// A findLine integer variable is set to match the lineCount for the specified file.
		ArrayList<String> infoArray = new ArrayList<String>();
		String[] info = new String[10];
		int findLine = 1;
		
		// A file object is created and a while loop used to run through each line of the text file.
		// Each line of project information is added to the ArrayList.
		// This is useful because when one project is updated, that line of info can be replaced in the array.
		// The updated array can then be re-written to the CurrentProjects.txt file.
		try {
			File projects = new File("C:\\CurrentProjects.txt");
			Scanner projectFile = new Scanner(projects);
			
			while (projectFile.hasNextLine()) {
				infoArray.add(projectFile.nextLine());
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error.");
			
		}
		
		// Another try-catch block is now used to create another file object.
		// Each line of the text file is run through and when the indicated file is found,
		// i.e. the lineCount matches the findLine variable, then the line info is split.
		// That specific split line info is then stored in the info string array.
		try {
			File projects = new File("C:\\CurrentProjects.txt");
			Scanner projectFile = new Scanner(projects);
			
			while (projectFile.hasNextLine()) {
				if (findLine == lineCount) {
					info = projectFile.nextLine().split(", ");
					
				} else {
					findLine++;   // Line count incremented if match is not made.
					
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error.");
		}
		
		// Each index of the split line is then assigned to a new variable.
		// These variables describe project info.
		// The totalFee and amountPaid indexed variables are parsed for comparison.
		String projectNum = info[0];
		String projectName = info[1];
		String buildingType = info[2];
		String address = info[3];
		String erfNum = info[4];
		String deadline = info[7];
		String Completion;
		String Status = "Finalised";  // Status of project set to 'finalised'.
		
		double totalFee = Double.parseDouble(info[5]);
		double amountPaid = Double.parseDouble(info[6]);
		
		// If the project has been paid in full, no invoice is generated (i.e. totalFee = amountPaid).
		// The user is prompted for a completion date for the project.
		if (totalFee == amountPaid ) {
			System.out.println("The project has been paid in full. No invoice generated.");
			System.out.println("Please add a completion date for this project (e.g. day, month, year, 3 December 2020): ");
			
			Completion = stringCheck("completion date");  
		
		// If there is still an amount outstanding, the user is prompted for customer details to generate an invoice.
		// They are also prompted for a completion date.
		} else {
			System.out.println("Your invoice will be generated with the following details: ");
			System.out.println("\nPlease enter the customer's full name: ");
	
			String customer = stringCheck("customer's full name");
			
			String personType2 = "Customer"; 
			
			System.out.println("\nPlease enter the customer's contact number: ");
			int number2 = intCheck("customer's contact number");
			
			System.out.println("\nPlease enter the customer's email address: ");
			String email2 = stringCheck("customer's email address");
			
			System.out.println("\nPlease enter the customer's physical address: ");
			String address2 = stringCheck("customer's physical address");
			
			System.out.println("Please add a completion date for this project (e.g. day, month, year, 3 December 2020): ");
			Completion = stringCheck("completion date");
			
			// A new person object is created with the gathered info.
			// This object is then displayed to the user with the DisplayPerson() method.
			NewPerson customer1 = new NewPerson(personType2, customer, number2, email2, address2);
			
			System.out.println("\nPlease view your invoice details below: ");
			System.out.println(customer1.DisplayPerson());
			System.out.println("\nAmount still owed: R" + (totalFee - amountPaid) + "\n");
		
		}
		// Finalised project details also displayed to the user in a clear format.
		System.out.println("Finalised Project Details: \n" + "Project Number: " + projectNum + "\nProjectName: " + projectName
				+ "\nBuilding Type: " + buildingType + "\nPhysical Address: " + address + "\nERF Number: " + erfNum + "\nTotal Fee: R" 
				+ totalFee + "\nAmount Paid: R" + amountPaid + "\nDeadline: " + deadline + "\nCompletion Date: " + Completion + "\nProject Status: " + Status);
		
		infoArray.remove(lineCount-1);  // infoArray updated by removing the project from the current projects list.
		
		// The updated infoArray is then written to the CurrentProjects.txt file.
		try {
			Formatter F = new Formatter("C:\\CurrentProjects.txt");
			for (String element : infoArray) {
				F.format("%s", element + "\r\n");
				
			}
			System.out.println("Project successfully finalised.");  // Successful message displayed.
			F.close();
			
		} catch (Exception e) {
			System.out.println("Error.");  // try-catch block used to handle errors.
			
		}
		String projectComplete = projectNum + ", " + projectName + ", " + buildingType + ", " + address + ", " 
				+ erfNum + ", " + totalFee + ", " + amountPaid + ", " + deadline + ", " + Completion + ", " + Status;	
		
		// A file is then created to store the completed/ finalised projects, if it does not already exist.
		try {
			File newFile = new File("C:\\CompletedProjects.txt");  // Please specify the file path for your desired output.
			
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
		
		// Thereafter, the string of project completed info is written to the CompletedProjects.txt file in append mode.
	    try { 
	        BufferedWriter out = new BufferedWriter(new FileWriter("C:\\CompletedProjects.txt", true));  // Please specify the file path for your desired output.
	            out.write(projectComplete + " \r\n"); 
	            out.close(); 
	            System.out.println("Project sucessfully finalised.");  // Successful message displayed.
	            
	        } catch (IOException e) { 
	        		System.out.println("exception occoured" + e); 
	            
	        }
	}
	/**
	 * The dateCheck method determines whether a project is incomplete or overdue and displays those listed projects.
	 * <p>
	 * It takes in either an 'overdue' or 'incomplete' projectType string, searches through the project objects in the
	 * CurrentProjects.txt file, and displays a list of overdue or complete project objects.
	 * @param projectType string type to specify projects listed (either 'overdue' or incomplete')
	 * @throws ParseException occurs if a date string is in the wrong format to be parsed 
	 */
	public void dateCheck(String projectType) throws ParseException {
		/* A string array is set to store project related info from each split line in the CurrentProjects.txt file.
		 * An integer array is used to store numbers 1 through to 12, set to relate to the number of months in the year.
		 * Another string array is set to store abbreviated months of the year to get date information on a project.
		 * An integer for an indexed month number is also set to 0.
		 */
		String[] info = new String[10];
		int[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		String[] monthsofYear = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		int monthNum = 0;
		
		/* A try-catch block is then used to create a file object to scan through with a while loop.
		 * Each line of project info is split, with the info stored in the info string array.
		 * Index 7 of the info array ('deadline') is then split further to get specific date information (e.g '3 December 2020').
		 * The first index (dateInfo[0]) is stored into a 'day' integer variable.
		 * A string 'month' is set using the first three letters of dateInfo[1], which would be the full month name e.g. 'December'.
		 * The year integer variable is set from index dateInfo[2].
		 */
		try {
			File projects = new File("C:\\CurrentProjects.txt");
			Scanner projectFile = new Scanner(projects);
			
			while (projectFile.hasNextLine()) {
				info = projectFile.nextLine().split(", ");
				String projectNum = info[0];
				String projectName = info[1];
				String buildingType = info[2];
				String address = info[3];
				String erfNum = info[4];
				String totalFee = info[5];
				String amountPaid = info[6];
				String Completion = info[8];
				String finalise = info[9];
				String deadline = info[7];
				String[] dateInfo = deadline.split(" ");
				int day = Integer.parseInt(dateInfo[0]);
				String monthInfo = dateInfo[1];
				String month = (monthInfo.substring(0,2));
				int year = Integer.parseInt(dateInfo[2]);
				
				/* A for loop is then used to compare the substring 'month' with the monthsofYear string array.
				 * Once matched with an abbreviated month of the year, the corresponding number from the integer array 'months'
				 * is stored in the 'monthNum' variable, for use as date info.
				 */
				for (int index = 0; index < monthsofYear.length ; index++) {	
					if (month.equalsIgnoreCase(monthsofYear[index])) {
						monthNum = months[index];
						
					}
				}
				String current = "" + java.time.LocalDate.now();  // Getting the current date and storing it as a string.
				
				// Creating a new simple date format object.
				SimpleDateFormat dateObj = new SimpleDateFormat("yyyy-MM-dd");
				
				// Dates d1 and d2 are then created by parsing string info from 'current' date 
				// and date info gathered from the file above.
				Date d1 = dateObj.parse(current);
				Date d2 = dateObj.parse(day + "-" + monthNum + "-" + year);
				
				// Setting a string to display project details.
				String projectDetails = "\nProject Number: " + projectNum + "\nProjectName: " + projectName
						+ "\nBuilding Type: " + buildingType + "\nPhysical Address: " + address + "\nERF Number: " + erfNum + "\nTotal Fee: R" 
						+ totalFee + "\nAmount Paid: R" + amountPaid + "\nDeadline: " + deadline + "\nCompletion Date: " + Completion + "\nProject Status: " + finalise;
				
				// If the current date is before the deadline date and the user has chosen to view 'incomplete' projects,
				// Those specific projects from each line of the text file are displayed.
				if ((d1.compareTo(d2) > 0) && (projectType.equalsIgnoreCase("incomplete"))) {
					System.out.println(projectDetails);
				
				// Otherwise, if the current date is past the deadline and the user has chosen to view 'overdue' projects,
				// Those specific projects from each line of the text file are displayed.
				} else if ((d1.compareTo(d2) < 0) && (projectType.equalsIgnoreCase("overdue"))) {
					System.out.println(projectDetails);
					
				}
			}
		} catch (FileNotFoundException e) {  // try-catch block used to handle errors.
			System.out.println("Error.");
			
		}
	}
}