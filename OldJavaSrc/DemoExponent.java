//import java.util.Scanner;                 // So when we import an Object like Scanner like this, we can call the function within the program
import java.util.Math.pow
public class DemoMath_KMM                                                        //a Class contains Methods
{
   public static void main(String[] args)                                        // this starts a Method
   {
     int int1 = 3, int2 = 5,  int3 = 22, int4, int5, int6;
     double double1 = 2.2, double2 = 2.2, double3;
     char char1 = 'a', char2 = 'b', char3 = '5', char4;
     boolean boolean1 = true, boolean2;
     String firstName = "Joe";
     System.out.println(firstName);
     
     int4 = int1 + int2;      //  Arithmetic ops demo
     System.out.println(int4);//
     int4 = int1 - int2;      //
     System.out.println(int4);//    
     int4 = int1 * int2;      //
     System.out.println(int4);//
     int4 = int1 / int2;      //     
     System.out.println(int4);//
     
     Math.pow(2,3);                                         // Java Method Math.pow will allow for exponents ie Math.[to the power of]
     System.out.println(Math.pow(4,3));                     // Math.pow always outputs a double. Syntax is (whole
     System.out.println(Math.pow(2.2,3.3));
     System.out.println("This is a small Math.pow demo");
     System.out.println(Math.sqrt(25.25));
     System.out.println("This is a small Math.sqrt demo");   // Check out Java API oracle docs for more modules
     System.out.println(Math.random());                      // Math.random demo. returns random #  
     System.out.println(Math.round(1.4946));         // round demo; rounds value up/down, outputs Int.1941
     System.out.println(Math.round(25.499999999999999));
     System.out.println(Math.round(25.49999999999999));
     // System.out.println("This isan imput string. Please enter two numbers");   // All Java progs have a Method called main
     // int n1, n2;                                                                // Java Ints enter memory
     //                                                                            // be careful bears shouldnt ingest large furry dogs
     // Scanner keyboard = new Scanner (System.in);                                // Java begins to scan for kb input with object System.out
     // n1 = keyboard.nextInt();                                                   // Java will accept the next KB input into memory for n1
     // n2 = keyboard.nextInt();
   }
}                   