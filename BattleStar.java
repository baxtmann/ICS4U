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

public class BattleStar
{
    static Console c;           // The output console
    public static String number[] = new String [101]; //Creates global array to hold " ." and record where the hits and misses happen
    public static int location[] = new int [101]; //Array that holds the random numbers
    public static int hit = 0, miss = 0, tries = 0, position = 0, row; //Declares counters for tracking the hits, misses, attempts and the row that determines users row + their position to track the users guesses
    public static String column; //Declares the String variable "column" that's used to find where the user's guess is located

    public static void main (String[] args)  //Main method
    {
	c = new Console (); //Create new console
	createArray (); //Runs the method that creates the inital array for the game
	arrayHits (); //Runs method that creates the array to generate hit locations
	for (int i = 0 ; i < 10 ; i++) //Creates a for loop that will run the program 10 times (10 user attempts) and then stops the game after
	{//start for loop
	    tries = tries + 1; //Counts how many tries the user has had
	    userInput (); //Runs method that gets users input and sets variables as global so they can be accessed by different methods
	    checkWin (); //Runs method that generates the location in the array that the user is guessing
	    winLose (); //Runs method that determines if the user hit or missed using position variable and outputs misses, guesses and number of hits used.
	}//end for loop

    } // main method


    
    
    
    
    
    
    public static void createArray ()  //Method #1 runs at the beginning of the program
    {//start method
	int number1 = 1;            //Declares variable number1 which is used as a one of the internal counters
	c.println ("");             //Outputs blankspace for seperation
	c.println ("  B A T T L E  S T A R");       //Prints out BATTLESTAR title
	c.println (" ~~~~~~~~~~~~~~~~~~~~~~~");     //Prints out the underline for the title
	c.println ("    A B C D E F G H I J");      //Prints out the columns
	c.setCursor (4, 100);       //Sets starting point to begin drawing the grid
	int counter;                //Declares "counter" variable so it can be accessed in the method
	for (int i = 0 ; i < 101 ; i++) //For loop that puts "." into all of the array spaces
	{//start for loop
	    number [i] = " ."; //Puts "." into all array spaces
	}//end for loop
	c.print (" " + number1 + " ");
	number1 = number1 + 1;
	for (counter = 1 ; counter < 101 ; counter++) //For loop that draws all periods into the grid, and breaks line every 10 characters to go down to the next line.
	{//start for loop
	    c.print (number [counter - 1]);
	    if (((counter % 10 == 0) && (number1 < 11))) //If the counter divided by 10 equals zero run the if statement below
	    {//start if statement
		c.println (""); //Prints a blank space to even out spacing
		c.print (" " + number1 + " "); //Prints a number between 1 & 9 according to the "number1" variable
		number1 = number1 + 1;

	    }//end if statement
	    if (counter == 90)//Counter for when it hits 90
	    {//start if statement
		c.setCursor (14, 1);//Reset the cursor
		c.print ("10 ");//Print 10 at the beginning of the line.
	    }//end if statement


	}//end for loop
    } //Method#1 ending


    
    
    
    
    
    
    
    
    public static void arrayDrawn (int position)  //Method#2 Runs when the user makes a guess
    {//start method 2
	int number1 = 1; //Declares variable number1 which is used as a one of the internal counters
	c.println (""); //Outputs blankspace for seperation
	c.println ("  B A T T L E  S T A R"); //Prints out BATTLESTAR title
	c.println (" ~~~~~~~~~~~~~~~~~~~~~~~"); //Prints out the underline for the title
	c.println ("    A B C D E F G H I J"); //Prints out the columns
	c.setCursor (4, 100); //Sets starting point to begin drawing the grid
	int counter; //Declares "counter" variable so it can be accessed in the method

	c.print (" " + number1 + " ");  //prints out numbers
	number1 = number1 + 1;      //adds + 1 to every number
	for (counter = 1 ; counter < 101 ; counter++) //For loop that draws all periods into the grid, and breaks line every 10 characters to go down to the next line.
	{//start for loop
	    c.print (number [counter - 1]);
	    if (((counter % 10 == 0) && (number1 < 11))) //If the counter divided by 10 equals zero run the if statement below
	    {//start if statement
		c.println (""); //Prints a blank space to even out spacing
		c.print (" " + number1 + " "); //Prints a number between 1 & 9 according to the "number1" variable
		number1 = number1 + 1;

	    }//end if statement
	    if (counter == 90)      //if counter is equal to 90
	    {//start if statement
		c.setCursor (14, 1); //set cursor to (14,1)
		c.print ("10 ");    //prints out number 10
	    }//end if statement


	}//end for loop
    } //Method#2 ending


    
    
    
    
    
    public static void arrayHits ()  //Method#3 generates 10 random numbers and sends them to places that hold numbers
    {//start method 3
     
       for (int i = 0 ; i < 10 ; i++) //For loop that runs 10 times to make 10 random numbers
	    location[i]=-1;//offset the location
       
       
       for (int i = 0 ; i < 10 ; i++) //For loop that runs 10 times to make 10 random numbers
	{//start for loop
	    int randNum = (int) (Math.random () * 100 + 1); //Generate a random number between 1 and 100.
	    location [randNum] = randNum; //Sends random numbers to array and puts them in correct array slots
	    
	    c.println(randNum);//Print the random number
	}//end for loop
    } //Method#3 ending



    public static void checkWin ()  //Method#4 determines which spot the user is guessing
    {
	if (row == 1) //If its in row 1
	    position = 0; //Sets position to 0
	if (row == 2) //If its in row 2
	    position = 10; //Sets position to 2
	if (row == 3) //If its in row 3
	    position = 20; //Sets position to 3
	if (row == 4) //If its in row 4
	    position = 30; //Sets position to 4
	if (row == 5) //If its in row 5
	    position = 40; //Sets position to 5
	if (row == 6) //If its in row 6
	    position = 50; //Sets position to 6
	if (row == 7) //If its in row 7
	    position = 60; //Sets position to 7
	if (row == 8) //If its in row 8
	    position = 70; //Sets position to 8
	if (row == 9) //If its in row 9
	    position = 80; //Sets position to 9
	if (row == 10) //If its in row 10
	    position = 90; //Sets position to 10
	if (column.equals ("a")) //If the column equals a
	    position = position; //Add one to the last position
	if (column.equals ("b")) //If the column equals b
	    position = position + 1; //Adds one to the last position
	if (column.equals ("c")) //If the column equals c
	    position = position + 2; //Adds one to the last position
	if (column.equals ("d")) //If the column equals d
	    position = position + 3; //Adds one to the last position
	if (column.equals ("e")) //If the column equals e
	    position = position + 4; //Adds one to the last position
	if (column.equals ("f")) //If the column equals f
	    position = position + 5; //Adds one to the last position
	if (column.equals ("g")) //If the column equals g
	    position = position + 6; //Adds one to the last position
	if (column.equals ("h")) //If the column equals h
	    position = position + 7; //Adds one to the last position
	if (column.equals ("i")) //If the column equals i
	    position = position + 8; //Adds one to the last position
	if (column.equals ("j")) //If the column equals j
	    position = position + 9; //Adds 10 to the last position;
    } //Method#4 ending



    public static void winLose ()  //Method#5 determines users hits or misses and reccords it, and shows it to the user
    {//start method 5
	//for (int i = 1 ; i < 101 ; i++) //for loop that compares values in the array to the users guess to see if its a hit or miss.
	//{
	    if (position == location [position]) //If position and an array number are the same, the user got a hit
	    {//start if statement
		number [position] = (" H"); //Displays an "H" in the position the user hit
		c.clear (); //Clears screen
		arrayDrawn (position); //Redraws array and changes it to show the hit
		hit = hit + 1; //Adds 1 hit if the user gets a hit
	    }//end if statement
	//}
	if (position != location [position]) //If position and the array locations[position] arent the same, the user gets a miss.
	{//Start if statement
	    number [position] = (" M"); //Displays "M" in position the user missed
	    c.clear (); //Clears screen
	    arrayDrawn (position); //Redraws array and changes it to show the miss
	    miss = miss + 1; //Add 1 miss if the user misses
	}//end if statement
	c.println (); //Prints blank space
	c.println ("Tries: " + tries + " Hits: " + hit + " Misses " + miss); //Shows how many times the user has guessed, how many times they won, and how many times they lost
    } //Method#5 ending


    public static void userInput ()  //Method#6 Gets information from user
    {//Start method 6
	c.println (""); //Adds a blank space
	c.println ("Enter the column"); //Asks user to enter a column for their guess
	column = c.readString (); //Asks for the users column and assigns it to the variable "column"
	c.println ("Enter the row"); //Asks user to enter a row for their guess
	row = c.readInt (); //Asks for the users row and assigns it to the variable "row"
    } //Method#6 ending



    public static void endGame ()  //Method#7 Ends game after user guesses 10 hits
    {//Start method 7
	if (hit == 10) //If the amount of hits = 10
	    System.exit (0); //End the program
    } //Method#7 ending
} // BattleStar class
