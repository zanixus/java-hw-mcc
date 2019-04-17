import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SearchingAFile
{
public static void main(String[] args)
{
int numberSearch;
Scanner keyboard = new Scanner(System.in);
Scanner inputStream = null;
try
{
inputStream = new Scanner(new FileInputStream("numbers.txt"));
}//end try
catch(FileNotFoundException e)
{
System.out.println("File could not be found, program to close.");
System.exit(0);
}//end catch
System.out.println("Please enter a number to search for:");
numberSearch = keyboard.nextInt();
while(inputStream.hasNextInt())
{
if(inputStream.nextInt() == numberSearch)
	{
	System.out.println("Match");
	break;
	}//end if
	else
	System.out.println("No match.");

}//end while

inputStream.close();
}//end main

}//end class