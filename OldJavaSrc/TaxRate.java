import java.util.Scanner;
import java.text.DecimalFormat;
public class TaxRate
{
    public static void main(String[] args)
    {    
    double price;                                  //housekeeping aka startUp()
    double stateTaxRate;
    double cityTaxRate;
    double totalTax;
    double total;
    System.out.println("Enter price");
    Scanner keyboard    = new Scanner(System.in);
    price = keyboard.nextDouble();
    if (price == 0)
      {
         System.out.println("End of program");    //endOfJob aka finishUp()
      }
    if (price >0)                                 //detailLoop aka mainLoop()
      {
      System.out.println("Enter state tax");
      stateTaxRate        = keyboard.nextDouble();
      System.out.println("Enter city tax");
      cityTaxRate        = keyboard.nextDouble();
          do                                             
          {
            if (price >0)
            {
            totalTax = price * stateTaxRate + price * cityTaxRate;
            total = price + totalTax;
            System.out.println("Price is " + price + " and total tax is " + totalTax);
            System.out.println("Total is " + total);
            System.out.println("Enter price");
            price = keyboard.nextDouble();
            }
          }
         while (price >0);    
      }                                            //end startup                                    
   }
}
      