package Assign4;
/*This program utilizes the methods copied over from calendar.java
 * to print the calendar for a full year. The user inputs a valid year 
 * (e.g. 2012), and the program will return the calendars for each month 
 * of that year.  
 */

import java.util.Scanner;

public class RepeatCalendar 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner (System.in);
		
		int year = 0;		
		
		System.out.println("Enter a year (e.g. 2012)"); //user input
		year = input.nextInt();
		
		
		for (int j=1; j<13;j++) {		//loops for 12 months in a year	
			printMonthCalendar2(j, year);//Calls the method printMonthCalendar2
			System.out.println();				
			System.out.println();
		}
	input.close();	
	}
/*The method printMonthCalendar utilizes the methods printMonthHeader and
* printMonthBody and returns full calendar 
* 
* precondition: month must be an integer from 1-12 
* year has to be a valid year (e.g. 2012)
* postcondition: prints out a full calendar for the 
* corresponding month and year user inputed
*/
	public static void printMonthCalendar2(int month, int year) 
	{
		printMonthHeader2(month, year);
		printMonthBody2(month, year);	
	}
/*The method printMonthHeader prints the header for a calendar 
* based on the month and year the user inputs
* this method utilizes getMonthName method
* precondition: Month and Year are integers, month spans from 1-12 and 
* year is some integer
* postcondition: Prints the header for a calendar (month and year, followed by 
* a break with dotted lines followed by the days of the week.)
*/
	public static void printMonthHeader2(int month, int year) 
	{
		System.out.println("\t" + getMonthName2(month) + " " + year);
		System.out.println("----------------------------");
		System.out.println(" Sun" + " " +  "Mon" + " " + "Tue" + " " + "Wed" + " " + "Thu" + " " + "Fri" + " " + "Sat");
	}
/*The method printMonthBody prints the body of the month based on the year 
* and month the user inputs. This method utilizes getStartDay and 
* getNumDaysinMonth method.
* 	
* precondition: Month and year are integers, month spans from 1-12 and year
*  is some valid integer (e.g. 2012)
* postcondition: Method will print out the body of the calendar based on the month, 
* year, days in the month and starting day of the month (e.g. Monday)
*/
	public static void printMonthBody2(int month, int year) 
	{
		int i = 0;
		for( i = 0; i < (getStartDay2(month,year)%7); i++)//fixes shifting problem
		{        										
			System.out.print("    ");			//prevents shift of first week
		}	
		for (i = 1; i <= getNumDaysinMonth2(month,year);i++) 
		{
			if(i<10) 
			{
				System.out.print("   " + i);
			}
			else 
			{ 
				System.out.print("  " + i);
			}
			if ((i + getStartDay2(month,year)) % 7 == 0 ) {
				System.out.println();
			}
		}		
	}		
/*The method getMonthName takes integer input (1-12) and returns the 
* corresponding month name in String form.
* 
* precondition: month needs to be an integer from 1-12 
* postcondition: returns the month in String form based on the integer input
*/
	public static String getMonthName2(int month) 
	{
		switch (month) 
		{
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
/*The method getStartDay implements Zeller's Algorithm for determining the
 * day of the week the first day of the month is. The method adjusts
 * 	Zeller's number scheme for day of week (0= Saturday,...,6=Friday) to
 * conform to a day of week number that corresponds to ISO conventions
 * (i.e., 1=Monday,...,7=Sunday)
 * 
 * preconditions: The month value is some integer from 1-12 and the year is 
 * some valid year (e.g 2012)
 * postcondition: A value 1-7 is returned, representing the first day of the
 * month: 1=Monday,...,0=Sunday
 */
	public static int getStartDay2(int month, int year) 
	{	
        final int day = 1; 		

        // Adjust month number & year to fit Zeller's numbering system
        if ( month < 3 ) 
        {
            month = month + 12;
            year = year - 1;
        }
        
        int yearInCent = year % 100;  // k Calculate year within century
        int century = year / 100;     // j Calculate century term
        int firstDay  = 0;            // h Day number of first day in month 'm'
        
        firstDay = (day + (13 * (month + 1) / 5) + yearInCent +
            (yearInCent / 4) + (century / 4) + (5 * century)) % 7;
        
        // Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
        int dayNum = ((firstDay + 5) % 7) + 1;     
        
        return dayNum;
	}
/* The method getNumDaysinMonth takes the input and returns the number of days 
 * in that particular month
 * 	
 * precondition: month and year are integers
 * postcondition: based on the year and month the method will return either 
 * 31, 30, 29, or 28 as the number of days in that corresponding month
 */
	public static int getNumDaysinMonth2( int month, int year) 
	{			
		if (month ==2 ) 
		{							    //This takes care of the month of Feb.			
			if (isLeapYear2(year)) 
			{
				return 29;
			}	
			else 
			{
				return 28;	
			}
		}
		//Accounts for the day patterns found in the 11 months (Feb excluded)
		else if (month ==4 || month == 6 || month == 9 || month == 11) 
		{                
			return 30;	
		}					        
		else 
		{				
			return 31;
		}							
	}
/*The method isLeapYear determines if (int year) is a leap year, method will 
 * return result 
 * 	
 * precondition: year is a valid integer (e.g. 2012)
 * postcondition: if year can satisfy the arithmetic condition in the method, 
 * then result = true, else result = false
 */
	public static boolean isLeapYear2(int year) 
	{
		//calculation for leap years	
		boolean result =  (year%4 == 0) && ((year%100 != 0) || (year%400 == 0));
		return result;
	}
}
			
	
	

