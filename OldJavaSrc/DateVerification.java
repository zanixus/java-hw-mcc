import java.util.Scanner;
import java.lang.Character;
public class DateVerification

{
    public static void main(String[] args)
    {
    Scanner keyboard    = new Scanner(System.in);
    String userInput;
    String dayString, monthString, yearString;
    int dayInt, monthInt, yearInt;
    System.out.println("Enter a date dd/mm/yyyy");
    userInput = keyboard.nextLine();
    if (userInput.length() != 10)
       {
       System.out.println("Invalid input. Program will close.");
       System.exit(0);  //kick user when he enters bs
       }
    dayString   = userInput.substring(0,2);
    monthString = userInput.substring(3,5);
    yearString  = userInput.substring(6);
    char dayChar0   = dayString.charAt(0);
    char dayChar1   = dayString.charAt(1);
    char monthChar0 = monthString.charAt(0);
    char monthChar1 = monthString.charAt(1);
    char yearChar0  = yearString.charAt(0);
    char yearChar1  = yearString.charAt(1);
    char yearChar2  = yearString.charAt(2);
    char yearChar3  = yearString.charAt(3);
    if (Character.isDigit(dayChar0) && (Character.isDigit(dayChar1))     &&
       (Character.isDigit(monthChar0) && (Character.isDigit(monthChar1)) &&
       (Character.isDigit(yearChar0) && (Character.isDigit(yearChar1)    &&
       (Character.isDigit(yearChar2) && (Character.isDigit(yearChar3)))))))
    {
    dayInt   = Integer.parseInt(dayString);
    monthInt = Integer.parseInt(monthString);
    yearInt  = Integer.parseInt(yearString);
    int switchMonth = monthInt;
    int switchDay   = dayInt;
    int switchYear  = yearInt;
     switch (monthInt)
     {
       case 01:
         System.out.printf("January %d %d", monthInt, dayInt, yearInt);
       break;
//     case 02:
//     break;
//     case 03:
//     break
//     case 04:
//     break
//     case 05:
//     break
//     case 06:
//     break
//     case 07:
//     break
//     case 08:
//     break
//     case 09:
//     break
//     case 10:
//     break
//     case 11:
//     break
//     case 12:
//     break
     } 
    }
    else 
       {
       System.out.println("Invalid input. Program will close.");
       System.exit(0);
       }
    }
}