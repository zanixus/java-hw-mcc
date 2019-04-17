import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class readerdemo {
    public static void main(String[] args) {
        String fileName = "qa.txt";
        Scanner inputStream = null;
        System.out.println("The file " + fileName + "\ncontains the following lines:\n");
        try {
            inputStream = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException e) {
            System.out.println("Error opening the file " + fileName);
            System.exit(0);
        }
//        while (inputStream.hasNextLine()) {
//            String line = inputStream.nextLine();
//            System.out.println(line);
//        }
        for (int i = 0; i < 3; i++) {
            String line = inputStream.nextLine();
            System.out.println(line);
        }
        inputStream.close();
    }
}