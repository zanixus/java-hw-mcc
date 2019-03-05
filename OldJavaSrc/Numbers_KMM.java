/**                                                       @version 1.0
Write a program that prints the numbers from 1 to 100. 
But for multiples of three print “Fizz” instead of the number 
and for the multiples of five print “Buzz”. For numbers 
which are multiples of both three and five print “FizzBuzz”.

*/
import java.util.Scanner;
public class fizzbuzz_KMM
{
   public static void main(String[] args)
   {
   int fizz = 0, buzz = 0, fizzbuzz = 0, i;
   for (i=1; i<=100; i++)
   {
   fizz = i % 3; //3
   buzz = i % 5; //5
   fizzbuzz = fizz + buzz; //3+5
   if (fizz == 0)
      System.out.println(i+"<- fizz");
   else if (buzz == 0)
      System.out.println(i+"<- buzz");
   else if (fizzbuzz == 0)
      System.out.println(i+"<- fizzbuzz");
   else
   System.out.println(i);
   fizzbuzz = 0;
   fizz = 0;
   buzz = 0; 
   }
   }//end main
}//end class