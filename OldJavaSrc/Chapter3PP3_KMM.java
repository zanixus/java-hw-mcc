/**                                                         @version 1.0
 *   @author Kevin M. Mallgrave
 *           Professor Janet Brown-Sederberg
 *           CTIM-157 B02
 *   @since  19 October 2018
 *
 *
 *   Version 1.0: initial release
 */
// Suppose that we are working for an online service that provides a bulletin board
// for its users. We would like to give our users the option of filtering out profanity. 
// Suppose that we consider the words cat, dog, and llama to be profane. 
// Write a program that reads a string from the keyboard and tests whether 
// the string contains one of our profane words. Your program should find words
// like cAt that differ only in case. Option: As an extra challenge, 
// have your program reject only lines that contain a profane word exactly. 
// For example, Dogmatic concatenation is a small category should not be considered profane.
 
import java.util.Scanner;
public class Chapter3PP3_KMM
 
{
    public static void main(String[] args)
   {
   String userInput;
   Scanner keyboard = new Scanner(System.in);
   boolean cat = false, dog = false , llama = false;    
   System.out.println("Enter a sentence containing cat, dog or llama.");
   userInput = keyboard.nextLine();
   String checkString = userInput.toLowerCase(); 
   
   if(checkString.contains("cat"))
   {
   cat = true;
   }

   if(checkString.contains("dog"))
   {
   dog = true;
   }

   if(checkString.contains("llama"))
   {
   llama = true;
   }
   {
   System.out.println("The sentence does not contain a profane word");
   }

   if (cat == true || dog == true || llama == true)
   {
      if (cat == true)
      {
         if (cat == true && dog == true && llama == true)
         {
         System.out.println("Line rejected.");
   }
   else if (cat == true && dog == true)
   {
   System.out.println("Line rejected.");
   }else if(cat == true && llama == true){
   System.out.println("Line rejected.");
   }else{
   System.out.println("Line rejected.");
   }
   }

   if(dog == true){
   if(dog == true && llama == true){
   System.out.println("Line rejected.");
   }else{
   System.out.println("Line rejected.");
   }
   }

   if(llama == true){
   System.out.println("Line rejected.");
   }
   }
   }
}

    
//     Scanner keyboard    = new Scanner(System.in);
//      String text;
//      String cat = " cat ", dog = " dog ", llama = " llama ";
//      // try new string and index = 0 to find just "cat" etc
//      //
//      // first if ( userInput.indexOf('dog')==0
//      //
//      // only  && (userInput.length ==('dog'.length) )
//      //
//      // last if (userInput.indexOf(" dog")== userInput.length - (" dog".length)
//      //
//      // if (userInput.indexOf(" dog ") >=0 is standalone word
//      //
//      //String cat = " cat", dog = "dog", llama = "llama";
//      //String cat = "cat ", dog = " dog ", llama = " llama ";
//      
//      String firstPartCat, lastPartCat;
//      String firstPartDog, lastPartDog;
//      String firstPartLlama, lastPartLlama;
//      char   firstCharacter;
//      char   secondCharacter;
//      char   thirdCharacter;
//      char   fourthCharacter;
//      char   fifthCharacter;
//      int positionCat, positionDog, positionLlama;
//      System.out.println("Enter words");
//      text = keyboard.nextLine();
//      positionCat    = text.indexOf(cat);
//      positionDog    = text.indexOf(dog);
//      positionLlama  = text.indexOf(llama);
//      firstPartCat   = text.substring(positionCat,3);//get 3 chars:C-A-T
//      System.out.println("fuck you");
//      lastPartCat    = text.substring(positionCat + cat.length());
// //     System.out.println(firstPartCat + censor + lastPartCat);
 
//     public static void main(String[] args)
//    {
//     
//    String userInput = ("Enter a sentence containing cat, dog or llama.");
//    boolean cat = false, dog = false , llama = false;
//    String userInput = words.toLowerCase(); 
//    
//    if(sentence.contains("cat")){
//    cat = true;
//    }
// 
//    if(sentence.contains("dog")){
//    dog = true;
//    }
// 
//    if(sentence.contains("llama")){
//    llama = true;
//    }else{
//    JOptionPane.showMessageDialog(null, "The sentence does not contain a profane word");
//    }
// 
//    if(cat == true || dog == true || llama == true){
//    if(cat == true){
//    if(cat == true && dog == true && llama == true){
//    JOptionPane.showMessageDialog(null, "The sentence contains the following profane words:"
//    + "\nCat"
//    + "\nDog"
//    + "\nLlama");
//    System.exit(0);
//    }else if(cat == true && dog == true){
//    JOptionPane.showMessageDialog(null, "The sentence contains the following profane words:"
//    + "\nCat"
//    + "\nDog");
//    System.exit(0);
//    }else if(cat == true && llama == true){
//    JOptionPane.showMessageDialog(null, "The sentence contains the following profane words:"
//    + "\nCat"
//    + "\nLlama");
//    System.exit(0);
//    }else{
//    JOptionPane.showMessageDialog(null, "The sentence contains the following profane words:"
//    + "\nCat");
//    System.exit(0);
//    }
//    }
// 
//    if(dog == true){
//    if(dog == true && llama == true){
//    JOptionPane.showMessageDialog(null, "The sentence contains the following profane words:"
//    + "\nDog"
//    + "\nLlama");
//    System.exit(0);
//    }else{
//    JOptionPane.showMessageDialog(null, "The sentence contains the following profane words:"
//    + "\nDog");
//    System.exit(0);
//    }
//    }
// 
//    if(llama == true){
//    JOptionPane.showMessageDialog(null, "The sentence contains the following profane words:"
//    + "\nLlama");
//    System.exit(0);
//    }
//    }
// 
//    }else if(startProgram == NO_OPTION){
//    System.exit(0);
//    }else{
//    System.out.println("Program was force closed.");
//    System.exit(0);
//    }
//    System.exit(0);
//    }
//    } 
// 

