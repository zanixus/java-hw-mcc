/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  09 Mar 2019

 Part 3: Develop two classes (Square.java and Triangle.java) which extend the class GeoFigure.java
 , implement the interface SidedObject.java and contain methods area (see Part 1).

 @version 1.0: initial release
 */
public class Square extends GeoFigure implements SidedObject {

    public Square() {
        super();
        this.setFigureType("Triangle");
    }

    public Square(int b) {
        this.setWidth(b);
        this.setHeight(b);
        this.setArea(area(b,b));
        this.setFigureType("Square");
    }

    public int area(int b, int h) {
        return b * h;
    }

    public void displaySides() {
        System.out.printf("Sides:       4\n");
    }

}