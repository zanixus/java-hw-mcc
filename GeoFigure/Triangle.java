/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  09 Mar 2019

 Part 3: Develop two classes (Square.java and Triangle.java) which extend the class GeoFigure.java
 , implement the interface SidedObject.java and contain methods area (see Part 1).

 @version 1.0: initial release
 */
public class Triangle extends GeoFigure implements SidedObject {

    public Triangle() {
        super();
        this.setFigureType("Triangle");
    }

    public Triangle(int b, int h) {
        this.setWidth(b);
        this.setHeight(h);
        this.setArea(area(b,h));
        this.setFigureType("Triangle");
    }

    public int area(int b, int h) {
        return (b * h) / 2;
    }

    public void displaySides() {
        System.out.printf("Sides:       3\n");
    }

}