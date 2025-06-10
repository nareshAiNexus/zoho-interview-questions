import java.util.*;

public class TicketSystem {
  
  // AVAILABLE BERTHS
  private final List<String> availableBerths = new ArrayList<>(Arrays.asList("L", "M", "U")); // 3

  // RAC BOOKING QUEUE
  private final Queue<TrainPassenger> racQueue = new LinkedList<>();

  // WAITING LIST QUEUE
  private final Queue<TrainPassenger> waitingList = new LinkedList<>();

  // CONFIRMED PASSENGERS
  private final List<TrainPassenger> confirmedPassengers = new ArrayList<>();

  int ticketCounter = 0;

  public void bookTicket(String name, int age, String gender, String berthPrefered){
    String ticketId = "T" + ticketCounter++;
    TrainPassenger passenger;

    if(!availableBerths.isEmpty()){
      String allocattedBerth = allocateBerth(age, gender, berthPrefered);

      // CREATE NEW PASSENGER 
      passenger = new TrainPassenger(name, age, gender, berthPrefered, allocattedBerth, ticketId);
      confirmedPassengers.add(passenger);
      availableBerths.remove(allocattedBerth);
      System.out.println("Ticket Booked : " + passenger);
    }
    else if (racQueue.size() < 1) {
      passenger = new TrainPassenger(name, age, gender, berthPrefered, "RAC", ticketId); 
      racQueue.offer(passenger);
      System.out.println("Ticket in RAC : " + passenger);       
    }
    else if (waitingList.size() < 1){
      passenger = new TrainPassenger(name, age, gender, berthPrefered, "Waiting", ticketId); 
      waitingList.offer(passenger);
      System.out.println("Ticket in Waiting List : " + passenger);   
    }
    else{
      System.out.println("No Tickets available : ");
    }

  }

  public String allocateBerth(int age, String gender, String prefered){

    if((age > 60 || gender.equalsIgnoreCase("female")) && availableBerths.contains("L")){
      return "L";
    }
    if(availableBerths.contains(prefered)){
      return prefered;
    }
    return availableBerths.get(0);
  }

  public void cancelTicket(String ticketId){

    Optional<TrainPassenger> passengerOpt = confirmedPassengers.stream()
      .filter(p -> p.ticketId.equals(ticketId))
      .findFirst();

      if (passengerOpt.isPresent()){
        TrainPassenger passenger = passengerOpt.get();
        confirmedPassengers.remove(passenger);
        availableBerths.add(passenger.allottedBerth);

        if (!racQueue.isEmpty()){
          TrainPassenger racPassenger = racQueue.poll();
          String allocateBerth = allocateBerth(racPassenger.age, racPassenger.gender, racPassenger.berthPrefered);
          racPassenger.allottedBerth = allocateBerth;
          confirmedPassengers.add(racPassenger);
          availableBerths.remove(allocateBerth);
          System.out.println("RAC ticket moved to confirmed");
        }
        if (!waitingList.isEmpty()){
        TrainPassenger waitingPassenger = waitingList.poll();
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

  public void displayAvailableTickets(){
    System.out.println("Available Berths : " + availableBerths.size());
    System.out.println("Available tickets in RAC : " + (1 - racQueue.size()));
    System.out.println("Available Waiting List Tickets : " + (1 - waitingList.size()));
  }

  public void displayRacTickets(){
    if(racQueue.isEmpty()){
      System.out.println("No RAC Bookings available...");
    }
    else{
      System.out.println("RAC Tickets : ");
      for (TrainPassenger passenger : racQueue){
        System.out.println(passenger);
      }
      
    }
  }

  public void displayConfirmedTickets(){
    if(confirmedPassengers.isEmpty()){
      System.out.println("No Bookings are confirmed");
    }
    else{
      System.out.println("Confirmed Bookings .");
      for(TrainPassenger passenger  : confirmedPassengers){
        System.out.println(passenger);
      }
    }
  }

  public void displayWaitingList(){
    if(waitingList.isEmpty()){
      System.out.println("Waiting List was Empty ...");
    }
    else{
      System.out.println("WaitingList ...");
      for(TrainPassenger passenger: waitingList){
        System.out.println(passenger);
      }
    }
  }
}

