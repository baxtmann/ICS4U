// The "JavaLuhnAlgo" class.
import java.awt.*;
import hsa.Console;

public class JavaLuhnAlgo
{
    static Console c;           // The output console
//MAIN PROGRAM   
//-----------------------------------------------------------------------------------------------------------
     public static void main (String[] args)
    {
	c = new Console ();
	c.println ("Please Enter Your Card Number"); //STEP 1: Enter your credit card
	String test = c.readString ();
	validateCreditCardNumber (test);
    }
//----------------------------------------------------------------------------------------------------------
//END OF MAIN PROGRAM
//==========================================================================================================
//START OF SUBROUTINE
    public static void validateCreditCardNumber (String str)
    {
	int[] ints = new int [str.length ()]; //This is finding out how long the string is (For a credit card it should be between 13-16)
	for (int i = 0 ; i < str.length () ; i++)
	{
	    ints [i] = Integer.parseInt (str.substring (i, i + 1)); //str.substring is a java command that goes one by one through the string and can execute as such
	}
	//Run the program through for every other number
	for (int i = ints.length - 2 ; i >= 0 ; i = i - 2)
	{
	    int j = ints [i];
	    j = j * 2; //STEP 2: qucikly multiply it by two
	    if (j > 9)
	    {
		j = j % 10 + 1; //STEP 3 adding the double digits together
	    }
	    ints [i] = j;
	}
	int sum = 0; //quickly decalre the sum as zero before we assign a value to it
	//STEP 4 Add the sum together (Sum will tell us if its valid or not)
	for (int i = 0 ; i < ints.length ; i++)
	{
	    sum += ints [i];
	}
	//User output of result (If credit card is valid or not)
	if (sum % 10 == 0)
	{
	    c.println (str + " is a valid credit card number");
	}
	else
	{
	    c.println (str + " is an invalid credit card number");
	}
    } // main method
} // JavaLuhnAlgo class
