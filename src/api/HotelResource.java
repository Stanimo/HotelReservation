package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    public static Customer getCustomer(String email) {
        return service.CustomerService.getCustomer(email);
    }

    public static void createACustomer(String email, String firstName, String lastName) {
        service.CustomerService.addCustomer(email, firstName, lastName);
    }

    public static IRoom getRoom(String roomNumber) {
        return service.ReservationService.getARoom(roomNumber);
    }

    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        return service.ReservationService.reserveARoom(getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    public static Collection<Reservation> getCustomerReservations(String customerEmail) {
        return ReservationService.getCustomerReservation(getCustomer(customerEmail));
    }

    public static Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return service.ReservationService.findRooms(checkIn, checkOut);
    }
}
