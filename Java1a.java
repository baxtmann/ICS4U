// The "Java1a" class.
//Brandon Axtmann
//ICS4U - VHSS
//Feb 5 2018
import java.awt.*;
import hsa.Console;

public class Java1a
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console ();
	
	String Age, Height, Hair, name; //Declare Variables
	
	// Get User Data
	c.println("What is your name?");
	name = c.readLine ();
	c.println("How old are you?");
	Age = c.readLine ();
	c.println("How tall are you?");
	Height = c.readLine ();
	c.println("What is your hair colour?");
	Hair = c.readLine ();
	
	//POST output to user
	c.println(" ");
	c.println("Description of " +name);
	c.println("Age:   " +Age);
	c.println("Height:   " +Height);
	c.println("Hair Colour:    " +Hair);

	 
	
	
	// Place your program here.  'c' is the output console
    } // main method
} // Java1a class
