//----------------------------------------
//          The "MemeClasss" class.       |
//            Brandon Axtmann             |
//              Feb 07 2017               |
//             ICS4U - Berec              |
//----------------------------------------
import java.awt.*;
import hsa.Console;

public class MemeClasss
{
    static Console c; // The output console
    public static void main (String[] args)
    {
	c = new Console ();
	//Decalare Variables
	int userDay, userMonth, userYear, daysCalc, dayOfTheWeek, days, year, leapyear, dayOfMonth;
	daysCalc = 0; //set variable
	//Get user data
	c.println ("Please enter the year");
	userYear = c.readInt ();
	c.println ("Please enter the month");
	userMonth = c.readInt ();
	c.println ("Please enter the day");
	userDay = c.readInt ();
	dayOfMonth = userDay;
	//Calcualte raw amount of days from years * 365 - initial value
	days = (userYear - 1900) * 365;
	//Calculate leap year
	for (int i = 1904 ; i < userYear ; i = i + 4)
	    days = days + 1;
	userDay = userDay + days;
	//BEGIN MONTH + DAY CALCUALTIONS
	if (userMonth == 1)
	{
	    //If its Jan, dont add the month, just the days
	    daysCalc = userDay;
	}

	if (userMonth == 2)
	{
	    //If its feb, add 31 + the days in feb
	    daysCalc = 31 + userDay;
	}
	if (userMonth == 3)
	{
	    //If its march, add 31 + 28
	    daysCalc = userDay + 31 + 28;
	}
	if (userMonth == 4)
	{
	    //If its APRIL, add 31 +28 + 31 + userDays
	    daysCalc = 31 + 28 + 31 + userDay;
	}
	if (userMonth == 5)
	{
	    //If its MAY add 31 +28 +31 +30 +user days
	    daysCalc = 31 + 28 + 31 + 30 + userDay;
	}
	if (userMonth == 6)
	{
	    //If its JUNE add 31 +28 +31 +30 + 31 +userDays
	    daysCalc = 31 + 28 + 31 + 30 + 31 + userDay;
	}
	if (userMonth == 7)
	{
	    //If its JULY add 31 +28 +31 +30 +31 + 30 + userDay
	    daysCalc = 31 + 28 + 31 + 30 + 31 + 30 + userDay;
	}
	if (userMonth == 8)
	{
	    //if its AUGUST add 31+ 28 +31 +30 +31 +30+ 31+ userDay
	    daysCalc = 31 + 28 + 31 + 30 + 31 + 30 + 31 + userDay;
	}
	if (userMonth == 9)
	{ //if its SEPTEMBER add 31+28+31+30+31+30+31+31
	    daysCalc = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + userDay;
	}
	if (userMonth == 10)
	{
	    //If its October add 31+28+31+30+31+30+31+31+30+userDays
	    daysCalc = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + userDay;

	}
	if (userMonth == 11)
	{
	    //If its November add 31 +28 +31 +30 +31+30+31+31+30+31+userDay
	    daysCalc = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + userDay;
	}
	if (userMonth == 12)
	{
	    //If its December add 31+28+31+30+31+30+31+31+30+31+30+userDay
	    daysCalc = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + userDay;
	}
	//Calcualte What day of the week it is
	dayOfTheWeek = daysCalc % 7;
	//Draw the calandar
	c.println ("  S  M  T  W  T  F  S");
	//For day 1 - Monday
	if (dayOfTheWeek == 1)
	{
	    c.print ("   ");
	    dayOfMonth = dayOfMonth + 1;
	    for (int i = 1 ; i < dayOfMonth ; i++)
	    {
		if (i % 7 == 0)
		    c.println ("");
		c.print ("  *");
	    }
	}
	//For Day 2 - Tuesday
	if (dayOfTheWeek == 2)
	{
	    c.print ("      ");
	    dayOfMonth = dayOfMonth + 2;
	    for (int i = 2 ; i < dayOfMonth ; i++)
	    {
		if (i % 7 == 0)
		    c.println ("");
		c.print ("  *");
	    }
	}
	//For day 3 - Wednsday
	if (dayOfTheWeek == 3)
	{
	    c.print ("         ");
	    dayOfMonth = dayOfMonth + 3;
	    for (int i = 3 ; i < dayOfMonth ; i++)
	    {
		if (i % 7 == 0)
		    c.println ("");
		c.print ("  *");
	    }
	}
	//For day 4 - Thurday
	if (dayOfTheWeek == 4)
	{
	    c.print ("            ");
	    dayOfMonth = dayOfMonth + 4;
	    for (int i = 4 ; i < dayOfMonth ; i++)
	    {
		if (i % 7 == 0)
		    c.println ("");
		c.print ("  *");
	    }
	}
	//For day 5 - Friday
	if (dayOfTheWeek == 5)
	{
	    c.print ("               ");
	    dayOfMonth = dayOfMonth + 5;
	    for (int i = 5 ; i < dayOfMonth ; i++)
	    {
		if (i % 7 == 0)
		    c.println ("");
		c.print ("  *");
	    }
	}
	//For day 6 - Saturday
	if (dayOfTheWeek == 6)
	{
	    c.print ("                  ");
	    dayOfMonth = dayOfMonth + 6;
	    for (int i = 0 ; i < dayOfMonth ; i++)
	    {
	    i = i++;    
	    if (i % 7 == 0)
		    c.println ("");
		c.print ("  *");
	    }
	}
	//For day 7 - Sunday
	if (dayOfTheWeek == 0)
	{
	    c.print ("");
	    for (int i = 0 ; i < dayOfMonth ; i++)
	    {
		if (i % 7 == 0)
		    c.println ("");
		c.print ("  *");
	    }
	}
    } // main method
} // MemeClasss class

