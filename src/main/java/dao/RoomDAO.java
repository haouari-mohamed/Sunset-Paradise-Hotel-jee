package dao;

import java.util.List;
import model.Room;

public interface RoomDAO {
    List<Room> findAvailableRooms(String checkInDate, String checkOutDate, int numGuests);
    Room getRoomById(int roomId);
    boolean addRoom(Room room);
    boolean updateRoom(Room room);
    boolean deleteRoom(int roomId);
    List<Room> getAllRooms(); // Method to get all rooms from the database
}
