import java.util.Scanner;
public class nant {

    public static void main(String[] args) {


        Course[] numOfCourses;
        int userInput = 0;
        double total = 0;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to DemoNantucket...");
        System.out.println("This program is designed to calculate the amount for a semester at the University of Nantucket.");

        System.out.print("Enter your total number of courses: ");
        userInput = keyboard.nextInt();
        numOfCourses = new Course[userInput];

        System.out.println("Please enter the information for each course.");
        for(int i = 0; i < numOfCourses.length; i++) { // populate array
        System.out.println("Course # " + (i+1) + ".\n");
        System.out.print("Department: ");
        keyboard.nextLine();
        String department = keyboard.nextLine();
        System.out.print("Course Number: ");
        int courseNumber = keyboard.nextInt();
        System.out.print("Course Credits: ");
        int courseCredits = keyboard.nextInt();

        if(department.toUpperCase().equals("SCI") || department.toUpperCase().equals("CSC") || department.toUpperCase().equals("PHY"))
        {
        numOfCourses[i] = new LabCourse(department, courseNumber, courseCredits);
        } // end if statement
        else
        numOfCourses[i] = new Course(department, courseNumber, courseCredits);
        } // end for loop

        for(int i = 0; i < numOfCourses.length; i++) { // finding course cost
        numOfCourses[i].setCourseCost(numOfCourses[i].getCourseCredits() * 120.0);
        } // end for loop

        for(int i = 0; i < numOfCourses.length; i++) { // print course info
        System.out.println(numOfCourses[i].toString() + "\n");
        } // end for loop

        for(int i = 0; i < numOfCourses.length; i++) { // find total
        total = total + (numOfCourses[i].getCourseCost());
        } // end for loop

        System.out.println("Total Price: $" + total);
        System.out.println("\nThank you for using DemoNantucket, goodbye.");

        } // end main

} // end class