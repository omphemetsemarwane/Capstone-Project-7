//ExistingProjects class is created to find, view, update and finalise projects in the PoisedMenu

//The PoisedMenu class is used to call this class

//A class is a blueprint from which objects are made (It consists of both data and the code that manipulates the data)

//A public modifier was assigned to the class for easy direct access

//Different java classes from the java.io package to use in the program were imported

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
 * The ExistingProjects is a subclass that inherits methods from the PoisedChecks (superclass).
 * <p>
 * ExistingProjects contains methods used to find, view, update, finalize and to check date on projects in the PoisedMenu 
 * PoisedMenu class, which runs the main program, calls methods on this class to perform different functions
 * @author Omphemetse Marwane
 */
public class ExistingProjects extends PoisedCheck { //The ExistingProjects class which extends PoisedCheck is declared
	
	/**
	 * findproject() method is used to find a specific project object in the "currentprojects.txt" file 
	 * <p>
	 * The findproject() method takes in one parameter with String information related to the project
	 * findproject() method returns an integer to indicate the line number of the project being identified.
	 * @param projectinfo can either be a project number or project name used to locate the project object
	 * @return returns an integer linecount, which indicate the line number of the project in the text file
	 */
	
	public int findproject(String projectinfo) {
		
		//A String array is created to stored information about the project from each line in the external text file.
		//A linecount is used to run through the text file to locate the project.
		String[] info = new String[10];  
		int linecount = 1;  
		
		// A new file object (projects) is created 
		//A while loop used to run and read through lines in the text file.
		//info is then split and stored in the array.
		//A While loop is exited if the first or second index in the array is equal to the projectinfo parameter,
		//The project number or project name have to match that in the text file line.
		
		try {
			File projects = new File("currentrojects.txt");  
			Scanner projectfile = new Scanner(projects);
			
			while (projectfile.hasNextLine()) {  
				
				info = projectfile.nextLine().split(", "); 
				
				if ((info[0].equalsIgnoreCase(projectinfo)) || (info[1].equalsIgnoreCase(projectinfo))) {
					break;  
					
				} else {
					linecount++; //linecount increments if match not found
					
				}
			}
		} catch (FileNotFoundException e) {  //The try-catch block used for error handling.
			System.out.println("Error.");
	
		}
		return linecount;  //An integer line count data type is returned.
	}
	
	/**
	 * viewprojects() method is used to to show all project objects in the "currentprojects.txt file
	 * <p>
	 * Projects are shown in friendly-manner.
	 */
	
	public void viewprojects() {
		String[] information = new String[10];  //A String array is created to store the project information in a text file.
		
		// A file object (searchfile) is created
		//A while loop is used to read through each line in the "currentprojects.txt" file.
		// Each line in the file is split
		//The information is then stored in the String array.
		//Each variable in an array is assigned an index e.g. info[0] = projectnumber
		// Each project is then displayed in a friendly-manner.
		
		try {
			File searchfile = new File("currentrojects.txt");
			Scanner projectfile = new Scanner(searchfile);
			
			while (projectfile.hasNextLine()) {
					information = projectfile.nextLine().split(", ");
					String projectnumber = information[0];
					String projectname = information[1];
					String typeofbuilding = information[2];
					String physicaladdress = information[3];
					String ERFnumber = information[4];
					String projectcost = information[5];
					String amountpaid = information[6];
					String deadline = information[7];
					String Completion = information[8];
					String Status = information[9];
					
					//The project's information is displayed for each line in the file.
					System.out.println("\nProject Number: " + projectnumber + "\nProjectName: " + projectname
							+ "\nBuilding Type: " + typeofbuilding + "\nPhysical Address: " + physicaladdress + "\nERF Number: " + ERFnumber + "\nTotal Fee: R" 
							+ projectcost + "\nAmount Paid: R" + amountpaid + "\nDeadline: " + deadline + "\nCompletion Date: " + Completion + "\nProject Status: " + Status);
			}
		} catch (FileNotFoundException e) {  //The try-catch block is used for error handling.
			System.out.println("Error.");
			
		}
	}
	
	/**
	 * updateproject() method is used to edit project information on a specific project object indentified in the "currentprojects.txt" file
	 * <p>
	 * The updateproject() method takes in an editOption from the main menu in the PoisedMenu class  
	 * The updateproject() method takes in the result from the called on findproject() method
	 * updtateproject() method is used to locate a project object and update the selected information on the project in the text file.
	 * @param editOption integer choice made by the user in the main menu (either 1 or 2)
	 * @param linecount integer linecount returned by the findproject() method to locate the project
	 */
	public void updateproject(int editOption, int linecount) {
		
		// An ArrayList is created to store each line from each project from the text file with current projects.
		// A String array is used to store variables from a split line in the array.
		// findline integer variable is created to match the linecount for the identified file.
		ArrayList<String> infoArray = new ArrayList<String>();
		String[] info = new String[10];
		int findline = 1;
		
		// A File object(projects) is created 
		//A while loop used to read through each line of the text file.
		// Each line of project information is added to the ArrayList.
		// This is important because when a project is updated, that line of information can be replaced in the array.
		// The updated array is then be re-written to the "currentprojects.txt" file.
		try {
			File projects = new File("currentrojects.txt");
			Scanner projectFile = new Scanner(projects);
			
			while (projectFile.hasNextLine()) {
				infoArray.add(projectFile.nextLine());  //Each line is added to the infoArray.
		
			}
		
		} catch (FileNotFoundException e) {  //The try-catch block is used error handling.
			System.out.println("Error.");
		}
		
		//Another try-catch block is used to create another File object.
		/*A while loop is used to run through each line of the text file and when the indicated file is found,
		 * the linecount matches the findline variable, then the line information is split.*/
		//The split line information is then stored in the information string array.
		try {
			File projects = new File("currentrojects.txt");
			Scanner projectFile = new Scanner(projects);
			
			while (projectFile.hasNextLine()) {
				if (findline == linecount) {
					info = projectFile.nextLine().split(", ");
					
				} else if (findline != linecount) {  // linecount increments if match is not found.
					findline++;
				}
			}
		
		} catch (FileNotFoundException e) {
			System.out.println("Error.");
		}
		
		/* When the user chose editOption 1, they are asked for a new due date.
		 * The new due date information is then added into index number 7 in the infoArray, to update the previous information.
		 * The infoArray is then converted into a string, with extra characters removed (i.e. '[' trailing characters).
		 * "newline"(finalised String) is inserted into the correct index of the infoArray, ArrayList (i.e. linecount -1 is used).
		 * The same process is followed for editOption 2, except that the user is asked for a new total amount, which is replaced at index 6 in the infoArray.
		 */
		
		if (editOption == 1) {
			System.out.println("Enter a new project due date: ");
			String newdeadline = stringCheck("Due Date");
			info[7] = newdeadline;
			String newinfo = Arrays.toString(info);
			String changeline = newinfo.replace("[", "");
			String newline = changeline.replace("]", "");
			infoArray.set(linecount-1, newline);
			
		} else if (editOption == 2) {
			System.out.println("Enter a new total amount of the fee paid to date:");
			double newamount = doubleCheck("New Total Amount");
			info[6] = Double.toString(newamount);
			String newinfo = Arrays.toString(info);
			String changeline = newinfo.replace("[", "");
			String newline = changeline.replace("]", "");
			infoArray.set(linecount-1, newline);
			
		}
		
		//Each element, or line of project's information, of the updated array is then re-written to the "currentprojects.txt" file.
		try {
			Formatter F = new Formatter("currentrojects.txt");
			for (String element : infoArray) {
				F.format("%s", element + "\r\n");
			}
			System.out.println("Project was updated successfully.");  //A message is then displayed.
			F.close();
			
		} catch (Exception e) {
			System.out.println("Error.");  //The try-catch block is used for error handling.
			
		}	
	}
	
	/**
	 * finaliseproject() method finalises a project object by generating an invoice to the customer and marking the project as finalised
	 * finaliseproject() method also adds a completion date to the project information.
	 * <p>
	 * finaliseproject() method also selects a project object from the "currentprojects.txt" file
	 * determines whether an invoice must be generated to the customer
	 * finaliseproject() method then marks the project as finalised, and adds a completion date. 
	 * The finalised project is then stored in a new text file called "completedprojects.txt".
	 * @param linecount integer linecount is determined by the findproject() method
	 */
	
	public void finaliseproject(int linecount) {
		// An ArrayList is created to store each line (from each project) from the text file with current projects.
		// A string array stores elements from a split line in the array.
		// A findline integer variable is created to match the linecount for the specified file.
		ArrayList<String> infoArray = new ArrayList<String>();
		String[] info = new String[10];
		int findline = 1;
		
		// A File object(projects) is created  
		//A while loop used to read through each line of the text file.
		// Each line of project information is added to the ArrayList.
		// This is important because when a certain project is updated, that line of information can be replaced in the array.
		// The updated array can then be re-written to the "currentprojects.txt" file.
		
		try {
			File projects = new File("currentrojects.txt");
			Scanner projectFile = new Scanner(projects);
			
			while (projectFile.hasNextLine()) {
				infoArray.add(projectFile.nextLine());
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error.");
			
		}
		
		// A try-catch block is used to create another file object.
		// Each line of the text file is run through and when the specified file is found, the linecount matches the findline variable, then the line info is split.
		// That specific split line information is then stored in the info string array.
		try {
			File projects = new File("currentrojects.txt");
			Scanner projectFile = new Scanner(projects);
			
			while (projectFile.hasNextLine()) {
				if (findline == linecount) {
					info = projectFile.nextLine().split(", ");
					
				} else {
					findline++;   //linecount incrementes if match is not found.
					
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error.");
		}
		
		// Each index of the split line is assigned to a new variable.
		// These variables are used describe project information.
		// The totalFee and amountPaid indexed variables are parsed for comparison.
		String projectnumber = info[0];
		String projectname = info[1];
		String typeofbuilding = info[2];
		String physicaladdress = info[3];
		String ERFnumber = info[4];
		String deadline = info[7];
		String Completion;
		String Status = "Finalised";  //The Status of project marked as "Finalised".
		
		double projectcost = Double.parseDouble(info[5]);
		double amountpaid = Double.parseDouble(info[6]);
		
		// If the project has been paid in full, an invoice is not generated (if the projectcost = amountpaid).
		// The user is asked to input the completion date for the project.
		if (projectcost == amountpaid ) {
			System.out.println("Project has been paid in full. No invoice generated.");
			System.out.println("Add a completion date for this project (e.g. day, month, year, 3 December 2020): ");
			
			Completion = stringCheck("Completion Date");  
		
		// If there is still an amount outstanding, the user is asked for the customer's details for an invoice to be  generated
		// The user is also asked to input a completion date for the project.
		
		} else {
			System.out.println("The invoice will be generated with the following details: ");
			System.out.println("\nEnter the customer's full name: ");  //The user input the customer's full name
	
			String customer = stringCheck("Customer's full name");
			
			String typeofperson2 = "Customer"; 
			
			System.out.println("\nEnter the customer's contact numbers: ");  //The user input the customer's contact numbers
			int number2 = integerCheck("Customer's contact numbers");
			
			System.out.println("\nEnter the customer's email address: ");  //The user input the customer's email address
			String email2 = stringCheck("Customer's email address");
			
			System.out.println("\nEnter the customer's physical address: ");  //The user input the customers physical address
			String address2 = stringCheck("Customer's physical address");
			
			System.out.println("Add a completion date for this project (e.g. day, month, year, 3 December 2020): ");
			Completion = stringCheck("completion date");  //The user input the completion date of the project
			
			// A new person details object is created with the gathered information.
			// The object is then shown to the user with the showPersonDetails() method.
			PersonDetails customer1 = new PersonDetails(typeofperson2, customer, number2, email2, address2);
			
			System.out.println("\nPlease view your invoice details below: ");
			System.out.println(customer1.showPersonDetails());
			System.out.println("\nAmount still owed: R" + (projectcost - amountpaid) + "\n");
		
		}
		//The Finalised project details are also shown to the user in a friendly-manner.
		System.out.println("Finalised Project Details: \n" + "Project Number: " + projectnumber + "\nProjectName: " + projectname
				+ "\nBuilding Type: " + typeofbuilding + "\nPhysical Address: " + physicaladdress + "\nERF Number: " + ERFnumber + "\nTotal Fee: R" 
				+ projectcost + "\nAmount Paid: R" + amountpaid + "\nDeadline: " + deadline + "\nCompletion Date: " + Completion + "\nProject Status: " + Status);
		
		infoArray.remove(linecount-1);  //The infoArray is updated by removing the project from the current projects list.
		
		//An updated infoArray is then written to the "currentprojects.txt" file.
		try {
			Formatter F = new Formatter("currentrojects.txt");
			for (String element : infoArray) {
				F.format("%s", element + "\r\n");
				
			}
			System.out.println("The project was finalised successfully.");  //The message is displayed.
			F.close();
			
		} catch (Exception e) {
			System.out.println("Error.");  //The try-catch block is used for error handling.
			
		}
		String projectcomplete = projectnumber + ", " + projectname + ", " + typeofbuilding + ", " + physicaladdress + ", " 
				+ ERFnumber + ", " + projectcost + ", " + amountpaid + ", " + deadline + ", " + Completion + ", " + Status;	
		
		// A  text file is created to store the completed (finalised projects), if it does not already exist.
		try {
			File newfile = new File("completedprojects.txt");  //Specify the file path for your desired output.
			
			if (newfile.createNewFile()) {
				System.out.println("The file was created: " + newfile.getName());
				
			}
			else {
				System.out.println("The file already exists.");
				
			}
		} catch (IOException e) {
			 System.out.println("An error occurred.");
			 e.printStackTrace();
			
		}
		
		//A String of the completed project information is written in the "completedprojects.txt" file using the append mode.
	    try { 
	        BufferedWriter output = new BufferedWriter(new FileWriter("completedprojects.txt", true));  //Specify the file path for your desired output.
	            output.write(projectcomplete + " \r\n"); 
	            output.close(); 
	            System.out.println("The project was finalised sucessfully.");  //The message is displayed.
	            
	        } catch (IOException e) { 
	        		System.out.println("Exception" + e); 
	            
	        }
	}
	
	/**
	 * datecheck() method is used to check whether a project is incomplete or overdue and displays those projects.
	 * <p>
	 * datecheck() takes in either an 'overdue' or 'incomplete' 
	 * projectype String, searches through the project objects in the "currentprojects.txt" file, 
	 * projecttype String then displays a list of overdue or complete project objects.
	 * @param projectype string type to specify projects listed (either 'overdue' or incomplete')
	 * @throws ParseException occurs if a date string is in the wrong format 
	 */
	public void datecheck(String projectype) throws ParseException {
		
		/* A string array is created to store project information from each split line in the "currentprojects.txt" file.
		 * An integer array is used to store numbers 1 to 12, to relate to the number of months in the year.
		 * Another string array is created to store months abbreviations of the year in order to get date information of a project.
		 * An integer for the indexed month number is set to zero
		 */
		String[] info = new String[10];
		int[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		String[] monthsofyear = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		int monthnum = 0;
		
		// A try-catch block is used to create a file object  
		// A while loop is used to read through each line in the text file.
		// Each line of project information is split
		// The information is then stored in the info string array.
		// The index 7 of the infoArray (which is "deadline") is then split  to get specific date information for the project (e.g "26 February 2021").
		// The first index (which is dateinfo[0]) is stored into a integer variable("day").
		// String ("month") is created using the first three letter's of dateinfo[1], which would be the full month name e.g. "February".
		// The integer ("year") variable is created from index dateinfo[2].
		 
		try {
			File projects = new File("currentrojects.txt");
			Scanner projectFile = new Scanner(projects);
			
			while (projectFile.hasNextLine()) {
				info = projectFile.nextLine().split(", ");
				String projectnumber = info[0];
				String projectname = info[1];
				String typeofbuilding = info[2];
				String physicaladdress = info[3];
				String ERFnumber = info[4];
				String projectcost = info[5];
				String amountpaid = info[6];
				String Completion = info[8];
				String finalise = info[9];
				String deadline = info[7];
				String[] dateInfo = deadline.split(" ");
				int day = Integer.parseInt(dateInfo[0]);
				String monthInfo = dateInfo[1];
				String month = (monthInfo.substring(0,2));
				int year = Integer.parseInt(dateInfo[2]);
				
				// for loop is used to compare the substring "month" with the monthsofyear string array.
				
				/* if "month" matches with an abbreviated "monthsofyear", the corresponding number from the integer array "months"
				is stored in the "monthnum" variable and used as date information. */
				 
				for (int index = 0; index < monthsofyear.length ; index++) {	
					if (month.equalsIgnoreCase(monthsofyear[index])) {
						monthnum = months[index];
						
					}
				}
				
				String current = "" + java.time.LocalDate.now();  //Used to get the current date and store's it as a String value.
				
				//A new object in a date format is created
				
				SimpleDateFormat dateObject = new SimpleDateFormat("yyyy-MM-dd");
				
				// Two Date (date1 and date2) are created by parsing String info from "current" date and date information collected from the file.
				Date date1 = dateObject.parse(current);
				Date date2 = dateObject.parse(day + "-" + monthnum + "-" + year);
				
				//A String is created to show project details.
				String projectDetails = "\nProject Number: " + projectnumber + "\nProjectName: " + projectname
						+ "\nBuilding Type: " + typeofbuilding + "\nPhysical Address: " + physicaladdress + "\nERF Number: " + ERFnumber + "\nTotal Fee: R" 
						+ projectcost + "\nAmount Paid: R" + amountpaid + "\nDeadline: " + deadline + "\nCompletion Date: " + Completion + "\nProject Status: " + finalise;
				
				// If the user choose view incomplete project(the current date is before the deadline date) 
				//The specific projects from each line in the text file are shown to the user in the friendly-manner.
				if ((date1.compareTo(date2) > 0) && (projectype.equalsIgnoreCase("incomplete"))) {
					System.out.println(projectDetails);
				
				//If the user choose view overdue projects(the current date has pasted the deadline)
				// The specific projects from each line in the text file are shown to the user in the friendly-manner.
				} else if ((date1.compareTo(date2) < 0) && (projectype.equalsIgnoreCase("overdue"))) {
					System.out.println(projectDetails);
					
				}
			}
		} catch (FileNotFoundException e) {  //A try-catch block is used for error handling.
			System.out.println("Error.");
			
		}
	}
}