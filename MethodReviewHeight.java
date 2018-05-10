// The "MethodReviewHeight" class.
import java.awt.*;
import hsa.Console;

public class MethodReviewHeight
{
    static Console c;           // The output console

    public static double userFemur = 0;
    public static double userHumerus = 0;
    public static double height = 0;
    public static String userGender = "";
    public static String userOpt = "";
    public static void main (String[] args)
    {
	c = new Console ();

	c.print ("Do you define as male or female (m/f): ");
	userGender = c.readString ();

	c.print ("Would you like to enter the height of your femur or humerus (f/h): ");
	userOpt = c.readString ();


	if (userOpt.equals ("f"))
	{
	    c.print ("What is the length of your femur: ");
	    userFemur = c.readDouble ();
	    if (userGender.equals ("f"))
	    {
		femaleFemur ();
	    }
	    else
	    {
		maleFemur ();
	    }
	}
	else
	{
	    c.print ("What is the length of your humerus: ");
	    userHumerus = c.readDouble ();
	    if (userGender.equals ("f"))
	    {
		femaleHumerus ();
	    }
	    else
	    {
		maleHumerus ();
	    }

	}

    } // main method


    public static void femaleFemur ()
    {
	height = userFemur * 1.94 + 28.7;
	c.print("You are " + height + " tall.");
    }


    public static void maleFemur ()
    {
	height = userFemur * 1.88 + 32;
	c.print("You are " + height + " tall.");
    }


    public static void femaleHumerus ()
    {
	height = userHumerus * 2.8 + 28.2;
	c.print("You are " + height + " tall.");
    }


    public static void maleHumerus ()
    {
	height = userHumerus * 2.9 + 27.9;
	c.print("You are " + height + " tall.");
    }
} // MethodReviewHeight class
