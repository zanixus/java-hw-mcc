/**                                                       @version 1.0
   @author Kevin M. Mallgrave
           Professor Janet Brown-Sederberg
           CTIM-157 B02
   @since  30 November 2018
    This is a small demo class for my Numbers_KMM class.
    This program requires Numbers_KMM.java to function properly.
    
    Version 1.0: initial release

*/
import java.util.Scanner;
public class NumbersInstanceDemo_KMM
{
   public static void main(String[] args)
   {//begin main  
   Numbers_KMM numbers = new Numbers_KMM(); 
   Scanner numberInput = new Scanner(System.in);
   double firstNumber, secondNumber, thirdNumber;
   System.out.println("Please enter three numbers.");
   firstNumber    = numberInput.nextDouble();
   secondNumber   = numberInput.nextDouble();
   thirdNumber    = numberInput.nextDouble();
   System.out.println("Method smallest output:     " +
   numbers.smallest(firstNumber,secondNumber,thirdNumber));
   System.out.println("Method average output:      " +
   numbers.average(firstNumber,secondNumber,thirdNumber));
   System.out.println("Method allTheSame output:   " +
   numbers.allTheSame(firstNumber,secondNumber,thirdNumber));
   System.out.println("Method allDifferent output: " +
   numbers.allDifferent(firstNumber,secondNumber,thirdNumber));
   System.out.println("Method sorted output:       " +
   numbers.sorted(firstNumber,secondNumber,thirdNumber));     
   }//end main
}//end class
