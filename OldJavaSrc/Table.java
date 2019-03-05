public class Table
    {
    public void makeDepreciationTable( int useful_Life, double acquisition_Value, double salvage_Value )
    {
        int sum = 0;
        int year = 1;
        double accumulatedDepreciation = 0;
        //  make a loop to calculate the sum
        while ( year <= useful_Life )
        {
            sum += year;
            year++;
        }
        System.out.println("The sum is " +sum );
        // write the header of the table
        System.out.println(" Acquisition Value" + "" + " Salvage Value" + "" + " Useful Life" + "" + " Annual Depreciation" + "" + " Accumulated Depreciation" + "" + " Book Value" + "" +" Fraction");
        // make a loop
        while ( year <= useful_Life )
        {
            // calculate fraction
            double fraction = (double)year/sum;
            // calculate annualDepreciation
            double annualDepreciation = (acquisition_Value - salvage_Value) * fraction ;
            // calc accumulatedDepreciation
            accumulatedDepreciation += annualDepreciation;
            // calc bookValue
            double bookValue = acquisition_Value  - accumulatedDepreciation;
            // write one line of table
            System.out.println(acquisition_Value + "" + salvage_Value + "" + useful_Life + "" + annualDepreciation + "" + accumulatedDepreciation + "" + bookValue + "" + fraction);
            year++;
        }



    }
}