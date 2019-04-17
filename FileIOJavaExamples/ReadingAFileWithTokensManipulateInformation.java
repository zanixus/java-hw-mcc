import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadingAFileWithTokensManipulateInformation
{
 public static void main(String[] args)
 {
  String tokenRead;
  Scanner inputStream = null;
  int average, sum = 0, count = 0;
  
  try
  {
    inputStream = new Scanner(new FileInputStream("numbers.txt"));
  }//end try
  catch(FileNotFoundException e)
  {
    System.out.println("Could not  open file, program will close.");
    System.exit(0);
  }//end catch
  
  while(inputStream.hasNext())
  {
    tokenRead = inputStream.next();
    sum = sum + Integer.parseInt(tokenRead);
    System.out.println(tokenRead);
    ++count;
    
  }//end while  
  
  average = sum/count;
  System.out.println();
   System.out.println("Average is: " + average);
  
 }//end main
}//end clas