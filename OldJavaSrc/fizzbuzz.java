/**                                                       @version 1.0
Write a program that prints the numbers from 1 to 100. 
But for multiples of three print “Fizz” instead of the number 
and for the multiples of five print “Buzz”. For numbers 
which are multiples of both three and five print “FizzBuzz”.

*/

public class fizzbuzz {

private int loop;

public fizzbuzz() {
   this.loop = 100;
   }   

private int fizz(int n) {
   return n % 3;
   }
   
private int buzz(int n) {
   return n % 5;
   }

public void fizzbuzz(int loop)
   {   
   for (int i=1; i<=loop; i++) {
      if (fizz(i) == 0 && buzz(i) !=0)
         System.out.println("fizz:     "+i);
      else if (buzz(i) == 0 && fizz(i) !=0)
         System.out.println("buzz:     "+i);
      else if (fizz(i) == 0 && buzz(i) == 0)
         System.out.println("fizzbuzz: "+i);
      else 
      System.out.println("          "+i);
      }
   }
   
public static void main(String[] args) {
   fizzbuzz yo = new fizzbuzz();
   yo.fizzbuzz(100);
   }//end main
}//end class
