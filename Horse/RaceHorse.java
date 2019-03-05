/**                                                       @version 1.0
   @author Kevin M. Mallgrave
           Professor Janet Brown-Sederberg
           CTIM-168 B02
   @since  5 Mar 2019
   

Part 2. Develop a class RaceHorse.java which is a child of the class Horse.java. The class should have the private variables: 
races, and wins. The class should have a default constructor and a non-default constructor which accepts values for races, and wins
. You should have the appropriate getters and setters. The setter method for races should not accept a value < 0 (it will trap the 
user until a valid amount is entered by the user). The setter method for wins should not accept a value < 0 or greater than the numbe
r of races (it will trap the user until a valid amount is entered by the user). The class should have a toString and an equals method.

 */
import java.util.Scanner;
public class RaceHorse extends Horse {
//
// Instance variables
//
   private int races;   
   private int wins; 
//
// Constructors
// 
   public RaceHorse() {
       super();
      this.races = 0;
      this.wins = 0;
   }

    public RaceHorse(String horseName, String horseColor, int
            horseBirthYear, int horseRaces, int horseWins) {
        this.setName(horseName);
        this.setColor(horseColor);
        this.setBirthYear(horseBirthYear);
        this.setWins(horseWins);
        this.setRaces(horseRaces);
   }
//
// Getter methods
//
   public int getRaces() {
      return this.races;
   }
   
   public int getWins() {
      return this.wins;
   }
   
   public String toString() {
      return
      super.toString() +
      "\nHorse race wins:  " + this.getWins()+ 
      "\nHorse race total: " + this.getRaces();
   }

   public boolean equals(RaceHorse horseObject) {
      boolean isEqual = false;
      if ((horseObject != null) && (horseObject instanceof Horse)) {
         Horse horseInstance = (Horse)horseObject;
         isEqual = super.equals(horseInstance) &&
                   this.getWins() == horseObject.getWins() &&         
                   this.getRaces() == horseObject.getRaces();
      }
      return isEqual;
   }
   
   public void setRaces(int horseRaces) {
      Scanner keyboard = new Scanner(System.in);
      while  (horseRaces < 0) {
        System.out.println
        ("Please enter a valid amount of horse races, > 0:: ");
        horseRaces = keyboard.nextInt(); keyboard.nextLine();
      }
      this.races = horseRaces;
   }
   
    public void setWins(int horseWins) {
      Scanner keyboard = new Scanner(System.in);
      while  (horseWins < 0) {
        System.out.println
        ("Please enter a valid amount of racing wins, > 0: ");
        horseWins = keyboard.nextInt(); keyboard.nextLine();
      }
      this.wins = horseWins;
   }
}