/**                                                       @version 1.0
   @author Kevin M. Mallgrave
           Professor Janet Brown-Sederberg
           CTIM-157 B02
   @since  13 December 2018
   
   Java house object methods   
   
   version 0.9: most methods done, try K&R/"1TBS" indent/brace style
   version 1.0: initial release
   
 */
import java.util.Scanner;
public class House {
//instance variables
   private String address;//Street, Town, State, zip (as a single String)
   private int squareFeet;
   private int cost;
   private int lotSize; //in square feet
   private int bedrooms;
   private int bathrooms;

   public House() { //default constructor
      this.address = "unknown";
      this.squareFeet = 0;
      this.cost = 0;
      this.lotSize = 0;
      this.bedrooms = 0;     
      this.bathrooms = 0;
   }
   
   public House(String addressPassed, int squareFeetPassed, 
      int costPassed, int lotSizePassed, int bedroomPassed, int bathroomsPassed) {
      //NON-DEFAULT constructor - use with PUBLIC method, takes args
      this.setAddress(addressPassed);
      this.setLotSize(lotSizePassed);
      this.setSquareFeet(squareFeetPassed);
      this.setCost(costPassed);
      this.setBedrooms(bedroomPassed);
      this.setBathrooms(bathroomsPassed);
   }

   //getter methods: RETURNS info about object

public String getAddress() {
   //keyword this returns OWN OBJECT info
   //"whatever object called me(this.Dog), return values for me(this.Dog)
      return this.address;
   }//end method
   
public int getCost() {
      return this.cost;
   }//end method

public int getLotSize() {
      return this.lotSize;
   }//end method
 
public int getSquareFeet() {
      return this.squareFeet;
   }//end method
   
public int getBedrooms() {
      return this.bedrooms;
   }//end method
   
public int getBathrooms() {
      return this.bathrooms;
   }//end method
   
   //setter methods: SET info about object
public void setAddress(String addressPassed) {
      Scanner keyboard = new Scanner(System.in);
      //we don't need to check for default value "unknown",
      //but we are doing this for the rest of the methods,
      //so we may as well follow the format
      while  (addressPassed.equals("unknown")) {
      System.out.println
      ("Please enter the address of the home.\n");
      addressPassed = keyboard.nextLine();                     
      } 
      this.address = addressPassed;
   }//end method
   
public void setCost(int costPassed) {
      //     cost //must be >= 0
      Scanner keyboard = new Scanner(System.in);
      while  (costPassed <=0) {
      System.out.println
      ("Please enter the cost of the home, must be >= 0:\n");
      costPassed = keyboard.nextInt(); keyboard.nextLine();                     
      } 
      this.cost = costPassed;
   }//end method

   public void setLotSize(int lotSizePassed) {
      //     lotSize //must be > 0
      Scanner keyboard = new Scanner(System.in);
      while  (lotSizePassed <=0) {
         System.out.println
         ("Please enter the lot size of the property, must be >= 0:\n");
         lotSizePassed = keyboard.nextInt(); keyboard.nextLine();                     
      } 
      this.lotSize =  lotSizePassed;
   }//end method
   
   public void setSquareFeet(int squareFeetPassed) {
      // squareFeet //must be > 0
      Scanner keyboard = new Scanner(System.in);
      while  (squareFeetPassed <=0) {
      System.out.println
      ("Please enter the size of the home in square feet, must be >= 0:\n");
      squareFeetPassed = keyboard.nextInt(); keyboard.nextLine();                     
      } 
      this.squareFeet =  squareFeetPassed;
   }//end method
   
   public void setBedrooms(int bedroomPassed) {
      //     bedrooms //must be > 0
      Scanner keyboard = new Scanner(System.in);
      while  (bedroomPassed <=0) {
      System.out.println
      ("Please enter the amount of bedrooms, must be >= 0:\n");
      bedroomPassed = keyboard.nextInt(); keyboard.nextLine();                     
      } 
      this.bedrooms = bedroomPassed;
      }//end method
   
   public void setBathrooms(int bathroomsPassed) {
      //     bathrooms //must be > 0
      Scanner keyboard = new Scanner(System.in); 
      while  (bathroomsPassed <=0) {
         System.out.println
         ("Please enter the amount of bathrooms, must be >= 0:\n");
         bathroomsPassed = keyboard.nextInt(); keyboard.nextLine(); 
      } 
      this.bathrooms = bathroomsPassed;
      }//end method
    
   public String toString() {
      // 4. A method (name the method toString) 
      // that will return a String of the 6 instance variables and appropriate associated strings.
      DecimalFormat usDollars = new DecimalFormat ("$#,##0.00");
      return 
      "\nAddress:        " + this.getAddress()+   
      "\nCost(int):      " + this.getCost() +
      "\nSquare feet:    " + this.getSquareFeet()+
      "\nLot size:       " + this.getLotSize()+
      "\nBedrooms:       " + this.getBedrooms()+
      "\nBathrooms:      " + this.getBathrooms()+
      "\nCost(USD):      " + usDollars.format(this.getCost())+
      "\nCost per sq ft: " + usDollars.format(this.costPerSqFt(this.getCost(),this.getSquareFeet()));
      }//end method 

   public boolean equals(House housePassed) {
      return 
      this.getAddress().equals(housePassed.getAddress())
      &&
      this.getCost() == housePassed.getCost()
      &&
      this.getLotSize() == housePassed.getLotSize()
      &&
      this.getSquareFeet() == housePassed.getSquareFeet()
      &&
      this.getBedrooms() == housePassed.getBedrooms()
      &&
      this.getBathrooms() == housePassed.getBathrooms();   
      }//end method

   public int costPerSqFt(int costPassed, int sqFtPassed) {
      // 3. A method that will calculate and return the cost per square foot of the house.  
      return costPassed / sqFtPassed;
      }//end method   
   
   public static void main(String[] args) {
      House house0 = new House();
      House house1 = new House();
      House house2 = new House();
      House house3 = new House();
      house3.setAddress("unknown");
      house3.setCost(-1);
      house3.setLotSize(-1);
      house3.setSquareFeet(-1);
      house3.setBedrooms(-1);
      house3.setBathrooms(-1);
      System.out.println(house3.toString()); 
      //yes this hideous line of java code below is valid and works
      //System.out.println(house3.costPerSqFormatter(house3.costPerSqFt(house3.getCost(),house3.getSquareFeet())));      
      house1.setCost(120000);
      house1.setLotSize(2600);
      house1.setSquareFeet(1000);
      house1.setBedrooms(2);
      house1.setBathrooms(1);
      house1.setBedrooms(2);
      house1.setAddress("2601 Almond St., Philadelphia, PA, 19134");
      System.out.println(house1.toString()); 
      System.out.println(house0.equals(house1));
      System.out.println(house1.equals(house3));
      }//end main    
   
}//end class