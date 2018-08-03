/*This program prompts the user to select either to translate english into
 * morse code or vice versa. The user will be prompt to select an option and
 * input a string of text. The program will return all english values in
 * uppercase. The program will space each character when in morse code
 * form and put a "|" between each word in morse code. The code will ignore
 * punctuation. 
 * 
 */

import java.util.Scanner;

public class morse {

	public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        Scanner sent = new Scanner(System.in);

        int userChoice = 0;

        System.out.println("Type 1 to translate English to Morse or 2 to translate Morse to English");
        userChoice = input.nextInt();
        System.out.println("Enter Text for translation");
        String text = sent.nextLine().toUpperCase();	
		
        //loops jsut in case user picks value outside of choices
        while (userChoice >= 3 && userChoice <= 0)
        {
            System.out.println("ReEnter a valid value");
            userChoice = input.nextInt();
        }
        switch(userChoice)//allows for code to call method based on userChoice
        {
        case 1:
            System.out.println(Eng2Mors(text));
            break;
        case 2:
            System.out.println(Mors2Eng(text));
            break;
        default:
            System.out.println("Enter a valid value");
        }
        
        input.close();
        sent.close();
        
    }
	
	
/*The method Mors2Eng translates Morse code to English by mapping the alphabet
 * array with the Morse code array and returning the Morse code counterpart
 * for targeted letter.
 * 
 * preconditions: the parameters must be in String form
 * postconditions: The method will return the translated sequence.
 */
	
	
    public static String Mors2Eng(String text)
    {
        //splits each character with a space and stores in text2[]
        String text2[] = text.split(" ");      
        String seq = "";
        String morseAlphaNum[] = {".-" , "-...", "-.-." , "-..", "." , "..-." , "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",".----", "..---","...--","....-",".....","-....","--...","---..","----.","-----", "|"} ;
        String alphabetNum[] = {"A", "B", "C" , "D", "E", "F", "G", "H", "I" , "J" , "K" , "L", "M" , "N" , "O" , "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3" , "4", "5", "6", "7", "8", "9", "0", " "};		
        for (int j = 0; j < text2.length; j++)//runs length of text2[]
        {
            for (int i= 0; i < morseAlphaNum.length; i++)//runs length of map
            {
                //maps alphabetNum with morseAlphaNum  
                if (text2[j].equals(morseAlphaNum[i]))
                {
                   seq += alphabetNum[i];
                }
            }
        }	
        return seq;				
    }	
/*The method Mors2Eng translates English into Morse code by mapping 
 * the Morse code array with the Morse code array and returning
 * the alphabet counterpart for targeted letter.
 * 
 * preconditions: The parameters must be in String form with each character
 * separated by a space and each word separated by "|". 
 * postconditions: The method will return the translated sequence.
 */	
    public static String Eng2Mors(String text)
    {
        String seq = "";
        String morseAlphaNum[] = {".-" , "-...", "-.-." , "-..", "." , "..-." , "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",".----", "..---","...--","....-",".....","-....","--...","---..","----.","-----", "|"} ;
        String alphabetNum[] = {"A", "B", "C" , "D", "E", "F", "G", "H", "I" , "J" , "K" , "L", "M" , "N" , "O" , "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3" , "4", "5", "6", "7", "8", "9", "0", " "};		
        
        //loops through each value in text
        for (int j = 0; j < text.length(); j++)
        {   
        	//loops through each value in alphabetNum[]
            for (int i= 0; i < alphabetNum.length; i++)
            {
            	//returns string representation of a char
            	//compares with reference of alphaNum[i]
                if (String.valueOf(text.charAt(j)).equals(alphabetNum[i]))
                {     	
                    seq += morseAlphaNum[i] + " ";				
                }
            }
        }	
        return seq;		
    }
}	