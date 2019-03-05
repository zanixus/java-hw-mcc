/**                                                         @version 1.0
 *   @author Kevin M. Mallgrave
 *           Professor Janet Brown-Sederberg
 *           CTIM-157 B02
 *   @since  02 November 2018
 *
 *  This program takes an asset cost, salvage value and useful
 *  lifespan as input and processes it using three different
 *  depreciation paradigms. The program then outputs values in USD
 *  for the user displaying their asset depreciation using these
 *  three models, based on their initial input values.
 *  The three depreciation models used are Straight Line,
 *  Double Declining Balance, and Sum of Years' Digits.
 *
 *  Version 1.0: initial release
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class Depreciation_KMM
{
    public static void main(String[] args)
    {//Declarations
    double cost, salvageValue, usefulLife;
    double expenseI, expenseJ, expenseK;
    // external class setup sequence
    DecimalFormat usDollars = new DecimalFormat ("$#,##0.00");
    Scanner keyboard        = new Scanner(System.in);
    // input sequence
    System.out.printf("Please enter asset cost.\n");
    cost = keyboard.nextDouble();
    System.out.printf("Please enter asset salvage value.\n");
    salvageValue = keyboard.nextDouble();
    System.out.printf("Please enter useful life of the asset in years.\n");
    usefulLife = keyboard.nextDouble();
    // process loop stack - calc depreciation with 3 paradigms
    System.out.printf("Straight line depreciation model:\n");
    for (int i = 1; i<=usefulLife;i++)
    {// P1. Straight Line
        expenseI = (cost - salvageValue) / usefulLife;
        System.out.printf("Year %1d: %1s\n", i, usDollars.format(expenseI));
    }
    System.out.printf("Double declining balance depreciation model:\n");
    double bookValueJ =
    cost, doubleDecliningYearly = ((1.0 / usefulLife) * 2) * 100; 
    for (int j = 1; j<=usefulLife;j++)
    {// P2. Double Declining Balance
        expenseJ = bookValueJ * (doubleDecliningYearly / 100); 
        System.out.printf("Year %1d: %1s\n", j, usDollars.format(expenseJ));
        bookValueJ = bookValueJ - expenseJ;
    }
    // P3. Sum of the Years
    System.out.printf("Sum of the years' digits depreciation model:\n");
    double sumOfYears = 0, fraction;
    double bookValueK = cost, productionLife = usefulLife;
    int k;
    for (k = 1; k<=usefulLife;k++)
       {//this loop finds our sumOfYears variable for us
           sumOfYears = sumOfYears + (double)k;
       }
    for (k = 1; k <= usefulLife;k++)
    {
    fraction = productionLife / sumOfYears;
    expenseK = fraction * (bookValueK - salvageValue);
    System.out.printf("Year %1d: %1s\n", k, usDollars.format(expenseK));
    productionLife--;
    }//you evil CPA you. no funny money here
    }
}
