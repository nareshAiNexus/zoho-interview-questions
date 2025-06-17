## Flight Ticket Reservation system

1. Booking Ticket
2. Booking conditions:
  a. Each flight has 50 seats
  b. Get passenger details along with flight name and seats required
  c. Ticket starting price is 5000 rupees
  d. After every successful booking, price increases by 200 rupees
3. Cancel Ticket
4. Cancel conditions:
  a. Refund amount
  b. Price reduces by 200 rupees for every cancelled ticket
5. Print flight details with passengers


## Approach

1. Four classes 
    - Flight -> To store the Flight details
    - FLightBooking -> To Book the tickets
    - FlightPassenger -> To store the passenger details
    - FLightReservation -> Class for Flight Reservation

2. Store the passenger details in FlightPassenger class
3. Create the booking methods in the FLightBooking class 
4. Create the FLightReservation to reserve tickets
