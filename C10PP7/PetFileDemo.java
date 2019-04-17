/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  15 Apr 2019

 Revise the class Pet, as shown in Listing 6.1 of Chapter 6, so that it is serializable.
 Write a program that allows you to write and read objects of type Pet to a file.
 The program should ask the user whether to write to a file or read from a file.
 In either case, the program next asks for the file name. A user who has asked to write to a
 file can enter as many records as desired. A user who has asked to read from a file is shown
 all of the records in the file. Be sure that the records do not scroll by so quickly that the
 user cannot read them.

 @version 1.0: initial release
 */
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
public class PetFileDemo {

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

    private static void printStringArray(String[] arrayInput) {
        Scanner keyboard = new Scanner(System.in);
        int counter = 1;
        for (int i = 0; i < 4; i++) {
            System.out.println(arrayInput[i]);
        }
        for (int i = 4; i < arrayInput.length; i++) {
            System.out.println(arrayInput[i]);
            if (arrayInput[i].length() == 0) {
                System.out.printf("Pet record %d displayed. Press any key to continue.\n", counter);
                counter++;
                String blocker = keyboard.nextLine();
            }
        }
    }

    private static void writeFile(String fileToWrite, String objectInfo) {
        String lsbLine = "";
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileOutputStream(fileToWrite, true));
        } catch(FileNotFoundException e)  {
            System.out.println("Error opening the file " + fileToWrite);
            System.out.println("Please check your file name and working directory and run the program again.");
            System.exit(0);
        }
        outputStream.println(objectInfo);
        outputStream.close();
    }

    private static boolean petInventory() {
        Scanner keyboard = new Scanner(System.in);
        Random petStats = new Random();
        String menu, prompt;
        boolean quit = false;
        System.out.println("1. Write new pet information to file");
        System.out.println("2. Read pet information file");
        System.out.println("0. Quit");
        menu = keyboard.nextLine();
        switch (menu) {

            case "0":
                quit = true;
                break;

            case "1":
                String petName = "";
                while ((petName.trim().length() > 0)  == false) {
                    System.out.printf("Please enter a name for your pet. Weight and age will be randomized.\n");
                    petName = keyboard.nextLine();
                }
                Pet toFile = new Pet(petName, (petStats.nextInt(100) +10), (petStats.nextInt(9) +1));
                writeFile("pets.txt", toFile.toString());
                break;

            case "2":
                printStringArray(readFile("pets.txt", findLines("pets.txt")));
                break;

            default:

                break;
        }
        return quit;
    }

    public static void main(String[] args) {
        boolean hasQuit = false;
        while (hasQuit == false) {
            hasQuit = petInventory();
        }
    }
}