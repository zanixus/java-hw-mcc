import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileReader;

public class FileUtilities
{

public static int countNumberOfLines(String fileName)
{
int count = 0;
Scanner inputStream = null;
File fred = null;

try
{
fred = new File(fileName);
inputStream = new Scanner(fred);
}//end try
catch(FileNotFoundException e)
{
System.out.println("File not found, program will close.");
System.exit(0);
}//end catch

while(inputStream.hasNextLine())
{
inputStream.nextLine();
++count;
}//end while
inputStream.close();
return count;
}//end method
}//end class