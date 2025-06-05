import java.util.*;

public class TicketSystem {
  
  // AVAILABLE BERTHS
  private final List<String> availableBerths = new Array<>(Arrays.asList("L", "M", "U")); // 3

  // RAC BOOKING QUEUE
  private final Queue<Passenger> racQueue = new LinkedList<>();

  // WAITING LIST QUEUE
  private final Queue<Passenger> waitingList = new LinkedList<>();

  // CONFIRMED PASSENGERS
  private final List<Passengers> confirmedPassengers = new ArrayList<>();

  int ticketCounter = 0;

  public void bookTicket(String name, int age, char gender, String berthPrefered){
    String ticketId = "T" + ticketCounter++;
    Passenger passenger;

    if(!availableBerth.isEmpty()){
      String allocattedberth = allocateBerth(age, gender, berthPrefered);

      // CREATE NEW PASSENGER 
      passenger = new Passenger(name, age, gender, berthPrefered, allocatedBerth, ticketId);
      confirmedPassengers.add(passenger);
      availableBerths.remove(allocattedberth);


    }

  }

  public static void allocateBerth(int age, char gender, String prefered){

    if(age > 60 ||| gender.equalsIgnoreCase('f') && availableBerths.contains("L")){
      return "L";
    }
    if(availableBerths.contains(prefered)){
      return prefered;
    }

    return availableBerths.get(0);
  }
  
}
