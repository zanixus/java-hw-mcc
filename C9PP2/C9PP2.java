/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  24 Mar 2019

 Class C9PP2

    This class extends Calculator.java from Chapter 9 of the textbook.
    It handles thrown exceptions and will recover from bad operators and attempts to divide by zero.
    Copying and pasting code from the book gave me ugly formatting, I am not wild about this program.java

 @version 1.0: initial release
 */
import java.util.Scanner;
public class C9PP2 extends Calculator {

    private double result;
    private double precision = 0.0001;
    private double memory;

    public static void main(String[] args) throws DivideByZeroException, UnknownOpException {
        C9PP2 clerk = new C9PP2();
        System.out.println("Calculator is on.");
        clerk.helpMsg();
        clerk.doCalculation();
        System.out.println("The final result is " + clerk.getResult());
        System.out.println("Calculator program ending.");
    }

    public C9PP2() {
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