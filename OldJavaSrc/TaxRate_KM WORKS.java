import java.util.Scanner;
import java.text.DecimalFormat;
public class TaxRate_KM
{
    public static void main(String[] args)
    {    
    double price;                                  //startup
    double stateTaxRate;
    double cityTaxRate;
    double totalTax;
    double total;
    System.out.println("Enter price");
    Scanner keyboard    = new Scanner(System.in);
    price = keyboard.nextDouble();
    if (price == 0)
      {
         System.out.println("End of program");
      }
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
   }
}
      