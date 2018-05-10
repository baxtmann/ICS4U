// The "TickTackToe" class.
//Brandon Axtmann
//ICS4U Berec
//April 20 2019
import java.awt.*;
import hsa.Console;

public class TickTackToe
{
    static Console c;           // The output console
    public static int randNum1, randNum2, right0, right1, right2, down0, down1, down2, rightBottom, leftBottom, counter123 = 0, userWins, userLosses, userTies, column, row, turns; //Declare a series of varaibles globally
    public static boolean intercept, tryToWin, win, aiWin; //Declare boolean variables
    //----------------------------------------------------------------------------Varaible Breakdown---------------------------------------------------------------------------------------------------------------------------------------
    //randNum1(int) - is a random number for the row on the grid     down2(int) - represents the spot to win [0][2];[1][2];[2][2]                -column(int) - records the column location of where the user wants to go
    //randNum2(int) - is a random number for the row on the grid     rightBottom(int) - represents the right diagonal spot to win                -row(int) - records the row location of where the user wants to go
    //right0(int) - reprsents the spot to win [0][0];[0][1];[0][2]   leftBottom(int) - represensts the left diagonal spot to win                 -turns(int) - counter tracks how many times a user/computer has went
    //right1(int) - reprsents the spot to win [1][0];[1][1];[1][2]   counter123(int) - counter keeps track of how many times the AI runs         -intercept(boolean) - will let the computer know if the computer has tried to interept the user
    //right2(int) - reprsents the spot to win [2][0];[2][1];[2][2]   userWins(int) - counter keeps track of how many time the user has won       -tryToWin(boolean) - will let the computer know if the computer has tried to win the game
    //down0(int) - represents the spot to win [0][0];[1][0];[2][0]   userLosses(int) - counter keeps track of how many times the user has lost   -win(boolean) - records if the user has won the game
    //down1(int) - represents the spot to win [0][1];[1][1];[2][1]   userTies(int) - counter keeps track of how many times the user has tied     -aiWin(boolean) - records if the user has lost the game (computer wins)
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static String dataBase[] [] = new String [3] [3]; //Create dataBase 2D array (For recording X's and O's)
    public static int pointSys[] [] = new int [3] [3]; //Create pointSys 2D array (For calculating where the computer should guess)
    //---------------------------------------------------------------------------Reasoning for 2 (2D) Arrays-------------------------------------------------------------------------------------------------------------------------------
    //dataBase records empty spots with ~ and taken spots with x and o. This array gets displayed to user and is very simple. pointSys is made for the computer to understand where is should go. Empty spaces = 10 and spaces taken by
    //the user = 1 and spaces taken by the computer = 3.  Using these numbers, we can tell the spaces where the user is. For example; if the user guesses 2 spots in a row, that means there is 2 spaces where the value of the spot is
    //one, and one empty space which equals 10. So if we sum this row, it will equal 12. This makes it easier for the computer to figure out if it should block. All the computer has to look for is a spot where everything sums to
    //and that will let us know we can block the user
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void main (String[] args)
    {
	c = new Console ();
	clearDatabase (); //Run clearDatabase method which prepares all the arrays and can wipe them clean after the game has ended
	for (int z = 0 ; z < 7 ; z++) //This for loop controls how many games the user can play (7)
	{ //Open for loop

	    if (turns < 9) //If the turns are less than 9; then
	    { //Open if statement
		c.clear ();   //Clear the screen
		init (); //Run the init method
		ai (); //Run AI method which determines where the computer guesses
		checkWin (); //This checks each space to see if the user has won anywhere
		checkWins (); //This figures out the total amount of times that the user has won
	    } //Close if statement
	    else
	    { //Open else statement
		clearDatabase (); //If the game is over, then clear the dataBase and variables
	    } //Close else statement
	} //Close for loop
    } // main method


    public static void init ()  //This method shows the main gameboard to the user along with some of the user output scenarios
    { //Open init method
	c.println ("|------Tic Tac Toe------|"); //Printing on the screen
	c.println ("|    0:     1:      2:  |"); //Printing on teh screen
	c.println ("|0:  " + dataBase [0] [0] + "      " + dataBase [0] [1] + "       " + dataBase [0] [2] + "   |"); //Printing on the screen
	c.println ("|1:  " + dataBase [1] [0] + "      " + dataBase [1] [1] + "       " + dataBase [1] [2] + "   |"); //Printing on the screen
	c.println ("|2:  " + dataBase [2] [0] + "      " + dataBase [2] [1] + "       " + dataBase [2] [2] + "   |"); //Printing on the screen
	c.println ("|-----------------------|"); //Printing on the screen
	showStats (); //This method shows stats to the user about how many times they have won
	dataEntry (); //Get the users column and row
	if (dataBase [column] [row].equals ("~")) //If the space in the dataBase is empty; then allow the user to go there and set the dataBase accordingly
	{ //Open if statement
	    dataBase [column] [row] = "X"; //Set the dataBase spot where the user guessed to "X" to register that the user has went there
	    pointSys [column] [row] = 1; //Set the pointSys spot where the userr guessed to 1 to register that the user has went there
	    turns = turns + 1; //Add one to turns to signify that the user has guessed there
	} //Close if statement
	else //If the space is occupied
	{ //Open else statement
	    c.println ("Ooops that spot is already taken!"); //Tell the user the spot is taken
	    dataEntry (); //Re-run the method until the user guessed a spot that is not taken
	} //Close else statement
	c.clear (); //Clear the screen so the program can re-draw the updated version
    } //Close init method


    public static void showStats ()  //This method displays the statistics of how many times the user has won/lost/tied
    { //Open showStats method
	c.println ("Total number of games won: " + userWins); //Printing on the screen
	c.println ("Total numer of games lost: " + userLosses); //Printing on the screen
	c.println ("Total number of games tied: " + userTies); //Printing on the screen
    } //Close method


    public static void dataEntry ()  //This method gets the column and row from the user to see where they are going
    { //Open dataEntry method
	c.println ("Enter a row: "); //Printing on the screen
	column = c.readInt (); //Get the column from the user
	c.println ("Enter a column: "); //Printing on the screen
	row = c.readInt (); //Get the row from the user
    } //Close method


    public static void ai ()  //This method executes the AI portion of the program
    { //Open ai method
	counter123++; //This is a counter which counts how many times the AI has run
	if (counter123 == 1) //If this is the first time the AI is running, then there is no where for the computer to block, so just pick a random number
	{ //Open if statement
	    generateRand (); //This number generates a random number
	} //Close if statement
	sumValues (); //This method sums all of the possible wins in the game to calculate where the computer should block
	checkSpaces (); //This method checks spaces to see if the user has won
	checkAIWin (); //This method checks spaces to see if the AI has won
	turns = turns + 1; //This registers how many turns have been used
    } //Close ai method


    public static void generateRand ()  //This method generates a randdom number for the AI to guess at
    { //Open generateRand method
	randNum1 = (int) (Math.random () * 2 + 1); //Generate random number1
	randNum2 = (int) (Math.random () * 2 + 1); //Generate random number2
	if (pointSys [randNum1] [randNum2] == 10) //If the space inside pointSys array is 10; that means the space is empty, so the AI can go there
	{ //Open if statement
	    dataBase [randNum1] [randNum2] = "O"; //Set the space to "O" to show that the computer has went there
	    pointSys [randNum1] [randNum2] = 3; //Set the space to 3 to show that the computer has went there
	} //Close if statement
	else //If the space is not empty; then go again until it guesses a space that is empty
	    generateRand (); //Run the gerate random array which generates a random number fro the AI
    } //Close generateRand method


    public static void checkWin ()  //This method checks to see if the user has won against the computer
    { //Open checkWin method
	if (right0 == 3) //If this position = 3; then the user has won the game
	{ //Open if statement
	    c.println ("Yay! You beat the computer!"); //Printing on the screen
	    win = true; //Set win to true because the user has won
	} //Close if statement
	else if (right1 == 3) //If this position = 3; then the user has won the game
	{ //Open else if statement
	    c.println ("Yay! You beat the computer!"); //Printing on the screen
	    win = true; //Set win to true because the user has won
	} //Close else if statement
	else if (right2 == 3) //If this position = 3; then the user has won the game
	{ //Open else if statement
	    c.println ("Yay! You beat the computer!"); //Printing on the screen
	    win = true; //Set win to true because the user has won
	} //Close else if statement
	else if (down0 == 3) //If this position = 3; then the user has won the game
	{ //Open else if statement
	    c.println ("Yay! You beat the computer!"); //Printing on the screen
	    win = true; //Set win to true because the user has won
	} //Close else if statement
	else if (down1 == 3) //If this position = 3; then the user has won the game
	{ //Open else if statement
	    c.println ("Yay! You beat the computer!"); //Printing on the screen
	    win = true; //Set win to true because the user has won
	} //Close else if statement
	else if (down2 == 3) //If this position = 3; then the user has won the game
	{ //Open else if statement
	    c.println ("Yay! You beat the computer!"); //Printing on the screen
	    win = true; //Set win to true because the user has won
	} //Close else if statement
	else if (rightBottom == 3) //If this position = 3; then the user has won the game
	{ //Open else if statement
	    c.println ("Yay! You beat the computer!"); //Printing on the screen
	    win = true; //Set win to true because the user has won
	} //Close else if statement
	else if (leftBottom == 3) //If this position = 3; then the user has won the game
	{ //Open else if statement
	    c.println ("Yay! You beat the computer!"); //Printing on the screen
	    win = true; //Set win to true because the user has won
	} //Close else if statement
	else if (leftBottom < 3) //If this position is greater than 3; then the user has not won
	    win = false; //Set win to false because the user has not won
    } //Close checkWin method


    public static void sumValues ()  //This method will sum all of the possible places you could win so that the computer can figure out where to guess
    { //Open sumValues method
	right0 = pointSys [0] [0] + pointSys [0] [1] + pointSys [0] [2]; //Add all the values in the 0 row
	right1 = pointSys [1] [0] + pointSys [1] [1] + pointSys [1] [2]; //Add all the values in the 1st row
	right2 = pointSys [2] [0] + pointSys [2] [1] + pointSys [2] [2]; //Add all the values in the 2nd row
	down0 = pointSys [0] [0] + pointSys [1] [0] + pointSys [2] [0]; //Add all the values in the 0 column
	down1 = pointSys [0] [1] + pointSys [1] [1] + pointSys [2] [1]; //Add all the values in the 1st column
	down2 = pointSys [0] [2] + pointSys [1] [2] + pointSys [2] [2]; //Add all the values in the 2nd column
	rightBottom = pointSys [0] [2] + pointSys [1] [1] + pointSys [2] [0]; //Add all the values in the right to left diagonal
	leftBottom = pointSys [0] [0] + pointSys [1] [1] + pointSys [2] [2]; //Add all the values in the left to right diagonal
    } //Close sumValues method


    public static void checkSpaces ()  //This is the acual AI part of the program where it figues out where to go
    { //Open checkSpaces method
	if (right0 == 12) //If the right0 row has 12 that means there is 1 empty spot (Value of 10) and 2 spots where the user has went
	{ //Open if statement
	    for (int i = 0 ; i < 3 ; i++) //Run through the 3 spaces to find the spot that is empty
	    { //Open for statement
		if (pointSys [0] [i] == 10) //If the space is 10 then its empty, and the computer should take that spot
		{ //Open if statement
		    dataBase [0] [i] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
		    pointSys [0] [i] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
		    intercept = true; //Set intercept to true(Shows the computer that it has intercepted something)
		} //Close if statement
	    } //Close for statement
	} //Close if statement
	else if (right1 == 12) //If the right1 row has 12 that means there is 1 empty spot (Value of 10) and 2 spots where the user has went
	{ //Open else if statement
	    for (int i = 0 ; i < 3 ; i++) //Run through the 3 spaces to find the spot that is empty
	    { //Open for statement
		if (pointSys [1] [i] == 10) //If the space is 10 that means its empty, and the computer can take that spot
		{ //Open if statement
		    dataBase [1] [i] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
		    pointSys [1] [i] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
		    intercept = true; //Set intercept to true (Shows the computer that it has intercepted something)
		} //Close if statement
	    } //Close if statement
	} //Close else if statement
	else if (right2 == 12) //If the right2 row has 12 that means there is 1 empty spot (Value of 10) and 2 spots where the user has went
	{ //Open else if statement
	    for (int i = 0 ; i < 3 ; i++) //Run through the 3 spaces to find the spot that is empty
	    { //Open for statement
		if (pointSys [2] [i] == 10) //If the space is 10 that means that space is empty snd the computer can take that spot
		{ //Open if statement
		    dataBase [2] [i] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
		    pointSys [2] [i] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
		    intercept = true; //Set intercept to true (Shows the computer that it has intercepted something)
		} //Close if statement
	    } //Close for statement
	} //Close else if statement
	else if (down0 == 12) //If the down0 row has 12 that means there is 1 empty spot (Value of 10) and 2 spots where the user has went
	{ //Open else if statement
	    for (int i = 0 ; i < 3 ; i++) //Run through the 3 spaces to find the spot that is empty
	    { //Open for statement
		if (pointSys [i] [0] == 10) //If the space is 10 that means that space is empty and the computer can take that spot
		{ //Open if statement
		    dataBase [i] [0] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
		    pointSys [i] [0] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
		    intercept = true; //Set intercept to true(Shows the computer that it has intercepted something)
		} //Close if statement
	    } //Close for statement
	} //Close else if statement
	else if (down1 == 12) //If the down1 row has 12 that means there is 1 empty spot (Value of 10) and 2 spots where the user has went
	{ //Open else if statement
	    for (int i = 0 ; i < 3 ; i++) //Run through the 3 spaces to find the spot that is empty
	    { //Open for statement
		if (pointSys [i] [1] == 10) //If the space is 10 that meant the space is empty and the computer can take that spot
		{ //Open if statement
		    dataBase [i] [1] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
		    pointSys [i] [1] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
		    intercept = true; //Set intercept to true (Shows the computer that it has intercepted something)
		} //Close if statement
	    } //Close for statement
	} //Close else if statement
	else if (down2 == 12) //If the down2 row has 12 that means there is 1 empty spot (Value of 10) and 2 spots where the user has went
	{ //Open else if statement
	    for (int i = 0 ; i < 3 ; i++) //Run through the 3 spaces to find the spot that is empty
	    { //Open for statement
		if (pointSys [i] [2] == 10) //If the space is 10 that means the space is empty and the computer can take that spot
		{ //Open if statement
		    dataBase [i] [2] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
		    pointSys [i] [2] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
		    intercept = true; //Set intercept to true (Shows the computer taht it has intercepted something)
		} //Close if statement
	    } //Close for statement
	} //Close else if statement
	else if (rightBottom == 12) //If the rightBottom row has 12 that means there is 1 empty spot (Value of 10) and 2 spots where the user has went
	{ //Open if statement
	    if (pointSys [0] [2] == 10) //If the space is 10 that means the space is empty and the computer can take that spot
	    { //Open if statement
		dataBase [0] [2] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
		pointSys [0] [2] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
		intercept = true; //Set intercept to true (Shows the computer taht it has intercepted something)
	    } //Close if statement
	    if (pointSys [1] [1] == 10) //If the space is 10 that means the space is empty and the computer can take that spot
	    { //Open if statement
		dataBase [1] [1] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
		pointSys [1] [1] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
		intercept = true; //Set intercept to true (Shows the computer taht it has intercepted something)
	    } //Close if statement
	    if (pointSys [2] [0] == 10) //If the space is 10 that means the space is empty and the computer can take that spot
	    { //Open if statement
		dataBase [2] [0] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
		pointSys [2] [0] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
		intercept = true; //Set intercept to true (Shows the computer taht it has intercepted something)
	    } //Close if statement
	} //Close else if statement
	else if (leftBottom == 12) //If the leftBottom row has 12 that means there is 1 empty spot (Value of 10) and 2 spots where the user has went
	{ //Open if statement
	    if (pointSys [0] [0] == 10) //If the space is 10 that means the space is empty and the computer can take that spot
	    { //Open if statement
		dataBase [0] [0] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
		pointSys [0] [0] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
		intercept = true; //Set intercept to true (Shows the computer taht it has intercepted something)
	    } //Close if statement
	    if (pointSys [1] [1] == 10) //If the space is 10 that means the space is empty and the computer can take that spot
	    { //Open if statement
		dataBase [1] [1] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
		pointSys [1] [1] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
		intercept = true; //Set intercept to true (Shows the computer taht it has intercepted something)
	    } //Close if statement
	    if (pointSys [2] [2] == 10) //If the space is 10 that means the space is empty and the computer can take that spot
	    { //Open if statement
		dataBase [2] [2] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
		pointSys [2] [2] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
		intercept = true; //Set intercept to true (Shows the computer taht it has intercepted something)
	    } //Close if statement
	} //Close else if statement
	if (intercept != true) //If intercept is true then we just quick check to see if the computer can win the game instead of blocking the user
	{ //Open if statement
	    if (right0 == 16) //If right0 is 16, then there is an open space for the computer to win
	    { //Open if statement
		for (int i = 0 ; i < 3 ; i++) //Run through the 3 spaces to find the spot that is empty
		{ //Open for loop
		    if (pointSys [0] [i] == 10)
		    { //Open if statement
			dataBase [0] [i] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
			pointSys [0] [i] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
			tryToWin = true; //Set tryToWin to true; which shows us that the computer tried to win
		    } //Close if statement
		} //Close for loop
	    } //Close if statemet


	    else if (right1 == 16) //If right1 is 16, then there is an open space for the computer to win
	    { //Open else if statement
		for (int i = 0 ; i < 3 ; i++) //Run through the 3 spaces to find the spot that is empty
		{ //Open for loop
		    if (pointSys [1] [i] == 10)
		    { //Open if statement
			dataBase [1] [i] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
			pointSys [1] [i] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
			tryToWin = true; //Set tryToWin to true; which shows us that the computer tried to win
		    } //Close if statement
		} //Close for loop
	    } //Close else if statement
	    else if (right2 == 16) //If right2 is 16, then there is an open space for the computer to win
	    { //Open else if statement
		for (int i = 0 ; i < 3 ; i++) //Run through the 3 spaces to find the spot that is empty
		{ //Open for loop
		    if (pointSys [2] [i] == 10) //If pointSys is 10; that means that space is empty and the computer can take it
		    { //Open if statement
			dataBase [2] [i] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
			pointSys [2] [i] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
			tryToWin = true; //Set tryToWin to true; which shows us that the computer tried to win
		    } //Close if statement
		} //Close for loop
	    } //Close else if statement
	    else if (down0 == 16) //If down0 is 16, then there is an open space for the computer to win
	    { //Open else if statement
		for (int i = 0 ; i < 3 ; i++) //Run through the 3 spaces to find the spot that is empty
		{ //Open for loop
		    if (pointSys [i] [0] == 100) //If pointSys is 10; that means that space is empty and the computer can take it
		    { //Open if statement
			dataBase [i] [0] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
			pointSys [i] [0] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
			tryToWin = true; //Set tryToWin to true; which shows us that the computer tried to win
		    } //Close if statement
		} //Close for loop
	    } //Close else if
	    else if (down1 == 16) //If down1 is 16, then there is an open space for the computer to win
	    { //Open else if statement
		for (int i = 0 ; i < 3 ; i++) //Run through the 3 spaces to find the spot that is empty
		{ //Open for loop
		    if (pointSys [i] [1] == 10) //If pointSys is 10; that means that space is empty and the computer can take it
		    { //Open if statement
			dataBase [i] [1] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
			pointSys [i] [1] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
			tryToWin = true; //Set tryToWin to true; which shows us that the computer tried to win
		    } //Close if statement
		} //Close for loop
	    } //Close else if
	    else if (down2 == 16) //If down2 is 16, then there is an open space for the computer to win
	    { //Open else if statement
		for (int i = 0 ; i < 3 ; i++) //Run through the 3 spaces to find the spot that is empty
		{ //Open for loop
		    if (pointSys [i] [2] == 10) //If pointSys is 10; that means that space is empty and the computer can take it
		    { //Open if statement
			dataBase [i] [2] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
			pointSys [i] [2] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
			tryToWin = true; //Set tryToWin to true; which shows us that the computer tried to win
		    } //Close if statement
		} //Close for loop
	    } //Close else if
	    else if (rightBottom == 16) //If rightBottom is 16, then there is an open space for the computer to win
	    { //Open if statement
		if (pointSys [0] [2] == 10) //If pointSys is 10; that means that space is empty and the computer can take it
		{ //Open if statement
		    dataBase [0] [2] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
		    pointSys [0] [2] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
		    tryToWin = true; //Set tryToWin to true; which shows us that the computer tried to win
		} //Close if statement
		if (pointSys [1] [1] == 10) //If the pointSys is 10; that means that space empty and teh computer can take it
		{ //Open if statement
		    dataBase [1] [1] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
		    pointSys [1] [1] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
		    tryToWin = true; //Set tryToWin to true; which shows us that the computer tried to win
		} //Close if statement
		if (pointSys [2] [0] == 10) //If the pointSys is 10; that means that space is empty and the computer can take it
		{ //Open if statement
		    dataBase [2] [0] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
		    pointSys [2] [0] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
		    tryToWin = true; //Set tryToWin to true; which shows us that the computer tried to win
		} //Close if statement
	    } //Close else if
	    else if (leftBottom == 16) //If leftBottom is 16, then there is an open space for the computer to win
	    { //Open if statement
		if (pointSys [0] [0] == 10) //If the pointSys is 10; that means that space is empty and the computer can take it
		{ //Open if statement
		    dataBase [0] [0] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
		    pointSys [0] [0] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
		    tryToWin = true; //Set tryToWin to true; which shows us that the computer tried to win
		} //Close if statement
		if (pointSys [1] [1] == 10) //If the pointSys is 10; that means that space is empty and the computer can take it
		{ //Open if statement
		    dataBase [1] [1] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
		    pointSys [1] [1] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
		    tryToWin = true; //Set tryToWin to true; which shows us that the computer tried to win
		} //Close if statement
		if (pointSys [2] [2] == 10) //If the pointSys is 10; that means that space is empty and the computer can take it
		{ //Open if statement
		    dataBase [2] [2] = "O"; //Set that specific space in dataBase array to "O" so set it as taken
		    pointSys [2] [2] = 3; //Set that specific space in the pointSys array to 3 to show it is taken
		    tryToWin = true; //Set tryToWin to true; which shows us that the computer tried to win
		} //Close if statement
	    } //Close else if
	} //Close intercept else if
	if (intercept != false && tryToWin != false) //If the computer did not intercept the user and did not try to win, then we need to generate a random number as a place for the computer to guess
	{ //Open if statement
	    generateRand (); //Call teh generateRand method which generates a random number
	} //Close if statement
    } //Close checkSpaces method


    public static void checkAIWin ()  //Open checkAIWin method
    { //Open method
	if (right0 == 9) //If right is 9 that means the computer won
	{ //Open if statement
	    c.println ("Oh no! The computer beat you!"); //Print on the screen
	    aiWin = true; //set aiWin to true so the computer knows it won
	} //Close if statement
	else if (right1 == 9) //If right1 is 9 that means the computer won
	{ //Open else if
	    c.println ("Oh no! The computer beat you!"); //Print on the screen
	    aiWin = true; //set aiWin to true so the computer knows it won
	} //Close else if
	else if (right2 == 9) //If right2 is 9 that means the computer won
	{ //Open else if
	    c.println ("Oh no! The computer beat you!"); //Print on the screen
	    aiWin = true; //set aiWin to true so the computer knows it won
	} //Close else if
	else if (down0 == 9) //If down0 is 9; that menas the computer won
	{ //open else if
	    c.println ("Oh no! The computer beat you!"); //Print on the screen
	    aiWin = true; //set aiWin to true so the computer knows it won
	} //Close else if
	else if (down1 == 9) //If down1 is 9; that menas the computer won
	{ //Open else if
	    c.println ("Oh no! The computer beat you!"); //Print on the screen
	    aiWin = true; //set aiWin to true so the computer knows it won
	} //Close else if
	else if (down2 == 9) //If down2 is 9; that menas the computer won
	{ //Open else if
	    c.println ("Oh no! The computer beat you!"); //Print on the screen
	    aiWin = true; //set aiWin to true so the computer knows it won
	} //Close else if
	else if (rightBottom == 9) //If rightBottom is 9; that means the computer won
	{ //Open else if
	    c.println ("Oh no! The computer beat you!"); //Print on the screen
	    aiWin = true; //set aiWin to true so the computer knows it won
	} //Close else if
	else if (leftBottom == 9) //If leftBottom is 9; that means the computer won
	{ //Open else if
	    c.println ("Oh no! The computer beat you!"); //Print on the screen
	    aiWin = true; //set aiWin to true so the computer knows it won
	} //Close else if
    } //Close checkAIWin method


    public static void clearDatabase ()  //Create the clearDatabase method. This method clears the databases of data when the game ends
    { //Open method
	int i = 0; //Declare i variable which is a local counter
	for (i = 0 ; i < 3 ; i++) //For loop to run through the database to clear it
	{ //Open for loop
	    dataBase [0] [i] = "~"; //Set this location to clear it
	    dataBase [1] [i] = "~"; //Set this location to clear it
	    dataBase [2] [i] = "~"; //Set this location to clear it
	} //Close for loop

	int m = 0; //Delclare m variable which is a local counter
	for (m = 0 ; m < 3 ; m++) //For loop to run through the database to clear it
	{ //Open for loop
	    pointSys [0] [m] = 10; //Set this location to clear it
	    pointSys [1] [m] = 10; //Set this location to clear it
	    pointSys [2] [m] = 10; //Set this location to clear it
	} //Close for loop
	turns = 0; //Set turns back to zero to clear it of the prvious game data
    } //Close method


    public static void checkWins ()  //Create the checkWins method which checks to see who won the game
    { //Open method
	if (aiWin = false && win == false) //If no one won, that means they tied
	{ //Open if statement
	    userTies = userTies + 1; //Add one to the userTies variable
	} //Close if statement
	if (win == true) //If win is true - the the user won
	{ //Open if statement
	    userWins = userWins + 1; //Add one to the user Tties variable
	} //Close if statement
	if (aiWin = false)
	{ //Open if statement
	    userLosses = userLosses + 1; //Add one to the userLosses variable
	} //Close if statement
    } //Close method
} // TickTackToe class


