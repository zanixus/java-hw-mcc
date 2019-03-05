public class Meth0ds
{
public static void main(String[] args)
{
String message = "Vote Early Vote Often";
String slogan = "Morning in America";
int number;
int a = 5, b = 8;
double numberDouble;

DemoMethods.printSomething();
MyMethods.printAnything("Vote Today");
MyMethods.printAnything(message);
MyMethods.printAnything(slogan);

number = MyMethods.addTwoInts(2, 4);
System.out.println(number);

number = MyMethods.addTwoInts(a, b);
System.out.println(number);

number = MyMethods.addTwoInts(a, 12);
System.out.println(number);

numberDouble = MyMethods.addTwoDoubles(1.5, 7.5);
System.out.println(numberDouble);

numberDouble = MyMethods.addTwoDoubles(1, 7);
System.out.println(numberDouble);

//System.out.println(sum); scope limit

}//end main

}//end class