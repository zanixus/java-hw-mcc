import java.util.Scanner;
import java.text.DecimalFormat;
public class SubstringDemo

{
    public static void main(String[] args)
    {
    Scanner keyboard    = new Scanner(System.in);
     String text;
     System.out.println("Enter two words");
     text = keyboard.nextLine();
 //    String text = "Hello out there";                 //starting string
     String firstPart, lastPart;                        //declare parts
     String capitalLastPart;                            //new int for capitalized letter
     int position;                                      //int for finding position in string (0th-Nth)
     position = text.indexOf(" ");                      //int equals first space in string. this finds first space in string
     System.out.println(text);                          //print our starting string
     firstPart = text.substring(0, position);           // firstPart string is 0th char in string to int position - first space
     firstPart = firstPart.toLowerCase();               // firstPart string changed to lower case with string class action
     firstPart = " " + firstPart;                       // concat a space to our firstPart string to prepare it for inversion
     lastPart = text.substring(position + 1);           // first space position +1 is the lastPart
     capitalLastPart = lastPart.substring(0, 1);        // grab 0-1 chars(ie first letter) to get ready to capitalize it    
     capitalLastPart = capitalLastPart.toUpperCase();   // run our new string through toUpperCase() to capitalize it
     lastPart = text.substring(position + 2);                 // 
     System.out.println(capitalLastPart + lastPart + firstPart );  //    
    }
}