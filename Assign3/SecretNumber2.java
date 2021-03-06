package Assign3;
/*Program: User guesses a secret number between 1 and N. N is generated by the user. Program will prompt user 
 *         for the max number of guesses user wants to make. Each time a user makes a guess, program will
 *         respond with "correct, "too low", or "too high". Program keep track of number of guesses. 
 *         Continue until number has been discovered or max number of guesses have been made.
 *         Program will have a "play again" feature and the ability to decline
 *         Secret number generated by program 
*/

import java.util.Scanner;

public class SecretNumber2 {

	public static void main(String[] args) {
		
		
		
		int N = 0;																					//Variables used in the program
		int Attempt = 0;																			//The string YorN is for the replay feature
		int guess = 0;
		String YorN;
		Boolean replay = true;
		
		
		Scanner input = new Scanner(System.in);

		
		while (replay = true) {																		//Made giant while loop to loop actual game, then the body for the conditions
			
			System.out.println("Enter a number N");													//Prompts and stores input for variables			
			N = input.nextInt();
			System.out.println("Enter the number of attempts you would like to make");
			Attempt = input.nextInt();
			
			int randomNumber = (int)(N * Math.random())+1; 											//uses Math to generate random integer from 1 to N+1, to be inclusive
			
			System.out.println("Make your guess");													//Prompts for guess
			guess = input.nextInt();
			for (int i = 2; i<= Attempt; i++) {														//For loop to deal with counts for the attempts made as well as the	
				if (guess == randomNumber) {														//conditional results based on the guess entered, i = 2 because guess initialized once outside the loop 
					System.out.println("correct");
					i = Attempt;																	//Without this the code would print "correct" for the remainder of attempts available
				}
				else if (guess > randomNumber) {													//Rest of the body for for loop will prompt for another input to keep the loop running
					System.out.println("too high");													//until either all attempts have been made or correct answer have been found
					System.out.println("try again");
					guess = input.nextInt();
				}
				else if (guess < randomNumber) {
					System.out.println("too low");
					System.out.println("try again");
					guess = input.nextInt();
				}
			}
			System.out.println("Play again? Press Y to replay or enter another key to exit!!");		//This is outside the for loop and within the while loop so that the replay feature works 
			YorN = input.next();																	//Allows for input of strings
			
			if (YorN.equals("Y") || YorN.equals("y")) {												//Had to set boolean value, so Y or y will be true, so if the string entered is either Y or y		
				replay = true;																		//result will be true
			}
			else {
				replay = false;																		//Any other value entered will be false, forcing program to break
				break;
			}
		}				
	}
}
