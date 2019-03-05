public class HouseTest 
{

public static void main(String[] args) {
   House house0 = new House();
   House house1 = new House();
   House house2 = new House();
   house1.setCost(120000);
   house1.setLotSize(2600);
   house1.setSquareFeet(1000);
   house1.setBedrooms(2);
   house1.setBathrooms(1);
   house1.setBedrooms(2);
   house1.setAddress("2601 Almond St., Philadelphia, PA, 19134");
   //these work just fine, but I chose to format them and put them in my
   //toString() method, so I get a tidy dollar signed string value
   //for my output rather than an ugly int without a decimal place
   //to represent "USD"
   //System.out.println(house1.costPerSqFt(house1.getCost(),house1.getSquareFeet()));
   //System.out.println(costPerSqFt(88000, 1458));
   System.out.println(house1.toString());
   System.out.println(house0.equals(house1));
   System.out.println(house0.equals(house2));
   }//end main 
}