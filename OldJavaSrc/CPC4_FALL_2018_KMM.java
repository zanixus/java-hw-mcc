/**                                                         @version 4.0
 *   @author Kevin M. Mallgrave
 *           Professor Janet Brown-Sederberg
 *           CTIM-157 B02
 *   @since  02 November 2018
 *
 *   This program will calculate the cost of a boat for the user.
 *   It take inputs in sequence, stores them in memory, and outputs
 *   the result of arithmetic operations as user-friendly string data.
 *
 *   Version 1.0: initial release
 *   Version 1.1: corrected outputs to match exact case spec of PDF
 *   Version 2.0: chapter 3 project overhaul. use if statements for input
 *   Version 2.1: change format in program output, 
 *                use Allman/BSD indent style, style cleanup
 *   Version 4.0: Chapter 4 overhaul, version bump to 4 to match, 
 *                use do-while loops for input sequence
 *                Divide program into four clear blocks: 
 *                0. Declarations, 1. Input, 2. Processing,
 *                and 3. Output.
 *                Use DecimalFormat class for output code readability.  
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class CPC4_FALL_2018_KMM
{
    public static void main(String[] args)
    {//start main
        //    0.
        //    Declarations
        //
        final int ANNUAL_REGISTRATION_FEE = 150;
        final int ANNUAL_COASTGUARD_INSPECTION_FEE = 100;
        int    boatYear=-1, hoursPerYear, totalRegistrationCost;
        int    numberOfBerths=-1; 
        int    numberOfDaysOfCoastGuardApprovedTrainingPerYear=-1;
        double boatPrice=-1, interestRate=-1, downPayment=-1;
        double costGallonFuel=-1, monthlyMooringFee=-1, boatLength=-1;
        double salvageValue, zeroDayLoanBalance, hoursPerGallon=-1;
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
        String pleaseEnter           = "Please enter the";
        String boatInfo              = "of the boat";
        DecimalFormat usFoot         = new DecimalFormat ("0.00 foot");
        DecimalFormat usDollars      = new DecimalFormat ("'$'0.00");
        DecimalFormat thousandths    = new DecimalFormat ("0.0000");
        Scanner keyboard = new Scanner(System.in);
        
        //         1.
        //         start input sequence
        //         input block
        
        System.out.printf("%1s name %1s:\n", pleaseEnter, boatInfo);
        boatName   = keyboard.nextLine();
        
        do
        {          
            System.out.printf("%1s year %1s, must be >= 1900 and <= 2018:\n",
            pleaseEnter, boatInfo);
            boatYear   = keyboard.nextInt(); keyboard.nextLine();
        }
        while (boatYear > 2018 || boatYear < 1900);
        
        System.out.printf("%1s make %1s:\n", pleaseEnter, boatInfo);
        boatMake   = keyboard.nextLine();
        System.out.printf("%1s model %1s:\n", pleaseEnter, boatInfo);
        boatModel  = keyboard.nextLine();
        
        do 
        {
            System.out.printf
            ("%1s length %1s, must be > 0:\n", pleaseEnter, boatInfo); 
            boatLength = keyboard.nextDouble(); keyboard.nextLine();
        }
        while (boatLength <= 0);
        
        do
        {
            System.out.printf("%1s price %1s:\n", pleaseEnter, boatInfo);
            boatPrice  = keyboard.nextDouble(); keyboard.nextLine();;
        }
        while (boatPrice <=0.0); 
             
        System.out.printf("%1s if the boat is new, true or false:\n",
        pleaseEnter);
        boatIsNew     = keyboard.nextBoolean(); keyboard.nextLine();
        
        do   
        {  
            System.out.printf
            ("%1s down payment you will make, must ",pleaseEnter);
            System.out.printf("be >= 0 and >= 30%% of the purchase price:\n");
            downPayment    = keyboard.nextDouble(); keyboard.nextLine(); 
        }
        while  ((downPayment <=0.0)
        ||     (downPayment < boatPrice * 0.3 && boatIsNew == false));
        
        do
        {
            System.out.printf("%1s interest rate on your loan, must be >=0:\n"
            , pleaseEnter);
            interestRate   = keyboard.nextDouble(); keyboard.nextLine();  
            if  (interestRate >=1.0)
               {
               System.out.printf
               ("Interest rate must be entered as a decimal value ");
               System.out.printf
               ("less than 1.0.\n");              
               interestRate  = interestRate / 100.0; 
               System.out.printf("Your interest rate has been set to %1s.\n",
               thousandths.format(interestRate));      
               }
        }
        while  (interestRate <=0.0);
        
        do 
        {
            System.out.printf
            ("%1s average hours per gallon, must be >= 0:\n", pleaseEnter);
            hoursPerGallon   = keyboard.nextDouble(); keyboard.nextLine();                    
        }
        while  (hoursPerGallon <=0.0);
        
        do
        {
            System.out.printf
            ("%1s average cost of gas per gallon, must be >= 0:\n", pleaseEnter);
            costGallonFuel   = keyboard.nextDouble(); keyboard.nextLine();
        }
        while (costGallonFuel <=0.0);
  
        do
        {
            System.out.printf
            ("%1s average hours per year, must be >= 0:\n", pleaseEnter);
            hoursPerYear = keyboard.nextInt(); keyboard.nextLine();
        }
        while  (hoursPerYear <=0);
        
        do
        {
            System.out.printf
            ("%1s monthly mooring fee, must be >= 0:\n", pleaseEnter);
            monthlyMooringFee = keyboard.nextDouble(); keyboard.nextLine();
        }
        while  (monthlyMooringFee <=0.0);
        
        do
        {
        System.out.printf
        ("%1s number of berths the boat has, must be >= 0:\n", pleaseEnter);
        numberOfBerths = keyboard.nextInt(); keyboard.nextLine();                     
        }        
        while  (numberOfBerths <=0);
         
        do
        {
            System.out.printf
            ("%1s number of Coast Guard training days per year you'll have:\n",
            pleaseEnter);
            numberOfDaysOfCoastGuardApprovedTrainingPerYear =//long intname lol
            keyboard.nextInt(); keyboard.nextLine();   
        }
        while  (numberOfDaysOfCoastGuardApprovedTrainingPerYear <=0.0);
        
        //    2.                      
        //    start boat cost calculation sequence
        //    processing block
        
        salvageValue                  = boatPrice * .33;                  //2.a
                double monthlyLoanPayment     =                           //2.b
               (boatPrice - downPayment) * ((interestRate / 12)
               / (1 - Math.pow(1 + (interestRate / 12), - (3 * 12))));
        zeroDayLoanBalance            = boatPrice - downPayment;
        totalLoanPayments             = monthlyLoanPayment * 36;          //2.c
        totalInterestPaid             = monthlyLoanPayment * 36           //2.d
                                      - zeroDayLoanBalance;
        repairMaintenanceYear1        = boatPrice * .01;                  //2.e
        repairMaintenanceYear2        = boatPrice * .02;
        repairMaintenanceYear3        = boatPrice * .03;
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
        
        //    3.
        //    start output sequence
        //    output block
        
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
    }//end main
}