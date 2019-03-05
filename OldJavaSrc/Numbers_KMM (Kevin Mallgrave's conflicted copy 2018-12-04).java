/**                                                       @version 1.0
   @author Kevin M. Mallgrave
           Professor Janet Brown-Sederberg
           CTIM-157 B02
   @since  30 November 2018

   This class is a collection of five methods.
   I have included a small main method as a demo program,
   but these methods will work when instanced in another
   class.
   
   Version 1.0: initial release

 */
public class Numbers_KMM
{

//begin methods toolbox: 
//double output:  smallest(), average() 
//boolean output: allTheSame(), allDifferent(), sorted()
   
   public double smallest (double x, double y, double z)
   {
   if      (x < y && y < z)
      return x; 
   else if (y < x && y < z)
      return y;
   else
      return z;
   }
   
   public double average (double x, double y, double z)
   {
   double sum = x + y + z;
   return sum / 3;
   }   

   public boolean allTheSame (double x, double y, double z)
   {
   if (x == y && y == z)
      return true;
   else
      return false;
   }
      
   public boolean allDifferent (double x, double y, double z)
   {
   if (x != y && x != z && y != z)
      return true;
   else
      return false;
   }
      
   public boolean sorted (double x, double y, double z)
   {
   if (x <= y && y <= z)
      return true;
   else
      return false; 
   }
   
//end methods toolbox
//
//begin demo main method to test outputs
   
   public static void main(String[] args)
   {  
   Numbers_KMM tonyTheNumbersGuy = new Numbers_KMM();//yo tony, numbers guy
   double firstNumber, secondNumber, thirdNumber;//handle deez numbas for me
   System.out.println("Method outputs:");
   firstNumber    = 3;
   secondNumber   = 6;
   thirdNumber    = 9;
   System.out.println("Method smallest output:     " +//tony says OK
   tonyTheNumbersGuy.smallest(firstNumber,secondNumber,thirdNumber));
   System.out.println("Method average output:      " +
   tonyTheNumbersGuy.average(firstNumber,secondNumber,thirdNumber));
   System.out.println("Method allTheSame output:   " +
   tonyTheNumbersGuy.allTheSame(firstNumber,secondNumber,thirdNumber));
   System.out.println("Method allDifferent output: " +
   tonyTheNumbersGuy.allDifferent(firstNumber,secondNumber,thirdNumber));
   System.out.println("Method sorted output:       " +
   tonyTheNumbersGuy.sorted(firstNumber,secondNumber,thirdNumber));     
   }  
}//end class