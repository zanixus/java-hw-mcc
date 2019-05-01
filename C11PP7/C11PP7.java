/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  29 Apr 2019

    Quick string array printer recursion demo. stringSort recursively calls itself to print every
    combination of chars in a 2D array of String.

 @version 1.0: initial release
 */

public class C11PP7 {

    private static void stringSort(String[][] data, String inputString, int row, int col) {
        String outputString = inputString + data[row][col];
        if (row == data.length - 1) {
            System.out.println(outputString);
        }
        if (row < data.length - 1) {
            stringSort(data, outputString, row + 1, 0);
        }
        if (col < data[row].length - 1) {
            stringSort(data, inputString, row, col + 1);
        }
    }

    public static void main (String [] args) {
        String[][] inputOne = {
                {"A", "B"},
                {"1", "2"},
                {"XX","YY","ZZ"}
        };
        String[][] inputTwo = {
                {"A"},
                {"1"},
                {"2"},
                {"XX","YY"}
        };
        System.out.println("Test case 1");
        stringSort(inputOne, "",0, 0);
        System.out.println("Test case 2");
        stringSort(inputTwo, "",0, 0);
    }
}