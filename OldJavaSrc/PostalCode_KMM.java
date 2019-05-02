/**                                                       @version 1.0
   @author Kevin M. Mallgrave
           Professor Janet Brown-Sederberg
           CTIM-157 B02
   @since  30 November 2018

   This class parses a 5-digit integer into a postal code RF string.
   It consists of five methods and a main method. 
   The description of each method is below.
   
   Method getUserInput
      This method grabs input from the keyboard.
   Method printGuideLine
      This method prints a pipe "|" char to stdout.
   Method generateCheckDigit
      This method generates a check digit from a 5-digit US zip code,
      and returns it as an int.
   Method sumOfDigits
      Returns the sum of each digit number place e.g 19125 returns
      int 18. Used for calculating the check digit.
      This is an ugly method, I have fixed it to handle ZIP with leading 0
      (ie Brockton, MA 02302), it works the same as the clean one
      but I have pride in my silly string parser, so I'll make it work
   Method printDigitCode
      Case statement, takes int 0-9, returns string value.
      String value is a 5-bit binary "code" representing USPS RF codes.
      
    Version 1.0: initial release
     
 */

import java.util.Scanner;
public class PostalCode_KMM {

public static int getUserInput()   {// get 5 digts from user 
   Scanner keyboard = new Scanner(System.in);
   System.out.println("Please enter a zip code");
   int zip = keyboard.nextInt();
   return zip;
   }//end method

public static void printGuideLine()    {//prints ONE guideline, stays on the line
   System.out.print("|");
   }//end method

public static int generateCheckDigit(int n) {
    //accepts #, return single digit #(check digit/last)
   if (n == 10)
      return 0;
   else return 10 - (n % 10);
   }//end method
   
public static int sumOfDigits(int n) { //accepts 5 digit number, returns sum of digits
      String zipSumString = Integer.toString(n);
      if (zipSumString.length() != 5)//pad string not equal to 5char with zeros
          zipSumString = ("00000" + zipSumString).substring(zipSumString.length());         
      int fourth    = Integer.parseInt(zipSumString.substring(4,5));
      int third     = Integer.parseInt(zipSumString.substring(3,4));
      int second    = Integer.parseInt(zipSumString.substring(2,3));
      int first     = Integer.parseInt(zipSumString.substring(1,2));
      int zeroth    = Integer.parseInt(zipSumString.substring(0,1));
      int zipSum    = zeroth + first + second + third + fourth;
      return zipSum;
   }//end method
   
public static void printDigitCode(int n) {//prints bar/colon code
   switch (n)
   {
   case 1:
      System.out.print(":::||");
      break;
   case 2:
      System.out.print("::|:|");
      break;
   case 3:
      System.out.print("::||:");
      break;
   case 4:
      System.out.print(":|::|");
      break;
   case 5:
      System.out.print(":|:|:");
      break;
   case 6:
      System.out.print(":||::");
      break;
   case 7:
      System.out.print("|:::|");
      break;
   case 8:
      System.out.print("|::|:");
      break;
   case 9:
      System.out.print("|:|::");
      break;
   case 0:
      System.out.print("||:::");
      break;
   default:
      System.out.print("OOOPS");
      break;    
   }
   }//end method
   
public static void main(String[] args) {//begin main program
   int userInput = getUserInput();
   int sum  = sumOfDigits(userInput);
   int checkDigit = generateCheckDigit(sum);
   printGuideLine();
   for (int i = 4; i >= 0; i--) {//thank you math people
   printDigitCode(userInput / (int)Math.pow(10, i));
   userInput = userInput    % (int)Math.pow(10, i);
   }
   printGuideLine();
   }//end main
}//end class
