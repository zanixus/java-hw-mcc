import java.util.Scanner;
public class printfdemo
{
	public static void main(String[] args)
	{
//      double amount = 123456789.123456789; //print float
//      System.out.printf("$%,1.2f\n",       //% means format this way for printf
//                        amount);
//      System.out.printf("%1s\n",          //print string
//                        "w");
//      System.out.printf("%1c\n",          //print char
//                        'x');
      int numberOfItems  = 20;
      double costPerItem = 1.26;
      String itemName = "apples";
      String s1 = "The cost of";
      String s2 = "is";
      String s3 = "today.";      
      System.out.printf("%1s %1d %1s %1s $%,1.2f %1s \n", 
      s1, numberOfItems, itemName, s2, numberOfItems * costPerItem, s3);
	}
}
