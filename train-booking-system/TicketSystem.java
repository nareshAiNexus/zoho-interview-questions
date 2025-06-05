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
      confirmedPassengers.add(passenger);
      System.out.println("Ticket Booked : " + passenger);
    }
    else if (racQueue.size() < 1) {
      passenger = new Passenger(name, age, gender, berthPrefered, "RAC", ticketId); 
      racQueue.offer(passenger);
      System.out.println("Ticket in RAC : " + passenger);       
    }
    else if (waitingList.size() < 1){
      passenger = new Passenger(name, age, gender, berthPrefered, "Waiting", ticketId); 
      waitingList.offer(passenger);
      System.out.println("Ticket in Waiting List : " + passenger);   
    }
    else{
      System.out.println("No Tickets available : ");
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

  public void cancelTicket(String ticketId){
    Optional<Passenger> passengerOpt = confirmedPassengers.stream()
      .filter(p -> p.ticketId.equals(ticketId))
      .findFirst();

      if (passengerOpt.isPresent()){
        Passenger passenger = passengerOpt.get();
        confirmedPassengers.remove(passenger);
        availableBerths.add(passenger.allottedBerth);

        if (!racQueue.isEmpty()){
          Passenger racPassenger = racQueue.poll();
          String allocateBerth = allocateBerth(racPassenger.age, racPassenger.gender, racPassenger.berthPrefered);
          racPassenger.allottedBerth = allocateBerth;
          confirmedPassengers.add(racPassenger);
          availableBerths.remove(allocateBerth);
          System.out.println("RAC ticket moved to confirmed");
        }
        if (!waitingList.isEmpty()){
        Passenger waitingPassenger = waitingList.poll();
        racQueue.offer(waitingPassenger);
        waitingPassenger.allottedBerth = "RAC";
        System.out.println("Waiting list ticket list moved to RAC");

        }
        System.out.println("Ticket Cancelled Succesfully for ticketId " + ticketId);
      }
      else{
        System.out.println("TicketId was not found...");
      }


  }
 
  public void bookingTicket(){
    if(confirmedPassengers.isEmpty()){
      System.out.println("No confirmed tickets ...");
    }
    else{
      System.out.println("Confirmed Tickets : ");

      for(Passenger passenger : confirmedPassengers){
        System.out.println(passenger);
      }
    }
  }

  public void printAvailableTickets(){
    System.out.println("Available Berths : " + availableBerths.size());
    System.out.println("Available tickets in RAC : " + (1 - racQueue.size()));
    System.out.println("Available Waiting List Tickets : " + (1 - waitingList.size()));
  }

  public void viewRacTickets(){
    if(racQueue.isEmpty()){
      System.out.println("No RAC Bookings available...");
    }
    else{
      System.out.println("RAC Tickets : ");
      for (Passenger passenger : racQueue){
        System.out.println(passenger);
      }
      
    }
  }

}

