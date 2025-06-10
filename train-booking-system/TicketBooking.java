import java.util.*;

public class TicketBooking {
  public static void main(String[] args) {
    
    TicketSystem ticketSystem = new TicketSystem();
    Scanner scan = new Scanner(System.in);

    while (true){

      System.out.println("\n1. Book ticket");
      System.out.println("2. Cancel ticket");
      System.out.println("3. Display bookings");
      System.out.println("4. Display Available Tickets");
      System.out.println("5. Display RAC list");
      System.out.println("6. Display Waiting list");
      System.out.println("7. Exit\n");
      
      System.out.print("Enter your choice : ");
      int choice = scan.nextInt();
      scan.nextLine();

      switch (choice){

        case 1 -> {
          System.out.print("Enter your Name : ");
          String name = scan.nextLine();

          System.out.print("Enter your Age : ");
          int age = scan.nextInt();
          scan.nextLine();

          System.out.print("Enter your gender : ");
          String gender = scan.nextLine();
          
          System.out.print("Prefered Berth (L, M, U): ");
          String preferedBerth = scan.nextLine();

          // Create Passenger object for each person
          ticketSystem.bookTicket(name, age, gender, preferedBerth);
        }

        case 2 -> {
          System.out.print("Enter the Booking Id : ");
          String ticketId = scan.nextLine();

          ticketSystem.cancelTicket(ticketId);
          System.out.println("Your Ticket was cancelled Succesfully : ");
        }
        case 3 -> {
          ticketSystem.displayConfirmedTickets();
        }
        case 4 -> {
          ticketSystem.displayAvailableTickets();
        }
        case 5 -> {
          ticketSystem.displayRacTickets();
        }
        case 6 -> {
          ticketSystem.displayWaitingList();
        }
        case 7 -> {
          System.out.println("Exiting ...");
          return;
        }
      }
    }
  }
}
