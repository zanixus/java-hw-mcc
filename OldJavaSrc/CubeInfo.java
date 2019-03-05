// This is a sample Java program to create a cube
// I have implemented this program from pseudocode I
// planned out in CTIM281 Chapter 1, Assignment 2, Question 4
// I've added my pseudocode step by step to line
// up with the actual Java arguments
//
import java.util.Scanner;
public class CubeInfo
{
public static void main(String[] args)
	// Main refers to the curly brace contents
	{												//1 start
		int myLine;									//2 input myLine
		System.out.println("Enter edge line size>> ");
		Scanner keyboard = new Scanner(System.in);	//
		// this prepares Scanner for KB input		//
		myLine = keyboard.nextInt();;	//
		int mySquare = myLine * myLine;		// 3 mySquare = myLine * myLine
		int myVolume = myLine * mySquare;	// 4 myVolume = myLine * mySquare
		int myArea   = 6      * mySquare;	// 5 myArea   = 6      * mySquare
		System.out.println("Cube square face");	//   6 output mySquare,
		System.out.println(mySquare);		//
		System.out.println("Cube volume");	//        output myVolume,
		System.out.println(myVolume);		//
		System.out.println("Cube area");	//        output myArea,
		System.out.println(myArea);			//
		System.out.println("Cube edge size");//       output myLine,
		System.out.println(myLine);			//
	}										//        7 stop
}
