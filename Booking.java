public class Booking {
  int bookingId, customerId, pickupTime, dropTime, amount;
  char from, to;

  public Booking(int bookingId, int customerId, int pickupTime, int dropTime, char from, char to){
    this.bookingId = bookingId;
    this.customerId = customerId;
    this.pickupTime = pickupTime;
    this.dropTime = dropTime;
    this.from = from;
    this.to = to;
  }


}
