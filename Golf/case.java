/**                                                       @version 1.0
   @author Kevin M. Mallgrave
           Professor Janet Brown-Sederberg
           CTIM-168 B02
   @since  10 Feb 2019
     
   Class Golf
 */
import java.util.Scanner;
public class Golf {
/**
   This method creates an array of GolfHole objects. It uses a loop to set them up,
   then calls initHole to populate the instance variables with accurate information.
 */
   private static void createGolf(GolfHole golfCourse[]) {
   for (int i = 0; i < golfCourse.length; i++) {
      golfCourse[i] = new GolfHole(i+1, 1, 1, 1, 1, "nodescription");
      }
      initHole(golfCourse[0], 4, 4, 433, 
      "Boston Comm Ave Pothole, greatest city of the Northeast, at least according to Bay Staters\n");
      initHole(golfCourse[1], 4, 2, 418, 
      "Mass Pike Pothole, just ignore the city of Worcester. This hole exemplifies Northern values\n");
      initHole(golfCourse[2], 3, 12, 166, 
      "Rhode Island Pothole, park side by each and buy some wieners all the way and coffeemilk. What does that mean?\n");
      initHole(golfCourse[3], 4, 18, 344, 
      "New Hampshire Turnpike Pothole, buy some cheap booze and and fireworks. Golf Free or Die\n");
      initHole(golfCourse[4], 4, 16, 408, 
      "Maine Turnpike Pothole, 'The Way Life Should Be'? Bring flannel and chewing tobacco\n");
      initHole(golfCourse[5], 5, 6, 545, 
      "Vermont US-7 Pothole, the Green Mountain hole. Bring flannel and ...something green\n");     
      initHole(golfCourse[6], 4, 10, 378, 
      "Connecticut Turnpike Pothole, please don't pull me over for speeding, I'm headed to NYC\n"); 
      initHole(golfCourse[7], 3, 8, 204, 
      "NY State Thruway Pothole, New York City, the social center of the Northeast, unfortunately\n");     
      initHole(golfCourse[8], 5, 14, 476, 
      "New Jersey Turnpike Pothole, The Jersey motto: 'Well, we don't like you either'\n"); 
      initHole(golfCourse[9], 4, 3, 455, 
      "Pennsylvania Turnpike Pothole, Philadelphia, 'Where are yooz going?' Greatest city of the Northeast. Go Iggles\n");
      initHole(golfCourse[10], 4, 11, 397, 
      "Delaware Turnpike Pothole, I've never seen so many tolls in such a small state. Have some scrapple!\n");
      initHole(golfCourse[11], 5, 7, 555, 
      "Maryland House Pothole, 30 miles to Bawldamore, hon. Baltimore - 'Charm City', the jewel(?) of the Chesapeake\n");
      initHole(golfCourse[12], 3, 5, 238, 
      "DC Beltway Pothole, you are truly foolish to drive here. Whoever wins, we all lose\n");
      initHole(golfCourse[13], 4, 13, 383, 
      "Virginia Emporia Speed Trap-hole, welcome to the Old Dominion, where speeding results in jail time\n");
      initHole(golfCourse[14], 4, 1, 389, 
      "North Carolina Shine Runner Hole, are these roads even paved? The birthplace of NASCAR\n");
      initHole(golfCourse[15], 3, 17, 137, 
      "South Carolina Hole to Nowhere, sweet tea, poverty and traditional Southern values\n");
      initHole(golfCourse[16], 4, 15, 341, 
      "Georgia Peach Core Hole, the land of Ted Turner, Coca-Cola, and the heart of the Deep South\n");
      initHole(golfCourse[17], 5, 9, 523, 
      "Florida Sunshine Hole, the sunny home of many Northern retirees and 'Florida Man'\n");
   }   
/**
   This method populates a single GolfHole object with information. It is just
   an abbreviated way to call setters.
 */   
   private static void initHole(GolfHole hole, int par, int handicap, int distance, String description) {
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
            System.out.printf("Please your score for hole %d, score 1-10.\n", i+1);
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
         
         int holeScore = 0;
            for (int i = 0; i < golfCourse.length; i++) {
               if (golfCourse[i].getScore() == golfCourse[i].getPar()+strokeMod) {
                  holeScore++;
               }
            }
            System.out.printf("\nYour total number of %s for this round is: %d\n", strokeType, holeScore);
            System.out.printf("Press any key to continue.\n");
   }
/**
   This is a small for loop method that prints hole info to stdout depending on score type.
   The syntax is identical to parCalc.
 */   
   private static void holeInfo(GolfHole golfCourse[], String strokeType, int strokeMod) {
      
         int holeScore = 0;
            for (int i = 0; i < golfCourse.length; i++) {
               if (golfCourse[i].getScore() == golfCourse[i].getPar()+strokeMod) {
                  System.out.printf(golfCourse[i].toString());
               }
            }
            System.out.printf("\nAll %s score hole information printed above.\n", strokeType);
            System.out.printf("Press any key to continue.\n");
   }
/**
   This method prints information to stdout, and calls holeInfo, parCalc, 
   and calls itself(listOptions) recursively.
 */   
   private static void listOptions(GolfHole golfCourse[], String messageSwitch) {
      int aces = 0, abovePar = 0, belowPar = 0, totalScore = 0;
      switch (messageSwitch) {
      
      case "a"://a. Calculate and print the total score for the round
         for (int i = 0; i < golfCourse.length; i++) {
            totalScore = golfCourse[i].getScore() + totalScore;
            }
         System.out.printf("\nYour total score for this round is: %d\n", totalScore);
         System.out.printf("Press any key to continue.\n");
         break;
      
      case "b"://b. Calculate and print the number of strokes above/below par for the round
         for (int i = 0; i < golfCourse.length; i++) {
            if (golfCourse[i].getScore() < golfCourse[i].getPar()) {
               belowPar = belowPar + golfCourse[i].getScore();
            } else if (golfCourse[i].getScore() > golfCourse[i].getPar()) {
               abovePar = abovePar + golfCourse[i].getScore();
            }
         }
         System.out.printf("\nYour total strokes below par for this round is: %d\n", belowPar);
         System.out.printf("\nYour total strokes above par for this round is: %d\n", abovePar);
         System.out.printf("Press any key to continue.\n");
         break;
      
      case "c"://c. Calculate and print the number of aces (hole in one)
            for (int i = 0; i < golfCourse.length; i++) {
            if (golfCourse[i].getScore() == 1) {
               aces++;
               }
         }
         System.out.printf("\nYour total number of aces for this round is: %d\n", aces);
         System.out.printf("Press any key to continue.\n");
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
         System.out.printf("\nAll ace score hole information printed above.\n");
         System.out.printf("Press any key to continue.\n");
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
         listOptions(golfCourse, "");
         break;
      
      case "v"://v. Quit successfully
         System.exit(0);
         break;   
      
      case ""://the "" case; blank string. just print options to screen
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
         break;
          
      default://the default case. User who enter ANYTHING other than a-v are reminded to enter a-v.
         System.out.printf("Please enter a selection, 'a' to 'v'.\nEnter 'u' to list options again, or 'v' to quit.\n");
         break;
      }
   }
/**
   Main method
 */
   public static void main(String[] args) {
      String menu = "";      
      GolfHole[] golfCourse = new GolfHole[18];
      createGolf(golfCourse);
      playRound(golfCourse);
      listOptions(golfCourse, "");   
      while (!menu.equals("v")) {
         Scanner keyboard = new Scanner(System.in);
         menu = keyboard.nextLine().toLowerCase();
         listOptions(golfCourse, menu);
      }
   }
}//end class 