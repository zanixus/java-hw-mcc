

import java.util.Scanner;
public class OverloadingMethods
{

public static void main(String[] args)

   {
   mult(3);
   mult(3,9);
   mult();
   mult(2.2);
   mult(3,9.7);
   mult(3.3,9.7);
   
   }//end main
   
   public static void mult (int n1)//void just executes
   {                       //does NOT return; anything
   System.out.println("int");
   }//end method
   
//    public static void mult (int n1, int n2)//overload demo
//    {                       //takes multiple args on method line
//    System.out.println("int, int");
//    }//end method
   
   public static void mult ()//overload demo
   {                        //takes NO() args
   System.out.println("no args");
   }//end method
   
   public static void mult (double n1)
   {
   System.out.println("double");
   }//end method
   
   public static void mult (int n1, double n2)
   {
   System.out.println("int double");
   }//end method
   
//    WATCH OUT FOR AMBIGUOUS METHOD REFERENCES
//
//    public static void mult (double n1, int n2)
//    { 
//    System.out.println("double int);
//    }//end method
   
   public static void mult (double n1, double n2)
   {
   System.out.println("double double");
   }//end method
   
   
}//end class