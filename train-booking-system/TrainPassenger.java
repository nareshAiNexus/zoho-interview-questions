public class TrainPassenger {
  String name;
  String gender;
  int age;
  String ticketId;
  String berthPrefered;
  String allottedBerth;

  public TrainPassenger(
      String name, int age, String gender, 
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

