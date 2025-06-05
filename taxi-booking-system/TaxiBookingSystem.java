import java.util.*;

public class TaxiBookingSystem {
  static List<Taxi> taxis = new ArrayList<>();
  static Scanner scan = new Scanner(System.in);
  static int customerCount = 0;

  public static void main(String[] args) {
    System.out.println("Enter No of Taxis : ");
    int numTaxis = scan.nextInt();
    initializeTaxis(numTaxis);

    while (true) {
      System.out.println("\n1. Book_Taxi \n2. Display_Details \n3. Exit");
      System.out.println("Enter your choice : ");

      int choice = scan.nextInt();

      switch (choice) {
        case 1 -> bookTaxi();
        case 2 -> displaytaxiDetails();
        case 3 -> {
            System.out.println("Exiting ...");
            return;
            }
        default -> System.out.println("Invalid Entry ? ");
      }
    }

  }

  public static void initializeTaxis(int n) {
    for (int i = 1; i <= n; i++) {
      taxis.add(new Taxi(i));
    }
  }

  public static void bookTaxi() {
    int customerId = customerCount++;
    System.out.println("Enter Pickup point (A-F) : ");
    char pickup = scan.next().toUpperCase().charAt(0);

    System.out.println("Enter Drop point (A-F) : ");
    char drop = scan.next().toUpperCase().charAt(0);

    System.out.println("Enter pickup time (in hours) : ");
    int pickupTime = scan.nextInt();

    Taxi selectedTaxi = null;
    int minDistance = Integer.MAX_VALUE;

    for (Taxi taxi : taxis) {
      // check taxi available at pickup time
      if (taxi.isAvailable(pickupTime)) {
        // Distance b/w curr location and pickup point
        int distance = Math.abs(taxi.currentPoint - pickup);
        // select taxi with min distance or low earnings if distance are equal
        if (distance < minDistance ||
            (distance == minDistance && taxi.totalEarnings < selectedTaxi.totalEarnings)) {

          selectedTaxi = taxi;
          minDistance = distance;
        }
      }
    }

    if (selectedTaxi == null) {
      System.out.println("Unable to Book taxi ..");
      return;
    }
    int dropTime = pickupTime + Math.abs(drop - pickup);
    int amount = selectedTaxi.calculateEarnings(pickup, drop);
    int bookingId = selectedTaxi.bookings.size() + 1;

    Booking booking = new Booking(bookingId, customerId, pickupTime, dropTime, pickup, drop);
    // Add the new Booking to the selected Taxi
    selectedTaxi.addBooking(booking);
    System.out.println("Taxi-" + selectedTaxi.id + "is allocated");
    selectedTaxi.totalEarnings += amount;

  }

  public static void displaytaxiDetails() {
    for (Taxi taxi : taxis) {
      System.out.println("-".repeat(80));
      System.out.println("Taxi-" + taxi.id + " total Earnings : Rs " + taxi.totalEarnings);
      System.out.printf("%-10s %-10s %-5s %-5s %-12s %-9s %6s%n",
          "BookingID", "CustomerD", "From", "TO", "PickupTime", "DropTime", "Amount");

      for (Booking booking : taxi.bookings) {
        System.out.printf("%-10d %-10d %-5c %-5c %-12d %-9d %-6d%n",
            booking.bookingId, booking.customerId, booking.from, booking.to,
            booking.pickupTime, booking.dropTime, booking.amount);
      }
    }
  }

}
