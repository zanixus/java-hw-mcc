/**                                                       @version 1.0
   @author Kevin M. Mallgrave
           Professor Janet Brown-Sederberg
           CTIM-157 B02
   @since  16 December 2018
   
   Word scrambler methods:
   
   main
      This is a stub main method that checks input.
   
   boolean checkForSameChars(String checkMe)
      This method checks if the chars in the String to be randomized
      are the same (ie "oo" in "boom"). If it is the same, return true.
      If different, return false. This is to prevent infinite loops in randomizer().
   
   String randomizer(String randomInput, String firstValue, String finalValue)
      This method is a nested loop that shuffles two random chars within a String,
      and reassembles the String and returns it. It calls checkForSameChars()
      to prevent an infinite loop.
   
   void scramble(String stringPassed)
      This is a small void method that calls randomizer() to shuffle chars.
   
   Version 1.0: initial release
 */

import java.util.Random;
public class ScrambleMethods {

public static void main(String[] args) {
   scramble("I");
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

public static boolean checkForSameChars(String checkMe) {
  boolean repeating = true;
  char c1 = checkMe.charAt(0);
  int length = checkMe.length();
  for (int i=1;i < length; i++) {
      char temp = checkMe.charAt(i);
      if(c1 != temp) {
         repeating = false;
      }
  }
  return repeating;
}

public static String randomizer(String randomInput, String firstValue, String finalValue) {
      Random scrambler = new Random();
      boolean repeatingChars = checkForSameChars(randomInput);
      char scram[] = randomInput.toCharArray();
      String scramblerOutput = randomInput;
      do {
         for(int i=0; i < 2; i++) {   
           int j = scrambler.nextInt(scram.length);
           char temp = scram[i]; scram[i] = scram[j];  scram[j] = temp;
         }
      scramblerOutput = new String(scram);
      } while ((scramblerOutput.equals(randomInput)) && repeatingChars == false);
      return scramblerOutput = firstValue + scramblerOutput + finalValue;
      }

public static void scramble(String stringPassed) {
   if (stringPassed.length() > 3) {
      String firstValue = stringPassed.substring(0,1);
      String finalValue  = stringPassed.substring(stringPassed.length()-1, stringPassed.length());   
      String randomInput = (stringPassed.substring(1,(stringPassed.length()-1)));   
      System.out.println(randomizer(randomInput, firstValue, finalValue));
   } else {
   System.out.println(stringPassed);
   }
}
}