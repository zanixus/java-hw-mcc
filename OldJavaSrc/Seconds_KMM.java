/**                                          @version 2.1
 *   @author Kevin M. Mallgrave
 *           Professor Janet Brown-Sederberg
 *           CTIM-157 B02
 *   @since  15 September 2018
 *   
 *    This is a Java calculator that takes input seconds
 *    and converts them to Gregorian calendar years, days,
 *    hours and minutes. See code comments at bottom.
 *    This program handles large second counts accurately.
 *    Enter large seconds counts for funny messages.
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class Seconds_KMM
{
    public static void main(String[] args)
    {
        long   unixTime = System.currentTimeMillis() / 1000L;//I'm sorry
        System.out.println("Enter time in seconds");        
        Scanner keyboard    = new Scanner(System.in);       
        double inputSeconds   = keyboard.nextDouble();
        double outputMinutes  = inputSeconds   /       60;
        double outputHours    = outputMinutes  /       60;
        double outputDays     = outputHours    /       24;
        double outputYears    = outputDays  / 365.2425; //1 Why not 365?
        double outputFalseY   = outputDays  / 365;      //2 just for fun
        double outputThisYear = unixTime //what an ugly way to get the time
        / 60 / 60 / 24 / 365.2425 + 1969;//breaks in 2038! See fun message
        double outputFromNow  = outputThisYear + outputYears;
        double outputFakeDate = outputThisYear + outputFalseY;
        DecimalFormat hoursAndMinutes       = new DecimalFormat ("#.##");
        DecimalFormat gregorianCalendar     = new DecimalFormat ("0");//3
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
        if (outputFromNow>2025)
          {
          System.out.println(" ");
          System.out.println("It will be the year " + calFromNow + ".");
          System.out.println("Feeling young yet? ");
          }
        if (outputFromNow>2038)
          {
          System.out.println(" ");
          System.out.println("This program won't work right due to Unix time.");
          System.out.println("I should use a modern way to get the date!");
          }
        if (outputFromNow>4000)
          {
          System.out.println(" ");
          System.out.println("If we had used 365 days to calculate a year,");
          System.out.println("We would have incorrectly calculated the year");
          System.out.println("to be " + calFalseYears + " instead of " +
                                        calFromNow);
          System.out.println("This is why I used DecimalFormat and doubles!");
          }
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
   This is just for fun. If you enter enouch seconds to get to year >4000,
   I'll use this outputFalseY variable to print the incorrect date in addition
   to the correct one. By that time, we will have had over full year's worth
   of leap years. This can add up to thousands of years with large input values
   Yet, before around this time, the years sync up properly.
   The Roman Catholic Church was not aware of the exact length of a solar year
   in 1582 when they gave us a new calendar to use, unfortunately.
   Maybe we will have a better calender in 4000 than this old one. Or maybe
   we'll be living on Mars, where our calendar will be arbitrary.
   3.
   The Gregorian calendar year contains 365.2425 days on average.
   If I simply println'ed outputYear I would have gotten 
   0.9993380539413311, value in memory. However, DecimalFormat correctly rounds
   this up to 1 year when formatting the date assuming inputSeconds = 31536063
   which offers consistency with the assignment goals and allows us to take
   advantage of our larger double variables.
   I also like the idea of formatting human-readable values into string.
   Lesson: If you load a double into memory, you may as well use it!"
   */
