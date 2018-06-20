package Assign2;
/******************************************************************** 
Purpose: Have the user input 6 integers separated by spaces and displayed  
         in a table. The last row and column of the table will be the sum    
         of their respective row or column.
 ********************************************************************/
import java.util.Scanner;

public class Module2Start {
	 public static void main( String [] args )
	    {
	        // Define and initialize variables for values to be input
	        int userNum1 = 0;
	        int userNum2 = 0;
	        int userNum3 = 0;
	        int userNum4 = 0;
	        int userNum5 = 0;
	        int userNum6 = 0;
	        
	        int ColSum1 = 0;
	        int ColSum2 = 0;
	        
	        int RowSum1 = 0;
	        int RowSum2 = 0;
	        int RowSum3 = 0;
	        
	        
	        // Use a Scanner to input integer values
	        Scanner input = new Scanner( System.in );
	        System.out.println( "\n\n" );
	        System.out.print( "Enter 6 integers separated by a blank space:" );
	        userNum1 = input.nextInt();     // Input first value
	        userNum2 = input.nextInt();     // Input second value
	        userNum3 = input.nextInt();     // Input third value
	        userNum4 = input.nextInt();     // Input fourth value
	        userNum5 = input.nextInt();     // Input fifth value
	        userNum6 = input.nextInt();     // Input sixth value
	        
	        
	        ColSum1 = userNum1 + userNum3 + userNum5; //Sum of the columns
	        ColSum2 = userNum2 + userNum4 + userNum6;
	       
	        RowSum1 = userNum1 + userNum2;			  //Sum of the rows	
	        RowSum2 = userNum3 + userNum4;
	        RowSum3 = userNum5 + userNum6;
	        int ColSum3 = RowSum1 + RowSum2 + RowSum3; //Sum of the last row with totals. 
	        
	        // Display the table.
	        System.out.println( "\n\n" );
	        System.out.println( "\t" + "Value" + "\t" + "Value" + "\t" + "Total");
	        System.out.println( "\t" + userNum1 + "\t" + userNum2 + "\t" + RowSum1);
	        System.out.println( "\t" + userNum3 + "\t" + userNum4 + "\t" + RowSum2);
	        System.out.println( "\t" + userNum5 + "\t" + userNum6 + "\t" + RowSum3);
	        System.out.println("\t" + "---------------------");
	        System.out.print("Total");
	        System.out.println("\t" + ColSum1 + "\t" + ColSum2 + "\t" + ColSum3);
	        System.out.println( "\n\n" );
	    }

}
