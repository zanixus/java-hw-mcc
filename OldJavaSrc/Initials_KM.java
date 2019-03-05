/**                                                         @version 1.0
 *   @author Kevin M. Mallgrave
 *           Professor Janet Brown-Sederberg
 *           CTIM-157 B02
 *   @since  15 September 2018
 *   
 *    This program inputs your first name, middle name and last name
 *    and outputs your full name, first name length, middle name length,
 *    last name length, initials and sum of your initials' ASCII value.
 */
import java.util.Scanner;
public class Initials_KM

{
    public static void main(String[] args)
    {
    Scanner keyboard    = new Scanner(System.in);
     String firstName, middleName, lastName;
     char   firstChar, middleChar, lastChar;
     int    asciiValue, firstLength, middleLength, lastLength;
     System.out.println("Enter your first name");
     firstName  = keyboard.nextLine(); 
     System.out.println("Enter your middle name");
     middleName = keyboard.nextLine();
     System.out.println("Enter your last name");
     lastName   = keyboard.nextLine();
     System.out.println(firstName);
     firstLength  = firstName.length();
     middleLength = middleName.length();
     lastLength   = lastName.length();
     firstChar    = firstName.charAt(0);
     middleChar   = middleName.charAt(0);
     lastChar     = lastName.charAt(0);
     asciiValue   = (byte)lastChar + (byte)middleChar + (byte)lastChar;
     System.out.println("Full name:                   " +
                           firstName +" "+ middleName + " " + lastName);
     System.out.println("Initials:                    " +
     Character.toString(firstChar) + Character.toString(middleChar) + 
     Character.toString(lastChar));
     System.out.println("First name length:           " + firstLength);
     System.out.println("Middle name length:          " + middleLength);
     System.out.println("Last name length:            " + lastLength);
     System.out.println("ASCII Value Sum of Initials: " + asciiValue); 
    }
}