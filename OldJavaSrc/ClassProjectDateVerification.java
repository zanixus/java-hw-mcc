import java.util.Scanner;
public class ClassProjectDateVerification
{

public static void main(String[] args)

   {//main   
   String userInput;
   boolean isLeap, isLeapYear, isValidDate;
   int limitDays;
   boolean inCorrectForm;
   boolean isValidMonth;
   boolean finalAnswer;
   
   userInput     = getInput();
   
   inCorrectForm = correctForm(userInput);
   
   isValidMonth  = validateMonth(userInput);
   
   isLeapYear    = isLeapYear(userInput.substring(6));    //years,  pos 6+
      
   isValidDate   = validateDate(userInput.substring(3,5), //days,  pos 3 to 5
                   userInput.substring(0,2),              //month, pos 0 to 2
                   isLeapYear);  
                                    
   System.out.println("valid date:   "+isValidDate); 
   if (inCorrectForm  == true 
      && isValidMonth == true 
      && isValidDate  == true)
      finalAnswer     = true;
   else
      finalAnswer     = false;
   
   System.out.println("final answer: "+finalAnswer);
   
   }//end main
   
   public static String getInput()
      { 
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Please enter the date in format mm/dd/yyyy");
      String userInput = keyboard.nextLine();
      return userInput;
      }//end method getInput
   
   public static boolean correctForm (String userInput)
      {
         if(userInput.length() != 10)
         {
         return false;
         }
         if(userInput.charAt(2) != '/' || userInput.charAt(5) != '/')
         {
         return false;
      }
      if
         (!( //if not
         Character.isDigit(userInput.charAt(0)) && 
         Character.isDigit(userInput.charAt(1)) &&
         Character.isDigit(userInput.charAt(3)) &&
         Character.isDigit(userInput.charAt(4)) &&
         Character.isDigit(userInput.charAt(6)) && 
         Character.isDigit(userInput.charAt(7)) &&
         Character.isDigit(userInput.charAt(8)) && 
         Character.isDigit(userInput.charAt(9))
         ))
      {
         return false;
      }
         return true;
   }//end method correctForm
   
   public static boolean isLeapYear (String y)
      {
         
         int yearInt = Integer.parseInt(y);
         System.out.println(yearInt);
         //translate year to integer and then
         //return bool result of year, either TRUE or FALSE
         return (yearInt % 400 == 0)
         ||     ((yearInt % 4 == 0) 
         &&     (yearInt % 100 != 0));
      }//end method isLeapYear
   
   
   public static boolean validateMonth(String s)
   {   
      String month = s.substring(0,1);
      int monthInt = Integer.parseInt(month);
      if(monthInt <= 12 && monthInt > 0){
      return true;
      }else{
      return false;
      }
   }//end method validateMonth
   
   public static boolean validateDate(String days, String month, boolean isLeap)
   {//can pass multiple args, see method above
      int monthInt  = Integer.parseInt(month);
      int dayInt    = Integer.parseInt(days);
      int limitDays = 0;     
      switch(monthInt)
      {
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
      limitDays = 31;
      break;
      case 9:
      case 4:
      case 6:
      case 11:
      limitDays = 30;
      break;
      case 2:
         if (isLeap == true)
         limitDays = 29;
         else 
         limitDays = 28; 
      break;
      default:
      limitDays = 0; 
      break;
   }//end switch 
   if
      (
      (monthInt >= 1 && monthInt <= 12) &&
      (dayInt >=1 && dayInt <= limitDays)
      )
      return true;
   else
      return false; 
   }//end method validateDate
}//end class