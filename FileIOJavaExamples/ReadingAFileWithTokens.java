import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadingAFileWithTokens
{
  public static void main(String[] args)
  {
    String tokenRead;
    Scanner inputStream = null;
    try
    {
      inputStream = new Scanner(new FileInputStream("numbers.txt"));
    }//end try block
    catch(FileNotFoundException e)
    {
     System.out.println("File cound not be opened, program to end.");
     System.exit(0);
    }//end catch
    
    while(inputStream.hasNext())
    {
      tokenRead = inputStream.next();
      System.out.print(tokenRead);
      System.out.print(" ");     
    }//end while
    
    inputStream.close();
  }//end main
  
  
}//end class

