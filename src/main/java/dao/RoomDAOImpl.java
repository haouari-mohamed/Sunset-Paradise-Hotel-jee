package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Room;
import util.DBUtil;

public class RoomDAOImpl implements RoomDAO {

    @Override
    public List<Room> findAvailableRooms(String checkInDate, String checkOutDate, int numGuests) {
        List<Room> availableRooms = new ArrayList<>();
        String sql = "SELECT * FROM rooms WHERE available = true";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Populate room object
                    Room room = new Room();
                    room.setId(resultSet.getInt("id"));
                    room.setType(resultSet.getString("type"));
                    room.setPrice(resultSet.getDouble("price"));
                    room.setAmenities(resultSet.getString("amenities"));
                    room.setAvailable(resultSet.getBoolean("available"));
                    // Add room to the list if it meets the criteria
                    availableRooms.add(room);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return availableRooms;
    }

    @Override
    public Room getRoomById(int roomId) {
        // Implementation to retrieve room by ID from the database
        return null;
    }

    @Override
    public boolean addRoom(Room room) {
        // Implementation to add a new room to the database
        return false;
    }

    @Override
    public boolean updateRoom(Room room) {
        // Implementation to update an existing room in the database
        return false;
    }

    @Override
    public boolean deleteRoom(int roomId) {
        // Implementation to delete a room from the database
        return false;
    }

	@Override
	public List<Room> getAllRooms() {
		// TODO Auto-generated method stub
		return null;
	}
}
