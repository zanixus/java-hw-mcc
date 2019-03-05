/**                                                       @version 1.0
   @author Kevin M. Mallgrave
           Professor Janet Brown-Sederberg
           CTIM-157 B02
   @since  16 December 2018
   
   Word scrambler methods:
   
   main
      This is a stub main method that tests scramble().
   
   void scramble(String stringPassed)
      This is a void method that prints a string. It takes a String input,
      parses the first and last letter of the string, and swaps two random letters in the
      String characters >1 and < (end of string). It contains a boolean value
      to check for repeating string chars to prevent infinite loops(ie input "wood" or "iiii")
      and uses a for loop to set this value. It uses a for loop nested within a do-while loop
      to prevent a word from NOT being shuffled. In other words you will always recieve a
      shuffled output. I have coded the method in order to avoid exception
      
      Version 1.0: initial release
 */

import java.util.Random;
public class ScrambleMethodss {

public static void main(String[] args) {
    scramble("Monty");
    scramble("Monty");
    scramble("Monty");
    scramble("Monty");
    scramble("Monty");
    scramble("Monty");
scramble("Monty");
scramble("Monty");
    scramble("don't");
    scramble("give");
    scramble("a");
    scramble("damn");
    scramble("for");
    scramble("a");
    scramble("man");
   scramble("that");
   scramble("can");
   scramble("only");
   scramble("spell");
   scramble("a");
   scramble("word");
   scramble("one");
   scramble("way");
   scramble("Mark");
   scramble("Twain");
}

public static void scramble(String stringPassed) {
   if (stringPassed.length() > 3) {
      String firstValue = stringPassed.substring(0,1);
      String finalValue  = stringPassed.substring(stringPassed.length()-1, stringPassed.length());   
      String randomInput = (stringPassed.substring(1,(stringPassed.length()-1))); 
      boolean repeatingChars = false;      
      char c1 = randomInput.charAt(0);
      int length = randomInput.length();
      for (int i = 1;i < length; i++) {
         char temp = randomInput.charAt(i);
         if(c1 != temp) {//check for repeating chars to prevent infinite loop below
            repeatingChars = false;
         } else {
           repeatingChars = true;
         }
      }      
      Random scrambler = new Random();
      char scram[] = randomInput.toCharArray();
      String scramblerOutput = randomInput;
      do {
         for(int i = 0; i < 2; i++) {   
           int j = scrambler.nextInt(scram.length);
           char temp = scram[i]; scram[i] = scram[j];  scram[j] = temp;
         }
      scramblerOutput = new String(scram);
      } while ((scramblerOutput.equals(randomInput)) && repeatingChars == false);
      scramblerOutput = firstValue + scramblerOutput + finalValue;   
      System.out.println(scramblerOutput);
   } else {//if chars less than 3, just print it to avoid exception
   System.out.println(stringPassed);
   }
}
}