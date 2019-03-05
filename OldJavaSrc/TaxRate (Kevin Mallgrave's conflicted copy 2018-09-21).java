import java.util.Scanner;
public class TaxRate
   {
     public static void main(String[] args)
     {
     double price;
     double stateTaxRate;
     double cityTaxRate;
     double totalTax;
     double total;
     System.out.println("Enter price");
     Scanner keyboard    = new Scanner(System.in);
     price = keyboard.nextDouble();
     System.out.println("Enter state sales tax");
     stateTaxRate        = keyboard.nextDouble();
     System.out.println("Enter city sales tax");
     cityTaxRate        = keyboard.nextDouble();
     if (price == 0)
       {
          System.out.println("End of program");
       }
     if (price >0)                                 //detailLoop aka mainLoop()
       {
        do
        {
          if (price >0)
          {
          totalTax = price * stateTaxRate + price * cityTaxRate;
          total = price + totalTax;
          System.out.println("Price is " + price + " and total tax is " + totalTax);
          System.out.println("Total is " + total);
          System.out.println("Enter a price or 0 to quit");
          price = keyboard.nextDouble();
         }
        }
        while (price >0);    
       } 
       }
 }
