/**  
 * case structure demo                                               
 */
import java.util.Random;
public class caseDemo_KMM

{
        public static void main(String[] args) 
    {
     Random rng = new Random();
     int die1, die2, sum;
     die1 = rng.nextInt(6) + 1; //(0-5 plus 1)
     die2 = rng.nextInt(6) + 1;
     sum = die1 + die2;
     sum = rng.nextInt(6) + rng.nextInt(6) +2;                                  		
     System.out.printf("Die roll result: %d\n", sum); 
        switch (sum) 
            {
            case 1: if (sum == 1);
            System.out.printf("win\n");                   
                     break;
            case 2: if (sum == 2)
            System.out.printf("win\n");
                     break;
            case 3: if (sum == 3)
            System.out.printf("win\n");
                     break;
            case 4: if (sum == 4)
            System.out.printf("lose\n");
                     break;
            case 5: if (sum == 5)
            System.out.printf("lose\n");
                     break;
            case 6: if (sum == 6)
            System.out.printf("lose\n");
                     break;
            case 7: if (sum == 7)
            System.out.printf("lose\n");
                     break;
            case 8: if (sum == 8)
            System.out.printf("lose\n");
                     break;
            case 9: if (sum == 9)
            System.out.printf("lose\n");
                     break;
            case 10:if (sum == 10)
             System.out.printf("Roll again\n", sum);
                     break;
            case 11:if (sum == 11)
             System.out.printf("Roll again\n", sum);
                     break;
            case 12:if (sum == 12)
             System.out.printf("Roll again\n", sum);
                     break;
            }            
       if (sum <1 || sum >12) //else - sum not between 0 and 13, rng broken
       { 
       System.out.printf("oops, the rng is broken\n", sum); 
       }
   }
}