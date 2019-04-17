/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  9 Apr 2019

    This program is a read/write demo. It detects the end of each line of a plaintext file and writes them
    to a new file, 8 "bits" max. Requires "binary.txt" file, which is a plaintext file of any number of lines, but
    for the sake of the demo it uses the provided binary.txt file provided with the assignment.

 @version 1.0: initial release
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
public class lsbi_KMM {

    //returns an int that is equal to the amount of lines in a plaintext file
    private static int findLines(String fileDotTxt) {
        int lines = 0;
        try {
            BufferedReader lineDetector = new BufferedReader(new FileReader(fileDotTxt));
            try {
                while (lineDetector.readLine() != null) {
                    lines++;
                }
                lineDetector.close();
            } catch (IOException e) {
                System.out.printf("Input/output error. Please check the file type.\n");
            }
        } catch (FileNotFoundException e) {
            System.out.printf("File not found. Please check your file and working directory.\n");
        }
        return lines;
    }

    private static void lsbi() {
        final int LINES = findLines("binary.txt");
        String[] bits = readFile("binary.txt", LINES);
        writeFile("stage.txt", bits);
    }

    //returns an array of String
    //array size is equal to lines of plaintext
    //each array String element is the corresponding file line
    private static String[] readFile(String fileDotTxt, int fileLines) {
        String fileName = fileDotTxt;
        String[] arrayOfLines = new String[fileLines];
        Scanner inputStream = null;
        int counter = 0;
        try {
            inputStream = new Scanner(new File(fileName));
        } catch(FileNotFoundException e) {
            System.out.println("Error opening the file " + fileName);
            System.out.println("Please check your file name and working directory and run the program again.");
            System.exit(0);
        }
        while (inputStream.hasNextLine()) {
            arrayOfLines[counter] = inputStream.nextLine();
            counter++;
        }
        inputStream.close();
        return arrayOfLines;
    }

    private static void writeFile(String fileToWrite, String[] arrayInput) {
        char lsb;
        StringBuilder builder = new StringBuilder();
        String lsbLine = "";
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileOutputStream(fileToWrite, true));
        } catch(FileNotFoundException e)  {
            System.out.println("Error opening the file " + fileToWrite);
            System.out.println("Please check your file name and working directory and run the program again.");
            System.exit(0);
        }
        for (int i = 0; i < arrayInput.length; i++) {
            if (arrayInput[i].length() > 0) { //let's not try this with a blank string. causes exceptions.
                lsb = arrayInput[i].charAt(arrayInput[i].length() - 1);
                builder.append(lsb);
                lsbLine = builder.toString();
                if (lsbLine.length() == 8) {
                    outputStream.println(lsbLine);
                    builder.setLength(0);
                    lsbLine = "";
                }
            }
        }
        outputStream.println(lsbLine);
        outputStream.close();
    }

    public static void main(String[] args) {
        lsbi();
    }
}