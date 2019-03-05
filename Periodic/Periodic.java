/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  09 Mar 2019
 Part 1: Develop an abstract class Periodic.java to hold information about elements of the periodic table.
 The class should have the variables: symbol, atomicNumber, and atomicWeight.
 The class should have a default constructor and a constructor that accepts arguments for all three variables.
 In addition the class should have the appropriate getters, setters, toString, and equals methods and an abstract method describeElement.

 @version 1.0: initial release
 */
public abstract class Periodic {
    //
// Instance variables
    private String symbol;
    private int atomicNumber;
    private double atomicWeight;

// Constructors
//
    public Periodic() {
        this.symbol = "unknown";
        this.atomicNumber = 0;
        this.atomicWeight = 0;
    }

    public Periodic(String symbol, int atomicNumber, double atomicWeight) {
        this.setSymbol(symbol);
        this.setAtomicNumber(atomicNumber);
        this.setAtomicWeight(atomicWeight);
    }
// Getter methods
//
    public String getSymbol() {
        return this.symbol;
    }

    public int getAtomicNumber() {
        return this.atomicNumber;
    }

    public double getAtomicWeight() {
        return this.atomicWeight;
    }

    public String toString() {
        String objectInfo;
        objectInfo =    "\nElement symbol: "
                        + this.getSymbol()
                        + "\nAtomic number:  "
                        + this.getAtomicNumber()
                        +  "\nAtomic weight:  "
                        + this.getAtomicWeight();
        return objectInfo;
    }

    public boolean equals(Periodic element) {
        return
                this.getSymbol() == element.getSymbol()
                        &&
                        this.getAtomicNumber() == element.getAtomicNumber()
                        &&
                        this.getAtomicWeight() == element.getAtomicWeight();
    }
    //
// Setter methods
//
    public void setSymbol(String symbolName) {
        this.symbol = symbolName;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public void setAtomicWeight(double atomicWeight) {
        this.atomicWeight = atomicWeight;
    }

    public abstract void describeElement();
}