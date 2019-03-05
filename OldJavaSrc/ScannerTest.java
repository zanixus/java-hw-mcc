import java.util.Scanner;
import java.text.DecimalFormat;
public class ScannerTest
{
    public static void main(String[] args)
   {
    Scanner keyboard    = new Scanner(System.in);
    String firstName, lastName, streetName, cityTown, state;
    int houseNumber, zipCode, age;
    char middleInitial; 
    boolean opinion;  
    System.out.println("Enter your first name");
    firstName = keyboard.nextLine();
    System.out.println("Enter your middle initial");
    middleInitial = keyboard.next().charAt(0);
    keyboard.nextLine();                     //flush cache after grabbing char
     System.out.println("Enter your last name");
    lastName = keyboard.nextLine();
    System.out.println("Enter your address number");
    houseNumber = keyboard.nextInt();
    keyboard.nextLine();                     //flush cache after grabbing int
    System.out.println("Enter your street");
    streetName = keyboard.nextLine();
    System.out.println("Enter your city/town");
    cityTown = keyboard.nextLine();
    System.out.println("Enter your state");
    state = keyboard.nextLine();
    System.out.println("Enter your zip code");
    zipCode = keyboard.nextInt();
    keyboard.nextLine();
    System.out.println("Enter your age");
    age = keyboard.nextInt();
    System.out.println("True or false");
    opinion = keyboard.nextBoolean();
    //keyboard.nextInt();
    System.out.println("First Name:        " +firstName+" "+middleInitial+ " "+lastName);
    System.out.println("Address:           " +houseNumber+" "+streetName);
    System.out.println("City, State:       " +cityTown+", "+state+" "+zipCode);
    System.out.println("Age :              " +age);
    System.out.println("Opinion:           "+opinion);
    }
}