package model;

public class Reservation {
    private int id;
    private int roomId;
    private String checkInDate;
    private String checkOutDate;
    // Other reservation details like guest information can be added here

    // Constructors, getters, and setters
    // Constructor(s)
    public Reservation() {
    }

    public Reservation(int id, int room_id, String check_in_date, String check_out_oate) {
        this.id = id;
        this.roomId = room_id;
        this.checkInDate = check_in_date;
        this.checkOutDate = check_out_oate;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
