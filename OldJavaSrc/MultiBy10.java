// this is a c# number doubler I have crudely rewritten in java
import java.util.Scanner;
public class MultiBy10
{
public static void main(String[] args)
	// Main refers to the curly brace contents
	{
		int valueToMultiply;
		int valueResult;
		//Java ints; bears shouldnt ->ingest large furry dogs
		System.out.println("Please enter a number to multiply by 10>> ");
      Scanner keyboard = new Scanner(System.in); 
      // this prepares Scanner for KB input
      valueToMultiply = keyboard.nextInt();
      // valueToMultiply int is equal to keyboard.nextInt(). This makes Scanner
      // populate valueResult with the int value of numbers entered
		valueResult = valueToMultiply * 10;
      System.out.println(valueToMultiply); //println starts newline with arg
      System.out.println("multiplied by 10 is");
		System.out.println(valueResult);
	}
}
