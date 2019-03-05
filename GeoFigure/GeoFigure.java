/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  09 Mar 2019

 Part 1: Develop the abstract class (GeoFigure.java) which will
 have the following variables: height, width, figureType and area.
 The class should have the appropriate constructors, getters, setters,
 toSting and equals methods and an abstract method named area which will
 calculate the area of the figure.

 This class has a default constructor but it really doesn't need one. "Cargo cult coding"?

 @version 1.0: initial release
 */
public abstract class GeoFigure {
    //
// Instance variables
    private int width;
    private int height;
    private int area;
    private String figureType;

// Constructors
//
    public GeoFigure() {
        this.width = 0;
        this.height = 0;
        this.area = 0;
        this.figureType = "none";
    }
// Getter methods
//
    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getArea() {
        return this.area;
    }

    public String getFigureType() {
        return this.figureType;
    }

    public String toString() {
        String objectInfo;
        objectInfo =    "\nFigure type: "
                        + this.getFigureType()
                        + "\nWidth:       "
                        + this.getWidth()
                        + "\nHeight:      "
                        + this.getHeight()
                        +  "\nArea:        "
                        + this.getArea();
        return objectInfo;
    }

    public boolean equals(GeoFigure figure) {
        return
                this.getArea() == figure.getArea()
                && this.getHeight() == figure.getHeight()
                && this.getWidth() == figure.getWidth()
                && this.getFigureType() == figure.getFigureType();
    }
    //
// Setter methods
//
    public void setWidth(int b) {
        this.width = b;
    }

    public void setHeight(int h) {
        this.height = h;
    }

    public void setArea(int a) {
        this.area = a;
    }

    public void setFigureType(String figure) {
        this.figureType = figure;
    }

    public abstract int area(int b, int h);


}