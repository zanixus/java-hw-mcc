/** 
   @author Kevin M. Mallgrave
           Professor Janet Brown-Sederberg
           CTIM-168 W01
   @since  24 Feb 2019
   
   Class Horse
   This is a Horse object class. It is not an abstract class and can be called as-is.
   It can be called with the required instance variables to create Horse objects.
   Birth years less than 1988 and greater than 2018 are not allowed.
   @version 1.0: initial release
 */
import java.util.Scanner;
public class Horse {
//
// Instance variables
//
   private String name;
   private String color;
   private int birthYear;   
//
// Constructors
// 
   public Horse() {
      this.name = "unnamed";
      this.color = "unknown";
      this.birthYear = 1988;
   }

   public Horse(String horseName, String horseColor, int horseBirthYear) {
      this.setName(horseName);
      this.setColor(horseColor);
      this.setBirthYear(horseBirthYear);
   }
//
// Getter methods
//
   public String getName() {
      return this.name;
   }
   
   public String getColor() {
      return this.color;
   }
 
   public int getBirthYear() {
      return this.birthYear;
   }
   
   public String toString() {
      return 
      "\nHorse name:       " + this.getName()+   
      "\nHorse color:      " + this.getColor() +
      "\nHorse birth year: " + this.getBirthYear();
   }

   public boolean equals(Horse horseObject) {
      return
      this.getName() == horseObject.getName()
      &&
      this.getColor() == horseObject.getColor()
      &&
      this.getBirthYear() == horseObject.getBirthYear();
   }
//
// Setter methods
//   
   public void setName(String horseName) {
      Scanner keyboard = new Scanner(System.in);
      this.name = horseName;
   }

   public void setColor(String horseColor) {
      Scanner keyboard = new Scanner(System.in);
      this.color = horseColor;
   }

   public void setBirthYear(int horseBirthYear) {
      Scanner keyboard = new Scanner(System.in);
      while  (horseBirthYear < 1988 || horseBirthYear > 2018) {
        System.out.println
        ("Please enter a valid birth year, 1988-2018: ");
        horseBirthYear = keyboard.nextInt(); keyboard.nextLine();
      }
      this.birthYear = horseBirthYear;
   }    
}