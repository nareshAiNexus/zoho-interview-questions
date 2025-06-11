
import java.util.*;

class FlightReservation {

  Map<String, Flight> flights;

  public FlightReservation(){
    flights = new HashMap<>();
    flights.put("Indigo" , new Flight("Indigo"));
    flights.put("SpiceJet" , new Flight("SpiceJet"));

  }

  public String bookTicket(String flightName, String passengerName, int age, int seats){

    Flight flight = flights.get(flightName);
    if(flight != null){
      return flight.bookTickets(passengerName, age, seats);
    }else{
      System.out.println("Booking failed : Flight not found");
      return null;
    }

  }

  public boolean cancelTicket(String flightName, String bookingId){

     Flight flight = flights.get(flightName);
     if(flight != null){
      return flight.cancelBooking(bookingId);
     }
     else{
      System.out.println("Cancellation failed : Failed Id not found");
      return false;
     }
  }

  public void displayFlightDetails(String flightName){
    Flight flight = flights.get(flightName);
    if(flight != null){
      flight.displayDetails();
    }
    else{
      System.out.println("Flight not found");
    }
  }
}
