/**                                                       @version 1.0
   @author Kevin M. Mallgrave
           Professor Janet Brown-Sederberg
           CTIM-157 B02
   @since  4 December 2018
   
   Dog object demo
   
   
   
   constructor(the method that makes the dog)
   a constructor is the method that makes the
   thing you want to make. called with keyword 'new'(ie. Dog Fido = new.Dog())
   
   Each class needs a CONSTRUCTOR, at least a DEFAULT
   Constructor always public, non static, same name as class
   NON-DEFAULT needs DEFAULT
   instance variables should be private in general
   use getter and setter methods to set variables
   
   
   Version 1.0: initial release
   
 */

public class Dog
{
//instance variables
private String name; //name of instance. NOT name of dog
private String breed;
private int age;
   //private object variables need setter methods to alter
   //public object variables can be passed from external program
   
   //constructor must always be public. has NO return type, is non-static.
   //constructor is named the same as the class. default constructor one line below
   
   //Default constructor - use with PRIVATE method
public Dog()
   {
   name  = "Unknown";
   breed = "Unknown";
   age   = 0;
   }
   public Dog(String namePassed, String breedPassed, int agePassed)
      {//NON-DEFAULT constructor - use with PUBLIC method, takes args
      this.setName(namePassed);
      this.setBreed(breedPassed);
      this.setAge(agePassed);
      }

//getter method: accesses info about object
public String getName()
   {
   //keyword this returns OWN OBJECT info
   //"whatever object called me(this.Dog), return values for me(this.Dog)
   return this.name;
   }//end method
   
public String getBreed()
   {
   return this.breed;
   }//end method

public int getAge()
   {
   return this.age;
   }//end method
   
   //setter methods: SET info about object
public void setName(String namePassed)
   {
   //keyword this returns OWN OBJECT info
   //"whatever object called me(this.Dog), return values for me(this.Dog)
   this.name = namePassed;
   }//end method
   
public void setBreed(String breedPassed)
   {
   if ((breedPassed.equals("Pit Bull")
   || (breedPassed.equals("Pitbull")
   || (breedPassed.equals("Rottweiler")))))
   {
   System.out.println("Dog breed not allowed. Breed set to Chihuahua.");
   breedPassed = "Chihuahua";
   }
   this.breed = breedPassed;
   }//end method

public void setAge(int agePassed)
   {
   if (agePassed > 30 || agePassed < 0)
   {
   System.out.println("Dog age out of range, age set to 0.");
   agePassed = 0;
   }
   this.age = agePassed;
   }//end method
   
   public String toString()
   {//you can replace default java methods if you'd like
   return 
   "\nName: " + this.getName()+
   "\nBreed: " + this.getBreed()+
   "\nAge: " + this.getAge();
   }//end method   
   
   public boolean equals(Dog dogPassed)
   {//polymorphism:
   // depending on the object that calls the method:
   // changes what method runs
   return 
   //we're using equals method of String class(default java method)
   //to compare "this.dogName" to
   this.getName().equals(dogPassed.getName())//get back 2 strings,
   &&
   this.getBreed().equals(dogPassed.getBreed())
   &&
   this.getAge() == dogPassed.getAge();
   
   }//end method
   
   public void bark()
   {   
   System.out.printf("%s: Bark, bark.\n", this.getName());
   }//end method
   
   public void poop()
   {
   System.out.printf("%s the %s takes a shit on your lawn.\n", this.getName(), this.getBreed());
   }//end method
   
public static void main(String[] args)
   {
   //create new instance of class Dog()
   Dog d1 = new Dog();
   d1.setName("Jerry");
   d1.setBreed("Border Collie");
   d1.setAge(11);
   //System.out.println(d1.getName()+" "+d1.getBreed()+" "+ d1.getAge());
   Dog d2 = new Dog();
   d2.setName("George");
   d2.setBreed("Bull Terrier");
   d2.setAge(5);
   Dog d3 = new Dog();
   d3.setName("Kramer");
   d3.setBreed("Great Dane");
   d3.setAge(8);
   //non default constructor demo - pass args and use setter methods
   Dog d4 = new Dog("Elaine", "Miniature Collie", 7);
   Dog d5 = new Dog("Newman", "Bulldog", 7);
   Dog d6 = new Dog("Mr. Peterman", "Dalmatian", 11);
   d3.bark();
   d3.poop();
   d1.bark();
   d2.bark();
   d2.poop();
   d4.bark();
   System.out.println(d1.toString());
   //print object instance, get object address in memory. uses default Java method toString() 
   System.out.println(d3);
   
   System.out.println(d1.equals(d4));
   }//end main    

}//end class