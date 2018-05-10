// The "ReasNamesIntoAnArrayExample" class.
import java.awt.*;
import hsa.Console;
import java.io.*;
public class ReasNamesIntoAnArrayExample
{
    static Console c;           // The output console

    public static void main (String[] args) throws IOException
    {
	c = new Console ();
	String[] userWord = new String [3168]; //array to hold names from file
	int count = 0, noHit = 0;
	BufferedReader fileInput;
	fileInput = new BufferedReader (new FileReader ("C://awords.txt"));
	userWord [count] = fileInput.readLine ();

	while (userWord [count] != null)
	{
	    count++;
	    userWord [count] = fileInput.readLine ();
	}
	fileInput.close ();
	//c.println ("The names are: ");

	for (int i = 0 ; i < count ; i++)
	{

	    for (int y = i+1 ; y < count ; y++)
	    {
		if (userWord [i].compareTo (userWord [y]) > 0)
		{
		    String tempVar;
		    tempVar = userWord [y];
		    userWord [y] = userWord [i];
		    userWord [i] = tempVar;
		}
	    }
	}

//for (int i =0; i <3167;i++)
//c.println(userWord[i]);



	c.println ("Enter the letter that starts with 'A' that you will be searching for 2dai.");
	String wordUser = c.readString ();

	for (int i = 0 ; i < 3167 ; i++)
	{
	    if (wordUser.equals (userWord [i]))
		c.print ("");
	    else
		noHit = noHit + 1;


	}
	if (noHit == 3167)
	    c.println ("Not found lol");
	else
	    c.println ("I found it!");
    } // main method
} // ReasNamesIntoAnArrayExample class
