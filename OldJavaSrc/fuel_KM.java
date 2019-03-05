import java.util.Scanner;
public class fuel_KM
{
    public static void main(String[] args)
    {
        int    beginningOdometerReading;
        int    endingOdometerReading;
        double gallonsToFillTank;
        double costPerGallonOfGas;
        int    numberMileDrivenPerYear;
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
        double fuelCostPerAnnum = numberMileDrivenPerYear
                                / milesPerGallon
                                * costPerGallonOfGas;
        double fuelCostPerMile  = costPerGallonOfGas / milesPerGallon;
        System.out.println(" ");  
	     System.out.println("Miles per gallon:     " + milesPerGallon);
        System.out.println("Fuel cost per mile:  " + fuelCostPerMile);
        System.out.println("Fuel cost per year:  " + fuelCostPerAnnum);
    }
}