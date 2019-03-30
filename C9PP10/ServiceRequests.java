/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  24 Mar 2019

 Class ServiceRequests

 ServiceRequests is an class that describes an ledger of service tickets. Each ticket has a linked name and number.
 ServiceRequests' size can be set when it is instanced. The default constructor size is 10, but any int will work.
 ServiceRequests' array size may be specified with the non-default constructor.
 ServiceRequest will throw a ServiceBackUpException if the arrays are full, and will throw a
 NoServiceRequestException if an invalid name is entered to remove from the arrays.

 @version 1.0: initial release
 */

public class ServiceRequests {

    // Instance variables
    private int[] number;
    private String[] name;

    // Constructors
//
    public ServiceRequests() {
        this.number = new int[100];
        this.name = new String[100];
        for (int i = 0; i < 100; i++) {
            this.name[i] = "";
            this.number[i] = 0;
        }
    }

    public ServiceRequests(int arraySize) {
        this.number = new int[arraySize];
        this.name = new String[arraySize];
        for (int i = 0; i < arraySize; i++) {
            this.name[i] = "";
            this.number[i] = 0;
        }
    }

    // Getter methods
    // getName(i)—returns the ith name in the list.
    public String getName(int i) {
        return this.name[i];
    }

    //getNumber—returns the current number of service requests.
    public int getNumber() {
        int reqCount = 0;
        for (int i = 0; i < number.length; i++) {
            if (this.number[i] > 0) {
                reqCount++;
            }
        }
        return reqCount;
    }

    public String toString() {
        String objectInfo;
        objectInfo = "Service request capacity:   " + this.number.length
                + "\nNumber of service requests: " + this.getNumber();
        return objectInfo;
    }

    public void setName(String name, int namePos) {
        this.name[namePos] = name;
    }

    public void setNumber(int number, int numberPos) {
        this.number[numberPos] = number;
    }

    //    //addName(name)—adds a name to the list of names.
    public void addName(String nameToAdd) throws ServiceBackUpException {
        boolean added = false;
        int attemptsToAdd = 0;
        for (int i = 0; i < name.length; i++) {
            if (added == false) {
                if (this.getName(i).equals("")) {
                    this.setName(nameToAdd, i);
                    this.setNumber(i+1, i);
                    added = true;
                } else {
                    attemptsToAdd++;
                    if (attemptsToAdd >= name.length) {
                        added = false;
                    }
                }
            }
        }
        if (added == false) {//throws ServiceBackUpException if there is no free space in the list.
            throw new ServiceBackUpException();
        }
    }

    //    //removeName(name)—removes a name from the list.
    public void removeName(String nameToRemove) throws NoServiceRequestException {
        boolean removed = false;
        int attemptsToRemove = 0;
        for (int i = 0; i < name.length; i++) {
            if (removed == false) {
                if (this.getName(i).equals(nameToRemove)) {
                    this.setName("", i);
                    this.setNumber(0, i);
                    removed = true;
                } else {
                    attemptsToRemove++;
                    if (attemptsToRemove >= name.length) {
                        removed = false;
                    }
                }
            }
        }
        if (removed == false) {//throws NoServiceRequestException if the name is not in the list.
            throw new NoServiceRequestException();
        }
    }
}
