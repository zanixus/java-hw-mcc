/**                                                         @version 1.0
 *   @author Kevin M. Mallgrave
 *           Professor Janet Brown-Sederberg
 *           CTIM-157 B02
 *   @since  02 November 2018
 * 
 *   You have three identical prizes to give away and a pool of ten finalists. 
 *   The finalists are assigned numbers from 1 to 10. 
 *   Write a program to randomly select the numbers of three finalists to receive a prize. 
 *   Make sure not to pick the same number twice. For example, picking finalists 
 *   3, 6, 2 would be valid but picking 3, 3, 11 would be invalid because 
 *   finalist number 3 is listed twice and 11 is not a valid finalist number. 
 *
 *   Version 1.0: initial release
 */

import java.util.Random;
public class C4PP8_KMM

{
    public static void main(String[] args)
    {//do while stack, use OR boolean
    int winner1, winner2, winner3;
    winner1 = (int) (Math.random() * 10) +1;
    winner2 = (int) (Math.random() * 10) +1;
    winner3 = (int) (Math.random() * 10) +1;
    do
    {
    winner1 = (int) (Math.random() * 10) +1;
    }
    while ((winner1 == winner2)
    ||    (winner1 == winner3));
    do
    {
    winner2 = (int) (Math.random() * 10) +1;
    }
    while ((winner2 == winner3)
    ||    (winner2 == winner1));
    do
    {
    winner3 = (int) (Math.random() * 10) +1;
    }
    while ((winner3 == winner2)
    ||    (winner3 == winner1));
    System.out.printf("Numbers: %1d, %1d, %1d\n", winner1,winner2,winner3);
    System.out.printf("Finalist %1d wins!\n", winner1);
    System.out.printf("Finalist %1d wins!\n", winner2);
    System.out.printf("Finalist %1d wins!\n", winner3);
    }
}