/**                                                         @version 1.0
 *   @author Kevin M. Mallgrave
 *           Professor Janet Brown-Sederberg
 *           CTIM-157 B02
 *   @since  19 October 2018
 *
 * This program uses a nested loop to test each number from 1 to 1000.
 * The inner loop uses the mod op to test for even divisors.
 * It adds each even divisor to the sum variable. When the inner loop finishes,
 * the outer loop does a boolean comparison to the number and sum variable.
 * If they are equal, it prints the number to the screen and continues.
 * 
 *   Version 1.0: initial release
 */
public class Perfect_KMM
{
   public static void main(String[] args)
   {   
   int number, mod, sum, perfectCount = 0;
   for (number=1; number <= 1000; number++)
   {//loop 1-999
   sum = 0; //initalize sum value for the loop
      for (int i = 1; i < number; i++)
      {//start number test loop
         mod = number % i;
         if (mod == 0)        
            sum = sum + i;
      }//end perfect number test
   if (sum == number)
   System.out.printf("Perfect number: %1d\n",number);
   }
   }
}
