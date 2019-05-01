/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  01 May 2019

 Class C11PP8

 This is a Java word ladder solver. It uses a dictionary file called words.txt(hardcoded, must be in C11PP8 working dir)
 I was not able to locate Pearson/Savitch words.txt, so I found another words.txt that contains 87314 words.
 It is able to work with huge files(>400k lines) and tiny ones, but huge files are processed more slowly.



 @version 1.0: initial release
 @version 1.1: fix bug with large word sizes, helps prevent stack overflows
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
public class C11PP8 {

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

    private static String[] readFile(String fileDotTxt, int fileLines) {
        String fileName = fileDotTxt;
        String[] arrayOfLines = new String[fileLines];
        Scanner inputStream = null;
        int counter = 0;
        try {
            inputStream = new Scanner(new File(fileName));
        } catch(FileNotFoundException e) {
            System.out.printf("Error opening the file %s.\n", fileName);
            System.out.printf("Please check your file name and working directory and run the program again.\n");
            System.exit(0);
        }
        while (inputStream.hasNextLine()) {
            arrayOfLines[counter] = inputStream.nextLine().toLowerCase();
            counter++;
        }
        inputStream.close();
        return arrayOfLines;
    }

    private static String[] createDictionary(String fileDotTxt) {
        final int LINES = findLines(fileDotTxt);
        String[] words = readFile(fileDotTxt, LINES);
        return words;
    }

    public static boolean wordMatch(String start, String end, String[] dict, int steps)  {
        boolean lengthMatches = false, dictMatch = false;
        StringBuilder builder = new StringBuilder();
        String currentWord = "";
        for (int i = 0; i < start.length(); i++) {
            builder.append(" ");
        }
        if (start.length() == end.length()) {
            lengthMatches = true;
        }
        if (lengthMatches == true) {
            if (end.equals(start)) {
                System.out.printf("<- Word found!");
                System.out.printf("\n\nEnd word found: %s. This word ladder took %d steps.\n", end, steps);
                dictMatch = true;
                return dictMatch;
            } else {
                for (int i = 0; i < dict.length; i++) {
                    currentWord = dict[i];
                    int count = 0;
                    for (int j = 0; j < start.length(); j++) {
                        if (start.length() == currentWord.length()) {//we can use any wordlist, even huge ones
                            if (start.charAt(j) == currentWord.charAt(j)) {
                                count++;
                            }
                        }
                    }
                    if (count == start.length() - 1) {
                        dict[i] = builder.toString(); // create a blank string with charsize == string in dict
                        System.out.printf("%s | ", currentWord);
                        steps++;
                        start = currentWord;
                        // recursion call
                        if (wordMatch(start, end, dict, steps)) {
                            dictMatch = true;
                            return dictMatch;
                        }
                    }
                }
            }
            dictMatch = false;
            return dictMatch;
        } else {
            System.out.printf("Start word length and end word length mismatch.\n");
            System.out.printf("Please make sure your start word and end words are the same length.\n");
            return dictMatch;
        }
    }

    private static boolean getInput(String[] dictionary) {
        Scanner keyboard = new Scanner(System.in);
        boolean quit = false, matches = false;
        String firstWord = "", endWord = "", prompt;
        while (firstWord.equals("")) {
            System.out.printf("Please enter the beginning word.\n");
            firstWord = keyboard.nextLine();
        }
        while (endWord.equals("")) {n
            System.out.printf("Please enter the end word.\n");
            endWord = keyboard.nextLine();
        }
        matches = wordMatch(firstWord, endWord, dictionary, 0);
        if (matches == false) {
            System.out.printf("\n\nNo word ladder found.\n");
        }
        System.out.printf("\nDo you want to enter another set of words? Y/N\n");
        prompt = keyboard.nextLine().toLowerCase();
        if (prompt.equals("n")) {
            quit = true;
        }
        return quit;
    }

    public static void main(String[] args) {
        String[] dictionary = createDictionary("words.txt");
        boolean quit = false;
        while (quit == false) {
            quit = getInput(dictionary);
        }
    }
}
