package Assign2;
/********************************************************************************* 
   Purpose: To take in user information (height in inches and weight in pounds)
            The program will convert inches to meters and pounds to kilograms
            and it'll use the converted measurements to calculate and display the 
            user's BMI as well as a small table for the user to reference. 
**********************************************************************************/            


import java.util.Scanner;

public class hwk2_bmi {

	public static void main(String[] args) {
		
		double weight = 0.0;                      //Define and Initialize user input variables
		double height = 0.0;                      //All the factors we need are here
		double BMI = 0.0;                         //Using double for numerical values instead of float
		double user_weight = 0.0;                 //just in case user enters more detailed information.
		double user_height = 0.0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter weight in pounds");  //Display prompt and user input information
		user_weight = input.nextDouble();
		System.out.println("Enter height in inches");
		user_height = input.nextDouble();
		
		weight = 0.45359237 * user_weight;              //Conversion and calculations
		height = 0.0254 * user_height;
		BMI = weight / (height * height);
		
		System.out.println("Body Mass Index: " + BMI);           //Display prompt of user information and
		System.out.println("\n");                                //reference for user to compare BMI.  
		System.out.println("\t" + "Underweight: less than 18.5");
		System.out.println("\t" + "Normal: 18.5 - 24.9");
		System.out.println("\t" + "Overweight: 25 - 29.9");
		System.out.println("\t" + "Obese: 30 or greater");
		
	}

}
