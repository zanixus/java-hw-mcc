/**                                                         @version 1.0
 *   Version 1.0: initial release
 * while loop demo prograM
 */
import java.util.Scanner;
public class compoundInterest
{
   public static void main(String[] args)
   { 
      Scanner keyboard = new Scanner(System.in);
      double balance = -1, annualRate = .24, monthlyPayment = -1;
      int howManyMonths = 0;
      while(balance<0)
      {
      System.out.println("Please enter the balance.");
      balance = keyboard.nextDouble();
      System.out.println("Please enter your monthly payments.");
      monthlyPayment = keyboard.nextDouble();
      }
      while(balance>0)
      {
         balance = balance + (balance * annualRate/12);
         balance = balance - monthlyPayment;
         System.out.println("Balance: "+balance);
         howManyMonths++;        
      }
      System.out.println(howManyMonths-1 + " months");
   
   
     
//    int number, mod, sum, perfectCount = 0;
//    for (number=1; number <= 1000; number++)
//    {//loop 1-999
//    sum = 0; //initalize sum value for the loop
//       for (int i = 1; i < number; i++)
//       {//start number test loop
//          mod = number % i;
//          if (mod == 0)        
//             sum = sum + i;
//       }//end perfect number test
//    if (sum == number)
//    System.out.printf("Perfect number: %1d\n",number);
//    }
   }
}
