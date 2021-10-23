package api;

import model.Customer;
import model.IRoom;
import model.Room;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class AdminResource {
    private static List<IRoom> allRooms = new LinkedList<IRoom>();

    public static Customer getCustomer(String email) {
        return service.CustomerService.getCustomer(email);
    }

    public static void addRoom(List<IRoom> rooms) {
        for (IRoom room : rooms) {
            service.ReservationService.addRoom(room);
            allRooms.add(room);
        }
    }

    public static Collection<IRoom> getAllRooms() {
        return allRooms;
    }

    public static Collection<Customer> getAllCustomers() {
        return service.CustomerService.getAllCustomers();
    }

    public static void displayAllReservations() {
        service.ReservationService.printAllReservation();
    }
}
