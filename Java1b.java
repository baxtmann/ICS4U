// The "Java1b" class.
import java.awt.*;
import hsa.Console;

public class Java1b
{
    static Console c;           // The output console
    
    public static void main (String[] args)
    {
	c = new Console ();
	int rating, rating2, rating3;
	String movie;
	
	c.println("What is the name of the movie?");
	movie = c.readLine ();
	c.println("What is your rating?");
	rating = c.readInt ();
	c.println("");
	c.println("User's rating of " +movie + ":"); 
	c.print("");
	for (int i = 1; i<= rating ; i++){
	c.setTextColor(Color.red);
	c.print("*");
	
	}

	
	
	// Place your program here.  'c' is the output console
    } // main method
} // Java1b class
