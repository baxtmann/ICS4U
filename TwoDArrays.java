// The "TwoDArrays" class.
import java.awt.*;
import hsa.Console;

public class TwoDArrays
{
    static Console c;           // The output console

    public static int twoDarray[] [] = new int [4] [5];
    public static int userChoice = 0;
    public static void main (String[] args)
    {
	c = new Console ();
	while (userChoice != 8)
	{
	    int userInput = 0;
	    c.println ("2D Array Practice");
	    c.println ("~~~~~~~~~~~~~~~~~~~~");
	    c.println ("1) Load 2D array with random numbers between 1 and 10");
	    c.println ("2) View the 2D array");
	    c.println ("3) Sum the rows of the 2D array");
	    c.println ("4) Sum the columns of the 2D array");
	    c.println ("5) Find the maximum value in the 2D array");
	    c.println ("6) Find the minimum value in the 2D array");
	    c.println ("7) Determine if all of the row sums are the same");
	    c.println ("8) Exit the program");
	    c.println ("");
	    c.print ("Enter your choice: ");
	    userChoice = c.readInt ();
	    c.println ();
	    if (userChoice == 1)
	    {
		loadArray ();
	    }
	    if (userChoice == 2)
	    {
		viewArray ();
	    }
	    if (userChoice == 3)
	    {
		viewArray ();
		sumOfRows ();
	    }
	    if (userChoice == 4)
	    {
		viewArray ();
		sumOfColumns ();
	    }
	    if (userChoice == 5)
	    {
		viewArray ();
		largestNumber ();
	    }
	    if (userChoice == 6)
	    {
		viewArray ();
		smallestNumber ();
	    }
	    if (userChoice == 7)
	    {
	    }
	    if (userChoice == 8)
	    {
		System.exit (0);
	    }
	}
     
    } // main method
     
     
    public static void loadArray ()
    {
	for (int i = 0 ; i < 4 ; i++)
	{
	    for (int j = 0 ; j < 5 ; j++)
	    {
		twoDarray [i] [j] = (int) (Math.random () * 10 + 1);
     
	    }
	}
    }
     
     
    public static void viewArray ()
    {
	c.clear ();
	for (int i = 0 ; i < 4 ; i++)
	{
	    for (int j = 0 ; j < 5 ; j++)
	    {
		c.print (" " + twoDarray [i] [j] + "  ");
	    }
	    c.println ();
	}
	c.println ();
    }
     
     
    public static void sumOfRows ()
    {
	c.clear ();
	int rowSum = 0;
	for (int i = 0 ; i < 4 ; i++)
	{
	    for (int j = 0 ; j < 5 ; j++)
	    {
		rowSum = rowSum + twoDarray [i] [j];
		c.print (" " + twoDarray [i] [j] + " ");
	    }
	    c.print (" = " + rowSum);
	    c.println ();
	    rowSum = 0;
	}
    }
     
     
    public static void sumOfColumns ()
    {
	int columnSum[] = new int [5];
	int row = 1;
	int column = 5;
	c.setCursor (column, row);
     
	for (int j = 0 ; j < 5 ; j++)
	{
	    for (int i = 0 ; i < 4 ; i++)
	    {
		columnSum [j] = columnSum [j] + twoDarray [i] [j];
	    }
	}
	c.setCursor (column, row);
	c.println (" =   =   =   =   = ");
	column++;
	for (int x = 0 ; x < 5 ; x++)
	{
	    c.setCursor (column, row);
	    c.print (" " + columnSum [x]);
	    row = row + 4;
	}
	c.println ();//ads a space
	c.println ();//adds a space
    }
    
    
    public static void largestNumber ()
    {
	int j,i;
	for (i = 0 ; i < twoDarray.length ; i++)   //creates for loop to determine first number
	{
	    for (j = 0 ; j < twoDarray.length ; j++) //creates for loop to determine second number
	    {
		if (twoDarray [i] [j] > twoDarray [j] [i])  //if number 1 is bigger than number 2
		{
		    int tempVariable = twoDarray [j] [i]; //checks to see
		    twoDarray [j] [i] = twoDarray [i] [j];  //which number is the biggest
		    twoDarray [i] [j] = tempVariable; //and which is the smallest ---> swaps numbers if one is bigger than the other
		}
	    }
	}
	c.println ("The largest number is: " + twoDarray [i] [j]); //prints out the following sentence
	//prints out largest number
    }
     
     
    public static void smallestNumber ()
    {
	for (int i = 0 ; i < twoDarray.length ; i++)       //creates for loop to determine first number
	{
	    for (int j = 0 ; j < twoDarray.length ; j++)   //creates for loop to determine second number
	    {
		if (twoDarray [i] [j] > twoDarray [j] [i])  //if number 1 is bigger than number 2
		{
		    int tempVariable = twoDarray [j] [i]; //checks to see
		    twoDarray [j] [i] = twoDarray [i] [j];  //which number is the biggest
		    twoDarray [i] [j] = tempVariable; //and which is the smallest ---> swaps numbers if one is bigger than the other
		}
	    }
	}
	c.println ("The smallest number is: " + twoDarray [1] [1]); //prints out the following sentence
    }
} // TwoDArrays class
