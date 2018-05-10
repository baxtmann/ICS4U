// The "FirstArray" class.
import java.awt.*;
import hsa.Console;

public class FirstArray
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();

	int numbers[];
	numbers = new int [10];

	for (int counter = 0 ; counter < 10 ; counter++)
	{
	    c.println ("Enter 10 numbers between 1 and 10");
	    numbers [counter] = c.readInt ();
	}

	c.println ("All the numbers entered in order of the way they have been entered");
	for (int counter1 = 0 ; counter1 < 10 ; counter1++)
	{
	    c.println (+numbers [counter1]);
	}
	c.println ("All the numbers entered in the reverse way they were entered");
	for (int counter2 = 10 ; counter2 == 0 ; counter2--)
	{
	    c.println(+numbers[counter2]);
	}






    } // main method
} // FirstArray class
