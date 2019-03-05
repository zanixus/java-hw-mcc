/**                                                         @version 2.1
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
 *   Version 2.1: change format in program output, use Allman/BSD indent style
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class CPC3_FALL_2018_KMM
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
        //         start input sequence
        System.out.printf("%1s name %1s\n", pleaseEnter, boatInfo);
        boatName   = keyboard.nextLine();
        System.out.printf("%1s year %1s\n", pleaseEnter, boatInfo);
        boatYear   = keyboard.nextInt(); keyboard.nextLine();
        if (boatYear > 2018 || boatYear < 1900)                           //3.B
        {
            System.out.printf("Invalid boat year entered.\n");
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
        if (boatLength <=0.0)                                            //3.C
        {
           System.out.printf("Invalid boat length entered.\n");
           boatLength   = 42.00; 
           System.out.printf("Your boat length has been set to %1.2f feet.\n",
           boatLength);
        }
        System.out.printf("%1s price %1s\n", pleaseEnter, boatInfo);
        boatPrice  = keyboard.nextDouble(); keyboard.nextLine();        //3.D
        if (boatPrice <=0.0)
        {
            System.out.printf("Invalid boat price entered.\n");
            boatPrice   = 110000.0;
            System.out.printf("Your boat price has been set to %s.\n",
            usDollars.format(boatPrice));
        } 
        System.out.printf("%1s down payment you will make:\n",pleaseEnter);
        downPayment    = keyboard.nextDouble(); keyboard.nextLine();    //3.E,F
        if  (downPayment <=0.0)   
        {
            System.out.printf("Invalid down payment entered.\n");   
            downPayment  = 0.0; 
            System.out.printf("Your down payment has been set to %1s.\n",
            usDollars.format(downPayment)); 
        }
        System.out.printf("%1s if the boat is new, true or false:\n",
        pleaseEnter);
        boatIsNew     = keyboard.nextBoolean();
        if (downPayment >= boatPrice * 0.3 && boatIsNew == false) 
        {
           //do nothing successfully 
        }
        else if (boatIsNew == false)
        {  //boating aint cheap fella
           downPayment = boatPrice * 0.3; 
           System.out.printf
           ("Down payment is insufficient for a used boat.\n");
           System.out.printf
           ("The down payment on a used boat must be at least 30%% of the\n");
           System.out.printf
           ("price of the boat, therefore your downpayment has been\n");
           System.out.printf
           ("recorded as: %1s\n", usDollars.format(downPayment));
        }    
        System.out.printf("%1s interest rate on your loan:\n", pleaseEnter);
        interestRate   = keyboard.nextDouble(); keyboard.nextLine();
        if  (interestRate <=0.0)                                     //3.G
        {
            System.out.printf("Invalid interest rate entered.\n");   
            interestRate  = 0.0; 
            System.out.printf("Your interest rate has been set to %1s.\n",
            thousandths.format(interestRate));
        }
        if  (interestRate >=1.0)                                     //3.H
        {
            System.out.printf
            ("Interest rate must be entered as a decimal value ");
            System.out.printf
            ("less than 1.0.\n");              
            interestRate  = interestRate / 100.0; 
            System.out.printf("Your interest rate has been set to %1s.\n",
            thousandths.format(interestRate));      
        }
        System.out.printf("%1s average hours per gallon:\n", pleaseEnter);
        hoursPerGallon = keyboard.nextDouble(); keyboard.nextLine();    
        if  (hoursPerGallon <=0.0)                                   //3.I  
        {
            System.out.printf("Invalid hours per gallon entered.\n");    
            hoursPerGallon  = 0.0; 
            System.out.printf("Your hours per gallon has been set to %1.2f.\n",
            (hoursPerGallon));                     
        }
        System.out.printf
        ("%1s average cost of gas per gallon:\n", pleaseEnter);
        costGallonFuel = keyboard.nextDouble(); keyboard.nextLine();
        if  (costGallonFuel <=0.0)                                  //3.J
        {
            System.out.printf("Invalid cost of gas per gallon entered.\n"); 
            costGallonFuel  = 0.0; 
            System.out.printf
            ("Your cost of gas per gallon has been set to %1s.\n",
            usDollars.format(costGallonFuel));           
        }
        System.out.printf("%1s average hours per year:\n", pleaseEnter);
        hoursPerYear = keyboard.nextInt(); keyboard.nextLine();  
        if  (hoursPerYear <=0)                                    //3.K
        {
            System.out.printf("Invalid hours per year entered.\n");  
            hoursPerYear  = 0; 
            System.out.printf("Your hours per year has been set to %1d.\n",
            hoursPerYear);
        }
        System.out.printf("%1s monthly mooring fee:\n", pleaseEnter);
        monthlyMooringFee = keyboard.nextDouble(); keyboard.nextLine(); 
        if  (monthlyMooringFee <=0.0)                             //3.L
        {
            System.out.printf("Invalid monthly mooring fee entered.\n");
            monthlyMooringFee  = 0.0; 
            System.out.printf("Your monthly mooring fee has been set to %1s.\n",
            usDollars.format(monthlyMooringFee));
        }
        System.out.printf("%1s the number of berths:\n", pleaseEnter);
        numberOfBerths = keyboard.nextInt(); keyboard.nextLine(); 
        if  (numberOfBerths <=0)                                    //3.M
        {
            System.out.printf("Invalid number of berths entered.\n");
            numberOfBerths  = 0; 
            System.out.printf("Your number of berths has been set to %1d.\n",
            numberOfBerths);                     
        }                  
        System.out.printf
        ("%1s number of Coast Guard training days per year you'll have:\n"
        , pleaseEnter);
        numberOfDaysOfCoastGuardApprovedTrainingPerYear = // long int name lol
        keyboard.nextInt(); keyboard.nextLine(); 
        if  (numberOfDaysOfCoastGuardApprovedTrainingPerYear <=0.0) //3.N
        {
            System.out.printf
            ("Invalid number of Coast Guard "); 
            System.out.printf
            ("training days per year entered.\n");              
            numberOfDaysOfCoastGuardApprovedTrainingPerYear = 0; 
            System.out.printf
            ("Your Coast Guard training days per year have been set to %1d.\n",
            numberOfDaysOfCoastGuardApprovedTrainingPerYear);    
        }                        
        //    start boat cost calculation sequence
        salvageValue       = boatPrice * .33;                             //2.a
        double monthlyLoanPayment =                                       //2.b
               (boatPrice - downPayment) * ((interestRate / 12)
               / (1 - Math.pow(1 + (interestRate / 12), - (3 * 12))));
        zeroDayLoanBalance     = boatPrice - downPayment;
        totalLoanPayments      = monthlyLoanPayment * 36;                 //2.c
        totalInterestPaid      = monthlyLoanPayment * 36                  //2.d
                               - zeroDayLoanBalance;
        repairMaintenanceYear1 = boatPrice * .01;                         //2.e
        repairMaintenanceYear2 = boatPrice * .02;
        repairMaintenanceYear3 = boatPrice * .03;
        double totalRepairMaintenance = repairMaintenanceYear1            //2.f
             + repairMaintenanceYear2 + repairMaintenanceYear3;
        bookValueBeginningYear1 = boatPrice;                              //2.g
        depreciationYear1 = 
        bookValueBeginningYear1 * (2 * 1 / 3.0);
        bookValueBeginningYear2 = bookValueBeginningYear1 - depreciationYear1;
        if((bookValueBeginningYear1 - depreciationYear1) < salvageValue)//3.A.a
        {
           depreciationYear1 = bookValueBeginningYear1 - salvageValue;
        }
        bookValueBeginningYear2 = bookValueBeginningYear1 - depreciationYear1;
        depreciationYear2 = 
        bookValueBeginningYear2 * (2 * 1 / 3.0);
        if((bookValueBeginningYear2 - depreciationYear2) < salvageValue)//3.A.b
        {
           depreciationYear2 = bookValueBeginningYear2 - salvageValue;
        }
        bookValueBeginningYear3 = bookValueBeginningYear2 - depreciationYear2;
        depreciationYear3 = 
        bookValueBeginningYear3 * (2 * 1 / 3.0);
        if((bookValueBeginningYear3 - depreciationYear3) < salvageValue)//3.A.c
        {
           depreciationYear3 = bookValueBeginningYear3 - salvageValue;
        }
        totalDepreciation = depreciationYear1 + depreciationYear2
                          + depreciationYear3;
        double exciseTaxYear1 = .9 * boatPrice / 1000 * 25;               //2.i
        double exciseTaxYear2 = .8 * boatPrice / 1000 * 25;
        double exciseTaxYear3 = .7 * boatPrice / 1000 * 25;
        totalExciseTax = exciseTaxYear1 + exciseTaxYear2 + exciseTaxYear3;//2.j
        double insuranceYear1 =                                         //3.O,P
          (boatPrice * .01 + bookValueBeginningYear1 * .03)
        + (numberOfBerths * 225)
        - (numberOfDaysOfCoastGuardApprovedTrainingPerYear * 125);       //2.k
        double insuranceYear2 = 
          (boatPrice * .01 + bookValueBeginningYear2 * .03)
        + (numberOfBerths * 225)
        - (numberOfDaysOfCoastGuardApprovedTrainingPerYear * 125);
        double insuranceYear3 = 
          (boatPrice * .01 + bookValueBeginningYear3 * .03)       
        + (numberOfBerths * 225)
        - (numberOfDaysOfCoastGuardApprovedTrainingPerYear * 125);
        totalInsuranceCost  = insuranceYear1                              //2.l
                            + insuranceYear2 + insuranceYear3;
        annualFuelCost = costGallonFuel * 100;                            //2.m
        totalFuelCost  = annualFuelCost * 3;                              //2.n
        totalCoastGuardInspectionFee = ANNUAL_COASTGUARD_INSPECTION_FEE*3;
        totalRegistrationCost        = ANNUAL_REGISTRATION_FEE * 3; //2.o,p,q,r
        annualMooringCost            = monthlyMooringFee * 12;            //2.s
        totalMooringCost             = annualMooringCost * 3;             //2.t
        totalBoatCost                = boatPrice + totalInterestPaid;     //2.u
        double annualInterestPaid    = totalInterestPaid / 3;             //2.v
        //    start output sequence
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
        ("The monthly loan payment will be $%1.2f per month.\n",
        (monthlyLoanPayment));
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
