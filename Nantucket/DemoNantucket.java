/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  09 Mar 2019

    Class DemoNantucket

    A small credit cost calculator. Uses a few procedural methods and a main loop. Fairly user friendly.
    Requires Course.java and LabCourse.java to run.

 @version 1.0: initial release
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class DemoNantucket {


    private static Course[] getCourseInfo() {
        Scanner keyboard = new Scanner(System.in);
        System.out.printf("Please enter the number of courses you are taking this semester.\n");
        String courseInput = keyboard.nextLine();
        while ((courseInput.matches("([1-9]|1[0])") == false)
                || ((courseInput.trim().length() > 0)  == false)) {
            System.out.printf("Please enter a valid amount of courses, 1-10.\n");
            courseInput = keyboard.nextLine();
        }
        Course[] semester = new Course[Integer.parseInt(courseInput)];

        for (int i = 0; i < semester.length; i++) {
            boolean validSubject = false, labCourse = false;
            String subject = "";
            while (validSubject == false) {
                switch (subject) {
                    case "ENG":
                        validSubject = true;
                        break;
                    case "MTH":
                        validSubject = true;
                        break;
                    case "CSC":
                        validSubject = true;
                        labCourse = true;
                        break;
                    case "HST":
                        validSubject = true;
                        break;
                    case "HUM":
                        validSubject = true;
                        break;
                    case "SCI":
                        validSubject = true;
                        labCourse = true;
                        break;
                    case "LAN":
                        validSubject = true;
                        break;
                    case "PHY":
                        validSubject = true;
                        labCourse = true;
                        break;
                    default:
                        System.out.printf("Please enter the subject of your %s course.\n", ordinal(i + 1));
                        System.out.printf("Subject must be ENG, MTH, CSC, HST, HUM, SCI, LAN, or PHY.\n");
                        subject = keyboard.nextLine().toUpperCase();
                        break;
                }
            }
            String courseNumber = "";
            while ((courseNumber.matches("(1[0-9][0-9]|2[0-9][0-9]|3[0-9][0-9]|4[0-9][0-9]|)") == false) ||
                    ((courseNumber.trim().length() > 0) == false)) {
                System.out.printf("Please enter the course number of your %s course.\n", ordinal(i + 1));
                System.out.printf("Your subject for this course is %s.\n", subject);
                courseNumber = keyboard.nextLine();
            }
            String courseCredits = "";
            while ((courseCredits.matches("(1|3|4)") == false) ||
                    ((courseCredits.trim().length() > 0) == false)) {
                System.out.printf("Please enter the amount of credits %s-%s will provide, 1, 3 or 4.\n", subject, courseNumber);
                courseCredits = keyboard.nextLine();
            }
            if (labCourse == true) {
                semester[i] = new LabCourse(subject, Integer.parseInt(courseNumber), Integer.parseInt(courseCredits));
            }else{
                semester[i] = new Course(subject, Integer.parseInt(courseNumber), Integer.parseInt(courseCredits));
            }
        }
        return semester;
    }

    private static int getBill(Course[] semester) {
        Scanner keyboard = new Scanner(System.in);
        int status = 0;
        String menu = "", prompt;
        double semesterCost = 0;
        DecimalFormat usd = new DecimalFormat ("'$'0.00");
        for (int i = 0; i < semester.length; i++) {
            semesterCost = semesterCost + semester[i].getCourseCost();
        }
        System.out.printf("Your total credit cost this semester is %s.\n",usd.format(semesterCost));
        System.out.printf("Press any key to continue.\n");
        prompt = keyboard.nextLine();
        System.out.printf("1. List all courses taken this semester\n");
        System.out.printf("2. Re-enter semester information and recalculate bill\n");
        System.out.printf("0. Quit\n");
        while ((menu.matches("(0|1|2)") == false) ||
                ((menu.trim().length() > 0) == false)) {
            menu = keyboard.nextLine();
        }
        switch (menu) {
            case "0":
                status = 2;
                break;
            case "1":
                for (int i = 0; i < semester.length; i++) {
                    System.out.printf(semester[i].toString());
                    System.out.printf("\n\n");
                }
                break;
            case "2":
                System.out.printf("Warning: This will overwrite your current semester schedule.\n");
                System.out.printf("Do you wish to continue? Y/N\n");
                prompt = keyboard.nextLine().toLowerCase();
                if (prompt.equals("y")) {
                    status = 1;
                }
                break;
            default:
                break;
        }
        return status;
    }

    public static String ordinal(int input) {
        String[] suffix = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
        String output;
        switch (input % 100) {
            case 11:
            case 12:
            case 13:
                output = input + "th";
            default:
                output = input + suffix[input % 10];

        }
        return output;
    }

    public static void main(String[] args){
        int status = 0;
        Course[] semester = getCourseInfo();
        while (status == 0){
            status = getBill(semester);
            if (status == 1) {
                semester = getCourseInfo();
                status = getBill(semester);
            }
        }
    }
}