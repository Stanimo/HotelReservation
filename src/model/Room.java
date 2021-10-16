package model;

public class Room implements IRoom{
    String roomNumber;
    Double price;
    RoomType roomType;

    public Room (String roomNumber, Double price, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
    }

    public Room() {
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public boolean isFree() {
        return true;
    }

    @Override
    public String toString() {
        return "The room number is: " + roomNumber + "\n" +
                "The price is: " + price + "\n" +
                "Room type is: " + roomType;
    }
}
