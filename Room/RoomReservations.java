/**                                                       @version 2.0
   @author Kevin M. Mallgrave
           Professor Janet Brown-Sederberg
           CTIM-168 B02
   @since  15 Feb 2019
     
   Class RoomReservations 
   
   This is a driver program for Room.java class. It is intended to be
   user friendly. I have tried to avoid input exceptions, so it accepts
   input as strings and handles whitespace without throwing an exception.
   
   Version 1.0: initial release 
   Version 1.1: use setters to set instance variables for booleans
   Version 2.0: modularize bookRooms. Clean up main method body. Use bool value in main
                to drive loop instead of cluttering up main with a do-while loop.
 */
import java.util.Random;
import java.util.Scanner;
public class RoomReservations {
/**   void roomSort

    This method sorts two int arrays lowest to highest with a bubble sort algorithm.
    The second array is sorted by the first one. It is intended
    to be used with two associated arrays that must retain their array position.
    I am sure there is a better way to do this in the Oracle Java libs somewhere,
    or perhaps I could pick an algorithm that can sort 2D arrays, but this works.
  
   @param  capacity[]  First array input. This is the array that is used for the ascending bubble sort.
   @param  room[]      Second array input. This array is sorted in the same order as the first one.
 */
   private static void roomSort(int capacity[], int room[]) {
   int n = room.length;
   for (int i = 0; i < n - 1; i++) {
       for (int j = 0; j < n-i-1; j++) {
            if (capacity[j] > capacity[j+1]) {
                int temp1 = capacity[j];
                int temp2 = room[j];
                capacity[j] = capacity[j+1];
                room[j] = room[j+1];
                capacity[j+1] = temp1;
                room[j+1] = temp2;
            }
        }        
    }        
}
/**   void createRooms

   This method creates an array of room objects. It has some random features
   to drive the Room.java class.   

   @param arrayOfRooms[]   Amount of objects to create.
   @param randomRange      Range of int to give Random(). e.g. 30 = 1-30.
                           "+ 1" is added to the range for more "friendly" numbers.
   @param randomOffset     Adjust the random number range upwards of downwards.   
 */
   private static void createRooms(Room arrayOfRooms[], int randomRange, int randomOffset) {
   Random roomRandom = new Random();
   for (int i = 0; i < arrayOfRooms.length; i++) {
      arrayOfRooms[i] = new Room(i+1, (roomRandom.nextInt(randomRange + 1) + randomOffset),
      roomRandom.nextBoolean(), false);
      }
   }   
/**   void listOptions

   This is a simple screen printer method. It outputs messages to stdout, and takes a String
   param to determine what messages are printed. The goal was to tidy up the main program body.

   @param messageSwitch     Drives the case statement within the method.   
 */
   private static void listOptions(String messageSwitch) {
      Scanner keyboard = new Scanner(System.in);
      String blocker, notice="Press any key to continue.";
      switch (messageSwitch) {
      
      case "1":
         System.out.println("\n"+"All rooms listed above.");
         break;
      
      case "2":
         System.out.println("\n"+"All available rooms listed above.");
         break;
      case "3":
         System.out.println("\n"+"All available smart rooms listed above.");
        break;
      
      case "4":
         System.out.println("\n"+"All available non-smart rooms listed above.");
         break;
      
      case "5":
         System.out.println("\n"+"All available rooms listed above, sorted by capacity, lowest to highest.");
         break;
      
      case "6":
         System.out.println("\n"+"All available smart rooms listed above, sorted by capacity, lowest to highest.");
         break;
      
      case "7":
         System.out.println("\n"+"All available non-smart rooms listed above, sorted by capacity, lowest to highest.");
         break;
      
      case "8":
      case "9":
         break;
      
      case "":
      System.out.println("1. List all rooms");
      System.out.println("2. List all available rooms"); 
      System.out.println("3. List all available smart rooms"); 
      System.out.println("4. List all available non-smart rooms"); 
      System.out.println("5. List all available rooms sorted by capacity (low to high)");
      System.out.println("6. List all available smart rooms sorted by capacity (low to high)"); 
      System.out.println("7. List all available non-smart rooms sorted by capacity (low to high)"); 
      System.out.println("8. Reserve a room (set occupied to true)"); 
      System.out.println("9. Cancel a room reservation (set occupied to false)"); 
      System.out.println("0. Quit");
      default:   
      break;
      }
      if ((messageSwitch.matches("([1-9])") == true)) {
           System.out.println(notice);
           blocker = keyboard.nextLine();
      }
      } 
/**   boolean bookRooms

   The detail loop of the program. Returns a boolean value to drive the while loop in main.
   This method is a little ugly, I don't much care for the redundant for loop stacks,
   but this will do for now.   
 */      
      private static boolean bookRooms(Room[] reservations) {
         boolean quit = false;
         String menu, roomReserve = "";;
         Scanner keyboard = new Scanner(System.in);
         int[] arrayRoom = new int[reservations.length];
         int[] arrayCapacity = new int[reservations.length];
         listOptions("");
         menu = keyboard.nextLine();      
         
         switch (menu) {
               
         case "0": //0. Quit program, successfully
           quit = true;         
           break;
                
         case "1": //List all rooms            
            for (int i = 0; i < reservations.length; i++) {            
               arrayRoom[i] = reservations[i].getRoomNumber();
            }
            for (int i = 0; i < arrayRoom.length; i++) { 
               arrayCapacity[i] = (reservations[arrayRoom[i] -1].getCapacity());
            }
            for (int i = 0; i < arrayRoom.length; i++) {
               if (arrayRoom[i] != 0 || arrayCapacity[i] !=0) {
               System.out.println("Room: "+ arrayRoom[i] + " Capacity: " + arrayCapacity[i]);
               }
            }
            listOptions("1");             
            break;
               
         case "2": //List all available rooms      
            for (int i = 0; i < reservations.length; i++) {     
               if (reservations[i].getOccupied() == false) {         
               arrayRoom[i] = reservations[i].getRoomNumber();
               }
            }
            for (int i = 0; i < arrayRoom.length; i++) { 
               if (reservations[i].getOccupied() == false) {
               arrayCapacity[i] = (reservations[arrayRoom[i] -1].getCapacity());
               }
            }
            for (int i = 0; i < arrayRoom.length; i++) {
               if (arrayRoom[i] != 0 || arrayCapacity[i] !=0){
               System.out.println("Room: "+ arrayRoom[i] + " Capacity: " + arrayCapacity[i]);
               }
            } 
            listOptions("2");         
            break;
               
         case "3": //List all available smart rooms           
            for (int i = 0; i < reservations.length; i++) {     
            if (reservations[i].getSmart() == true && reservations[i].getOccupied() == false) {         
               arrayRoom[i] = reservations[i].getRoomNumber();
               }
            }
            for (int i = 0; i < arrayRoom.length; i++) { 
               if (reservations[i].getSmart() == true && reservations[i].getOccupied() == false) {
               arrayCapacity[i] = (reservations[arrayRoom[i] -1].getCapacity());
               }
            }
            for (int i = 0; i < arrayRoom.length; i++) {
               if (arrayRoom[i] != 0 || arrayCapacity[i] !=0){
               System.out.println("Room: "+ arrayRoom[i] + " Capacity: " + arrayCapacity[i]);
               }
            }  
            listOptions("3");         
            break;
         
         case "4": //List all available non-smart rooms      
            for (int i = 0; i < reservations.length; i++) {     
            if (reservations[i].getSmart() == false && reservations[i].getOccupied() == false) {         
               arrayRoom[i] = reservations[i].getRoomNumber();
               }
            }
            for (int i = 0; i < arrayRoom.length; i++) { 
               if (reservations[i].getSmart() == false && reservations[i].getOccupied() == false) {
               arrayCapacity[i] = (reservations[arrayRoom[i] -1].getCapacity());
               }
            }
            for (int i = 0; i < arrayRoom.length; i++) {
               if (arrayRoom[i] != 0 || arrayCapacity[i] !=0){
               System.out.println("Room: "+ arrayRoom[i] + " Capacity: " + arrayCapacity[i]);
               }
            }         
            listOptions("4");          
            break; 
              
         case "5": //List all available rooms sorted by capacity (low to high)
            for (int i = 0; i < reservations.length; i++) {     
               if (reservations[i].getOccupied() == false) {         
               arrayRoom[i] = reservations[i].getRoomNumber();
               }
            }
            for (int i = 0; i < arrayRoom.length; i++) { 
               if (reservations[i].getOccupied() == false) {
               arrayCapacity[i] = (reservations[arrayRoom[i] -1].getCapacity());
               }
            }
            for (int i = 0; i < arrayRoom.length; i++) {
            roomSort(arrayCapacity, arrayRoom);
               if (arrayRoom[i] != 0 || arrayCapacity[i] !=0){
               System.out.println("Room: "+ arrayRoom[i] + " Capacity: " + arrayCapacity[i]);
               }
            }
            listOptions("5");         
            break;      
         
         case "6": //6. List all available smart rooms sorted by capacity (low to high)      
            for (int i = 0; i < reservations.length; i++) {     
            if (reservations[i].getSmart() == true && reservations[i].getOccupied() == false) {         
               arrayRoom[i] = reservations[i].getRoomNumber();
               }
            }
            for (int i = 0; i < arrayRoom.length; i++) { 
               if (reservations[i].getSmart() == true && reservations[i].getOccupied() == false) {
               arrayCapacity[i] = (reservations[arrayRoom[i] -1].getCapacity());
               }
            }
            for (int i = 0; i < arrayRoom.length; i++) {
               roomSort(arrayCapacity, arrayRoom);
               if (arrayRoom[i] != 0 || arrayCapacity[i] !=0){
               System.out.println("Room: "+ arrayRoom[i] + " Capacity: " + arrayCapacity[i]);
               }
            }
            listOptions("6");          
            break;
         
         case "7": //7. List all available non-smart rooms sorted by capacity (low to high)"      
            for (int i = 0; i < reservations.length; i++) {     
               if (reservations[i].getSmart() == false && reservations[i].getOccupied() == false) {         
               arrayRoom[i] = reservations[i].getRoomNumber();
               }
            }
            for (int i = 0; i < arrayRoom.length; i++) { 
               if (reservations[i].getSmart() == false && reservations[i].getOccupied() == false) {
               arrayCapacity[i] = (reservations[arrayRoom[i] -1].getCapacity());
               }
            }
            for (int i = 0; i < arrayRoom.length; i++) { 
            roomSort(arrayCapacity, arrayRoom);
               if (arrayRoom[i] != 0 || arrayCapacity[i] !=0){
               System.out.println("Room: "+ arrayRoom[i] + " Capacity: " + arrayCapacity[i]);
               }
            }
            listOptions("7");            
            break;      
         
         case "8": //Reserve a room (set occupied to true)
            System.out.println("Please enter a room to reserve, 1-24.");
            roomReserve = keyboard.nextLine();
            while ((roomReserve.matches("([1-9]|1[0-9]|2[0-4])") == false) ||
                  ((roomReserve.trim().length() > 0)  == false)) {                
                  System.out.println("Invalid room entered. Please enter 1-24.");
                  roomReserve = keyboard.nextLine();        
                  }
            if (reservations[Integer.parseInt(roomReserve)-1].getOccupied() == true) {
               System.out.println("This room is already reserved. Please choose another room."+"\n");
            } else {
            System.out.println("You have reserved room "+roomReserve+".");
            reservations[Integer.parseInt(roomReserve)-1].setOccupied(true);
            listOptions("8");
            }         
            break; 
              
         case "9": //Cancel a room reservation (assign this.Room.setOccupied = false)
            System.out.println("Please enter a room to cancel. 1-24.");
            roomReserve = keyboard.nextLine();
            while ((roomReserve.matches("([1-9]|1[0-9]|2[0-4])") == false) ||
                  ((roomReserve.trim().length() > 0)  == false)) {                
                  System.out.println("Invalid room entered. Please enter 1-24.");
                  roomReserve = keyboard.nextLine();        
                  }
            if (reservations[Integer.parseInt(roomReserve)-1].getOccupied() == false) {
               System.out.println("This room is not reserved. Please choose another room."+"\n");
            } else {
            System.out.println("You have canceled the reservation on room "+roomReserve+".");
            reservations[Integer.parseInt(roomReserve)-1].setOccupied(false);
            listOptions("8");
            }      
            break;   
            
         default:       
           listOptions("oops");                     
         break;
         }
      return quit;
   }
/**
   Main method. Sets up some declarations, calls createRooms, and calls bookRooms while closedLoop is false.
   closedLoop will be set to true when the user chooses to quit in bookRooms.
 */
   public static void main(String[] args) {
      // Declarations
      boolean closedLoop = false;
      Room[] reservations = new Room[24];   
      createRooms(reservations, 30, 20);  
      //   Main loop
      while (closedLoop == false) {
          closedLoop = bookRooms(reservations); 
      }   
   }//end main
}//end class 
