/**                                                       @version 1.0
   @author Kevin M. Mallgrave
           Professor Janet Brown-Sederberg
           CTIM-157 B02
   @since  11 December 2018
   
   Appointment methods
   small object oriented appointment methods
      
   
   Version 1.0: initial release
 */
import java.util.Scanner;
public class Appointment
{

private String month;
private int day;
private int year;
private int hour;
private int minute;

public Appointment()
   {//default constructor
   this.setMonth("January");
   setDay(1, "January", 1999);
   this.setYear(2019);
   this.setHour(0);
   this.setMinute(0);
   }
   
public Appointment(String monthPassed, int dayPassed, int yearPassed, int hourPassed, int minutePassed)
   {// 1 non-default constructor that accepts arguments for all instance variables
      //your constructor must call the setter methods below to set the values of the instance variables   
   this.setMonth(monthPassed);
   this.setDay(dayPassed, monthPassed, yearPassed);
   this.setYear(yearPassed);
   this.setHour(hourPassed);
   this.setMinute(minutePassed);
   }

//getter method: accesses info about object

// 5 getter methods (one for each instance variable) that return the value of the variable
   
public String getMonth()
   {
   return this.month;
   }//end method

public int getDay()
   {
   return this.day;
   }//end method
   
public int getHour()
   {
   return this.hour;
   }//end method
   
public int getMinute()
   {
   return this.minute;
   }//end method
   
   //setter methods: SET info about object
public void setMonth(String monthPassed)
   {
   Scanner keyboard = new Scanner(System.in);
   boolean monthCheck = true;
   
   while 
   ( 
   (monthPassed.equals("January") == false)
   && (monthPassed.equals("February") == false)
   && (monthPassed.equals("March") == false)
   && (monthPassed.equals("April") == false)
   && (monthPassed.equals("May") == false)
   && (monthPassed.equals("June") == false)
   && (monthPassed.equals("July") == false)
   && (monthPassed.equals("August") == false)
   && (monthPassed.equals("September") == false)
   && (monthPassed.equals("October") == false)
   && (monthPassed.equals("November") == false)
   && (monthPassed.equals("December") == false)
   || (monthCheck == false)
   )
   {
   System.out.println("Please enter a valid month.  ff January through December.");
   monthPassed = keyboard.nextLine();
   System.out.println(monthPassed);
   }

   this.month = monthPassed;
   }//end method
   
public void setHour(int hourPassed)
   {
   Scanner keyboard = new Scanner(System.in);
   while (hourPassed < 0 || hourPassed > 23)
   {
   System.out.println("Please enter a valid hour. 0-23.");
   hourPassed = keyboard.nextInt(); keyboard.nextLine();
   }
   this.hour = hourPassed;
   }
   
public void setYear(int yearPassed)
   {
   Scanner keyboard = new Scanner(System.in);
   while (yearPassed < 0 || yearPassed > 2019)
   {
   System.out.println("Please enter a valid year. 0-2019.");
   yearPassed = keyboard.nextInt(); keyboard.nextLine();
   }
   this.year = yearPassed;
   }

public void setMinute(int minutePassed)
   {
   Scanner keyboard = new Scanner(System.in);
   while (minutePassed < 0 || minutePassed > 60)
   {
   System.out.println("Please enter a valid minute. 0-60.");
   minutePassed = keyboard.nextInt(); keyboard.nextLine();
   }
   this.minute = minutePassed;
   }

public void setDay(int dayPassed, String monthPassed, int yearPassed)
   {
   boolean valid = false;
   while (valid == false)
   {   
      Scanner keyboard = new Scanner(System.in);
      boolean isLeap = (yearPassed % 400 == 0) 
      || ((yearPassed % 4 == 0) 
      && (yearPassed % 100 != 0)); 
      switch(monthPassed)
      {
      case "January":
      case "March":
      case "May":
      case "July":
      case "August":
      case "October":
      case "December":
         while (dayPassed < 1 || dayPassed > 31)
         {
         System.out.println("Invalid day entered. Please enter the day.");
         dayPassed = keyboard.nextInt(); keyboard.nextLine();
         }
         valid = true;
         break;
      case "September":
      case "April":
      case "June":
      case "November":
         while (dayPassed < 1 || dayPassed > 30)
         {
         System.out.println("Invalid day entered. Please enter the day.");
         dayPassed = keyboard.nextInt(); keyboard.nextLine();
         }
         valid = true;
         break;
      case "February":
         if(isLeap == true)
         {
         while (dayPassed < 1 || dayPassed > 29)
         {
         System.out.println("Invalid day entered. Please enter the day.");
         dayPassed = keyboard.nextInt(); keyboard.nextLine();
         }
         valid = true;
         }
         else
         { 
         while (dayPassed < 1 || dayPassed > 28)
         {
         System.out.println("Invalid day entered. Please enter the day.");
         dayPassed = keyboard.nextInt(); keyboard.nextLine();
         } 
         valid = true;
         }
         break;
      default:
      //          setMonth(monthPassed);  
      //          setDay(dayPassed, monthPassed, yearPassed); 
      //          setYear(yearPassed); 
         break;
      }//end switch   
   }//end while
   this.day = dayPassed;
   }//end method

public String toString()
   {
   return 
   "\nMonth: " + this.month +
   "\nDay: " + this.day +
   "\nHour: " + this.hour +
   "\nMinute: " + this.minute +
   "\nYear: " + this.year;
   }

public boolean equals(Appointment appointmentPassed)
   {//tells me if what I have stored in "month", "day" etc are "true"
    //appointmentPassed = "instance of the class "appointment"
    //checking if two appointments "objects" are the same,
    //basically
   return 
   this.month.equals(appointmentPassed.month)
   &&
   this.day == appointmentPassed.day
   &&
   this.hour == appointmentPassed.hour
   &&
   this.minute == appointmentPassed.minute;
   }
   
   
   
public static void main(String[] args)
   {//debugger driver program
//    Appointment a1 = new Appointment();
//    
//    Appointment a2 =
//    new Appointment ("May", 13, 2018, 12, 45);
//    System.out.println(a2.toString());

//    OOPS. FIX STRING MONTH CASE STUFF.
//    Appointment a3 =
//    new Appointment ("Fred", 13, 2018, 12, 45);
//    System.out.println(a2.toString());

   Appointment a3 =
   new Appointment ("May", 13, 2018, -1, -1);
   System.out.println(a3.toString());
   System.out.println("finish");

  }  

}//end class