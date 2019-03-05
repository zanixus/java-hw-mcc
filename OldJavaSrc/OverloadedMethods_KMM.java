/**                                                       @version 1.0
   @author Kevin M. Mallgrave
           Professor Janet Brown-Sederberg
           CTIM-157 B02
   @since  30 November 2018

   This is a class intended to demo overloaded methods.
   It features four methods called dataBase. Each dataBase method
   accepts different input arguments.
   
   The main method prompts the user for input, and uses each
   dataBase() method to print the output to stdout in order.
   This is a demo method for the four dataBase() methods.
    
   Version 1.0: initial release
    
 */

import java.util.Scanner;
public class OverloadedMethods_KMM
{
   
public static void dataBase (String first, String last)
   {
   System.out.printf("First Name: %s\n", first);
   System.out.printf("Last Name:  %s\n", last);
   }
   
public static void dataBase (String first, String last, long phone)
   {
   System.out.printf("First Name:    %s\n", first);
   System.out.printf("Last Name:     %s\n", last);
   System.out.printf("Phone Number:  %d\n", phone);
   }

public static void dataBase (String first, String last, int zip, long phone)
   {
   System.out.printf("First Name:    %s\n", first);
   System.out.printf("Last Name:     %s\n", last);
   System.out.printf("Zip Code:      %d\n", zip);
   System.out.printf("Phone Number:  %d\n", phone);
   }
   
public static void dataBase (String first, String last, int house,
              String street, String city, String state, int zip, long phone)
   {
   System.out.printf("First Name:    %s\n", first);
   System.out.printf("Last Name:     %s\n", last);
   System.out.printf("House Number   %d\n", house);
   System.out.printf("Street Name:   %s\n", street);
   System.out.printf("City Name:     %s\n", city);
   System.out.printf("State:         %s\n", state);
   System.out.printf("Zip Code:      %d\n", zip);
   System.out.printf("Phone Number:  %d\n", phone);
   }
      
public static void main(String[] args)
   {   
   String firstName;
   String lastName;
   int houseNumber;
   String streetName;
   String cityName;
   String stateName;
   int zipCode;
   long phoneNumber;
   Scanner keyboard = new Scanner(System.in);
   System.out.printf("Please enter your first name.\n");
   firstName        = keyboard.nextLine();
   System.out.printf("Please enter your last name.\n");
   lastName         = keyboard.nextLine();
   System.out.printf("Please enter your house number.\n");
   houseNumber      = keyboard.nextInt(); keyboard.nextLine();
   System.out.printf("Please enter your street name.\n");
   streetName       = keyboard.nextLine();
   System.out.printf("Please enter your city.\n");
   cityName         = keyboard.nextLine();
   System.out.printf("Please enter your state.\n");
   stateName        = keyboard.nextLine();
   System.out.printf("Please enter your zip code.\n");
   zipCode          = keyboard.nextInt(); keyboard.nextLine();
   System.out.printf("Please enter your phone number.\n");
   phoneNumber      = keyboard.nextLong(); keyboard.nextLine();
   System.out.printf("1. dataBase(firstName, lastName) output.\n");
   dataBase(firstName, lastName);
   System.out.printf("\n");
   System.out.printf
   ("2. dataBase(firstName, lastName, phoneNumber) output.\n");
   dataBase(firstName, lastName, phoneNumber);
   System.out.printf("\n");
   System.out.printf
   ("3. dataBase(firstName, lastName, zipCode, phoneNumber) output.\n");
   dataBase(firstName, lastName, zipCode, phoneNumber);
   System.out.printf("\n");
   System.out.printf
   ("4. dataBase(all variables) output.\n");
   dataBase(firstName, lastName, houseNumber, streetName, 
             cityName, stateName, zipCode, phoneNumber);
   }
            
}//end class