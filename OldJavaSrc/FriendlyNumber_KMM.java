/**                                                         @version 1.0
 *   @author Kevin M. Mallgrave
 *           Professor Janet Brown-Sederberg
 *           CTIM-157 B02
 *   @since  19 October 2018
 *
 *   This program will ask for a five digit whole number, and check the number
 *   to make sure it is exactly five digits and only contains ASCII values
 *   that can be converted to ints. It will reject anything other than this,
 *   and exit cleanly. It is designed to have a very narrow input profile.
 *   It will then check the five digit whole number to see if it is a friendly
 *   number by using the modulo operator and summing the total.
 *   The program will then print out the number and whether or not it is a 
 *   friendly number.
 *
 *   This program only uses one if-else statement.
 *
 *   Version 1.0: initial release
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class FriendlyNumber_KMM
{
    public static void main(String[] args)
    {
    Scanner keyboard = new Scanner(System.in);
    String inputNumberString;
    int ones, tens, hundreds, thousands, tenThousands;
    int checkOnes, checkTens, checkHundreds, checkThousands, checkTenThousands;
    int friendlyNumberIndex;
    System.out.print("Please enter a five digit whole number.\n");
    inputNumberString = keyboard.nextLine();    
    int inputLength   = inputNumberString.length();
    while (inputLength != 5)
          {//an infinite loop doesn't matter if it terminates after...
          System.out.print("Number is not five digits. Program will close.\n"); 
          System.exit(0); 
          }//...one iteration, right? I hope not. 
    char firstCharacter    = inputNumberString.charAt(0);
    char secondCharacter   = inputNumberString.charAt(1);
    char thirdCharacter    = inputNumberString.charAt(2);
    char fourthCharacter   = inputNumberString.charAt(3);
    char fifthCharacter    = inputNumberString.charAt(4);
    while (((int)firstCharacter <48) || ((int)firstCharacter > 57)  ||
          ((int)secondCharacter <48) || ((int)secondCharacter > 57) ||
          ((int)thirdCharacter <48)  || ((int)thirdCharacter > 57)  ||
          ((int)fourthCharacter <48) || ((int)fourthCharacter > 57) ||
          ((int)fifthCharacter <48)  || ((int)fifthCharacter > 57)) 
          {//this is ugly, but works, ok, I'll take it
          System.out.print("Number is not five digits. Program will close.\n"); 
          System.exit(0); 
          }//only strings that parse to five ints can get past. let's begin         
    tenThousands = Integer.parseInt(inputNumberString.substring(0,5));
    thousands    = Integer.parseInt(inputNumberString.substring(0,4));
    hundreds     = Integer.parseInt(inputNumberString.substring(0,3));
    tens         = Integer.parseInt(inputNumberString.substring(0,2));
    ones         = Integer.parseInt(inputNumberString.substring(0,1));
    checkTenThousands = tenThousands % 5;
    checkThousands    = thousands    % 4;
    checkHundreds     = hundreds     % 3;
    checkTens         = tens         % 2;
    checkOnes         = ones         % 1;
    friendlyNumberIndex = checkOnes + checkTens + checkHundreds 
                               + checkThousands + checkTenThousands;
    if (friendlyNumberIndex == 0) //here's my one and only one if-else boolean
       {          // total mod operator int = 0? TRUE
       System.out.printf("%s is a friendly number.\n", inputNumberString);
       }
    else         // anything else, not a friendly number = FALSE
       {
       System.out.printf("%s is not a friendly number.\n", inputNumberString);
       }
    }
}