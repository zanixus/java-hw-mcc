/**                                                   @version 1.0
 *   @author Kevin M. Mallgrave
 *           Professor Janet Brown-Sederberg
 *           CTIM-157 B02
 *   @since  19 October 2018
 *
 *   This program reads an int from user input.
 *   It takes the int and runs it through inner and outer loops
 *   It outputs a formatted facts table to stdout for the input int.
 *   Works best with ints >15 for 80 column witdh(xterm et al in Linux)
 *   or ints >100 in jGRASP (5char formatted column)
 *   but it will accept any whole number.
 *
 *   Version 1.0: initial release
*/
import java.util.Scanner;
public class multiplicationTable_KMM
{
    public static void main(String[] args) 
    {
       int userInput;
       System.out.printf("Please enter a whole number.\n");
       Scanner keyboard = new Scanner(System.in);
       userInput = keyboard.nextInt(); 
       System.out.printf("    Multiplication table for %1d:\n",userInput);        
       // format first row. 8char
       System.out.printf("       "); 
       for(int i = 1; i<=userInput;i++)
          {//outer loop, first row
          System.out.printf("%5d",i);
          }
       System.out.printf("\n");    
       for(int i=1;i<=userInput;i++) 
       {      
           System.out.printf("%5d  ",i);
           for(int j=1;j<=userInput;j++) 
           {
               System.out.printf("%5d",i*j);
           }//inner loop end 
       System.out.printf("\n");
       }//outer loop end 
    }    
}