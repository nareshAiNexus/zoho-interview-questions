import java.util.*;

public class FlightBooking {
  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);

    while (true) { 
      System.out.println("1. Booking Ticket ");
      System.out.println("2. Cancel Ticket ");   
      System.out.println("3. Display flight Details");   
      System.out.println("4. Exit");

      int choice = scan.nextInt();
      
      switch (choice) {
        case 1 -> {
          System.out.print("Enter FLight Name (Indigo / SpiceJet)");
          String flightName = scan.nextLine();

          

        }
      }
    }
  }
}
