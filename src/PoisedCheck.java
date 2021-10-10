//The PoisedCheck class was created to check the user inputs

//This class contains three methods which are used to check the user's input(when the user input an Integer, String and Double data types)

//Based on the user's input the output is returned 

//Scanners were used to collect the user's input

import java.util.Scanner;

/**
 * PoisedChecks is a superclass for the Poised project.
 * <p>
 * The PoisedCheck class contains three methods which check user inputs.
 * The three methods are inherited by the three subclasses(PoisedMenu, NewProjects and ExistingProjects) of this program to make sure that all user inputs are checked properly.
 * @author Omphemetse Marwane
 */

//Main class is declared
public class PoisedCheck {  
	
	/**
	 * This method checks for user input when the user is asked to input an integer
	 * @param type type explain the type of input required from the user 
	 * @return returns the integer output 
	 */
	public static int integerCheck(String type) {  
		
		while(true) {  //While loop is used to repeatedly ask the user for input until it's correct.
			Scanner numberinput = new Scanner(System.in);  
			String number = numberinput.nextLine();
			
			try {
				int output = Integer.parseInt(number);  //Checks for the correct input
				return output;
				
			} catch (NumberFormatException ex) {
				System.out.println("Incorrect. Please enter the " + type + ": \n");  //Error message is displayed 
				
			}
		}
	}
	
	/**
	 * This method checks for user input when the user is asked to input a string.
	 * @param type type explain the type of input required from the user
	 * @return returns the String output
	 */
	public static String stringCheck(String type) {
		
		while(true) {  //While loop is used to repeatedly ask the user for input until it's correct.
			Scanner userinput = new Scanner(System.in);
			String input = userinput.nextLine();
			
			if ((input == null) || (input.length() > 130)) {  //if statement is used to check if the input is empty, short, or long.
				System.out.println("Incorrect. Please enter the " + type + ": \n"); //Error message is displayed
				
			} else {
				return input;  // Returns the correct String 
				
			}
		}
	}
	
	/**
	 * This method checks for user input when the user is asked to input a double number.
	 * @param type type explain the type of input required from user 
	 * @return returns double output 
	 */
	public static double doubleCheck(String type) {
		
		while(true) {  //While loop is used to repeatedly ask the user for input until it's correct.
			Scanner doubleinput = new Scanner(System.in);
			String number = doubleinput.nextLine();
			
			try {
				double output = Double.parseDouble(number);  // Parse the input to a double to check for correct input
				return output;
				
			} catch (NumberFormatException ex) {
				System.out.println("Incorrect. Please enter the " + type + ": \n");  // Error message displayed 
				
			}
		}
	}
}