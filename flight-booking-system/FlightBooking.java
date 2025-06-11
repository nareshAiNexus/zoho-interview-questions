import java.util.*;

public class FlightBooking {
  public static void main(String[] args) {
    
    FlightReservation system = new FlightReservation();
    Scanner scan = new Scanner(System.in);

    while (true) { 
      System.out.println("\n1. Booking Ticket ");
      System.out.println("2. Cancel Ticket ");   
      System.out.println("3. Display flight Details");   
      System.out.println("4. Exit\n");

      System.out.print("Enter your choice : ");
      int choice = scan.nextInt();
      scan.nextLine();
      
      switch (choice) {
        // Case 1
        case 1 -> {
          System.out.print("Enter FLight Name (Indigo / SpiceJet) : ");
          String flightName = scan.nextLine();
          System.out.println("FlightName : " + flightName);

          if(system.flights.containsKey(flightName)){
            system.displayFlightDetails(flightName);

            System.out.print("Enter your Name : ");
            String name = scan.nextLine();

            System.out.print("Enter your age : ");
            int age = scan.nextInt();

            System.out.print("Enter No of seats : ");
            int seats = scan.nextInt();

            String bookingId = system.bookTicket(flightName, name, age, seats);
            
            if(bookingId != null){
              System.out.println("Booking was succesful -> Booking ID : " + bookingId);
            }
          }
          else{
            System.out.println("Invalid flight name, Please Try again.");
          }
        }
        // CASE 2
        case 2 -> {
          System.out.print("Enter the flight Name : ");
          String cancelFlightName = scan.nextLine();

          System.out.print("Enter your Booking Id : ");
          String cancelId = scan.nextLine();

          system.cancelTicket(cancelFlightName, cancelId);

          System.out.println("Your Booking was cancelled succesfully");
        }
        case 3 -> {
          System.out.print("Enter the flightName : ");
          String displayFlightName = scan.nextLine();

          system.displayFlightDetails(displayFlightName);
        }
        case 4 -> {
          System.out.println("Exiting ...");
          return ;
        }
      }
    }
  }
}


