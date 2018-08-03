/*Program: This program is a simple terminal based pacman game. There is a
 * total of 5 commands the user is given to chose from. Command 1 and 2
 * rotates the token counter-clockwise and clockwise respectively. 
 * Command 0 brings up a command window, command 3 moves the token in the
 * direction its face 1 space and clears previous space with " " , and
 * command 4 prints game statistics and exits the program. 
 * 
 * 
 */


import java.util.Random; //so i can use the "distinct" function
import java.util.Scanner;

public class PACman {
    int position_row = 0;//position of pacman
    int position_column = 0;//position of pacman
    String gameGrid[][]; //makes gameGrid global, saves grid
    double moves = 0.0; //keeps count of moves made
    double CookieNum = 0.0;//keeps count of cookies eaten
    
    public static void main(String[] args) 
    {
        int x = 0;
        int y = 0;
        int userInput1 = 0;
        PACman pacman = new PACman(); //creates new object


        Scanner input = new Scanner (System.in);
        //initial prompt
        System.out.println("Enter Matrix Size");
        System.out.print("X:");
        x = input.nextInt();
        System.out.print("Y:");
        y= input.nextInt();
        
        System.out.println("Welcome to PacMan!");
        System.out.println("Enter the number of the command desired.");
        System.out.println("Display Commands <0>: ");
        System.out.println("Turn Left <1>: ");
        System.out.println("Turn Right <2>: ");
        System.out.println("Move <3>: ");
        System.out.println("Exit <4>: ");
        
        //initializes grid 
        pacman.initializeGrid(x, y);              
        pacman.cookiePlacer(pacman.Cooki(.08));//random cookies at 8%
        pacman.gridPrint();//prints grid
        System.out.println("Command: ");
        userInput1 = input.nextInt();

        //loops for all cases & possible invalid entries
        while(userInput1  !=4) 
        {
            pacman.getOrientation(userInput1);
            pacman.makeMove(userInput1);
            pacman.gridPrint();           
            System.out.print("command:");
            userInput1 = input.nextInt();           
            getMenu(userInput1);
            System.out.println();
        }
        pacman.gameOver(userInput1);
        input.close();
    }

/*The method getMenu displays the command menu when userInput1 == 0, and
 * does nothing for case 1,2,3,& 4. This is so default can display when
 * a command outside the given options is selected.
 * 
 * precondition: userInput1 must be an integer.
 * postcondition: displays command menu, or default depending on userInput1
 ******************************************************************/
        public static void getMenu(int userInput1)
        {            
            switch (userInput1)
            {
            case 0://command 0, shows command options              
                System.out.println("Enter the number of the command desired.");
                System.out.println("Display Commands <0>: ");
                System.out.println("Turn Left <1>: ");
                System.out.println("Turn Right <2>: ");
                System.out.println("Move <3>: ");
                System.out.println("Exit <4>: ");
                break;
            case 1: //prevents default from running when commands are entered
                break;
            case 2:
                break;               
            case 3:
                break;
            case 4:                
                break;
            default:
                System.out.println("Invalid Command please Try again!");
                break;              
            }			
        }
               	
/*The method initializeGrid sets up a basic x by y matrix with pacman
 * and ".", but no cookies
 * 
 * precondition: x and y must be ints
 * postcondition: returns a grid x by y with a token in [0][0] and "." 
 * all else 
 **********************************************************************/
        public void initializeGrid(int x, int y) 
        {
            //generates X by Y matrix filled with "."
            String Grid[][] = new String[x][y];
            for(int i=0; i< x; i++)
            {
                for(int j =0; j< y; j++)
                {
                    Grid[i][j] = ".";        
                }   
            }
            Grid[0][0] = ">";//places token at [0][0] 
                      
            //sets Grid to global object gameGrid 
            //no need to have method to save gameGrid         
            gameGrid = Grid;          
        }
		      
/*The method gridPrint prints gameGrid
 *
 *precondition: gameGrid must be initialized using initializeGrid method 
 *postcondition: prints gameGrid
 *******************************************************************/
        public void gridPrint()
        {
            for(int i=0; i< gameGrid.length; i++)
            {
                for(int j =0; j< gameGrid[0].length; j++)
                {
                    System.out.print(gameGrid[i][j]);        
                }  
                System.out.println();
            }
        }

/*The method Cooki utilizes the methods distinct, limit, ints
 * and random from random and math class and toArray from array class to
 * generate a unique random integer from 1- last index of the matrix to
 * be used as an index for which a cookie will be placed. The list of index
 * will be stored in the array toCookie. This method calls from math to use
 * the floor method which rounds a value down to the nearest integer.
 * 
 * precondition: percent is a double (decimal form) and entered when calling
 * method
 * postcondition: returns an int[] array toCookie that holds the index
 * values, with respect to the matrix. 
 *               
 ***************************************************************************/
        public int[] Cooki(double percent)
        {
           //total number of cells in gameGrid 
           int Totalcells = gameGrid.length * gameGrid[0].length;
           //Total number of cookies (8% of grid rounded down)
           int NumCooki = (int) (Math.floor(percent * Totalcells));
           
           /*toCookie is an array that gets a unique random integer from 
            * 1 to the number of cells in the matrix. The array is the 
            * index value of a specific point within the matrix. The index
            * is counted with respect to the entire matrix.
            * The max number of elements in the array is determined by
            * the limit of the total number of cookies allowed.       
            */
           
           int[] toCookie = new Random().ints(1,Totalcells).distinct().limit(NumCooki).toArray();       
           return toCookie;     
        }

/*The method cookiePlacer re-calculates the index from toCookie into a [][]
 * form and places a cookie in the array using the new indexes. This
 * method calls from math to use the floor method which rounds a value
 * down to the nearest integer.
 *
 *precondition: toCookie must be an int array holding valid indexes with 
 *respect to the entire matrix. 
 *postcondition: converts the values in toCookie to indexes in [][] form
 *and places a cookie in said location
 *
 **************************************************************************/       
        public String[][] cookiePlacer(int [] toCookie)
        {
            //dependent on total number of cookies
            for (int x = 0; x < toCookie.length; x++)
            {
                for(int i = 0; i < gameGrid.length; i++) //rows
                {
                    for (int j = 0; j < gameGrid[0].length; j++) //cols
                    {
                        //calculates for the column cookie belongs in based
                        //on index from toCookie[]
                        int col = toCookie[x] % gameGrid[0].length;
                        
                        //calculates for the row cookie belongs in based 
                        //on index from toCookie[]
                        int row = (int) (Math.floor(toCookie[x]/gameGrid[0].length));                      
                        
                        gameGrid[row][col]="O";
                    }
                }
            }             
            return gameGrid;
        }
        
        
/*The method makeMove moves the pacman according to the direction its facing
 * taking count of the move made, cookies eaten. This method will also replace
 * the previously occupied space with " " and the newly occupied space with
 * a pacman token.
 * 
 * precondition: pacman must have an orientation
 * postcondition: pacman will move one space followed by a count of the move
 * made, cookies eaten (if space had cookie), and taken space is replaced by
 * the pacman token and the previously occupied space is replaced with a " ".        
 *************************************************************************/
        public String makeMove(int userInput1)
        {// >, 1: counterclockwise, 2:clockwise, 3 move in direction facing
         //if move off grid-> try again   
            if (userInput1 == 3)
            {
                switch (gameGrid[position_row][position_column])
                {
                case ">":
                    //off map feature, if pacman goes off map, 
                    //code will prompt to try again.
                    if ((position_row >= 0) && (position_column > 0))
                    {
                        //replaces moved space with " ".
                        gameGrid[position_row][position_column] = " ";
                        //adjusts location of pacman
                        position_column = position_column-1;
                        //if pacman encounters cookie
                        if (gameGrid[position_row][position_column].equals("O"))
                        {
                            CookieNum += 1;
                        }
                        gameGrid[position_row][position_column] = ">";
                        moves += 1;
                    }
                    else
                    {
                        //map out option to redo. 
                        System.out.println("Invalid Entry try again!");
                        moves +=1;
                    }
                    //same concept throughout method with minor adjustments
                    //for different cases. 
                    break;
                    
                case "V":
                    //off map feature, if pacman goes off map, 
                    //code will prompt to try again.
                    if ((position_row > 0) && (position_column >= 0))
                    {
                        gameGrid[position_row][position_column] = " ";
                        position_row = position_row - 1;
                        if (gameGrid[position_row][position_column].equals("O"))
                        {
                            CookieNum += 1;
                        }
                        gameGrid[position_row][position_column] = "V";
                        moves += 1;
                    }
                    else
                    {
                        System.out.println("Invalid Entry try again!");
                        moves +=1;
                    }
                    break;
                    
                case "^"://down
                    //off map feature, if pacman goes off map, 
                    //code will prompt to try again.
                    if ((position_row < gameGrid.length-1) && (position_column >= 0))
                    {                     
                        gameGrid[position_row][position_column] = " ";
                        position_row = position_row + 1;
                        if (gameGrid[position_row][position_column].equals("O"))
                        {
                            CookieNum += 1;
                        }
                        gameGrid[position_row][position_column] = "^";
                        moves += 1;
                    }
                    else
                    {
                        System.out.println("Invalid Entry try again!");
                        moves +=1;
                    }

                    break;
                    
                case "<":
                    //off map feature, if pacman goes off map, 
                    //code will prompt to try again.
                    if ((position_column < gameGrid[0].length-1))
                    {
                        gameGrid[position_row][position_column] = " ";
                        position_column = position_column + 1;
                        if (gameGrid[position_row][position_column].equals("O"))
                        {
                            CookieNum += 1;
                        }
                        gameGrid[position_row][position_column] = "<";
                        moves += 1;
                    }
                    else
                    {
                        System.out.println("Invalid Entry try again!");
                        moves +=1;
                    }
                    break;
                }
            }
            return gameGrid[position_row][position_column];
        }

        
/*The method getOrientation adjusts the orientation of the token pacman.
 * The method adjusts bases on current pacman orientation, "<","^",">"
 * and "V" and userinput1, 1 or 2. 
 *
 *precondition: pacman must already have a orientation and userinput must
 *be valid (1 or 2)
 *postcondition: based on current orientation and userinput1, pacman's 
 *direction is changed.         
 ************************************************************************/
        public String getOrientation(int userInput1)
        {
            if (gameGrid[position_row][position_column].equals(">"))
            {
                if (userInput1 == 1 )
                {
                    gameGrid[position_row][position_column] = "^";
                }
                else if (userInput1 == 2 )
                {
                    gameGrid[position_row][position_column] = "V";
                }
            }
            else if (gameGrid[position_row][position_column].equals("^"))
            {
                if (userInput1 == 1)
                {
                    gameGrid[position_row][position_column] = "<";
                }
                else if (userInput1 == 2)
                {
                    gameGrid[position_row][position_column] = ">";
                }
            }
            else if (gameGrid[position_row][position_column].equals("<"))
            {
               if (userInput1 == 1)
               {
                   gameGrid[position_row][position_column] = "V";
               }
               else if (userInput1 ==2 )
               {
                   gameGrid[position_row][position_column] = "^";
               }                               
            }
            else if (gameGrid[position_row][position_column].equals("V"))
            {
                if (userInput1 == 1)
                {
                    gameGrid[position_row][position_column] = ">";
                }
                else if (userInput1 == 2)
                {
                    gameGrid[position_row][position_column] = "<";
                }
            }
            return gameGrid[position_row][position_column];
        }
/*The method gameOver prints out the game statistics
 * 
 * preconditions: userInput has to equal 4
 * postconditions: prints out game statistics
 *************************************************************************/
        public void gameOver(int userInput1)
        {//when option 4 is hit, want to disp stats and break.
            if (userInput1 == 4)
            {
                double CookiePerMove = CookieNum/moves;
                System.out.println("#Moves: " + moves  + " #Cookies eaten: " + CookieNum + " #Moves per cookie: " + CookiePerMove );
                System.out.println();
                System.out.println("Bye! Bye!");
            }
        }
        
        

}
