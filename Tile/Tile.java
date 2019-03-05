/**                                                       @version 1.0
   @author Kevin M. Mallgrave
           Professor Janet Brown-Sederberg
           CTIM-168 B02
   @since  15 Feb 2019
     
   Class Tile
   
   This is a class that contains methods that define a Tile object.
   The Tile object can be used to play an arithmetic game.

   Version 1.0: initial release 
 */ 
public class Tile {

   private boolean placed;
   private int value; 
    
   public Tile() {
      placed = false;
      value = 0;  
   }  

   public Tile(boolean placedPassed, int valuePassed) {
      placed = placedPassed;
      value = valuePassed; 
   }
  
   public void setPlaced(boolean placedPassed) {
      placed = placedPassed;  
   }
  
   public void setValue(int valuePassed) {
      value = valuePassed;
   }

   public int getValue() {
       return value;
   }
  
   public boolean getPlaced() {
   return placed;
   }
  
   public String toString() {
       return (
         "\nPlaced: " + placed +
         "\nValue:  " + value
       );
   }
  
   public boolean equals(Tile tilePassed) {
      return (
         this.value == tilePassed.value &&
         this.placed == tilePassed.placed
      );
   }     

}