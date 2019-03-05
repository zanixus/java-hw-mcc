/**                                                         @version 1.0
 *   @author Kevin M. Mallgrave
 *           Professor Janet Brown-Sederberg
 *           CTIM-157 B02
 *   @since  19 October 2018
 *
 *   This program will ask a user for ear pain symptoms,
 *   and suggest a diagnosis. MedicalDiagnosis_KMM is not a doctor,
 *   the output of this program is intended for recreational
 *   and educational use only.
 *
 *   Version 1.0: initial release
 */
import java.util.Scanner;
public class MedicalDiagnosis_KMM
{
	public static void main(String[] args)
	{
   boolean earLobePain, earBlocked, earAirplane, earWorseOverPastWeeks;
   boolean earGrossStuff, earCommonCold, earAndMouthPain;
   String pleaseEnter = "Please enter true or false.\n";
   Scanner keyboard   = new Scanner(System.in);
   // input sequence start  
   System.out.printf
   ("Does the pain get worse when you pull on your earlobe?\n");
   System.out.printf(pleaseEnter);
   earLobePain = keyboard.nextBoolean();
   if (earLobePain == true) 
      {
      System.out.printf
      ("You probably have an infection of the outer ear canal.\n"); 
      }
   else
      {
      System.out.printf
      ("Do you have a blocked feeling in your ear that cannot be cleared by swallowing?\n");
      System.out.printf(pleaseEnter); 
      earBlocked = keyboard.nextBoolean(); 
         if (earBlocked == true) 
            {              //start ears blocked branch
            System.out.printf
            ("Did the pain begin after an airplane flight?\n");
            System.out.printf(pleaseEnter);
            earAirplane = keyboard.nextBoolean();
            if (earAirplane == true) 
               {
               System.out.printf
               ("Changes in air pressure may have damaged your inner ear.\n");        
               }
            else 
               {
               System.out.printf
               ("Has your ear become worse over the past weeks?\n");
               earWorseOverPastWeeks = keyboard.nextBoolean();
                  if (earWorseOverPastWeeks == true) 
                  {
                  System.out.printf
                  ("You may have wax blockage.\n");
                  }
                  else 
                  {                
                  System.out.printf
                  ("You may have an acute middle ear infection\n");
                  }//I had this last month, it was no fun. "Serous Otitis Media"
               }   //It made me dizzy and muffled my hearing.
            }      //stop ears blocked branch  
     else 
         {
         System.out.printf
         ("Is there a sticky yellow-green discharge?\n");
         System.out.printf(pleaseEnter);
         earGrossStuff = keyboard.nextBoolean();
     if (earGrossStuff == true) 
         {
         System.out.printf
         ("You may have an infection of the outer ear canal or middle ear.\n");
         }
         else
            {
            System.out.printf
            ("Do you have a cold?\n");
            System.out.printf(pleaseEnter);
            earCommonCold = keyboard.nextBoolean();
            if (earCommonCold == true)
            {
            System.out.printf
            ("Earache is a common symptom of colds.\n");
            }
            else
               {
               System.out.printf
               ("Do you also have pain in your teeth or jaw?\n");
               System.out.printf(pleaseEnter);
               earAndMouthPain = keyboard.nextBoolean();
               if (earAndMouthPain == true)
                  {
                  System.out.printf
                  ("Tooth or gum trouble is sometimes felt as ear pain. ");
                  System.out.printf
                  ("contact your dentist\n");
                  }
               else
                  {
                  System.out.printf
                  ("Unable to suggest a diagnosis - Contact your physician.\n");
                  }  
               }
	         }
         }
      }
   }//looks like my curly braces line up, I'm good lol
}//I should pick an indent style and stick with it I guess