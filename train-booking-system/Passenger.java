public class Passenger {
  String name;
  int age;
  char gender;
  char berthPrefered;
  char allottedBerth;
  int ticketId;

  public Passenger(
      String name, int age, char gender, 
      char berthPrefered, char allottedBerth, int ticketId){

    this.name = name;
    this.age = age;
    this.gender = gender;
    this.berthPrefered = berthPrefered;
    this.allottedBerth = allottedBerth;
    this.ticketId = ticketId;
      }

  @Override
  public String toString() {
    return 
      "TICKET_ID : " + ticketId + 
      ", NAME : " + name + 
      ", AGE : " + age + 
      ", GENDER : " + gender +
      ", BERTH : " + allottedBerth;
  }
}
  

