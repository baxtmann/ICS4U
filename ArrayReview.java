// The "ArrayReview" class.
import java.util.Collections;
import java.awt.*;
import hsa.Console;

public class ArrayReview
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();
	int tempVar;
	for (int i = 0 ; i < 20 ; i++)
	{
	    int randNum = (int) (Math.random () * 100 - 1 + 1 + 1);
	    number [i] = randNum;
	}
	c.println ("The Array Review Program");
	c.println ("------------------------");
	c.println ("");
	c.println ("Choose one of the following options");
	c.println ("1. View the array");
	c.println ("2. Output the largest and smallest elements");
	c.println ("3. Sort the array");
	c.println ("4. Scramble the array");
	c.println ("5. Remove a value from the array");
	c.println ("6. Add a value to teh array");
	c.println ("x. Exit the program");
	c.println ("Enter your choice");
	String choice = c.readString ();
	if (choice.equals ("1"))
	{
	    c.println ("Number of columns to use when displaying the array: ");
	    int columns = c.readInt ();
	    for (int i = 1 ; i < 20 ; i++)
	    {
		if (i % columns == 0)
		{
		    c.print ("  " + i + ".) " + number [i]);
		    c.println ("");
		    c.setCursor (16 + 1, 30);
		}
		else
		{
		    int x = 10;
		    x = x + 3;
		    c.setCursor (16, x);
		    c.print ("  " + i + ".) " + number [i]);
		}
	    }
	}
	if (choice.equals ("2"))
	{
	    for (int i = 0 ; i < number.length ; i++)
	    {
		for (int j = 0 ; j < number.length ; j++)
		{
		    if (number [i] > number [j])
		    {
			tempVar = number [j];
			number [j] = number [i];
			number [i] = tempVar;
		    }
		}
	    }
	    c.println ("Largest number is: " + number [0] + " Smallest number is: " + number [19]);
	}
	if (choice.equals ("3"))
	{
	    for (int i = 0 ; i < number.length ; i++)
	    {
		for (int j = 0 ; j < number.length ; j++)
		{
		    if (number [i] < number [j])
		    {
			tempVar = number [j];
			number [j] = number [i];
			number [i] = tempVar;
		    }
		}
	    }
	    for (int x = 0 ; x < 20 ; x++)
	    {
		if (x % 5 == 0)
		{
		    c.print (x + ".) " + number [x] + "  ");
		    c.println ("");
		}
		else
		    c.print (x + ".) " + number [x] + "  ");
	    }
	}
	int randNum1 = 0;
	if (choice.equals ("4"))
	{
	    
	for (int yaboi=0;yaboi<20;yaboi++)
	c.println(number[yaboi]);
	
	
	
	
	
	for (int i = 0 ; i < 20 ; i++)
	    {
		
	    randNum1 = (int) (Math.random () * 19 - 1 + 1 + 1);
		int randNum2 = (int) (Math.random () * 19 - 1 + 1 + 1);
		int temp = 0;
		for (int m = 0 ; m < 100 ; m++)
		    temp = number [randNum1];
		number [randNum1] = number [randNum2];
		number [randNum2] = temp;
	    }
	    for (int y = 0 ; y < 20 ; y++)
	    {
		if (y % 5 == 0)
		{
		    c.print (y + ".) " + number [y] + "  ");
		    c.println ("");
		}
		else
		    c.print (y + ".) " + number [y] + "  ");
	    }
	}
	if (choice.equals ("5"))
	{
	    for (int y = 0 ; y < 20 ; y++)
	    {
		if (y % 5 == 0)
		{
		    c.print (y + ".) " + number [y] + "  ");
		    c.println ("");
		}
		else
		    c.print (y + ".) " + number [y] + "  ");
	    }
	    c.println ("Please enter the Array number you want to remove:");
	    int remove = c.readInt ();
	    number [remove] = 101;
	    for (int i = 0 ; i < number.length ; i++)
	    {
		for (int j = 0 ; j < number.length ; j++)
		{
		    if (number [i] < number [j])
		    {
			tempVar = number [j];
			number [j] = number [i];
			number [i] = tempVar;
		    }
		}
	    }
	    for (int t = 0 ; t < 19 ; t++)
	    {
		if (t % 5 == 0)
		{
		    c.print (t + ".) " + number [t] + "  ");
		    c.println ("");
		}
		else
		    c.print (t + ".) " + number [t] + "  ");
	    }
	}



	if (choice.equals ("6"))
	{
	    for (int i = 0 ; i < number.length ; i++)
	    {
		for (int j = 0 ; j < number.length ; j++)
		{
		    if (number [i] < number [j])
		    {
			tempVar = number [j];
			number [j] = number [i];
			number [i] = tempVar;
		    }
		}
	    }
	    c.println ("What value would you like to add?");
	    int value = c.readInt ();
	    number [19] = value;
	    for (int t = 0 ; t < 20 ; t++)
	    {
		if (t % 5 == 0)
		{
		    c.print (t + ".) " + number [t] + "  ");
		    c.println ("");
		}
		else
		    c.print (t + ".) " + number [t] + "  ");
	    }
	}

	//}
	if (choice.equals ("x"))
	{
	    System.exit (0);
	}



    } // main method


    public static int number[] = new int [20];
    public static int randomNums[] = new int [20];
    public static int newNumbers[] = new int [20];

} // ArrayReview class


