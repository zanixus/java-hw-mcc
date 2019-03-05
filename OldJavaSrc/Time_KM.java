import java.util.Scanner;
public class Time_KM
{
    public static void main(String[] args)
    {
        Scanner keyboard    = new Scanner(System.in);
        System.out.println("Enter years");
        double inputYears     = keyboard.nextDouble();
        System.out.println("Enter days");
        double inputDays      = keyboard.nextDouble();
        System.out.println("Enter hours");
        double inputHours     = keyboard.nextDouble();
        System.out.println("Enter minutes");
        double inputMinutes   = keyboard.nextDouble();
        System.out.println("Enter seconds");
        double inputSeconds         = keyboard.nextDouble();
        double outputMinutes        = inputMinutes  *          60;
        double outputHours          = inputHours    *        3600;
        double outputDays           = inputDays     *       86400;
        double outputYears          = inputYears    *    31540000;
        double outputSeconds        = outputMinutes + outputHours
                                    + outputDays    + outputYears;
        System.out.println(outputSeconds);
    }
}
