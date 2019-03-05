/**                                    @version 2.1
 *   @author Kevin M. Mallgrave
 *           Professor Janet Brown-Sederberg
 *           CTIM-157 B02
 *   @since  15 September 2018
 *   
 *    This is a Java calculator that takes input seconds
 *    and converts them to Gregorian calendar years, days,
 *    hours and minutes. See code comments at bottom.
 *    This program handles large second counts accurately.
 *    This program can assume a year is 365 days 
 *    or 365.2425 days. 
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class Seconds_KM
{
    public static void main(String[] args)
    {
        long   unixTime = System.currentTimeMillis() / 1000L;
        System.out.println("Enter time in seconds");
        Scanner keyboard    = new Scanner(System.in);
        double inputSeconds   = keyboard.nextDouble();
                System.out.println("Enter time in seconds");
                double inputYears     = keyboard.nextDouble();
                System.out.println("Enter time in seconds");
                double inputDays      = keyboard.nextDouble();
                System.out.println("Enter time in seconds");
                double inputHours     = keyboard.nextDouble();
                System.out.println("Enter time in seconds");
                double inputMinutes   = keyboard.nextDouble();
                System.out.println("Enter time in seconds");
                double inputSeconds   = keyboard.nextDouble();
                
        double outputMinutes  = inputSeconds   /       60;
        double outputHours    = outputMinutes  /       60;
        double outputDays     = outputHours    /       24;
        double outputYears    = outputDays     / 365.2425; //1 Why not 365?
        double outputFalseY   = outputDays     / 365;      //2
        double outputThisYear = unixTime       / 60 / 60 / 24 / 365.2425 + 1969;
        double outputFromNow  = outputThisYear + outputYears; // breaks in 2038!
        double outputFakeDate = outputThisYear + outputFalseY;
        DecimalFormat hoursAndMinutes          = new DecimalFormat ("#.##");
        DecimalFormat gregorianCalendar        = new DecimalFormat ("0"); //3
        String calSeconds     = gregorianCalendar.format(inputSeconds);
        String calMinutes     = hoursAndMinutes.format(outputMinutes);
        String calHours       = hoursAndMinutes.format(outputHours);
        String calDays        = gregorianCalendar.format(outputDays);
        String calFalseYears  = gregorianCalendar.format(outputFakeDate);
        String calYears       = gregorianCalendar.format(outputYears);
        String calFromNow     = gregorianCalendar.format(outputFromNow);
        System.out.println(" ");
        System.out.println("Years:           " + (calYears));
        System.out.println("Days:            " + (calDays));
        System.out.println("Hours:           " + (calHours));
        System.out.println("Minutes:         " + (calMinutes));
        System.out.println("Seconds:         " + (calSeconds));
    }
}