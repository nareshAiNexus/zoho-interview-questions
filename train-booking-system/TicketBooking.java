import java.util.*;

public class TicketBooking {
  public static void main(String[] args) {
    
    TicketSystem ticketSystem = new TicketSystem();
    Scanner scan = new Scanner(System.in);

    while (true){

      System.out.println("1. Book ticket");
      System.out.println("2. Cancel ticket");
      System.out.println("3. Display bookings");
      System.out.println("4. Display RAC Bookings");
      System.out.println("5. Display Waiting list");
      System.out.println("6. Exit\n");
      
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
          String gender = scan.next();

          System.out.print("Prefered Berth (L, M, U): ");
          String preferedBerth = scan.nextLine();
          scan.next();
          System.out.println();

          // Create Passenger object for each person
          ticketSystem.bookTicket(name, age, gender, preferedBerth);
        }
      }
    }
  }
}
