/**                                                         @version 1.0
    @author Kevin M. Mallgrave
            Professor Janet Brown-Sederberg
            CTIM-157 B02
    @since  02 November 2018

    demo for methods  
 */
import java.util.Scanner;
import java.text.DecimalFormat;
//import myMethods;
public class DemoMethods
{//method info: public/private, static/(non static), return type(int, string, void etc)
    public static void main (String[] args)
    {
    myMethods linePrinter        = new myMethods();
    String message = "Vote Early, Vote Often";
    String slogan  = "Read My Lips: No New Taxes";
    linePrinter.printAnything(message);
    linePrinter.printAnything(slogan);
    
    double number = myMethods.addTwoDoubles(1.4, 2.5);
    System.out.println(number);

     //number = addTwoDoubles(400, 300);
     //System.out.println(number);
    }//end main
}
