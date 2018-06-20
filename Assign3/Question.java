package Assign3;
/* Program: prompts user to enter max number of "?" to display on a line of output,
 * as well as a choice of 2 difference output patterns. Program will display chosen
 * pattern with "?".
 ***********************************************************************************/
// Step 1: Define values
// Step 2: Draw user information
// Step 3: Chunk out, vertical expansion, Horizontal Expansion


import java.util.Scanner;

public class Question {

	public static void main(String[] args) {
		int user_number = 0;				             //Initialize values
		int user_choice = 0; 
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter an interger");         //User input information
		user_number = input.nextInt();
		System.out.println("Pick pattern Ascending triangle(2) or Decending triangle(1): Type 1 or 2}");
		user_choice = input.nextInt();
		
		if (user_choice == 2) {
			for (int i = 1; i<= user_number; i++) {      //takes care of rows (small->lrg)
				for (int j = 1; j <= i; j++) {           //takes care of columns (small -> lrg)
					System.out.print("?");
				}
				System.out.println(); 					 //New line for every iteration
			}
		}
		else if (user_choice == 1) {					 //pattern 2
			for (int x = user_number; x > 0; x-- ) {     //takes care of rows (lrg-> small)
				for(int y = 1; y <= x; y++) {			 //takes care of columns (lrg->small)
					System.out.print("?");
				}
				System.out.println();					 //new line for every iteration
			}
		}			
	}
}
