import java.util.Scanner;
public class multiplicationTable_KM
{
   public static void main(String[] args)
   {
   Scanner keyboard = new Scanner(System.in);
   System.out.println("Please enter a number");
   int userInput;
   userInput = keyboard.nextInt();
   for(userInput =1; userInput<=10;userInput++)
      {//outer loop rows
      for (int i=1;i<=10;i++)
         {//inner loop columns
         System.out.print("\t"+userInput*i); 
         }
      }
//    for (int i=1;i<=10;i++)
//    {
//         for (int j=1;j<=10;j++)
//         {
//         System.out.print("\t"+i*j);
//         System.out.println();
//         } 
}
}