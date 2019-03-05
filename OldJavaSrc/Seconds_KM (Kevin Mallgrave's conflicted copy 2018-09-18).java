/**                                                                @version 1.0
 *   @author Kevin M. Mallgrave
 *           Professor Janet Brown-Sederberg
 *           CTIM-157 B02
 *   @since  15 September 2018
 *   
 *    This is a Java calculator that takes input seconds
 *    and converts them to Gregorian calendar years, days,
 *    hours and minutes. See code comments at bottom.
 *    This program handles large second counts accurately.
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class Seconds_KM
{
    public static void main(String[] args)
    {
        System.out.println("Enter time in seconds");
        Scanner keyboard    = new Scanner(System.in);
        double inputSeconds   = keyboard.nextDouble();
        double outputMinutes  = inputSeconds  /       60;       
        double outputHours    = outputMinutes /       60;
        double outputDays     = outputHours   /       24;
        double outputYears    = outputDays    / 365.2425; //1 Wny not 365?
        double outputYears365 = outputDays    /      365;
        DecimalFormat gregorianCalendar       = new DecimalFormat ("0"); //2
        String calSeconds     = gregorianCalendar.format(inputSeconds);
        String calMinutes     = gregorianCalendar.format(outputMinutes);
        String calHours       = gregorianCalendar.format(outputHours);
        String calDays        = gregorianCalendar.format(outputDays); 
        String calYears       = gregorianCalendar.format(outputYears);
        String calYears365       = gregorianCalendar.format(outputYears365);
        System.out.println(" ");  
	     System.out.println("Years:          " + (calYears));
        //System.out.println("False Years:    " + (calYears365));       //3
        //uncomment the above line to get output assuming year=365 days
        System.out.println("Days:           " + (calDays));
        System.out.println("Hours           " + (calHours));
        System.out.println("Minutes         " + (calMinutes));
        System.out.println("Seconds         " + (calSeconds));
    }
}
/* 
   1.
   I used a double to represent all I/O variables here. I tried int as seconds
   input but the program can deal with larger date ranges with this method.
   This also allows me to account for the true average year length of the 
   Gregorian calendar, 365.2425 years. We may assume that there is 365 days in
   a year but we don't have to, so I have chosen not to for the sake of the
   assignment. Besides, we are using a double, why not use our decimal places?
   As I have used DecimalFormat to hange my doubles into strings, this method
   properly counts both normal years(3.154e+7 seconds) and leap years
   (3.162e+7 seconds). The benefit of this is that Gregorian calendar years 
   are kept accurate with truly large inputSeconds counts, whereas assuming
   outputDays/365 will eventually cause overflow years that would not actually
   occur if we were to measure that time with a Gregorian calendar. Curiously
   most online seconds to years calculators assumed this even though it is not
   literally true, likely because they don't have the benefit of converting a
   variable to string as I did with DecimalFormat, which takes care of the
   decimal rounding and provides proper output.  
   
   2.
   The Gregorian calendar year contains 365.2425 days due to the presence of
   a leap year. If I simply println'ed outputYear I would have gotten 
   0.9993380539413311, value in memory. However, DecimalFormat correctly rounds
   this up to 1 year when formatting the date assuming inputSeconds = 31536063
   which offers consistency with the assignment goals and allows us to take
   advantage of our larger double variables.
   Lesson: "If you load a double into memory, you may as well use it!" 
   
   3.
   I kept the original outputYear line in case the assignment must assume
   a year is 365 days. Let's assume inputSeconds = 1.0407e+11.
   1.0407e+11 seconds gives us 3300 years assuming a year is 365 days, but
   this will actually be 3298 years due to extra days from leap years making
   years longer. So I have called this "False Years" as in reality
   1.0407e+11 seconds from now will be the Gregorian year 5,316, 
   i. e., 3,298 year from now.
   This is the basis of my claim that this way is more accurate.
   */