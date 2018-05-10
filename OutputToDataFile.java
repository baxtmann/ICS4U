// The "OutputToDataFile" class.
import java.awt.*;
import hsa.Console;
import java.io.*;
public class OutputToDataFile
{
    static Console c;           // The output console
    
    public static void main (String[] args) throws IOException
    {
	c = new Console ();
	PrintWriter fileOutput;
	fileOutput = new PrintWriter (new FileWriter("C://Users/baxtm/Documents/Java Files - ICS4U/test.txt"));
	
	c.print("This program will create a file on the c drive");
	c.print("called test.txt and place a message in the file.");
	
	fileOutput.println("This is the message");
	fileOutput.close();        
	
    } // main method
} // OutputToDataFile class
