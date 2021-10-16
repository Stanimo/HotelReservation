package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;

public class ReservationService {

    static Map<String, IRoom> roomPool = new HashMap<String, IRoom>();
    static Map<Customer, Reservation> reservations = new HashMap<Customer, Reservation>();

    public static void addRoom(IRoom room) {
        roomPool.put(room.getRoomNumber(), room);
    }

    public static IRoom getARoom(String roomId) {
        return roomPool.get(roomId);
    }

    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation newReservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.put(customer, newReservation);
        return newReservation;
    }

    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        IRoom reservedRoom = new Room();
        IRoom possibleRoom = new Room();
        Set<IRoom> possibleRooms = new HashSet<>();

        for (Map.Entry<Customer, Reservation> reservationEntry : reservations.entrySet()) {
            for(Map.Entry<String, IRoom> room : roomPool.entrySet()) {
                possibleRoom = room.getValue();
                reservedRoom = reservationEntry.getValue().getRoom();
                if(!(reservedRoom.getRoomNumber().equals(possibleRoom.getRoomNumber()))) {
                    possibleRooms.add(possibleRoom);
                }
            }
        }
        return possibleRooms;
    }

    public static Collection<Reservation> getCustomerReservation(Customer customer) {
        List<Reservation> customerRes = new LinkedList<Reservation>();
        for(Map.Entry<Customer, Reservation> customer1 : reservations.entrySet()) {
            customerRes.add(reservations.get(customer1));
        }
        return customerRes;
    }

    public static void printAllReservation() {
        for(Map.Entry<Customer, Reservation> customer1 : reservations.entrySet()) {
            reservations.get(customer1).toString();
        }
    }

    Collection<Reservation> reservationCollection = new LinkedList<Reservation>();

}
