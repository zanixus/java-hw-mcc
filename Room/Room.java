/**                                                       @version 1.0
   @author Kevin M. Mallgrave
           Professor Janet Brown-Sederberg
           CTIM-168 B02
   @since  15 Feb 2019
     
   Class Room

   This class implements a Room object intended to represent a hotel room.
   Please see RoomReservations.java for a driver program.
   
   NOTE: Instance variable "capacity" cannot have a value of greater than 24
   or less than 1. Though the RoomReservation driver program will never call
   this as the rooms are hardcoded, it will prompt you to enter a value if needed.
   
   RoomReservation.java should NEVER have to call capacity and roomNumber 
   input methods AFTER the hardcoded room initialzation loop, but they are included 
   as a failsafe if a user somehow finds a way to do so.
   
   Version 1.0: initial release 
 */
import java.util.Scanner;
public class Room {
//
// Instance variables
//
   private int roomNumber;
   private int capacity;
   private boolean smart;
   private boolean occupied;   
//
// Constructors
// 
   public Room() { //default constructor
      this.roomNumber = 0;
      this.capacity = 0;
      this.smart = false;
      this.occupied = false;
   }

   public Room(int roomNumberPassed, int capacityPassed, boolean smartPassed, 
      boolean occupiedPassed) {
      //NON-DEFAULT constructor - use with PUBLIC method, takes args
      this.setRoomNumber(roomNumberPassed);
      this.setCapacity(capacityPassed);
      this.setSmart(smartPassed);
      this.setOccupied(occupiedPassed);
   }
//
// Getter methods
//
   public int getRoomNumber() {
      return this.roomNumber;
   }//end method
   
   public int getCapacity() {
      return this.capacity;
   }//end method
 
   public boolean getSmart() {
      return this.smart;
   }//end method
   
   public boolean getOccupied() {
      return this.occupied;
   }//end method
   
   public String toString() {
      return 
      "\nRoom Number:      " + this.getRoomNumber()+   
      "\nRoom Capacity:    " + this.getCapacity() +
      "\nRoom is Smart:    " + this.getSmart()+
      "\nRoom is Occupied: " + this.getOccupied();
   }//end method 

   public boolean equals(Room roomPassed) {
      return
      this.getRoomNumber() == roomPassed.getRoomNumber()
      &&
      this.getCapacity() == roomPassed.getCapacity()
      &&
      this.getSmart() == roomPassed.getSmart()
      &&
      this.getOccupied() == roomPassed.getOccupied();  
   }//end method
//
// Setter methods
//   
   public void setRoomNumber(int roomPassed) {
      // setter method for room number should validate the room number passed to the 
      // method as 1 - 24 (inclusive) if an invalid value is passed trap the user in 
      // a while loop until a valid value is entered
      Scanner keyboard = new Scanner(System.in);
      while  (roomPassed < 1 || roomPassed > 24) {
         System.out.println
         ("Please enter the room number, 1 to 24:\n");
         roomPassed = keyboard.nextInt(); keyboard.nextLine();                   
      } 
      this.roomNumber = roomPassed;
   }//end method

   public void setCapacity(int capacityPassed) {
      Scanner keyboard = new Scanner(System.in);
      while  (capacityPassed < 20 || capacityPassed > 50) {
        System.out.println
        ("Please enter the capacity of of the room, 20-50 people: ");
        capacityPassed = keyboard.nextInt(); keyboard.nextLine();
      }
      this.capacity = capacityPassed;
   }

   public void setSmart(boolean smartPassed) {
      this.smart = smartPassed;
   }

   public void setOccupied(boolean occupiedPassed) {
      this.occupied = occupiedPassed;
   }
}//end class
