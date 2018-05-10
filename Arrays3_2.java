// The "Arrays3_2" class.
//Brandon Axtmann
//Feb 23 2018
//ICS4U - Jon
//This program will create a 10 element array and fill it with random numbers between 1 and 10.
//The program will then output all the numbers in the way they were generated, then sum all the elements in the
//array, then will sum all the even numbers, then will sum all the odd numbers and then it will print said sum out.
import java.awt.*;
import hsa.Console;

public class Arrays3_2
{
    static Console c;           // The output console
    public static void main (String[] args)
    {
	c = new Console ();
	int evenSum = 0; //declare evenSum variable - which is for the sum of even numbers
	int oddSum = 0; //declare oddSum variable - which is for the sum of odd numbers
	int sum = 0; //decalare sum variable - which is for the sum of all the variables
	int numbers[]; //create the numbers array
	numbers = new int [10]; //finish creating the numbers array
	for (int counter = 0 ; counter < 10 ; counter++) //for loop for creating the random numbers
	{ //start loop
	    numbers [counter] = (int) (Math.random () * (10)); //create random numbers and then put it into array
	} //end loop
	for (int i = 0 ; i < 10 ; i++) //for loop to print all of the numbers in the order that they were generated
	    c.println (+numbers [i]); //print all of the numbers
	for (int i = 0 ; i < 10 ; i++) //for loop to sum all the number together
	    sum = sum + numbers [i]; //sum all of the numbers together
	c.println ("The sum is: " + sum); //print a single line for showing the sum of all the numbers
	for (int i = 0 ; i < 10 ; i++) //for loop for finding the sum of the even numbers
	{ //start loop
	    if (numbers [i] % 2 == 0) //if statement - if number in arryay % 2 ==0 then its even
	    { //start if statement
		evenSum = evenSum + numbers [i]; //if its even , add it to the evenSum variable
	    } //end if statement
	} //end loop
	c.println ("The sum of the even numbers is :" + evenSum); //print the sum of the even numbers on a single line
	for (int i = 0 ; i < 10 ; i++) //for loop for finding the sum of the odd numbers
	{ //start loop
	    if (numbers [i] % 2 == 1) //if statement - if number in array % 2 and equals 1 then it must be odd
	    { //start if statement
		oddSum = oddSum + numbers [i]; //if its odd then add it to the oddSum variable
	    } //end if statement
	} //end loop
	c.println ("The sum of the odd numbers is :" + oddSum); //print the sum of the odd numbers on the screen
    } // main method
} // Arrays3_2 class
