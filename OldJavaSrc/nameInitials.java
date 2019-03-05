/**                                                                @version 1.0
 *   @author Kevin M. Mallgrave
 *           Professor Janet Brown-Sederberg
 *           CTIM-157 B02
 *   @since  15 September 2018
 *   
 *    This is a Java initials generator
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class nameInitials
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
        String fuelCostPerAnnumCents  = currencyUSD.format(fuelCostPerAnnum);
        String fuelCostPerMileCents   = currencyUSD.format(fuelCostPerMile);
        System.out.println(" ");  
	System.out.println("Miles per gallon:     " + (milesPerGallon)); //3
        System.out.println("Fuel cost per mile:  " + (fuelCostPerMileCents));
        System.out.println("Fuel Cost Per Annum: " + (fuelCostPerAnnumCents));
    }
}

/*
   Post-code comments:
   1.
   We know that the US dollar only has two decimal places
   so I am formatting my doubles this way so I can't possibly for example
   get something like $0.6987654321 cents back no matter what I input
   This is USD, not BTC. We can't "really" have something like $.6987654321
   This does turn variable double fuelCostPer* inputs into string values
   (i e non-numeric data), but according to Oracle docs on DecimalFormat
   it rounds floats/doubles with the largest truncated decimal number.
   So 2.4987654321(,...) should output $2.50 as string value.
   I am recalling your comments on IRS and USD rounding Thursday here
   and your brother's old Basic program. As USD is a strictly defined
   value in the real world, we must make sure our output is consistent
   with its actual use unless we want a rude visit from the Taxman.
   
   2.
   I have broken out this argument over three newlines as it makes it more
   readable for me and hopefully for you for the sake of grading future
   assignments. This is a holdover from my shell scripting days
   to make scripts more readable. I'm not sure if it's "proper" Java scripting
   but it makes it easier for me to move things around and read.
   I make newlines at 80 lines as my most familiar coding is done in with
   vim in a Linux virtual terminal environment(80x60 xterm - this code was
   written in one) or notepad++ in Windows. 
   This file looks consistent in both editors and jGRASP,
   so I will probably use this format for the rest of my semester,
   but if you could give me feedback I would be grateful.

   3.
   This MPG figure hit home. I drive a 1986 Ford Mustang GT with a
   5.0 liter V8 engine. I wrench on it as a hobby and installed new heads,
   camshaft, intake, and exhaust. I upgraded the engine computer,
   fuel injectors, fuel pump, switched to 93 octane gas, and then
   I installed a supercharger on top of all that.
   Guess how much miles per gallon that thing gets? "Smiles per gallon"
*/
