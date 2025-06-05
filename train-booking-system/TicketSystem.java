import java.util.*;

public class TicketSystem {
  
  // AVAILABLE BERTHS
  private final List<String> availableBerths = new ArrayList<>(Arrays.asList("L", "M", "U")); // 3

  // RAC BOOKING QUEUE
  private final Queue<Passenger> racQueue = new LinkedList<>();

  // WAITING LIST QUEUE
  private final Queue<Passenger> waitingList = new LinkedList<>();

  // CONFIRMED PASSENGERS
  private final List<Passenger> confirmedPassengers = new ArrayList<>();

  int ticketCounter = 0;

  public void bookTicket(String name, int age, char gender, String berthPrefered){
    String ticketId = "T" + ticketCounter++;
    Passenger passenger;

    if(!availableBerths.isEmpty()){
      String allocattedBerth = allocateBerth(age, gender, berthPrefered);

      // CREATE NEW PASSENGER 
      passenger = new Passenger(name, age, gender, berthPrefered, allocattedBerth, ticketId);
      confirmedPassengers.add(passenger);
      availableBerths.remove(allocattedBerth);
    }

  }

  public String allocateBerth(int age, char gender, String prefered){

    if(age > 60 || gender == 'F' && availableBerths.contains("L")){
      return "L";
    }
    if(availableBerths.contains(prefered)){
      return prefered;
    }

    return availableBerths.get(0);
  }
  
}
