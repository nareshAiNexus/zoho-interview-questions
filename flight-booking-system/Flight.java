import java.util.*;

public class Flight {

  private String flightName;
  private int availableSeats;
  private int ticketPrice;
  private int bookingCounter;
  private Map<String, FlightPassenger> bookings;

  public Flight(String flightName){
    
    this.flightName = flightName;
    this.availableSeats = 50;
    this.ticketPrice = 5000;
    this.bookingCounter = 0;
    this.bookings = new HashMap<>();
  }

  public String bookTickets(String name, int age, int seats){
    if(seats <= availableSeats){
      bookingCounter++;
      String bookingId = "T" + bookingCounter;
      FlightPassenger passenger = new FlightPassenger(bookingId, name, age, seats);
      bookings.put(bookingId, passenger);
      availableSeats -= seats;
      ticketPrice += 200 * seats;
      return bookingId;
    }
    System.out.println("Booking failed : Not enough seats available ...");
    return null;
  }

  public boolean cancelBooking(String bookingId){
    FlightPassenger passenger = bookings.get(bookingId);

    if (passenger != null){
      int seats = passenger.getSeatsBooked();
      availableSeats -= seats;
      ticketPrice -= 200 * seats;
      bookings.remove(bookingId);
      System.out.println("Booking Cancelled Succesfully ...");
      return true;
    }
    else {
      System.out.println("Cancellation cancelled : Booking ID not found ...");
      return false;
    }
  }

  public void displayDetails(){
    System.out.println("Flight \t : " + flightName);
    System.out.println("availableSeats \t : " + availableSeats);
    System.out.println("ticketPrice \t : " + ticketPrice);
  }

  public void displayBookingDetails(){
    System.out.println("Flight : " + flightName);
    System.out.println("AvailableSeats : " + availableSeats);
    System.out.println("TicketPrice : " + ticketPrice);
    System.out.println("Passengers : ");

    for(FlightPassenger passenger : bookings.values()){
      System.out.println(passenger);
    }
  }
}

