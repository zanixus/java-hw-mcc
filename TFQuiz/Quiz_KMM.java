/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  9 Apr 2019

 This is a silly quiz program to demo file reads. It can handle any quiz size, but is set up for 10.
 TODO: add method to detect lines in file to set the quizSize variable

 @version 1.0: initial release
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
public class Quiz_KMM {

    private static void runQuiz() {
        final int QUIZSIZE = findLines("qa.txt");
        if (QUIZSIZE == 0) {
            System.out.printf("Error: No lines in file. Program stopped.\n");
            System.exit(0);
        }
        float quizScore = 0;
        String[] questions = openFile("qa.txt", QUIZSIZE);
        for (int i = 0; i < questions.length; i++) {
            System.out.printf("\n");
            printQuestion(questions[i], '|', 1);
            boolean check = false;
            boolean answer = promptUser();
            if (questions[i].substring(0,1).equals("t")) {
                check = true;
            }
            if (check == answer) {
                System.out.printf("Correct answer.\n");
                quizScore++;
            } else {
                System.out.printf("Incorrect answer.\n");
            }
        }
        float grade = (quizScore / QUIZSIZE) * 100;
        System.out.printf("\nThe quiz is over. You answered %d out of %d questions correctly.\n", (int)quizScore, QUIZSIZE);
        System.out.printf("Your quiz grade is %.2f%%.\n", grade);
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

    private static void printQuestion(String str, char ch, int count) {
        int occ = 0, i;
        if (count == 0) {
            System.out.println(str);
            return;
        }
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                occ++;
            }
            if (occ == count) {
                break;
            }
        }
        if (i < str.length() - 1) {
            System.out.println(str.substring(i + 2));
        } else {
            System.out.println("Empty string");
        }
    }

    private static boolean promptUser() {
        Scanner keyboard = new Scanner(System.in);
        boolean answer = false;
        try {
            System.out.println("Please enter true or false.");
            answer = keyboard.nextBoolean();
            keyboard.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter true or false.");
            answer = promptUser();
        }
        return answer;
    }

    private static String[] openFile(String fileDotTxt, int fileLines) {
        String fileName = fileDotTxt;
        String[] questions = new String[fileLines];
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
            questions[counter] = inputStream.nextLine();
            counter++;
        }
        inputStream.close();
        return questions;
    }

    public static void main(String[] args) {
        runQuiz();
    }
}