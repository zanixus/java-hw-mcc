public class appointmentTest
{
public static void main(String[] args)
   {//debugger driver program
    Appointment a1 = 
   new Appointment("September", 25, 1066, 13, 11);
   System.out.println(a1.toString());  
   
   Appointment a2 = 
   new Appointment("Fred", 20, 1955, 12, 30);
   System.out.println(a2.toString());
   //month/day input bug fixed, this works now
   
//  user input bug below
//
    Appointment a3 =
    new Appointment ("Joog", -1, -1964, 13, 13);
    System.out.println(a3.toString());
//    program bug: enter "February", "29", "1963"
//    or some other non leap year on object a3
//    This results in an illegal date,
//    as the date input logic has the "bad" year
//    in memory when the isLeap boolean is declared,
//    and is still referenced when the date is re-input.
//    Could fix with leap year check logic in setYear
  }  
}