package model;

public class FreeRoom extends Room{
//    private String roomNumber;
//    private Double price;
//    private RoomType roomType;

    public FreeRoom (String roomNumber, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.price = 0.0;
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Room number is: " + roomNumber + "\n" +
                "The room is free " + "\n" +
                "Room type is: " + roomType;
    }
}
