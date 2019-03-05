/**                                                         @version 1.0
 * @author Kevin M. Mallgrave
 *         Professor Janet Brown-Sederberg
 *         CTIM-157 B02
 * @since  19 October 2018
 *
 * This is a Rock Paper Scissors Lizard Spock game.
 * It uses the java.util.Random method to find a random number from 0-4
 * and uses the random int to assign a char value.
 * The program then asks for user input in char value with System.in.read.
 * The program then uses a case selection structure to pick
 * game outcomes based on the rpsCPU char in memory,
 * and runs if-else statements nested within the case structure.
 * All game outcome boolean logic uses char data values.
 * This code is optimized for 80 column width.
 * This program rejects invalid input, and accounts
 * for Random() method that is data out of range.
 *
 * Version 1.0: initial release
 *
 */
import java.util.Random;
public class Rock_KMM
{
   public static void main(String args[]) throws Exception {
   int  rpsIndex;
   char rpsPlayer, rpsDraw = 'r', rpsCPU = 'r';
   Random rpsJudge = new Random();
   rpsIndex = rpsJudge.nextInt(5);
   if      (rpsIndex == 0)
            rpsCPU = 'r';
   else if (rpsIndex == 1)
            rpsCPU = 'p';
   else if (rpsIndex == 2)
            rpsCPU = 's';
   else if (rpsIndex == 3)
            rpsCPU = 'l';
   else if (rpsIndex == 4)
            rpsCPU = 'k';
   else {
      System.out.println("method Random() out of range. OOPS");
      System.exit(0);
      }
   System.out.println("(R)ock, (P)aper, (S)cissors, (L)izard, Spoc(K)");
   System.out.println("Please enter 'R', 'P', 'S', 'K', or 'K'");
   rpsPlayer = (char)System.in.read();
   if      (rpsPlayer == 'r' || rpsPlayer == 'R'){
       rpsDraw = 'r';
       System.out.println("You chose Rock.");
       }
   else if (rpsPlayer == 'p' || rpsPlayer == 'P'){
       rpsDraw = 'p';
       System.out.println("You chose Paper.");
       }
   else if (rpsPlayer == 's' || rpsPlayer == 'S'){
       rpsDraw = 's';
       System.out.println("You chose Scissors.");
       }
   else if (rpsPlayer == 'l' || rpsPlayer == 'L'){
       rpsDraw = 'l';
       System.out.println("You chose Lizard. Hiss!");
       }
   else if (rpsPlayer == 'k' || rpsPlayer == 'K'){
       rpsDraw = 'k';
       System.out.println("You chose Spock. Live Long and Prosper.");
       }
   else {
      System.out.println
      ("Invalid input. Please enter 'R', 'P', 'S', 'L', or 'K'.");
      System.exit(0);
      }
      switch (rpsCPU) //let's use a case structure and have it switch on
      {//char rpsCPU, so we can compare char NOT int as the assignment asks
      case 'r':
         System.out.println
         ("Computer chose Rock.");
         if      (rpsDraw == rpsCPU){
         System.out.println
         ("Tie! Rock vs. Rock!");
         }
         else if (rpsDraw == 'p'){
         System.out.println
         ("You lose! Paper covers Rock");
         }
         else if (rpsDraw == 's'){
         System.out.println
         ("You lose! Rock smashes Scissors!");
         }
         else if (rpsDraw == 'l'){
         System.out.println
         ("You win! Rock crushes Lizard!");
         }
         else if (rpsDraw == 'k'){
         System.out.println
         ("You win! Spock vaporizes Rock with his phaser!");
         }
      break;
      case 'p':
         System.out.println
         ("Computer chose Paper.");
         if    (rpsDraw == rpsCPU){
         System.out.println
         ("Tie! Paper vs. Paper!");
         }
         else if (rpsDraw == 's'){
         System.out.println
         ("You win! Scissors cut Paper!");
         }
         else if (rpsDraw == 'r'){
         System.out.println
         ("You lose! Rock smashes Scissors!");
         }
         else if (rpsDraw == 'l'){
         System.out.println
         ("You win! Lizard eats Paper!");
         }
         else if (rpsDraw == 'k'){
         System.out.println
         ("You lose! Paper disproves Spock's Vulcan pseudoscience nonsense!");
         }
      break;
      case 's':
         System.out.println
         ("Computer chose Scissors.");
         if      (rpsDraw == rpsCPU){
         System.out.println
         ("Tie! Rock vs. Rock!");
         }
         else if (rpsDraw == 'r'){
         System.out.println
         ("You win! Rock smashes Scissors!");
         }
         else if (rpsDraw == 'p'){
         System.out.println
         ("You lose! Scissors cut paper!");
         }
         else if (rpsDraw == 'l'){
         System.out.println
         ("You lose! Scissors decapitate Lizard!");
         }
         else if (rpsDraw == 'k'){
         System.out.println
         ("You win! Spock somehow smashes scissors!");
         }
      break;
      case 'l':
         System.out.println
         ("Computer chose Lizard. Hiss!");
         if      (rpsDraw == rpsCPU){
         System.out.println
         ("Tie! Lizard duel!");
         }
         else if (rpsDraw == 'r'){
         System.out.println
         ("You win! Rock crushes Lizard!");
         }
         else if (rpsDraw == 'p'){
         System.out.println
         ("You lose! Lizard eats paper!");
         }
         else if (rpsDraw == 's'){
         System.out.println
         ("You win! Scissors decapitate Lizard!");
         }
         else if (rpsDraw == 'k'){
         System.out.println
         ("You lose! Lizard poisons Spock!");
         }
      break;
      case 'k':
         System.out.println
         ("Computer chose Spock. Live Long and Prosper.");
         if      (rpsDraw == rpsCPU){
         System.out.println
         ("Tie! The two Spocks engage in endless Vulcan theory debate!");
         }
         else if (rpsDraw == 'r'){
         System.out.println
         ("You lose! Spock vaporizes Rock with his phaser!");
         }
         else if (rpsDraw == 'p'){
         System.out.println
         ("You win! Paper disproves Spock's Vulcan pseudoscience nonsense!");
         }
         else if (rpsDraw == 's'){
         System.out.println
         ("You lose! Spock somehow crushes Scissors!");
         }
         else if (rpsDraw == 'l'){
         System.out.println
         ("You win! Lizard poisons Spock!");
         }
       break;
      }
   }
}
