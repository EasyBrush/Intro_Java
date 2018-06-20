//Note: check to see if method descriptions are all written out




import java.util.Scanner;

public class calendar {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int month = 0;
		int year = 0;		
		
		System.out.println("Enter a month (1-12)");
		month = input.nextInt();
		System.out.println("Enter a year (e.g. 2012)");
		year = input.nextInt();
		

		//printMonthBody(month, year);           //X
		printMonthCalendar(month, year);
		
	}	
		
	public static void printMonthCalendar(int month, int year) {
		printMonthHeader(month, year);								//uses printMonthHeader method to print header 
		printMonthBody(month, year);								//uses printMonthBody method to print body
		
	}
	
/*The method printMonthHeader prints the header for a calendar based on the month(int) and year(int) the user inputs
 * this method utilizes getMonthName method
 * 
 * precondition: Month and Year are integers, month spans from 1-12 and year is some integer
 * postcondition: Prints the header for a calendar (month and year, followed by a break with dotted lines followed by the days of the week.)
 */
	public static void printMonthHeader(int month, int year) {

		System.out.println("\t" + getMonthName(month) + " " + year);
		System.out.println("----------------------------");
		System.out.println(" Sun" + " " +  "Mon" + " " + "Tue" + " " + "Wed" + " " + "Thu" + " " + "Fri" + " " + "Sat");
		
	}
	
	public static void printMonthBody(int month, int year) {
		int i = 0;
		for( i = 0; i < (getStartDay(month,year)%7); i++) {										//accounts for when getStartDay = 7, easier to use %
			System.out.print("    ");														    //prevents shift of first week
		}	
		for (i = 1; i <= getNumDaysinMonth(month,year);i++) {
			if(i<10) {
				System.out.print("   " + i);
			}
			else { 
				System.out.print("  " + i);
			}
			if ((i + getStartDay(month,year)) % 7 == 0 ) {
				System.out.println();
			}
		}		
	}	
		//below is the first attempt, above is a more compact version. 			
		/*for (int i = 0; i < getStartDay(month,year); i++) {											//For loop prints spaces up until the startoftheday	
			System.out.print("    ");
		}	
		for (int j = 1; j <= getNumDaysinMonth(month , year); j++ ) {								    //Prints the date on the calendar up until the last date

			
			if ((getStartDay(month,year) + j) % 7 == 0) {
				if (j<10) {
					System.out.println("   " + j);
				} 				
				else {
					System.out.println("  " + j);								
				}
			}
			else {
				if (j<10)  
					{ System.out.print("   " + j); }
				
				else
					{System.out.print("  " + j); }				
			}			
		}	*/	
	//}
	
	
	
	
	
/*The method getMonthName takes integer input (1-12) and returns the corresponding month name in String form.
 * 
 * precondition: month needs to be an integer from 1-12 
 * postcondition: returns the month in String form based on the integer input
 */
	public static String getMonthName(int month) {
	
		switch (month) {
		case 1: 
			return "Janurary";
		case 2: 
			return "Feburary";
		case 3: 
			return "March";
		case 4: 
			return "April";
		case 5: 
			return "May";
		case 6: 
			return "June";		
		case 7: 
			return "July";
		case 8: 
			return "August";		
		case 9: 
			return "September";
		case 10: 
			return "October";
		case 11: 
			return "Novemeber";
		case 12: 
			return "December";
		default: 
			return "Invalid Month";
		}	
		
	}
	
	public static int getStartDay(int month, int year) {												//look at, was provided
        final int day = 1; 																				// Must be set to day 1 for this to work.  JRD.


        																								// Adjust month number & year to fit Zeller's numbering system
        if ( month < 3 ) 
        {
            month = month + 12;
            year = year - 1;
        }
        
        int yearInCent = year % 100;      																// k Calculate year within century
        int century = year / 100;      																	// j Calculate century term
        int firstDay  = 0;            																	// h Day number of first day in month 'm'
        
        firstDay = (day + (13 * (month + 1) / 5) + yearInCent +
            (yearInCent / 4) + (century / 4) + (5 * century)) % 7;
        
        																								// Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
        int dayNum = ((firstDay + 5) % 7) + 1;     
        
        return dayNum;
	}
	
	
/* The method getNumDaysinMonth takes the input and returns the number of days in that particular month
 * 	
 * precondition: month and year are integers
 * postcondition: based on the year and month the method will return either 31, 30, 29, or 28 as the number of days in that corresponding month
 */
	public static int getNumDaysinMonth( int month, int year) {
				
		if (month ==2 ) {													 //This takes care of the month of Feb.			
			if (isLeapYear(year)) {
				return 29;
			}	
			else {
				return 28;	
			}
		}
		else if (month ==4 || month == 6 || month == 9 || month == 11) {     //There is a known pattern for month !=2, in which the number of days in 
			return 30;													     //specific months are already predetermined, since months can only have either 30,31,28, or 29 days	
		}																     //a series of short circuit or statement will suffice		
		else {
			return 31;
		}	
						
	}
	
/*The method isLeapYear determines if (int year) is a leap year, method will return result
 * 	
 * precondition: year is an integer
 * postcondition: if year can satisfy the arithmetic condition in the method, then result = true, else result = false
 */
	public static boolean isLeapYear(int year) {
			
		boolean result =  (year%4 == 0) && ((year%100 != 0) || (year%400 == 0));
		return result;

		
	}
}
