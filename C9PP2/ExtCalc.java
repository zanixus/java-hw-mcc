/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  24 Mar 2019

 Class C9PP1

 This is a Java program that converts a 24 hour time string to a 12 hour time.
 All user input is taken in as a string with the method getInput.
 The method convertTime uses String class methods for sanity checks on
 input(length, matches with regex) and if it fails the sanity checks,
 a TimeFormatException is thrown. main then handles this exception
 and asks the user to enter a valid string if an exception is caught.
 This class requires TimeFormatException.java.

 @version 1.0: initial release
 */
import java.util.Scanner;
public class C9PP2 extends Calculator {

    private double result;
    private double precision = 0.0001;
    private double memory;

    public static void main(String[] args) throws DivideByZeroException, UnknownOpException {
        ExtCalc clerk = new ExtCalc();
        System.out.println("Calculator is on.");
        clerk.helpMsg();
        clerk.doCalculation();
        System.out.println("The final result is " + clerk.getResult());
        System.out.println("Calculator program ending.");
    }

    public ExtCalc() {
        super();
        this.memory = 0;
    }

    public void setMem(double mem) {
        this.memory = mem;
        System.out.println("result saved in memory");
    }

    public double getMem() {
        System.out.println("recalled memory value = " + this.memory);
        return this.memory;
    }

    public static void helpMsg() {
        System.out.print("Format of each line: ");
        System.out.println("operator space number");
        System.out.println("For example: + 3");
        System.out.println("To end, enter the letter e.");
        System.out.println("To save to memory, enter the letter m.");
        System.out.println("To recall saved memory, enter the letter r.");
    }

    public void doCalculation() throws DivideByZeroException, UnknownOpException {
        Scanner keyboard = new Scanner(System.in);
        boolean done = false;
        result = 0;
        System.out.println("result = " + result);
        while (!done) {
            char nextOp = (keyboard.next()).charAt(0);
            if ((nextOp == 'e') || (nextOp == 'E')) done = true;
            else if ((nextOp == 'm') || (nextOp == 'M')) setMem(result);
            else if ((nextOp == 'r') || (nextOp == 'r')) getMem();
            else {
                double nextNumber = keyboard.nextDouble();
                try {
                    result = evaluate(nextOp, result, nextNumber);
                    System.out.println("result " + nextOp + " " + nextNumber + " = " + result);
                    System.out.println("updated result = " + result);
                } catch (DivideByZeroException e) {
                    System.out.println("Error: Divide by zero is undefined. Value unchanged.");
                    helpMsg();
                } catch (UnknownOpException e) {
                    System.out.println("Error: unknown operator. Please enter +, -, * or /.Value unchanged.");
                    helpMsg();
                }
            }
        }
    }
}