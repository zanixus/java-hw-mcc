/**                                                         @version 2.0
 *   @author Kevin M. Mallgrave
 *           Professor Janet Brown-Sederberg
 *           CTIM-157 B02
 *   @since  19 October 2018
 *
 *   This program will calculate the cost of a boat for the user.
 *   It take inputs in sequence, stores them in memory, and outputs
 *   the result of arithmetic operations as user-friendly string data.
 *
 *   Version 1.0: initial release
 *   Version 1.1: corrected outputs to match exact case spec of
 *   Version 2.0: chapter 3 project overhaul
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class CPC2_FALL_2018_KMM
{
    public static void main(String[] args)
    {   //    Declarations                                                  //1
        final int ANNUAL_REGISTRATION_FEE = 150;
        final int ANNUAL_COASTGUARD_INSPECTION_FEE = 100;
        int    boatYear, hoursPerYear, totalRegistrationCost;
        int    numberOfBerths, numberOfDaysOfCoastGuardApprovedTrainingPerYear;
        double boatPrice, interestRate, downPayment, hoursPerGallon;
        double costGallonFuel, monthlyMooringFee, boatLength;
        double salvageValue, zeroDayLoanBalance;
        double repairMaintenanceYear1, repairMaintenanceYear2;
        double repairMaintenanceYear3, totalInterestPaid, totalLoanPayments;
        double bookValueBeginningYear1, depreciationYear1;
        double bookValueBeginningYear2, depreciationYear2;
        double bookValueBeginningYear3, depreciationYear3;
        double totalDepreciation, totalExciseTax, totalInsuranceCost;
        double totalFuelCost, annualFuelCost, totalCoastGuardInspectionFee;
        double annualMooringCost, totalMooringCost, totalBoatCost;
        boolean boatIsNew;
        String boatName, boatMake, boatModel;
        String pleaseEnter = "Please enter the";
        String boatInfo    = "of the boat:";
        DecimalFormat usFoot         = new DecimalFormat ("0.00 foot");
        DecimalFormat usDollars      = new DecimalFormat ("'$'0.00");
        DecimalFormat thousandths    = new DecimalFormat ("0.0000");
        Scanner keyboard = new Scanner(System.in);
        //         begin input sequence                                     //2
        System.out.printf("%1s name %1s\n", pleaseEnter, boatInfo);
        boatName   = keyboard.nextLine();
        System.out.printf("%1s year %1s\n", pleaseEnter, boatInfo);
        boatYear   = keyboard.nextInt(); keyboard.nextLine();
        if (boatYear > 2018 || boatYear < 1900)                           //B
           {
           System.out.printf("Invalid boat year entered. ");              
           boatYear   = 2018; 
           System.out.printf("Your boat model year has been set to %1d.\n",
           boatYear);                     
           }         
        System.out.printf("%1s make %1s\n", pleaseEnter, boatInfo);
        boatMake   = keyboard.nextLine();
        System.out.printf("%1s model %1s\n", pleaseEnter, boatInfo);
        boatModel  = keyboard.nextLine();
        System.out.printf("%1s length %1s\n", pleaseEnter, boatInfo); 
        boatLength = keyboard.nextDouble(); keyboard.nextLine();
        if  (boatLength <=0.0)                                            //C
           {
           System.out.printf("Invalid boat length entered. ");              
           boatLength   = 42.00; 
           System.out.printf("Your boat length has been set to %1.2f feet.\n",
           boatLength);                     
           } 
        System.out.printf("%1s price %1s\n", pleaseEnter, boatInfo);
        boatPrice  = keyboard.nextDouble(); keyboard.nextLine();
        System.out.printf("%1s down payment you will make:\n", pleaseEnter);
        downPayment    = keyboard.nextDouble(); keyboard.nextLine();
        System.out.printf("%1s interest rate on your loan:\n", pleaseEnter);
        interestRate   = keyboard.nextDouble(); keyboard.nextLine();
        System.out.printf("%1s average hours per gallon:\n", pleaseEnter);
        hoursPerGallon = keyboard.nextDouble(); keyboard.nextLine();
        System.out.printf("%1s average cost of gas per gallon:\n", pleaseEnter);
        costGallonFuel = keyboard.nextDouble(); keyboard.nextLine();
        System.out.printf("%1s average hours per year:\n", pleaseEnter);
        hoursPerYear = keyboard.nextInt(); keyboard.nextLine();
        System.out.printf("%1s monthly mooring fee:\n", pleaseEnter);
        monthlyMooringFee = keyboard.nextDouble(); keyboard.nextLine();
        
            //    begin boat cost calculation sequence
        salvageValue       = boatPrice * .33;                               //a
        double monthlyLoanPayment =                                         //b
               (boatPrice - downPayment) * ((interestRate / 12)
               / (1 - Math.pow(1 + (interestRate / 12), - (3 * 12))));
        zeroDayLoanBalance     = boatPrice - downPayment;    //need this double
        totalLoanPayments      = monthlyLoanPayment * 36;                   //c
        totalInterestPaid      = monthlyLoanPayment * 36                    //d
                               - zeroDayLoanBalance;
        repairMaintenanceYear1 = boatPrice * .01;                           //e
        repairMaintenanceYear2 = boatPrice * .02;
        repairMaintenanceYear3 = boatPrice * .03;
        double totalRepairMaintenance = repairMaintenanceYear1              //f
             + repairMaintenanceYear2 + repairMaintenanceYear3;
        bookValueBeginningYear1 = boatPrice;                                //g
        depreciationYear1 = 
        bookValueBeginningYear1 * 2 * 1 / 3.0;
        bookValueBeginningYear2 = bookValueBeginningYear1 - depreciationYear1;
        depreciationYear2 = 
        bookValueBeginningYear2 * 2 * 1 / 3.0;
        bookValueBeginningYear3 = bookValueBeginningYear2 - depreciationYear2;
        depreciationYear3 = 
        bookValueBeginningYear3 * 2 * 1 / 3.0;
        totalDepreciation = depreciationYear1 + depreciationYear2
                          + depreciationYear3;
        double exciseTaxYear1 = .9 * boatPrice / 1000 * 25;                 //i
        double exciseTaxYear2 = .8 * boatPrice / 1000 * 25;
        double exciseTaxYear3 = .7 * boatPrice / 1000 * 25;
        totalExciseTax = exciseTaxYear1 + exciseTaxYear2 + exciseTaxYear3;  //j
        double insuranceYear1 =
        boatPrice * .01 + bookValueBeginningYear1 * .03;                    //k
        double insuranceYear2 = 
        boatPrice * .01 + bookValueBeginningYear2 * .03;
        double insuranceYear3 = 
        boatPrice * .01 + bookValueBeginningYear3 * .03 ;
        totalInsuranceCost  = insuranceYear1                                //l
                            + insuranceYear2 + insuranceYear3;
        annualFuelCost = costGallonFuel * 100;                              //m
        totalFuelCost  = annualFuelCost * 3;                                //n
        totalCoastGuardInspectionFee = ANNUAL_COASTGUARD_INSPECTION_FEE*3;//o&p
        totalRegistrationCost        = ANNUAL_REGISTRATION_FEE * 3;       //q&r
        annualMooringCost            = monthlyMooringFee * 12;              //s
        totalMooringCost             = annualMooringCost * 3;               //t
        totalBoatCost                = boatPrice + totalInterestPaid;       //u
        double annualInterestPaid    = totalInterestPaid / 3;               //v
        //    begin output sequence
        System.out.printf("\n");
        System.out.printf
        ("Cost analysis prepared for the purchase of: %1s.\n", boatName);
        System.out.printf
        ("The costs of buying and owning a %1s %1d %1s %1s are as follows:\n",
        usFoot.format(boatLength), boatYear, boatMake, boatModel);
        System.out.printf
        ("Purchased for %1s with a downpayment of %1s\n",
        usDollars.format(boatPrice), usDollars.format(downPayment));
        System.out.printf
        ("and an interest rate of %1s on a loan of %1s:\n",
        thousandths.format(interestRate), usDollars.format(zeroDayLoanBalance));
        System.out.printf
        ("The monthly loan payment will be %1s per month.\n",
        usDollars.format(monthlyLoanPayment));
        System.out.printf("\n");
        System.out.printf("Year 1 annual additional costs will be:\n");
        System.out.printf("Depreciation: %s\n",
        usDollars.format(depreciationYear1));
        System.out.printf("Excise Tax: %s\n",
        usDollars.format(exciseTaxYear1));
        System.out.printf("Fuel: %s\n",
        usDollars.format(annualFuelCost));
        System.out.printf("Inspection Cost: %s\n",
        usDollars.format(ANNUAL_COASTGUARD_INSPECTION_FEE));
        System.out.printf("Insurance: %s\n",
        usDollars.format(insuranceYear1));
        System.out.printf("Interest: %s\n",
        usDollars.format(annualInterestPaid));
        System.out.printf("Registration: %s\n",
        usDollars.format(ANNUAL_REGISTRATION_FEE));
        System.out.printf("Repair and Maintenance: %s\n",
        usDollars.format(repairMaintenanceYear1));
        System.out.printf("Mooring Cost: %s\n",
        usDollars.format(annualMooringCost));
        System.out.printf("\n");
        System.out.printf("Year 2 annual additional costs will be:\n");
        System.out.printf("Depreciation: %s\n",
        usDollars.format(depreciationYear2));
        System.out.printf("Excise Tax: %s\n",
        usDollars.format(exciseTaxYear2));
        System.out.printf("Fuel: %s\n",
        usDollars.format(annualFuelCost));
        System.out.printf("Inspection Cost: %s\n",
        usDollars.format(ANNUAL_COASTGUARD_INSPECTION_FEE));
        System.out.printf("Insurance: %s\n",
        usDollars.format(insuranceYear2));
        System.out.printf("Interest: %s\n",
        usDollars.format(annualInterestPaid));
        System.out.printf("Registration: %s\n",
        usDollars.format(ANNUAL_REGISTRATION_FEE));
        System.out.printf("Repair and Maintenance: %s\n",
        usDollars.format(repairMaintenanceYear2));
        System.out.printf("Mooring Cost: %s\n",
        usDollars.format(annualMooringCost));
        System.out.printf("\n");
        System.out.printf("Year 3 annual additional costs will be:\n");
        System.out.printf("Depreciation: %s\n",
        usDollars.format(depreciationYear3));
        System.out.printf("Excise Tax: %s\n",
        usDollars.format(exciseTaxYear3));
        System.out.printf("Fuel: %s\n",
        usDollars.format(annualFuelCost));
        System.out.printf("Inspection Cost: %s\n",
        usDollars.format(ANNUAL_COASTGUARD_INSPECTION_FEE));
        System.out.printf("Insurance: %s\n",
        usDollars.format(insuranceYear3));
        System.out.printf("Interest: %s\n",
        usDollars.format(annualInterestPaid));
        System.out.printf("Registration: %s\n",
        usDollars.format(ANNUAL_REGISTRATION_FEE));
        System.out.printf("Repair and Maintenance: %s\n",
        usDollars.format(repairMaintenanceYear3));
        System.out.printf("Mooring Cost: %s\n",
        usDollars.format(annualMooringCost));
        System.out.printf("\n");
        System.out.printf("The total costs will be:\n");
        System.out.printf("Total boat cost: %s\n",
        usDollars.format(totalBoatCost));
        System.out.printf("Total depreciation cost: %s\n",
        usDollars.format(totalDepreciation));
        System.out.printf("Total excise tax cost: %s\n",
        usDollars.format(totalExciseTax));
        System.out.printf("Total fuel costs: %s\n",
        usDollars.format(totalFuelCost));
        System.out.printf("Total inspection cost: %s\n",
        usDollars.format(totalCoastGuardInspectionFee));
        System.out.printf("Total insurance cost: %s\n",
        usDollars.format(totalInsuranceCost));
        System.out.printf("Total interest cost: %s\n",
        usDollars.format(totalInterestPaid));
        System.out.printf("Total registration costs: %s\n",
        usDollars.format(totalRegistrationCost));
        System.out.printf("Total repair/maintenance costs: %s\n",
        usDollars.format(totalRepairMaintenance));
        System.out.printf("Total mooring costs: %s\n",
        usDollars.format(totalMooringCost));        
    }
}