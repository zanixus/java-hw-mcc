import java.util.Scanner;
public class PigLatin
{
    public static void main(String[] args)
    {
    Scanner keyboard = new Scanner(System.in);
    char   firstCharacter;
    String userInput;
    String vowelString;
    String consonantString;
    System.out.println("Enter a word");
    userInput = keyboard.next();
    userInput = userInput.toLowerCase();
    firstCharacter = userInput.charAt(0);
    if ((int)firstCharacter <97 || (int)firstCharacter > 122)
       {//check for ascii values. proper input range
       System.out.println("Invalid input. Program will close.");
       System.exit(0);  //kick user when he enters ints
       }
    if ((firstCharacter == 'a') || (firstCharacter == 'e') ||
        (firstCharacter == 'i') || (firstCharacter == 'o') ||
                                   (firstCharacter == 'u'))//use a bunch of ORs
       {
       vowelString = userInput.substring(1);              //truncate 0th character in string
       System.out.println(vowelString + "ay");
       }//endif
    else
       {
       consonantString = userInput.substring(1);
       System.out.println(consonantString + firstCharacter + "ay");
       }     
    }
}

//     String userOutput;                                         //declare parts
//     firstPart = text.substring(0, position);                    // firstPart string is 0th char in string to int position - first space
//     firstPart = firstPart.toLowerCase();                       // firstPart string changed to lower case with string class action
//     firstPart = " " + firstPart;                              // concat a space to our firstPart string to prepare it for inversion
//     lastPart = text.substring(position + 1);                  // first space position +1 is the lastPart
//     capitalLastPart = lastPart.substring(0, 1);              // grab 0-1 chars(ie first letter) to get ready to capitalize it    
//     capitalLastPart = capitalLastPart.toUpperCase();         // run our new string through toUpperCase() to capitalize it
//     lastPart = text.substring(position + 2);                 // 
//     System.out.println(capitalLastPart + lastPart + firstPart );  //    

