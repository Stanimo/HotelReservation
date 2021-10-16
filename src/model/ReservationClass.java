package model;

import java.util.Date;

public class ReservationClass {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    @Override
    public String toString() {
        return "Customer is: " + customer + "\n" +
                "Room is: " + room + "\n" +
                "Check in date is: " + checkInDate + "\n" +
                "Check out date is: " + checkOutDate;
     }
}
