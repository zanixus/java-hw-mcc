// this is a c# number doubler I have crudely rewritten in java
import java.util.Scanner;
public class ExpoCalc
{
	public static void main(String[] args)
	{
		int myNumber;
      int myExpo;
      double myAnswer;
		System.out.println("Please enter a number >> ");
      Scanner keyboard = new Scanner(System.in); 
      // this prepares Scanner for KB input
      myNumber = keyboard.nextInt();
      myExpo = keyboard.nextInt();
      // myNumber int is equal to keyboard.nextInt(). This makes Scanner
      // populate myNumber with the int value of numbers entered
		myAnswer = Math.pow(myNumber,myExpo); //hooking up a module like this in an arg does work
      System.out.println(myNumber);         //println does start a new line for each arg
      System.out.println("to the power of");
      System.out.println(myExpo);
      System.out.println("is");
		System.out.println(myAnswer);
	}
}
