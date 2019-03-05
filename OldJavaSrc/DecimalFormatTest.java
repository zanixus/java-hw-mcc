/*  Kevin M. Mallgrave
    Professor Janet Brown-Sederberg
    CTIM-157 B02
    15 Sep 2018
    This is a simple Java miles per gallon calculator.
    I have left numbered line comments in the file. These correspond to
    comments/thoughts I have written at the bottom of the file.
    This assignment hit home. I drive a 1986 Ford Mustang GT with a
    5.0 liter V8 engine. I wrench on it as a hobby and installed new heads,
    camshaft, intake, and exhaust. I upgraded the ECU and fuel injectors,
    then I installed a supercharger on top of all that.
    Guess how much miles per gallon that thing gets? "Smiles per gallon"
*/
import java.util.Scanner;
import java.text.DecimalFormat;
public class DecimalFormatTest
{
    public static void main(String[] args)
    {
        int    beginningOdometerReading;
        int    endingOdometerReading;
        double gallonsToFillTank;
        double costPerGallonOfGas;
        int    numberMileDrivenPerYear;
        DecimalFormat currencyUSD     = new DecimalFormat ("'$'0.00"); //1
        System.out.println("Enter your initial odometer reading (pre-fill)");
        Scanner keyboard = new Scanner(System.in);
        beginningOdometerReading = keyboard.nextInt();
        System.out.println("Enter your current odometer reading (post-drive)");
        endingOdometerReading = keyboard.nextInt();
        System.out.println("Enter your gas tank fill size in gallons");
        gallonsToFillTank = keyboard.nextDouble();
        System.out.println("Enter the cost per gallon of gas");
        costPerGallonOfGas = keyboard.nextDouble();
        System.out.println("Enter the miles driven per year");
        numberMileDrivenPerYear = keyboard.nextInt();
        int    milesDriven = endingOdometerReading - beginningOdometerReading;
        double milesPerGallon = milesDriven / gallonsToFillTank;
        double fuelCostPerAnnum = numberMileDrivenPerYear //2
                                / milesPerGallon
                                * costPerGallonOfGas;
        double fuelCostPerMile  = costPerGallonOfGas / milesPerGallon;
	double bsDouble = 0.698765432123456789;
	double bsAnnum = 2.498765432123456789;

        String fuelCostPerAnnumCents  = currencyUSD.format(bsAnnum);
        String fuelCostPerMileCents   = currencyUSD.format(bsDouble);
        System.out.println(" ");  
	System.out.println("Miles per gallon:     " + (milesPerGallon));
        System.out.println("Fuel cost per mile:  " + (fuelCostPerMileCents));
        System.out.println("Fuel Cost Per Annum: " + (fuelCostPerAnnumCents));
    }
}

/*
   Post-code comments:
   1.
   We know that the US dollar only has two decimal places
   so I am formatting my doubles this way so I can't possibly for example
   get something like $0.67373737 cents back no matter what I input
   This is USD, not BTC. We can't "really" have something like $.67373737
   This does turn variable double fuelCostPer* inputs into string values
   (i e non-numeric data), but according to Oracle docs on DecimalFormat
   it rounds floats/doubles with the largest truncated decimal number.
   So 2.49876543211111111111 should output $2.50 as string value.
   I am recalling your comments on IRS and USD rounding Thursday here
*/
