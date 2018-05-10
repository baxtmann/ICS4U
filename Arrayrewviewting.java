//                 The "ArrayReviewExercise" class.
//                          Brandon Axtmann
//                           March 13, 2018
//                              ICS4U
import java.awt.*;
import hsa.Console;

public class ArrayReviewExercise
{
    static Console c;           // The output console

    public static String userAnswer;                    //creates variable for users answer 
    public static String userChoice;                    //creates variable for users choice to select another option
    public static int userColumns;                      //creates variable for displaying users choice of columns in the array
    public static int randNum;                          //creates variable for a random number
    public static int arraySize;                        //creates variable for the size of the array created
    public static int number[] = new int [21];          //creates variable for amount of numbers in array
    public static int randomNumbers[] = new int [20];   //creates variable for amount of random numbers in array
    public static int tempVariable;                     //creates variable for a temporary variable
    public static int newNumber[] = new int [20];       //creates variable for new numbers in array

    public static void main (String[] args)
    {
	c = new Console ();


	//Main output
	initialize ();       //loads the array
	mainMenu ();        //shows the main menu

    } // main method


    public static void initialize ()        //method used to load in the array
    {

	arraySize = 21;     //sets array size to 21

	for (int i = 0 ; i < arraySize ; i++)       //for statement to create the array
	{
	    randNum = (int) (Math.random () * 100 - 1 + 1 + 1); //gets random numbers
	    number [i] = randNum;       //prints out random numbers from 1 to 21
	}


	userAnswer = "";    //sets users first answer to blank
    }


    public static void mainMenu ()      //Method used to displat main menu
    {
	c.setTextColor (Color.red);     //set colour to red
	c.println ("The Array Review Program");     //displays title
	c.println ("~~~~~~~~~~~~~~~~~~~~~~~~");     //underline for title
	c.println ();   //creates blank space below title
	c.setTextColor (Color.black);   //sets colour to black
	c.println ("Choose 1 of the following options: ");  //displays the following sentence on the screen
	c.println ("1. View the array");        //displays option 1 on the screen
	c.println ("2. Output the largest and smallest array elements");    //displays option 2 on the screen
	c.println ("3. Sort the array");    //displays option 3 on the screen
	c.println ("4. Scramble the array");    //displays option 4 on the screen
	c.println ("5. Remove a value from the array"); //displays option 5 on the screen
	c.println ("6. Add a value to the array");  //displays option 6 on the screen
	c.println ("x. Exit the program");  //displays option exit on the screen
	c.setTextColor (Color.red); //sets colour to red
	c.println ("-------------------------------------------------------------");    //creates divider between main menu and the option output
	c.setTextColor (Color.black);   //sets colour to black
	c.print ("Enter your choice: "); //asks user to enter their choice
	userAnswer = c.readString ();   //reads users choice
	c.print ("");   //prints blank space below answer


	if (userAnswer.equals ("1"))    //if user selects option 1
	{
	    c.print ("Number of columns to use when displaying the array: ");   //ask user how many columns they want displayed
	    userColumns = c.readInt (); //reads how many columns are wanted
	    displayArray ();    //displays array on screen
	    c.println ();   //creates blank space
	    clearScreen (); //clears screen
	    c.println();    //creates blank space
	}
	else if (userAnswer.equals ("2"))   //if user selects option 2
	{
	    largestSmallest (); //runs largest and smallest number method
	    c.println ();   //creates blank space
	    clearScreen (); //clears screen
	    c.println ();   //creates blank space
	}
	else if (userAnswer.equals ("3"))   //if user selects option 3
	{
	    sortArray ();   //runs method to sort the array
	    c.println ();   //creates blank space
	    clearScreen (); //clears screen
	    c.println ();   //creates blank space
	}
	else if (userAnswer.equals ("4"))   //if user selects option 4
	{
	    scrambleArray ();   //runs method to scramble the array
	    c.println ();   //creates blank space
	    clearScreen (); //clears screen
	    c.println ();   //creates blank space
	}
	else if (userAnswer.equals ("5"))   //if user selects option 5
	{
	    removeValue (); //runs method to remove a value from array
	    c.println ();   //creates blank space
	    clearScreen (); //clears screen
	    c.println ();   //creates blank space
	}
	else if (userAnswer.equals ("6"))   //if user selects option 6
	{
	    addValue ();    //runs method to add a value to the array
	    c.println ();   //creates blank space
	    clearScreen (); //clears screen 
	    c.println ();   //creates blank space
	}
	else if (userAnswer.equals ("x") || userAnswer.equals ("X"))    //if user selects option EXIT
	{
	    System.exit (0);    //exits screen
	}
    }


    public static void displayArray ()  //method to display array
    {
	for (int i = 1 ; i < 21 ; i++)  //creates for loop to display array numbers
	{
	    if ((i % userColumns == 0) && i < 21)   //creates if statement to display numbers according to users column choice and creates new rows
	    {
		c.setTextColor (Color.black);   //sets colour to black
		c.print (" " + i + ") ");   //prints out numbers 1-20
		c.setTextColor (Color.blue);    //sets colour to blue
		c.print (number [i] + " "); //prints out 20 random numbers
		c.println ();   //creates blank space
	    }

	    else    //else statement for array
	    {
		c.setTextColor (Color.black);   //sets colour to black
		c.print ("  " + i + ") ");      //prints out numbers 1-20
		c.setTextColor (Color.blue);    //sets colour to blue
		c.print (number [i] + " ");     //prints out 20 random numbers
	    }
	}

    }


    public static void largestSmallest ()       //method to determine largest and smallest number
    {
	for (int i = 0 ; i < number.length ; i++)       //creates for loop to determine first number
	{
	    for (int j = 0 ; j < number.length ; j++)   //creates for loop to determine second number
	    {
		if (number [i] > number [j])    //if number 1 is bigger than number 2
		{
		    tempVariable = number [j];  //checks to see
		    number [j] = number [i];    //which number is the biggest
		    number [i] = tempVariable;  //and which is the smallest ---> swaps numbers if one is bigger than the other
		}
	    }
	}

	c.print ("The largest number is: ");    //prints out the following sentence
	c.setTextColor (Color.blue);    //sets colour to blue
	c.print (number [0]);   //prints out largest number
	c.setTextColor (Color.black);   //sets colour to black
	c.print (". The smallest number is: "); //prints out the following sentence
	c.setTextColor (Color.blue);    //sets colour to blue
	c.print (number [19]);  //prints out smallest number
    }


    public static void sortArray ()     //method that sorts out the array
    {
	for (int i = 0 ; i < number.length ; i++)   //creates for loop for number 1
	{
	    for (int j = 0 ; j < number.length ; j++)   //creates for loop for number 2
	    {
		if (number [i] < number [j])    //if number 1 is less than number 2
		{
		    tempVariable = number [j];  //checks to see if next number is smaller
		    number [j] = number [i];    //or larger than the other and swaps if its 
		    number [i] = tempVariable;  // smaller than the previous one
		}
	    }
	}

	for (int m = 1 ; m < 21 ; m++)      //creates a for loop to print out numbers in array
	{
	    if (m % 5 == 0)     //sets columns to 5
	    {
		c.setTextColor (Color.black);   //sets colour to black
		c.print (m + ") "); //prints out numbers 1-20
		c.setTextColor (Color.blue);    //sets colour to blue
		c.print (number [m] + "  ");    //prints out sorted numbers
		c.println ();   //creates blank space
	    }   
	    else    //else statement
	    {
		c.setTextColor (Color.black);   //sets colour to black
		c.print (m + ") "); //prints out numbers 1-20
		c.setTextColor (Color.blue);    //sets colour to blue
		c.print (number [m] + "  ");    //prints out sorted numbers
	    }
	}


    }


    public static void scrambleArray ()     //method that scrambles array
    {
	int randNum1;   //creates variable for 1st random number
	int randNum2;   //creates variable for 2nd random number
	randNum1 = 0;
	for (int i = 1 ; i < 21 ; i++)  //creates for loop to display array
	{
	    randNum1 = (int) (Math.random () * 19 - 1 + 1 + 1); //gets 1st random number
	    randNum2 = (int) (Math.random () * 19 - 1 + 1 + 1); //gets 2nd random number
	    int tempVariable = 0;   //sets temporary variable to 0
	    for (int m = 0 ; m < 100 ; m++) //creates for loop to get random numbers from 1 - 100
		tempVariable = number [randNum1];   //swaps out 1st random number with temporary variable
	    number [randNum1] = number [randNum2];  //swaps random number 1 with random number 2
	    number [randNum2] = tempVariable;   //switchs number 2 with temporary variable
	}
	for (int j = 1 ; j < 21 ; j++)  //creates for loop to display numbers
	{
	    if (j % 5 == 0)     //sets columns length to 5 and displays new row every 5 numbers
	    {
		c.setTextColor (Color.black);   //sets colour to black
		c.print (j + ") "); //prints out numbers 1-20
		c.setTextColor (Color.blue);    //sets colour to blue
		c.print (number [j] + "  ");    //prints out scrambled numbers
		c.setTextColor (Color.black);   //sets colour to black
		c.println (""); //creates blank space
	    }
	    else    //else statement
	    {
		c.setTextColor (Color.black);   //sets colour toblack
		c.print (j + ") "); //prints out numbers 1-20
		c.setTextColor (Color.blue);    //sets colour to blue
		c.print (number [j] + "  ");    //prints out scrambled numbers
	    }
	}
    }


    public static void removeValue ()   //method to remove a value
    {
	for (int x = 1 ; x < 21 ; x++)  //prints out array
	{
	    if (x % 5 == 0)     //sets columns to 5 and prints a new line every 5 numbers
	    {
		c.setTextColor (Color.black);   //sets colour to black
		c.print (x + ") ");    //prints numbers 1-20
		c.setTextColor (Color.blue);    //sets colour to blue
		c.print (number [x] + "  ");    //prints out random numbers
		c.setTextColor (Color.black);   //sets colour to black
		c.println (""); //creates blank space
	    }
	    else    //else statement
	    {
		c.setTextColor (Color.black);   //sets colour to black
		c.print (x + ") "); //prints out numbers 1-20
		c.setTextColor (Color.blue);    //sets colour to blue
		c.print (number [x] + "  ");    //prints out random numbers
	    }
	}
	c.setTextColor (Color.black);   //sets colours to black
	c.println ("Please enter the Array number you want to remove:");    //prints following sentence
	int remove = c.readInt ();  //reads for which number to remove
	number [remove] = 101;  //removes number above and replaces it
	
	for (int m = 1 ; m < 20 ; m++)  //displays new array
	{
	    if (m % 5 == 0) //sets columns to 5 and prints a new line every 5 numbers
	    {
		c.setTextColor (Color.black);   //sets colour to black
		c.print (m + ") "); //displays numbers 1-20
		c.setTextColor (Color.blue);    //sets colour to blue
		c.print (number [m] + "  ");    //displays random numbers
		c.setTextColor (Color.black);   //sets colour to black
		c.println (""); //creates blank space
	    }
	    else        //else statment
	    {
		c.setTextColor (Color.black);   //sets colour to black
		c.print (m + ") ");     //prints numbers 1-20
		c.setTextColor (Color.blue);    //sets colour to blue
		c.print (number [m] + "  ");    //prints out random number
	    }
	}

    }


    public static void addValue ()      //method that adds value to array
    {
	for (int x = 1 ; x < 21 ; x++)  //for loop that displays array
	{
	    if (x % 5 == 0)     //sets columns to 5 and prints a new line every 5 numbers
	    {
		c.setTextColor (Color.black);   //sets colour to black
		c.print (x + ") "); //prints number 1-20
		c.setTextColor (Color.blue);    //sets colour to blue
		c.print (number [x] + "  ");    //prints 20 random numbers
		c.setTextColor (Color.black);   //sets colour to black
		c.println (""); //creates blank space
	    }
	    else        //else statement
	    {
		c.setTextColor (Color.black);   //sets colour to black
		c.print (x + ") "); //prints numbers 1-20
		c.setTextColor (Color.blue);    //sets colour to blue
		c.print (number [x] + "  ");    //prints out random numbers
	    }
	}
	for (int i = 0 ; i < number.length ; i++)   //gets number 1
	{
	    for (int j = 0 ; j < number.length ; j++)   //gets number 2
	    {
		if (number [i] < number [j])    //if number 1 is less than number 2
		{
		    tempVariable = number [j];  //swap number 2 with temporary variable
		    number [j] = number [i];    //swap number 2 with number 1
		    number [i] = tempVariable;  //swap number 1 with temporary variable
		}
	    }
	}
	c.println ("What value would you like to add to the array? ");  //asks user what number they want to add
	int value = c.readInt ();   //reads users answer
	number [20] = value;    //adds users number
	for (int m = 1 ; m < 21 ; m++)  //for statement that displays new array
	{
	    if ((m % 5 == 0) && m<21)   //sets columns to 5 and prints a new line every 5 numbers and adds one extra number
	    {
		c.setTextColor(Color.black);    //sets colour to black
		c.print (m + ") "); //prints numbers 1-20
		c.setTextColor(Color.blue);     //sets colour to blue
		c.print(number [m] + " ");  //prints random numbers
		c.println (" ");    //creates blank space
	    }
	    else    //else statment
	    {
		c.setTextColor(Color.black);    //sets colour to black
		c.print (m + ")");      //prints numbers 1-20
		c.setTextColor(Color.blue);     //sets colour to blue
		c.print(number [m] + " ");  //prints random numbers
	    }
	}

    }


    public static void clearScreen ()       //method to clear screen
    {
	c.setTextColor (Color.black);   //sets colour to black
	c.print ("Would you like to select another option? Enter (Yes(y) or No(n): ");  //asks user if they want to do another option
	userChoice = c.readString ();   //reads users choice
	if (userChoice.equals ("y") || userChoice.equals ("Y")) //if user says yes
	{
	    c.clear();  //clear screen
	    mainMenu ();    //show main menu
	}
	else if (userChoice.equals ("n") || userChoice.equals ("N"))    //if user says no
	{
	    System.exit (0);    //exit program
	}
    }
} // ArrayReviewExercise class
