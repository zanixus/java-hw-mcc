public class DriverAppointment
{
public static void main(String[] args)
   {Appointment a1 = new Appointment();
   
   Appointment a2 =
   new Appointment ("April", 13, 2018, 12, 45);
   System.out.println(a2.toString());

//    OOPS. FIX STRING MONTH CASE STUFF.
//    Appointment a3 =
//    new Appointment ("Fred", 13, 2018, 12, 45);
//    System.out.println(a2.toString());

   Appointment a3 =
   new Appointment ("April", 13, 2018, -1, -1);
   System.out.println(a2.toString());
   }  

}//end class