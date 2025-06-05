public class Passenger {
  String name;
  char gender;
  int age;
  String ticketId;
  String berthPrefered;
  String allottedBerth;

  public Passenger(
      String name, int age, char gender, 
      String berthPrefered, String allottedBerth, String ticketId){

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
  

