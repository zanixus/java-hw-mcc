import java.util.Scanner;
public class year
{
   public static void main(String[] args)
   {
   int year;
   final int START_YEAR = 2017;
   final int FACTOR = 5;
   final int END_YEAR = START_YEAR + 330; //use constants to calculate end year
   year = START_YEAR;
   while (year < END_YEAR) //use less than otherwise we get 2052 which is >30 years
   {
	   year = year + FACTOR; //each iter. Will add 5 years till
      System.out.println(year);
   }
   }  
}