/**                                                       @version 1.1
   @author Kevin M. Mallgrave
           Professor Janet Brown-Sederberg
           CTIM-168 B02
   @since  19 Feb 2019
     
   Class RoundOfGolf
   
   This class is a user friendly driver class for GolfHole.java(required).
   It creates an an array of GolfHole instances called golfCourse,
   allows the user to input their score in a round of golf, and prompts
   then user to select from several options to calculate stroke types and
   round score totals. It consists of the methods createGolf, initHole,
   playRound, parCalc, holeInfo, and listOptions, and main. Most methods
   are called from main and listOptions.
   
   version 1.0: initial release
   version 2.0: use better logic to drive while statement in main.
                listOptions now returns a boolean value(to drive while loop in main)
                Eliminated redundant listOptions method calls.
                Fixed string typo in playGolf.
 */
import java.util.Scanner;
public class RoundOfGolf {
/**
   This method creates an array of GolfHole objects. It uses a loop to set them up,
   then calls initHole to populate the instance variables with accurate information.
 */
   private static void createGolf(GolfHole golfCourse[]) {
//       for (int i = 0; i < golfCourse.length; i++) {
//          golfCourse[i] = new GolfHole(i+1, 1, 1, 1, 1, "nodescription");
//       }
      initHole(golfCourse[0], 1, 4, 4, 433, 
      "Boston Mass Ave Pothole, greatest city of the Northeast,\n at least according to Bay Staters\n");
      initHole(golfCourse[1], 2, 4, 2, 418, 
      "New Hampshire Turnpike Pothole, buy some cheap booze and\n fireworks. Golf Free or Die\n");
      initHole(golfCourse[2], 2,  3, 12, 166, 
      "Maine Turnpike Pothole, 'The Way Life Should Be'? Bring flannel\n and chewing tobacco\n");
      initHole(golfCourse[3], 4,  4, 18, 344, 
      "Vermont US-7 Pothole, the Green Mountain hole. Bring flannel\n and ...something green\n");
      initHole(golfCourse[4], 5,  4, 16, 408, 
      "Rhode Island Pothole, park side by each and buy some wieners\n all the way and coffeemilk. This is a valid sentence in Providence\n");
      initHole(golfCourse[5], 6,  5, 6, 545, 
      "Connecticut Turnpike Pothole, please don't pull me over for\n speeding, I'm headed to NYC and I really don't want to be here\n");     
      initHole(golfCourse[6], 7,  4, 10, 378, 
      "NY State Thruway Pothole, New York City, the social center of the\n Northeast, unfortunately\n");
      initHole(golfCourse[7], 8,  3, 8, 204, 
      "New Jersey Turnpike Pothole, The Jersey motto: 'Well, we don't\n like you either'\n");     
      initHole(golfCourse[8], 5, 14, 476, 
      "Pennsylvania Turnpike Pothole, exit south to Philadelphia.\n 'Where are yooz going?' Greatest city of the Northeast. Go Iggles\n"); 
      initHole(golfCourse[9], 4, 3, 455, 
      "Delaware Turnpike Pothole, I've never seen so many tolls in\n such a small state. Have some scrapple!\n");
      initHole(golfCourse[10], 4, 11, 397, 
      "Maryland House Pothole, 30 miles to Bawldamore, hon.\n Baltimore - 'Charm City', the jewel(?) of the Chesapeake\n");
      initHole(golfCourse[11], 5, 7, 555, 
      "DC Beltway Pothole, you are truly foolish to drive here.\n Whoever wins, we all lose\n");
      initHole(golfCourse[12], 3, 5, 238, 
      "West Virginia Appalachian Mountain-hole, an old coal mine.\n Home of the 'Mountain Dew Mouth'\n");
      initHole(golfCourse[13], 4, 13, 383, 
      "Virginia Emporia Speed Trap-hole, welcome to the Old Dominion,\n where speeding results in jail time\n");
      initHole(golfCourse[14], 4, 1, 389, 
      "North Carolina Shine Runner Hole, are these roads even paved?\n The birthplace of NASCAR\n");
      initHole(golfCourse[15], 3, 17, 137, 
      "South Carolina Hole to Nowhere, sweet tea, poverty\n and traditional Southern values\n");
      initHole(golfCourse[16], 4, 15, 341, 
      "Georgia Peach Core Hole, the land of Ted Turner, Coca-Cola,\n and the heart of the Deep South\n");
      initHole(golfCourse[17], 5, 9, 523, 
      "Florida Sunshine Hole, the sunny home of many Northern retirees\n and 'Florida Man'\n");
   }   
/**
   This method populates a single GolfHole object with information. It is just
   an abbreviated way to call setters.
 */   
   private static void initHole(GolfHole hole, int holeNumber, int par, int handicap, int distance, String description) {
      hole.setNumber(holeNumber);
      hole.setPar(par);
      hole.setHandicap(handicap);
      hole.setDistance(distance);
      hole.setDescription(description);
   }
/**
   This method prompts the user to enter their score for the round of golf they have played.
   It uses regular expressions and string input in an effort to throw fewer exceptions.
 */
   private static void playRound(GolfHole golfCourse[]) {
      Scanner keyboard = new Scanner(System.in);      
      for (int i = 0; i < golfCourse.length; i++) {
            System.out.printf("Please enter your score for hole %d, score 1-10.\n", i+1);
            String holeScore = keyboard.nextLine();
            while ((holeScore.matches("([1-9]|1[0-9]|1[0])") == false) ||
                  ((holeScore.trim().length() > 0)  == false)) {                
               System.out.printf("Invalid score entered for hole %d. Please enter 1-10.\n", i+1);
               holeScore = keyboard.nextLine();        
               }
         golfCourse[i].setScore(Integer.parseInt(holeScore));
         }
      }
/**
   This method calculates the total number of score types per round.
   golfCourse[] is the round of golf object input.
   String strokeType is the type of score(ace, eagle, etc). It is read to print to stdout later.
   int strokeMod is the check value for the score type.
 */      
   private static void parCalc(GolfHole golfCourse[], String strokeType, int strokeMod) {
      Scanner keyboard = new Scanner(System.in);
      int holeScore = 0;
         for (int i = 0; i < golfCourse.length; i++) {
            if (golfCourse[i].getScore() == golfCourse[i].getPar()+strokeMod) {
               holeScore++;
            }
         }
         System.out.printf("Your total number of %s for this round is: %d\n", strokeType, holeScore);
         System.out.printf("Press any key to continue.\n");
      String blocker = keyboard.nextLine();
   }
/**
   This is a small for loop method that prints hole info to stdout depending on score type.
   The syntax is identical to parCalc.
 */   
   private static void holeInfo(GolfHole golfCourse[], String strokeType, int strokeMod) {
      Scanner keyboard = new Scanner(System.in);
      int holeScore = 0;
         for (int i = 0; i < golfCourse.length; i++) {
            if (golfCourse[i].getScore() == golfCourse[i].getPar()+strokeMod) {
               System.out.printf(golfCourse[i].toString());
            }
         }
         System.out.printf("All %s score hole information printed above.\n", strokeType);
         System.out.printf("Press any key to continue.\n");
      String blocker = keyboard.nextLine();
   }
/**
   This method prints information to stdout, and calls holeInfo, parCalc, and returns a boolean value for the main loop.
   It takes a GolfHole object and a boolean value as an input parameter. Boolean value is "true" to print the menu, "false" to skip menu.
 */   
   private static boolean listOptions(GolfHole golfCourse[], boolean calledFromMain) {
      Scanner keyboard = new Scanner(System.in);
      int aces = 0, abovePar = 0, belowPar = 0, totalScore = 0;
      boolean userHasQuit = false;
      String blocker, messageSwitch;  
      if (calledFromMain == true) {          
         System.out.printf("a. Calculate and print the total score for the round\n");
         System.out.printf("b. Calculate and print the number of strokes above/below par for the round\n"); 
         System.out.printf("c. Calculate and print the number of aces (hole in one)\n"); 
         System.out.printf("d. Calculate and print the number of condors (4 below par)\n"); 
         System.out.printf("e. Calculate and print the number of albatross (3 below par)\n");
         System.out.printf("f. Calculate and print the number of eagles (2 below par)\n"); 
         System.out.printf("g. Calculate and print the number of birdies (one below par)\n"); 
         System.out.printf("h. Calculate and print the number of pars (at par)\n"); 
         System.out.printf("i. Calculate and print the number of bogeys (one above par)\n"); 
         System.out.printf("j. Calculate and print the number of double bogeys (two above par)\n");
         System.out.printf("k. Calculate and print the number of triple bogeys (three above par)\n");
         System.out.printf("l. Print the hole information for the holes on which you scored aces\n");
         System.out.printf("m. Print the hole information for the holes on which you scored condors\n");
         System.out.printf("n. Print the hole information for the holes on which you scored albatross\n");
         System.out.printf("o. Print the hole information for the holes on which you scored eagles\n");
         System.out.printf("p. Print the hole information for the holes on which you scored birdies\n");
         System.out.printf("q. Print the hole information for the holes on which you scored pars\n");
         System.out.printf("r. Print the hole information for the holes on which you scored bogeys\n");
         System.out.printf("s. Print the hole information for the holes on which you scored double bogeys\n");
         System.out.printf("t. Print the hole information for the holes on which you scored triple bogeys\n");
         System.out.printf("u. Select again\n");
         System.out.printf("v. Exit the program\n");
      }
      messageSwitch = keyboard.nextLine().toLowerCase();
      switch (messageSwitch) {
      
      case "a"://a. Calculate and print the total score for the round
         for (int i = 0; i < golfCourse.length; i++) {
            totalScore = golfCourse[i].getScore() + totalScore;
            }
         System.out.printf("\nYour total score for this round is: %d\n", totalScore);
         System.out.printf("Press any key to continue.\n");
         blocker = keyboard.nextLine();            
         break;
      
      case "b"://b. Calculate and print the number of strokes above/below par for the round
         for (int i = 0; i < golfCourse.length; i++) {
            if (golfCourse[i].getScore() < golfCourse[i].getPar()) {
               belowPar = belowPar + golfCourse[i].getScore();
            } else if (golfCourse[i].getScore() > golfCourse[i].getPar()) {
               abovePar = abovePar + golfCourse[i].getScore();
            }
         }
         System.out.printf("\nYour total strokes under par for this round is: %d\n", belowPar);
         System.out.printf("Your total strokes over par for this round is: %d\n", abovePar);
         System.out.printf("Press any key to continue.\n");         
         blocker = keyboard.nextLine();  
         break;
      
      case "c"://c. Calculate and print the number of aces (hole in one)
            for (int i = 0; i < golfCourse.length; i++) {
            if (golfCourse[i].getScore() == 1) {
               aces++;
               }
         }
         System.out.printf("\nYour total number of aces for this round is: %d\n", aces);
         System.out.printf("Press any key to continue.\n");
         blocker = keyboard.nextLine();
         break;
      
      case "d"://d. Calculate and print the number of condors (4 below par)
         parCalc(golfCourse, "condors", -4);
         break;
      
      case "e"://e. Calculate and print the number of albatross (3 below par)
         parCalc(golfCourse, "albatross", -3);
         break;
      
      case "f"://f. Calculate and print the number of eagles (2 below par)
         parCalc(golfCourse, "eagles", -2);
         break;
      
      case "g"://g. Calculate and print the number of birdies (one below par)
         parCalc(golfCourse, "birdies", -1);
         break;
      
      case "h"://h. Calculate and print the number of pars (at par)
         parCalc(golfCourse, "pars", 0);
         break;
      
      case "i"://i. Calculate and print the number of bogeys (one above par)
         parCalc(golfCourse, "bogeys", 1);
         break;
      
      case "j"://j. Calculate and print the number of double bogeys (two above par)
         parCalc(golfCourse, "double bogeys", 2);
         break;
      
      case "k"://k. Calculate and print the number of triple bogeys (three above par)
         parCalc(golfCourse, "triple bogeys", 3);
         break;
      
      case "l"://l. Print the hole information for the holes on which they scored aces
         for (int i = 0; i < golfCourse.length; i++) {
            if (golfCourse[i].getScore() == 1) {
               System.out.printf(golfCourse[i].toString());
            }
         }
         System.out.printf("All ace score hole information printed above.\n");
         System.out.printf("Press any key to continue.\n");
         blocker = keyboard.nextLine();             
         break;
      
      case "m"://m. Print the hole information for the holes on which they scored condors
         holeInfo(golfCourse, "condor", -4);
         break;
      
      case "n"://n. Print the hole information for the holes on which they scored albatross’
         holeInfo(golfCourse, "albatross", -3);
         break;
      
      case "o"://o. Print the hole information for the holes on which they scored eagles
         holeInfo(golfCourse, "eagle", -2);
         break;
      
      case "p"://p. Print the hole information for the holes on which they scored birdies
         holeInfo(golfCourse, "birdie", -1);
         break;
      
      case "q"://q. Print the hole information for the holes on which they scored pars
         holeInfo(golfCourse, "par", 0);
         break;
      
      case "r"://r. Print the hole information for the holes on which they scored bogeys
         holeInfo(golfCourse, "bogey", 1);
         break;
      
      case "s"://s. Print the hole information for the holes on which they scored double bogeys
         holeInfo(golfCourse, "double bogey", 2);
         break;
      
      case "t"://t. Print the hole information for the holes on which they scored triple bogeys
         holeInfo(golfCourse, "triple bogey", 3);
         break;
      
      case "u"://u. Select again
         break;//just return to the main loop
      
      case "v"://v. Quit successfully
         userHasQuit = true;
         break;
          
      default://the default case. User who enter ANYTHING other than a-v are reminded to enter a-v
         System.out.printf("Please enter a selection, 'a' to 'v'.\nEnter 'u' to list options again, or 'v' to quit.\n");
         userHasQuit = listOptions(golfCourse, false);
         break;//listOptions is called recursively with calledFromMain = false to skip menu print
      }
      return userHasQuit;
   }
/**
   Main method
 */
   public static void main(String[] args) {
      boolean loopClosed = false;    
      GolfHole[] golfCourse = new GolfHole[18];
      createGolf(golfCourse);
      playRound(golfCourse);
      while (loopClosed == false) {
         loopClosed = listOptions(golfCourse, true);
      }
   }
}//end class 