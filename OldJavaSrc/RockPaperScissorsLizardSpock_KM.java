import java.util.Random;
import java.util.Scanner;

public class RPS_KM
{
   public static void main(String args[]) throws Exception
   {    
   int  rpsIndex;
   int  rpsInt = 0;
   String rpsString = "initalString";
   Random rpsJudge = new Random();
   rpsIndex = rpsJudge.nextInt(3);
   System.out.println("Rock, paper, scissors");
   rpsPlayer = (char)System.in.read();
   if      (rpsPlayer == 'r' || rpsPlayer == 'R')
       rpsDraw = 'r';
   else if (rpsPlayer == 'p' || rpsPlayer == 'P')
       rpsDraw = 'p';
   else if (rpsPlayer == 's' || rpsPlayer == 'S')
       rpsDraw = 's';
   else if (rpsPlayer == 'l' || rpsPlayer == 'L')
       rpsDraw = 'l';
   else if (rpsPlayer == 'k' || rpsPlayer == 'K')
       rpsDraw = 'k';
   else 
      {
      System.out.println("Invalid input. Please enter R, P, S, L or K.");
      System.exit(0);
      }
   if      (rpsPlayer == 'r' || rpsPlayer == 'R')
       rpsInt = 0;
   else if (rpsPlayer == 'p' || rpsPlayer == 'P')
       rpsInt = 1;
   else if (rpsPlayer == 's' || rpsPlayer == 'S')
       rpsInt = 2;
   else if (rpsPlayer == 'l' || rpsPlayer == 'L')
       rpsInt = 3;
   else if (rpsPlayer == 'k' || rpsPlayer == 'K')
       rpsInt = 4;
   else 
      {
      System.out.println("the computer is cheating");
      System.exit(0);
      }
   System.out.println(rpsPlayer);
      switch (rpsIndex) //let's use a case structure
      {
         case 0:
         System.out.println("System chose Rock"); 
         if      (rpsInt == rpsIndex)
         {
         System.out.println("Its a tie!");
         }
         else if (rpsInt == 1)//paper
         {
         System.out.println("You win!");
         }
         else if (rpsInt == 2)//scissors
         {
         System.out.println("You lose!");
         }
      break;
      case 1:
         System.out.println("System chose Paper");
         if    (rpsInt == rpsIndex)
         {
         System.out.println("Its a tie!");
         }
       else if (rpsInt == 2)//scissors
         {
         System.out.println("You win!");
         }
       else if (rpsInt == 0)//rock
         {
         System.out.println("You lose!");
         }
      break;
      case 2: 
         System.out.println("System chose Scissors");
         if      (rpsInt == rpsIndex)
         {
         System.out.println("Its a tie!");
         }
         else if (rpsInt == 0)//rock
         {
         System.out.println("You win!");
         }
         else if (rpsInt == 1)
         {
         System.out.println("You lose!");
         }
      break;
      }
   }
}