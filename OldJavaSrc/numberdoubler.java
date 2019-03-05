// this is a c# number doubler I have crudely rewritten in java
import java.util.Scanner;
public class numberdoubler
{
	public static void main(String[] args)
	// Main refers to the curly brace contents
	{
		int myNumber;
		int myAnswer;
		//Java ints; bears shouldnt ->ingest large furry dogs
		System.out.println("Please enter a number >> ");
      Scanner keyboard = new Scanner(System.in); 
      // this prepares Scanner for KB input
      myNumber = keyboard.nextInt();
      // myNumber int is equal to keyboard.nextInt(). This makes Scanner
      // populate myNumber with the int value of numbers entered
		myAnswer = myNumber * 2;
      System.out.println(myNumber);         //println does start a new line for each arg
      System.out.println("doubled is");
		System.out.println(myAnswer);
	}
}
