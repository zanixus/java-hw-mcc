import java.util.Scanner;
import java.text.DecimalFormat;
public class myMethods
{//method info: public/private, static/(non static), return type(int, string, void etc)



public void printAnything(String stringPassed) //name and parameter list
    {
    System.out.println(stringPassed);   
    }//end method
    
    public static int addTwoInts(int intOne, int intTwo) //name and parameter list
    {    
    int sum = intOne + intTwo; 
    return sum;                  //return the method output when called
    }//end method
    
        
    public static double addTwoDoubles(double doubleOne, double doubleTwo) //name and parameter list
    {    
    return doubleOne + doubleTwo;
    }//end method
    
    public static void printSomething() //name and parameter list
    {
     System.out.printf("fuck you\n");    
    }//end method

}