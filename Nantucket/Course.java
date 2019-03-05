/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  09 Mar 2019

 Class Course

 Object definition for a college course

 @version 1.0: initial release
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class Course {
// Instance variables
//
    private String department;
    private int courseNumber;
    private int courseCredits;
    private double courseCost;
// Constructors
//
    public Course() {
        this.setDepartment("0");
        this.setCourseNumber(0);
        this.setCourseCredits(0);
        this.setCourseCost(0);
    }

    public Course(String dept, int course, int credits) {
        this.setDepartment(dept);
        this.setCourseNumber(course);
        this.setCourseCredits(credits);
        this.setCourseCost(credits*120);
    }
// Getter methods
//
    public String getDepartment() {
        return this.department;
    }

    public int getCourseNumber() {
        return this.courseNumber;
    }

    public int getCourseCredits() {
        return this.courseCredits;
    }

    public double getCourseCost() {
        return this.courseCost;
    }

    public String toString() {
        DecimalFormat usd = new DecimalFormat ("'$'0.00");
        String objectInfo;
        objectInfo = "\nDepartment:      " + this.getDepartment()
                +    "\nCourse number:   " + this.getCourseNumber()
                +    "\nCourse credits:  " + this.getCourseCredits()
                +    "\nCourse cost:     " + usd.format(this.getCourseCost());
        return objectInfo;
    }

    public boolean equals(Course collegeCourse) {
        boolean isEqual = false;
        isEqual =(this.getDepartment() == collegeCourse.getDepartment()
                && this.getCourseNumber() == collegeCourse.getCourseNumber()
                &&this.getCourseCredits() == collegeCourse.getCourseCredits()
                &&this.getCourseCost() == collegeCourse.getCourseCost()
        );
        return isEqual;
    }
    //
// Setter methods

    public void setDepartment(String department) {
        Scanner keyboard = new Scanner(System.in);
        boolean isValid = false;
        while (isValid == false) {
            switch (department) {
                case "ENG":
                    isValid = true;
                    break;
                case "MTH":
                    isValid = true;
                    break;
                case "CSC":
                    isValid = true;
                    break;
                case "HST":
                    isValid = true;
                    break;
                case "HUM":
                    isValid = true;
                    break;
                case "SCI":
                    isValid = true;
                    break;
                case "LAN":
                    isValid = true;
                    break;
                case "PHY":
                    isValid = true;
                    break;
                default:
                    System.out.println("Please enter a valid department.");
                    System.out.println("Department must be ENG, MTH, CSC, HST, HUM, SCI, LAN, or PHY.");
                    department = keyboard.nextLine().toUpperCase();
                    break;
            }
        }
        this.department = department;
    }

    public void setCourseNumber(int courseNumber) {
        Scanner keyboard = new Scanner(System.in);
        while  (courseNumber < 100 || courseNumber > 499) {
            System.out.println("Please enter a valid course number, 100-499: ");
            courseNumber = keyboard.nextInt();
            keyboard.nextLine();
        }
        this.courseNumber = courseNumber;
    }

    public void setCourseCredits(int courseCredits) {
        Scanner keyboard = new Scanner(System.in);
        while  ((courseCredits < 1 || courseCredits > 4)
                || (courseCredits == 2)
        ){
            System.out.println("Please enter a valid number of credits per course, 1, 3 or 4:");
            courseCredits = keyboard.nextInt();
            keyboard.nextLine();
        }
        this.courseCredits = courseCredits;
    }

    public void setCourseCost(double courseCost) {
        this.courseCost = courseCost;
    }

}