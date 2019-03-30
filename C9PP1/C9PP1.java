/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  24 Mar 2019

 Class C9PP1

 This is a Java program that converts a 24 hour time string to a 12 hour time.
 All user input is taken in as a string with the method getInput.
 The method convertTime uses String class methods for sanity checks on
 input(length, matches with regex) and if it fails the sanity checks,
 a TimeFormatException is thrown. main then handles this exception
 and asks the user to enter a valid string if an exception is caught.
 This class requires TimeFormatException.java.

 @version 1.0: initial release
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class C9PP1 {

    private static String convertTime(String time) throws TimeFormatException {
        String hours, minutes, period;
        if (time.length() == 4) {
            hours = time.substring(0, 1);
            minutes = time.substring(2, 4);
            if (time.charAt(1) != ':') {
                throw new TimeFormatException();
            }
        } else if (time.length() == 5) {
            hours = time.substring(0, 2);
            minutes = time.substring(3, 5);
            if (time.charAt(2) != ':') {
                throw new TimeFormatException();
            }
        } else {
            throw new TimeFormatException();
        }
        int convertHours = Integer.parseInt(hours);
        if (Integer.parseInt(hours) < 12) {
            period = " AM";
            if (Integer.parseInt(hours) == 0) {
                convertHours = 12;
            }
        } else {
            period = " PM";
            if (Integer.parseInt(hours) != 12) {
                convertHours = Integer.parseInt(hours) - 12;
            }
        }
        if ((hours.matches("([0-9]|0[0-9]|1[1-9]|2[0-3])") == false) ||
                ((minutes.matches("([0-5][0-9])"))  == false)) {
            throw new TimeFormatException();
        }
        String convertedTime = Integer.toString(convertHours) + ":" + minutes + period;
        return convertedTime;
    }

    private static String getInput(boolean quit) {
        Scanner keyboard = new Scanner(System.in);
        if (quit == false) {
            System.out.printf("Enter time in 24-hour format:\n");
        } else {
            System.out.printf("\nPress any key to enter another time. Press N to quit.\n");
        }
        String time = keyboard.nextLine().toUpperCase();
        return time;
    }

    public static void main(String[] args) {
        String runMain = "";
        String time;
        while (!runMain.equals("N")) {
            time = getInput(false);
            try {
                System.out.printf(convertTime(time));
            }
            catch (TimeFormatException e) {
                System.out.printf("\nInvalid time entered.\n");
                System.out.printf("Please enter a 24-hour time, HH:MM or H:MM, H/HH for hours, MM for minutes.\n");
            }
            runMain = getInput(true);
        }
        System.out.printf("End of program.\n");
    }
}