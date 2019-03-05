/**                                                         @version 0.1
 *   @author Kevin M. Mallgrave
 *           Professor Janet Brown-Sederberg
 *           CTIM-157 B02
 *   @since  19 October 2018
 *
 *   Version 0.1: unfinished, needs to accept strings that contain "cat", "dog", llama
 *                e.g "dogma", "Catskills", "llamathrust" but it doesn't yet. oops
 */
import java.util.Scanner;
public class Chapter3Project3_KMM
{
    public static void main(String[] args)
   {        
   Scanner keyboard    = new Scanner(System.in);
   String userInput;
   String cat = "cat", dog = "dog", llama = "llama";
   boolean catCheck = false, dogCheck = false , llamaCheck = false; 
   System.out.println("Enter words");
   userInput = keyboard.nextLine();
   String checkString = userInput.toLowerCase(); 
   if (checkString.contains("cat"))
   {
   catCheck = true;
   }
   if (checkString.contains("dog"))
   {
   dogCheck = true;
   }
   if (checkString.contains("llama"))
   {
   llamaCheck = true;
   }
   if (catCheck == false && dogCheck == false && llamaCheck == false)
   {
   System.out.println("Line accepted.");
   }
   if (catCheck == true || dogCheck == true || llamaCheck == true)
   {
     if (catCheck == true)
     {
        if (catCheck == true && dogCheck == true && llamaCheck == true)
        {
        System.out.println("Line rejected.");
   }
   else if (catCheck == true && dogCheck == true)
   {
   System.out.println("Line rejected.");
   }
   else if(catCheck == true && llamaCheck == true)
   {
   System.out.println("Line rejected.");
   }
   else
   {
   System.out.println("Line rejected.");
   }
   }
   if(dogCheck == true)
   {
   if(dogCheck == true && llamaCheck == true)
   {
   System.out.println("Line rejected.");
   }
   else
   {
   System.out.println("Line rejected.");
   }
   }
   if(llamaCheck == true){
   System.out.println("Line rejected.");
   }
   }
   }
}