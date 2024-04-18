package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Reservation;
import util.DBUtil;

public class ReservationDAOImpl implements ReservationDAO {

    @Override
    public List<Reservation> getReservationsByUserId(int userId) {
        // Implementation to retrieve reservations by user ID
        // This will involve querying the database to fetch reservations for the specified user ID
        // Return a list of reservations
        return null; // Placeholder for implementation
    }

    public boolean createReservation(Reservation reservation) {
        // Implementation to create a new reservation in the database
        // This will involve inserting a new record into the reservations table in the database
        // Return true if the reservation is successfully created, false otherwise
        return false; // Placeholder for implementation
    }

    @Override
    public List<Reservation> getAllReservations() {
        // Implementation to retrieve all reservations from the database
        List<Reservation> reservations = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM reservations");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                // Retrieve reservation details from the result set and create Reservation objects
                int id = resultSet.getInt("id");
                int roomId = resultSet.getInt("room_id");
                String checkInDate = resultSet.getString("check_in_date");
                String checkOutDate = resultSet.getString("check_out_date");
                // Create Reservation object and add it to the list
                Reservation reservation = new Reservation(id, roomId, checkInDate, checkOutDate);
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

	@Override
	public boolean addReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteReservation(int reservationId) {
		// TODO Auto-generated method stub
		return false;
	}
}
