/**                                                       
   @author Kevin M. Mallgrave
           Professor Janet Brown-Sederberg
           CTIM-168 W01
   @since  24 Feb 2019

    Class DemoHorses        
    This is a small demo class that uses the Horse class and its children RaceHorse and BreedingHorse.
    It creates an array of 6 Horse class objects, and prompts the user to enter the information for
    3 RaceHorse Horse-class objects. A RaceHorse cannot have more racesWon than races.

    Once this is done, it asks the user to pick 2 of the 3 RaceHorse objects to breed into a BreedingHorse.
    The user will be asked for the name of the new BreedingHorse, and the birth date.
    BreedingHorse coat color is determined by the parents; a BreedingHorse inherits its color
    from one of its parents. A BreedingHorse cannot be older than one of its parents.
    This is iterated three times to fill out all six stable stalls.

    The program then lists all stables using the Horse.toString method, and runs a case statement
    method to allow the user to view all Horses, view all RaceHorses, view all BreedingHorses, repopulate
    the stable, or quit(return true to main loop).
    
    There is no gender variable for the Horse class, so all Horse objects and descendents are hermaphroditic.
    You cannot breed a Horse with itself, but a horseFather can be a horseMother to a different BreedingHorse.
    These are all just arbitrary breeding restrictions I set up for the demo, the methods can handle it.
    While the program is set up to breed RacingHorse objects, it could handle any Horse object. Have fun.
    
    @version 1.0: initial release
 */
import java.util.Scanner;
public class DemoHorses {

   private static void createRaceHorse(Horse horseStable[]) {
      Scanner keyboard = new Scanner(System.in);       
      for (int i = 0; i < horseStable.length / 2; i++) {
            String name = "", color = "", birthYear = "", races = "", racesWon = "";
            while ((name.trim().length() > 0)  == false) {
               System.out.printf("Please enter a name for your horse in stall %d.\n", i+1);
               name = keyboard.nextLine();    
            }            
            while ((color.trim().length() > 0)  == false) {
               System.out.printf("Please enter the color of your horse in stall %d.\n", i+1);
               color = keyboard.nextLine().toLowerCase();    
            }             
           while (
                 (birthYear.matches("198[8-9]|199[0-9]|200[0-9]|201[0-8]") == false) ||
                 ((birthYear.trim().length() > 0)  == false
                 )
                 ) {  
               System.out.printf
               ("Please enter the year of birth for your horse in stall %d. Birth year must be between 1988 and 2018.\n", i+1);
               birthYear = keyboard.nextLine();
           }                       
           while (
                 (races.matches("([0-9]\\d*)") == false) ||
                 ((races.trim().length() > 0)  == false)
                 ) {   
              System.out.printf
              ("Please enter the amount of races your horse in stall %d has had.\n", i+1);
              races = keyboard.nextLine();    
           }                
           while (
                 (racesWon.matches("([0-9]\\d*)") == false) ||
                 ((racesWon.trim().length() > 0)  == false)
                 ) {   
              System.out.printf
              ("Please enter the amount of races your horse in stall %d has won.\n", i+1);
              racesWon = keyboard.nextLine();    
           }      
           if ((Integer.parseInt(racesWon) >  Integer.parseInt(races))) {
              System.out.printf
              ("Error: %s has only been in %s races. %s's win count cannot be %s.\n", name, races, name, racesWon);
              System.out.printf("%s's win count has been set to %s.\n", name, races);
              racesWon = races;   
           }       
     horseStable[i] = new RaceHorse(name, color, Integer.parseInt(birthYear), 
                          Integer.parseInt(races), Integer.parseInt(racesWon));
     }        
  }
  
   private static void breedHorse(Horse horseStable[]) {
      Scanner keyboard = new Scanner(System.in);          
      for (int i = 3; i < horseStable.length; i++) {
            String name = "", birthYear = "", horseMother = "", horseFather = "";   
            while ((name.trim().length() > 0)  == false) {
               System.out.printf("Please enter a name for your horse in stall %d.\n", i+1);
               name = keyboard.nextLine();    
            }
           while (
                 (horseMother.matches(horseFather))
                 || (!horseMother.matches("[1-3]"))
                 || (!horseFather.matches("[1-3]"))
                 ){
                 System.out.printf("Please pick a mother for the horse in stall %d.\n",i+1);
                 System.out.printf("Available horses are %s in stall 1, %s in stall 2, and %s in stall 3. Please enter a stall number.\n",
                                  horseStable[0].getName(), horseStable[1].getName(), horseStable[2].getName());
                 horseMother = keyboard.nextLine();
                 System.out.printf("Please pick a father for the horse in stall %d.\n",i+1);
                 System.out.printf("Available horses are %s in stall 1, %s in stall 2, and %s in stall 3. Please enter a stall number.\n",
                                   horseStable[0].getName(), horseStable[1].getName(), horseStable[2].getName());
                 horseFather = keyboard.nextLine(); 
              if  (horseMother.matches(horseFather)) {
                  System.out.printf("Error: Breeding horse has identical parents. Please select two different horses.\n");
                 }
              if (
                 (!horseMother.matches("[1-3]"))
                 || (!horseFather.matches("[1-3]"))
                 ){
                 System.out.printf("Error: Invalid stall selected. Please select stall 1, 2, or 3.\n");
                 }
           } 
           while (
                 (birthYear.matches("198[8-9]|199[0-9]|200[0-9]|201[0-8]") == false) ||
                 ((birthYear.trim().length() > 0)  == false)
                 ) {  
               System.out.printf
               ("Please enter the year of birth for your horse in stall %d. Birth year must be between 1988 and 2018.\n", i+1);
               birthYear = keyboard.nextLine();             
           }
           if (//could really use an exception catch here to trap a user who insists on entering data that cannot be parsed to int
              ((Integer.parseInt(birthYear) <  horseStable[Integer.parseInt(horseMother)-1].getBirthYear()))
              || ((Integer.parseInt(birthYear) <  horseStable[Integer.parseInt(horseFather)-1].getBirthYear()))
              )  {
               System.out.printf
               ("Error: %s's age is older than one of its parents. A breeding horse cannot be older than its parents.\n", name);
               System.out.printf("%s's birth year has been set to 2018.\n", name);
               birthYear = "2018";   
           }       
     horseStable[i] = new BreedingHorse(name, Integer.parseInt(birthYear),//just try getting down here, unparseable string punks
                                        horseStable[Integer.parseInt(horseMother)-1],
                                        horseStable[Integer.parseInt(horseFather)-1]);
     }  
  System.out.printf("\nHorse stable populated. Stalls 1-3 contain racing horses, stalls 4-6 contain breeding horses.\n");    
  System.out.printf("Press any key to view menu options.\n");
  String blocker = keyboard.nextLine();
  for (int i = 0; i < horseStable.length; i++) {
      System.out.println(horseStable[i].toString());
      }  
  }    

   private static boolean checkStables(Horse horseStable[]) {
      Scanner keyboard = new Scanner(System.in);
      boolean quit = false;
      String menu, prompt;
      System.out.println("\n1. List all horses in stable");
      System.out.println("2. List all race horses in stable"); 
      System.out.println("3. List all breeding horses in stable"); 
      System.out.println("4. Create new stable");
      System.out.println("0. Quit");
      menu = keyboard.nextLine();
      switch (menu) {
            
      case "0":
        quit = true;         
        break;
             
      case "1":           
        for (int i = 0; i < horseStable.length; i++) {
            System.out.println(horseStable[i].toString());
            }
            System.out.println("\nAll horses listed above.\n"); 
        break;
               
      case "2":      
        for (int i = 0; i < horseStable.length / 2; i++) {
            System.out.println(horseStable[i].toString());
            }
            System.out.println("\nAll racing horses listed above.\n");
         break;
               
      case "3":           
        for (int i = 3; i < horseStable.length; i++) {
            System.out.println(horseStable[i].toString());
            } 
            System.out.println("\nAll breeding horses listed above.");
            System.out.println("These horses have inherited their color from a parent horse.\n");  
         break;
         
      case "4":
         System.out.println("Warning: This will overwrite your current stable.");
         System.out.println("Do you wish to continue? Y/N"); 
         prompt = keyboard.nextLine().toLowerCase();
         if (prompt.equals("y")) {
            createRaceHorse(horseStable);   
            breedHorse(horseStable);
            }     
         break;  
                   
      default:                        
         break;
         }
      return quit;
   }

   public static void main(String[] args) {   
      boolean userHasQuit = false;
      Horse[] horseStable = new Horse[6];
      createRaceHorse(horseStable);   
      breedHorse(horseStable); 
      while (userHasQuit == false) {
         userHasQuit = checkStables(horseStable);
      }
   }
}