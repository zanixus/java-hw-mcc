/**                                                         @version 1.0
 *   @author Kevin M. Mallgrave
 *           Professor Janet Brown-Sederberg
 *           CTIM-157 B02
 *   @since  5 October 2018
 *
 *   This program will calculate the cost of a boat for the user.
 *   It take inputs in sequence, stores them in memory, and outputs
 *   the result of arithmetic operations. I have made use of Java
 *   classes DecimalFormat and Scanner in this simple program.
 *   I found the DecimalFormat class on Oracle Docs, I consider this
 *   to be a resource I learned of in Chapter 1/2 class sessions.
 *   I have optimized output line width for an 80x25 terminal stdout.
 *   I have considered the output specification in the PDF.
 *   This program prints dollar signs when appropriate,
 *   prints all dollar values to two decimal points,
 *   prints all decimal values to four decimal points,
 *   and uses printf() for all print statements.
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class CPC2_FALL_2018_KM
{
    public static void main(String[] args)
    {   //    Declarations                                                  //1
        final int ANNUAL_REGISTRATION_FEE = 150;
        final int ANNUAL_COASTGUARD_INSPECTION_FEE = 100;
        int    boatYear, hoursPerYear, totalRegistrationCost;
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
        String boatName, boatMake, boatModel;
        String pleaseEnter = "Please enter the";
        String boatInfo    = "of the boat";
        DecimalFormat usDollars      = new DecimalFormat ("'$'0.00");
        DecimalFormat usFoot         = new DecimalFormat ("0.00 foot");
        DecimalFormat thousandths    = new DecimalFormat ("0.0000");
        Scanner keyboard = new Scanner(System.in);
        //         begin input sequence                                     //2
        System.out.printf("%1s name %1s\n", pleaseEnter, boatInfo);
        boatName   = keyboard.nextLine();
        System.out.printf("%1s year %1s\n", pleaseEnter, boatInfo);
        boatYear   = keyboard.nextInt(); keyboard.nextLine();
        System.out.printf("%1s make %1s\n", pleaseEnter, boatInfo);
        boatMake   = keyboard.nextLine();
        System.out.printf("%1s model %1s\n", pleaseEnter, boatInfo);
        boatModel  = keyboard.nextLine();
        System.out.printf("%1s length %1s\n", pleaseEnter, boatInfo);
        boatLength = keyboard.nextDouble(); keyboard.nextLine();
        System.out.printf("%1s price %1s\n", pleaseEnter, boatInfo);
        boatPrice  = keyboard.nextDouble(); keyboard.nextLine();
        System.out.printf("%1s down payment you will make\n", pleaseEnter);
        downPayment    = keyboard.nextDouble(); keyboard.nextLine();
        System.out.printf("%1s interest rate on your loan\n", pleaseEnter);
        interestRate   = keyboard.nextDouble(); keyboard.nextLine();
        System.out.printf("%1s average hours per gallon\n", pleaseEnter);
        hoursPerGallon = keyboard.nextDouble(); keyboard.nextLine();
        System.out.printf("%1s average cost of gas per gallon\n", pleaseEnter);
        costGallonFuel = keyboard.nextDouble(); keyboard.nextLine();
        System.out.printf("%1s average hours per year\n", pleaseEnter);
        hoursPerYear = keyboard.nextInt(); keyboard.nextLine();
        System.out.printf("%1s monthly mooring fee\n", pleaseEnter);
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
        bookValueBeginningYear1 * 2 * 1 / 3;
        bookValueBeginningYear2 = bookValueBeginningYear1 - depreciationYear1;
        depreciationYear2 = 
        bookValueBeginningYear2 * 2 * 1 / 3;
        bookValueBeginningYear3 = bookValueBeginningYear2 - depreciationYear2;
        depreciationYear3 = 
        bookValueBeginningYear3 * 2 * 1 / 3;
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
        ("Cost analysis prepared for the purchase of %1s.\n", boatName);
        System.out.printf
        ("Total cost of ownership for a %1s %1d %1s %1s are as follows:\n",
        usFoot.format(boatLength), boatYear, boatMake, boatModel);
        System.out.printf
        ("Purchased for %1s with a down payment of %1s,\n",
        usDollars.format(boatPrice), usDollars.format(downPayment));
        System.out.printf
        ("and an interest rate of %1s on a loan of %1s.\n",
        thousandths.format(interestRate), usDollars.format(zeroDayLoanBalance));
        System.out.printf
        ("The monthly loan payment will be %1s per month.\n",
        usDollars.format(monthlyLoanPayment));
        System.out.printf("\n");
        System.out.printf("Year 1 annual additional costs will be:\n");
        System.out.printf("Depreciation:                    %s\n",
        usDollars.format(depreciationYear1));
        System.out.printf("Excise Tax:                      %s\n",
        usDollars.format(exciseTaxYear1));
        System.out.printf("Fuel:                            %s\n",
        usDollars.format(annualFuelCost));
        System.out.printf("Inspection Cost:                 %s\n",
        usDollars.format(ANNUAL_COASTGUARD_INSPECTION_FEE));
        System.out.printf("Insurance:                       %s\n",
        usDollars.format(insuranceYear1));
        System.out.printf("Interest:                        %s\n",
        usDollars.format(annualInterestPaid));
        System.out.printf("Registration:                    %s\n",
        usDollars.format(ANNUAL_REGISTRATION_FEE));
        System.out.printf("Repair and Maintenance:          %s\n",
        usDollars.format(repairMaintenanceYear1));
        System.out.printf("Mooring Cost:                    %s\n",
        usDollars.format(annualMooringCost));
        System.out.printf("\n");
        System.out.printf("Year 2 annual additional costs will be:\n");
        System.out.printf("Depreciation:                    %s\n",
        usDollars.format(depreciationYear2));
        System.out.printf("Excise Tax:                      %s\n",
        usDollars.format(exciseTaxYear2));
        System.out.printf("Fuel:                            %s\n",
        usDollars.format(annualFuelCost));
        System.out.printf("Inspection Cost:                 %s\n",
        usDollars.format(ANNUAL_COASTGUARD_INSPECTION_FEE));
        System.out.printf("Insurance:                       %s\n",
        usDollars.format(insuranceYear2));
        System.out.printf("Interest:                        %s\n",
        usDollars.format(annualInterestPaid));
        System.out.printf("Registration:                    %s\n",
        usDollars.format(ANNUAL_REGISTRATION_FEE));
        System.out.printf("Repair and Maintenance:          %s\n",
        usDollars.format(repairMaintenanceYear2));
        System.out.printf("Mooring Cost:                    %s\n",
        usDollars.format(annualMooringCost));
        System.out.printf("\n");
        System.out.printf("Year 3 annual additional costs will be:\n");
        System.out.printf("Depreciation:                    %s\n",
        usDollars.format(depreciationYear3));
        System.out.printf("Excise Tax:                      %s\n",
        usDollars.format(exciseTaxYear3));
        System.out.printf("Fuel:                            %s\n",
        usDollars.format(annualFuelCost));
        System.out.printf("Inspection Cost:                 %s\n",
        usDollars.format(ANNUAL_COASTGUARD_INSPECTION_FEE));
        System.out.printf("Insurance:                       %s\n",
        usDollars.format(insuranceYear3));
        System.out.printf("Interest:                        %s\n",
        usDollars.format(annualInterestPaid));
        System.out.printf("Registration:                    %s\n",
        usDollars.format(ANNUAL_REGISTRATION_FEE));
        System.out.printf("Repair and Maintenance:          %s\n",
        usDollars.format(repairMaintenanceYear3));
        System.out.printf("Mooring Cost:                    %s\n",
        usDollars.format(annualMooringCost));
        System.out.printf("\n");
        System.out.printf("The total costs will be:\n");
        System.out.printf("Total boat cost:                 %s\n",
        usDollars.format(totalBoatCost));
        System.out.printf("Total depreciation cost:         %s\n",
        usDollars.format(totalDepreciation));
        System.out.printf("Total excise tax cost:           %s\n",
        usDollars.format(totalExciseTax));
        System.out.printf("Total fuel costs:                %s\n",
        usDollars.format(totalFuelCost));
        System.out.printf("Total inspection cost:           %s\n",
        usDollars.format(totalCoastGuardInspectionFee));
        System.out.printf("Total insurance cost:            %s\n",
        usDollars.format(totalInsuranceCost));
        System.out.printf("Total interest paid:             %s\n",
        usDollars.format(totalInterestPaid));
        System.out.printf("Total registration costs:        %s\n",
        usDollars.format(totalRegistrationCost));
        System.out.printf("Total repair/maintenance costs:  %s\n",
        usDollars.format(totalRepairMaintenance));
        System.out.printf("Total mooring costs:             %s\n",
        usDollars.format(totalMooringCost));
    }
}