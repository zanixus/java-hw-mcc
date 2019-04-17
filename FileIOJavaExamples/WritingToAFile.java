import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class WritingToAFile
{
  public static void main(String[] args)
  {
  int userInput;
  Scanner keyboard = new Scanner(System.in);
  PrintWriter outputStream = null;
  try
  {
   outputStream 
     = new PrintWriter(new FileOutputStream("numbers.txt", true));    
  }
  catch(FileNotFoundException e)
  {
    System.out.println("File was not found, program to end.");
    System.exit(0);
  }//end catch block
  
  System.out.println("Please enter an int.");
  userInput = keyboard.nextInt();
  
  outputStream.println(userInput);
  outputStream.close();
  
  }//end main
}//end class