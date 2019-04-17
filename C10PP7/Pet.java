/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  24 Feb 2019

 Revise the class Pet, as shown in Listing 6.1 of Chapter 6, so that it is serializable.
 Write a program that allows you to write and read objects of type Pet to a file.
 The program should ask the user whether to write to a file or read from a file.
 In either case, the program next asks for the file name. A user who has asked to write to a
 file can enter as many records as desired. A user who has asked to read from a file is shown
 all of the records in the file. Be sure that the records do not scroll by so quickly that the
 user cannot read them.

 @version 1.0: initial release
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
public class Pet {
    //
// Instance variables
//
    private String name;
    private double weight;
    private int age;
    //
// Constructors
//
    public Pet() {
        this.name = "unnamed";
        this.weight = 0;
        this.age = 0;
    }

    public Pet(String name, double weight, int age) {
        if ((age < 0) || (weight < 0)) {
            System.out.printf("Error: Negative age or weight.");
            System.exit(0);
        } else {
            this.setName(name);
            this.setWeight(weight);
            this.setAge(age);
        }
    }
    //
// Getter methods
//
    public String getName() {
        return this.name;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return
                "\nPet name:       " + this.getName()+
                        "\nPet weight:     " + this.getWeight() +
                        "\nPet age:        " + this.getAge();
    }

    public boolean equals(Pet petObject) {
        return
                this.getName() == petObject.getName()
                        &&
                        this.getWeight() == petObject.getWeight()
                        &&
                        this.getAge() == petObject.getAge();
    }
    //
// Setter methods
//
    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        Scanner keyboard = new Scanner(System.in);
        while  (weight < 0.0) {
            System.out.println
                    ("Please enter a valid weight, 0 or higher: ");
            weight = keyboard.nextDouble(); keyboard.nextLine();
        }
        this.weight = weight;
    }

    public void setAge(int age) {
        Scanner keyboard = new Scanner(System.in);
        while  (age < 0) {
            System.out.println
                    ("Please enter a valid age, 0 or higher: ");
            age = keyboard.nextInt(); keyboard.nextLine();
        }
        this.age = age;
    }

    public void writeOutput() {
        System.out.println("Name: " + this.getName());
        System.out.println("Age: " + this.getAge());
        System.out.println("Weight: " + this.getWeight());
    }

    public void writeToFile() {
        System.out.println("Name: " + this.getName());
        System.out.println("Age: " + this.getAge());
        System.out.println("Weight: " + this.getWeight());
    }

    //returns an array of String, each String is equal to each line in a plaintext file
//    public String[] readFile(String fileDotTxt, int fileLines) {
//        String fileName = fileDotTxt;
//        String[] arrayOfLines = new String[fileLines];
//        Scanner inputStream = null;
//        int counter = 0;
//        try {
//            inputStream = new Scanner(new File(fileName));
//        } catch(FileNotFoundException e) {
//            System.out.println("Error opening the file " + fileName);
//            System.out.println("Please check your file name and working directory and run the program again.");
//            System.exit(0);
//        }
//        while (inputStream.hasNextLine()) {
//            arrayOfLines[counter] = inputStream.nextLine();
//            counter++;
//        }
//        inputStream.close();
//        return arrayOfLines;
//    }
//
//    public void writeFile(String fileToWrite, String[] arrayInput) {
//        String lsbLine = "";
//        PrintWriter outputStream = null;
//        try {
//            outputStream = new PrintWriter(new FileOutputStream(fileToWrite, true));
//        } catch(FileNotFoundException e)  {
//            System.out.println("Error opening the file " + fileToWrite);
//            System.out.println("Please check your file name and working directory and run the program again.");
//            System.exit(0);
//        }
//        for (int i = 0; i < arrayInput.length; i++) {
//        }
//        outputStream.close();
//    }

//    public void readFromFile() {
//        System.out.println("Name: " + this.getName());
//        System.out.println("Age: " + this.getAge());
//        System.out.println("Weight: " + this.getWeight());
//    }

}