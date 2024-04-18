package model;

public class Room {
    private int id;
    private String type;
    private double price;
    private String amenities;
    private boolean available;

    // Constructors, getters, and setters
    // Constructor(s)
    public Room() {
    }

    public Room(int id, String type, double price, String amenities, boolean available) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.amenities = amenities;
        this.available = available;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
