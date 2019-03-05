/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  09 Mar 2019

 Part 4: demo program.

 Quick demo program that generates some shapes. Not very interactive or user friendly.

 @version 1.0: initial release
 */
import java.util.Scanner;
public class DemoGeoFigure {

    private static boolean printInfo(Triangle triangles[], Square squares[]) {
        Scanner keyboard = new Scanner(System.in);
        boolean quit = false;
        String menu, prompt;
        System.out.println("\n1. Display triangle information");
        System.out.println("2. Display square information");
        System.out.println("0. Quit");
        menu = keyboard.nextLine();
        switch (menu) {

            case "0":
                quit = true;
                break;

            case "1":
                for (int i = 0; i < triangles.length; i++) {
                    System.out.println(triangles[i].toString());
                    triangles[i].displaySides();
                }
                break;

            case "2":
                for (int i = 0; i < squares.length; i++) {
                    System.out.println(squares[i].toString());
                    squares[i].displaySides();
                }
                break;

            default:
                break;
        }
        return quit;
    }

    public static void main(String[] args) {
        boolean userQuit = false;
        Triangle triangles[] = new Triangle[8];
        Square squares[] = new Square[8];
        for (int i = 0; i < triangles.length; i++) {
            triangles[i] = new Triangle((i + 1) * 2, (i + 1) * 3);
        }
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new Square((i + 1) * 2);
        }
        while (userQuit == false) {
        userQuit = printInfo(triangles, squares);
        }
    }
}