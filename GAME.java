// The "GAME" class.
//Dr. Brandon Heinz Axtmann - Professor of Memes @ Memes University
//Office hour 9-3PM Mon- Fri Except holidays
//March 6 2018
//Battle Star Program - ICS4U - Berec
//This Battle Star program is designed to mimic the famous Battleship program made by Mattel Toys.
//
//A Summary of battleship: Battleship (also Battleships or Sea Battle) is a guessing game for two players. It
//is played on ruled grids (paper or board) on which the players' fleets of ships (including battleships) are
//marked. The locations of the fleet are concealed from the other player. Players alternate turns calling
//"shots" at the other player's ships, and the objective of the game is to destroy the opposing player's
//fleet.
//
//Battleship is known worldwide as a pencil and paper game which dates from World War I. It was
//published by various companies as a pad-and-pencil game in the 1930s, and was released as a plastic
//board game by Milton Bradley in 1967. The game has spawned electronic versions, video games, smart
//device apps and a film.
//
//This program that is going to be made in java will have some fundamental changes to make it
/*appropriate for grade 12 student to be working on. The students will make a 10x10 grid made from "."
Using an array. Above and beside the grid, they will label the values for the rows and columns. In a
sperate array, the user will generate 10 random numbers between 1 and 10 and put them into a
separate array. The program will then ask the user for its guess (a row guess and a column guess) and
then use if statement to determine wither it's a hit or not. Once that is determined, the program will
redraw the program indicating where the hit or miss occurred. From there, the program will keep track
of wins, losses, and overall attempts. The program will give the user 10 tries before it ends the game.
This program will utilize methods to keep the main method clean, and utilize global variables to ensure
that variables can be accessed by all methods that require to use them. This program will also include
about 300% more internal documentation than industry standards require. This industry standard is
taken from the ISO/IEC committee ISO/IEC 18019:2004 - Guidelines for the design and preparation of
user documentation for application software, an international standard for user documentation.*/

import java.awt.*;
import hsa.Console;

public class GAME
{
    static Console c;           // The output console
    public static int hit = 0, miss = 0, tries = 0, row, position = 0; //Declare 3 counters to track hits, misses, and attempts. Also decalres row for determineing users row + position which tells us where the user is guessing
    public static String column; //Declare String varaibles "coloum" which is used to find out what coloum the user's guess is in
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void main (String[] args)  //Main method
    {
	c = new Console (); //Create new console
	createArray (); //Run method to create the inital array

	for (int x = 0 ; x < 10 ; x++) //For loop to run the program 10 times (User has 10 attempts) and then stops running
	{ //Start of for loop
	    tries = tries + 1; //Count how many tries the user uses
	    arrayWithHits (); //Runs the method that runs the array that generates the hit locations
	    userInput (); //Runs the method that gets the user input and puts it in global variables to be accessed by other methods
	    checkForWin (); //Runs the method full of if statements to generate the location in the array that the user is guessing
	    winOrLose (); //Runs the method that determines wether the user has hit or if they missed using the position variable. Also prints the number of hits, misses and and guesses that user has used.
	} //End of for loop

    } // main method


    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void createArray ()  //createArray ---Method #1 (Runs only once at the beginning of the program)
    {
	int number1 = 2; //Declare variable number1 as a variable that can be accessed anywhere inside this method. Number 1 will be one of the internal counters for this method.
	c.println (""); //Print a single line
	c.println ("   B A T T L E  S T A R"); //Print battlestar
	c.println ("---------------------------"); //Print a line of dashes
	c.println ("   A B C D E F G H I J"); //Print the coloums
	c.setCursor (4, 100); //Set the cursor to begin drawing the grid out
	int counter; //Declare counter variable as a variable that can be accessed anywhere inside this method. Counter will be on if the internal counters for this method.
	c.print ("1 ");
	for (int i = 0 ; i < 100 ; i++) //For loop to put "." into all of the spaces in the array
	{ //Start of loop
	    number [i] = " ."; //Put the " ." into all spaces in the array
	} //end loop

	for (counter = 1 ; counter < 101 ; counter++) //For loop to draw all of the periods into the chart, and break the line every 10 charecters and go to the next line.
	{
	    c.print (number [counter - 1]);
	    if (((counter % 10) == 0) && (number1 < 11))
	    {
		c.println ();
		c.print (number1 + " ");
		number1 = number1 + 1;
	    }


	    if (counter == 90) //if counter is 90, run this if statement
	    { //Start of if statement
		c.println (number [counter]);
		c.setCursor (14, 1); //Set cursor to this location, which is where the 10th line would begin
		c.print ("10"); //print the number 10 before we continue drawing the grid
	    } //end of if statement
	}

    } //End method # 1


    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void arrayAgain (int position)  //arrayAgain ---Method #2 (Runs whenever the user makes a guess) This method is almost the same as method #1, but the difference is that this method does not write " ." to the array so that
    { //Start Method #2                          //it does not overwrite the array.

	int number1 = 2; //Declare variable number1 as a variable that can be accessed anywhere inside this method. Number 1 will be one of the internal counters for this method.
	c.println (""); //Print a single line
	c.println ("   B A T T L E  S T A R"); //Print battlestar
	c.println ("---------------------------"); //Print a line of dashes
	c.println ("   A B C D E F G H I J"); //Print the coloums
	c.setCursor (4, 100); //Set the cursor to begin drawing the grid out
	int counter; //Declare counter variable as a variable that can be accessed anywhere inside this method. Counter will be on if the internal counters for this method.
	c.print ("1 ");
	


	    for (counter = 1 ; counter < 101 ; counter++) //For loop to draw all of the periods into the chart, and break the line every 10 charecters and go to the next line.
	    {
		c.print (number [counter - 1]);
		if (((counter % 10) == 0) && (number1 < 11))
		{
		    c.println ();
		    c.print (number1 + " ");
		    number1 = number1 + 1;
		}


		if (counter == 90) //if counter is 90, run this if statement
		{ //Start of if statement
		    c.println (number [counter]);
		    c.setCursor (14, 1); //Set cursor to this location, which is where the 10th line would begin
		    c.print ("10"); //print the number 10 before we continue drawing the grid
		} //end of if statement
	    }
    } //End method #2


    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static String number[] = new String [101]; //Creating a global array that will hold the initial array of " ." and evenutaually will record where hits and misses occur

    public static int locations[] = new int [101]; //The array that will hold the random numbers
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void arrayWithHits ()  //Method #3 - arrayWithHits will generate 10 random numbers and send them to locations array which will hold the random numbers
    { //Start of method #3
	for (int i = 0 ; i < 10 ; i++) //For loop that will run 10 times to generate 10 random numbers
	{ //Start of for loop
	    int randNum = (int) (Math.random () * 100 - 1 + 1 + 1); //Generate a random number between 1 and 100.
	    locations [randNum] = randNum; //Send the random numbers to the array and put the in the proper slot in the array
	} //End of for loop
    } //End of method #3


    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void checkForWin ()  //Method #4 will check to determine the spot on which the user is guessing so that it can be handled by the array
    { //Start of method #4
	if (row == 1) //If row is row 1, run
	    position = 0; //Set position to zero
	if (row == 2) //If row is row 2, run
	    position = 10; //Set position to 2
	if (row == 3) //If row is row 3, run
	    position = 20; //Set position to 3
	if (row == 4) //If row is row 4, run
	    position = 30; //Set position to 4
	if (row == 5) //If row is row 5, run
	    position = 40; //Set position to 5
	if (row == 6) //If row is row 6, run
	    position = 50; //Set position to 6
	if (row == 7) //If row is row 7, run
	    position = 60; //Set position to 7
	if (row == 8) //If row is row 8, run
	    position = 70; //Set position to 8
	if (row == 9) //If row is row 9, run
	    position = 80; //Set position to 9
	if (row == 10) //If row is row 10, run
	    position = 90; //Set position to 10
	if (column.equals ("a")) //If column equals a, run
	    position = position;  //Add one to the previous value of position
	if (column.equals ("b")) //If column equals b, run
	    position = position + 2; //Add 2 to the previous value of position
	if (column.equals ("c")) //If column equals c, run
	    position = position + 3; //Add 3 to the previous value of position
	if (column.equals ("d")) //If column equals d, run
	    position = position + 4; //Add 4 to the previous value of position
	if (column.equals ("e")) //If column equals e, run
	    position = position + 5; //Add 5 to the previous value of position
	if (column.equals ("f")) //If column equals f, run
	    position = position + 6; //Add 6 to the previous value of position
	if (column.equals ("g")) //If column equals g, run
	    position = position + 7; //Add 7 to the previous value of position
	if (column.equals ("h")) //If column equals h, run
	    position = position + 8; //Add 8 to the previous value of position
	if (column.equals ("i")) //If column equals i, run
	    position = position + 9; //Add 9 to the previous value of position
	if (column.equals ("j")) //If column equals j, run
	    position = position + 10; //Add 10 to the previous value of position;
    } //End of method #4


    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void winOrLose ()  //Method #5 will determine if the user hit or missed, and reccord that to the according variable, and will then tell the user.
    { //Start method #5
	for (int z = 0 ; z < 100 ; z++) //for loop will run 100 times, to allow us to compare every value in the array to the users guess to see if the hit or miss.
	{ //Start of for loop
	    if (position == locations [z]) //If the position and one of the numbers in the locations array are the same, that means the user hit.
	    { //Start if statement
		number [position] = (" H"); //Put an "H" in that position to show that the user has hit.
		c.clear (); //Clear the screen
		arrayAgain (position); //Redraw the array with changes to the array to signify the miss.
		hit = hit + 1; //add 1 to hit if the user hit.
	    } //End if statement
	} //End for loop
	if (position != locations [position]) //If the position and locations[position] are not the same, then the user missed.
	{ //Start if statement
	    number [position] = (" M"); ////Put an "M" in that position to show that the user missed.
	    c.clear (); //Clear the screen
	    arrayAgain (position); //Redraw the array with changes to the array to signify the miss.
	    miss = miss + 1; //Add 1 to miss if the user missed.
	} //End if statement
	c.setCursor(20,10);
	c.println (""); //Print a space
	c.println ("Tries: " + tries + " Hits: " + hit + " Misses " + miss); //Show the user how many times they have guessed so far, how many times won, and how many times lost.
    } //End method #5


    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void userInput ()  //Method #6 Get the information for the user (get the guess)
    { //Start method #6
	c.setCursor (15, 1);
	c.println (""); //Add a space
	c.println ("Enter the column"); //Ask for the users column guess
	column = c.readString (); //Get the users column guess and assign it to the column variable
	c.println ("Enter the row"); //Ask the user for the row guess
	row = c.readInt (); //Get the users row guess and assign it to the row variable
    } //End Method #6


    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void endGame ()  //Method #7 - If the user guesses all 10 hits, then end the game
    { //Start method #7
	if (hit == 10) //If the value of hits
	    System.exit (0); //This will end the program
    } //End method #7
} // GAME class


