/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  24 Mar 2019

 Class C9PP10

 Suppose that you are in charge of customer service for a certain business.
 As phone calls come in, the name of the caller is recorded and eventually
 a service representative returns the call and handles the request.
 Write a class ServiceRequests that keeps track of the names of callers.

 @version 1.0: initial release
 */
import java.util.Scanner;
public class C9PP10 {

    private static boolean checkTickets(ServiceRequests requests, int requestsLength) {
        Scanner keyboard = new Scanner(System.in);
        String name, menu, prompt;
        boolean quit = false;
        System.out.println("1. Add a service request");
        System.out.println("2. Remove a service request");
        System.out.println("3. Print all open service requests");
        System.out.println("0. Quit");
        menu = keyboard.nextLine();
        switch (menu) {

            case "0":
                quit = true;
                break;

            case "1":
                name="";
                System.out.printf("\n");
                while ((name.trim().length() > 0)  == false) {
                    System.out.printf("Ticket will be added. Please enter the customer's name.\n");
                    name = keyboard.nextLine();
                    try {
                        requests.addName(name);
                        System.out.printf("Customer %s added to support queue.\n", name);
                    } catch (ServiceBackUpException e) {
                        System.out.printf("\nNo free space in service request queue.\n");
                        System.out.printf("Please clear a support request and try again.\n\n");
                    }
                }
                break;

            case "2":
                name="";
                System.out.printf("\n");
                while ((name.trim().length() > 0)  == false) {
                    System.out.printf("Ticket will be removed. Please enter the customer's name.\n");
                    name = keyboard.nextLine();
                    try {
                        requests.removeName(name);
                        System.out.printf("Customer %s removed from support queue.\n", name);
                    } catch (NoServiceRequestException e) {
                        System.out.printf("\nName not in support request list.\n");
                        System.out.printf("Please enter a name in the request list.\n\n");
                    }
                }
                break;

            case "3":
                System.out.printf("\n");
                for (int i = 0; i < requestsLength; i++) {
                    System.out.printf("Ticket %d: %s\n", i+1, requests.getName(i));
                }
                System.out.printf("\n%s\n\n", requests.toString());
                break;

            default:
                break;
        }
        return quit;
    }

    public static void main (String [] args) {
        final int REQ_LENGTH = 10;
        ServiceRequests requests = new ServiceRequests(REQ_LENGTH);
        boolean hasQuit = false;
        while (hasQuit == false) {
            hasQuit = checkTickets(requests, REQ_LENGTH);
        }
    }
}