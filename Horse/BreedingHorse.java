/**
   @author Kevin M. Mallgrave
           Professor Janet Brown-Sederberg
           CTIM-168 W01
   @since  24 Feb 2019
   
   Class BreedingHorse
   This class extends Horse. It requires two Horse class objects to call, and will create
   a new BreedingHorse that inherits variables from its parent Horse objects.
   
   If you create an instance of BreedingHorse without parent Horse objects, the BreedingHorse()
   method will create two new default Horse objects to be a parent for the new mystery horse. 
    
   @version 1.0: initial release 
 */
import java.util.Random;
import java.util.Scanner;
public class BreedingHorse extends Horse {
//
// Instance variables
//
private Horse mother;   
private Horse father; 
//
// Constructors
// 
   public BreedingHorse() {
      this.mother = new Horse();
      this.father = new Horse();
   }

   public BreedingHorse(String horseName, int horseBirthYear, Horse horseMother, Horse horseFather) {
      Random colorInherit = new Random();
      if (colorInherit.nextBoolean() == true) {
         this.setColor(horseMother.getColor());
      } else {//50/50 chance to inherit each parent's coat color. We are breeding a pedigree here after all
         this.setColor(horseFather.getColor());
      }//although if you don't like this you can always use setColor to make a genetically modifed horse
      this.setName(horseName);
      this.setMother(horseMother);
      this.setFather(horseFather);
      this.setBirthYear(horseBirthYear);
   }
   
   public BreedingHorse(String horseName, String horseColor, int horseBirthYear, Horse horseMother, Horse horseFather) {
      this.setColor(horseColor);//overloaded method constructor if you insist on setting a horses's color
      this.setName(horseName);
      this.setMother(horseMother);
      this.setFather(horseFather);
      this.setBirthYear(horseBirthYear);
   }   
//
// Getter methods
//
   public Horse getFather() {
      return this.father;
   }//end method
   
   public Horse getMother() {
      return this.mother;
   }//end method
   
   public String toString() {
      return
      super.toString() +
      "\nHorse mother:     " + this.mother.getName()+
      "\nHorse father      " + this.father.getName();
   }//end method 

   public boolean equals(BreedingHorse horseObject) {
      boolean isEqual = false;
      if ((horseObject != null) && (horseObject instanceof Horse)) {
         Horse horseInstance = (Horse)horseObject;
         isEqual = super.equals(horseInstance) &&
                   this.getMother() == horseObject.getMother() &&         
                   this.getFather() == horseObject.getFather();
      }
      return isEqual;
   }
//
// Setter methods
//   
   public void setMother(Horse horseMother) {
      this.mother = horseMother;
   }
   
    public void setFather(Horse horseFather) {
      this.father = horseFather;
   }   
}