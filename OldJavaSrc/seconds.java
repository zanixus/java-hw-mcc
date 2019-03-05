
import java.util.Scanner;
public class seconds
{
    public static void main(String[] args)
    {
        System.out.println("Enter time in seconds");        
        Scanner keyboard    = new Scanner(System.in);       
        double inputSeconds   = keyboard.nextDouble();
        double outputSeconds  = inputSeconds;
        double outputMinutes  = outputSeconds   /       60;
        double outputHours    = outputMinutes  /       60;
        double outputDays     = outputHours    /       24;
        double outputYears    = outputDays  / 365;

        System.out.println(" ");
        System.out.println("Years:           " + (int)outputYears);
        System.out.println("Days:            " + (int)outputDays);
        System.out.println("Hours:           " + (int)outputHours);
        System.out.println("Minutes:         " + (int)outputMinutes);
        System.out.println("Seconds:         " + (int)inputSeconds);
     }
}