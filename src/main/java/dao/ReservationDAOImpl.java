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
    public List<Reservation> findAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            String sql = "SELECT * FROM reservations";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setId(resultSet.getInt("id"));
                reservation.setCustomerId(resultSet.getInt("customer_id"));
                reservation.setRoomId(resultSet.getInt("room_id"));
                reservation.setCheckInDate(resultSet.getDate("check_in_date"));
                reservation.setCheckOutDate(resultSet.getDate("check_out_date"));
                // Add reservation to the list
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(resultSet, statement, connection);
        }

        return reservations;
    }

    @Override
    public Reservation findReservationById(int id) {
        Reservation reservation = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            String sql = "SELECT * FROM reservations WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                reservation = new Reservation();
                reservation.setId(resultSet.getInt("id"));
                reservation.setCustomerId(resultSet.getInt("customer_id"));
                reservation.setRoomId(resultSet.getInt("room_id"));
                reservation.setCheckInDate(resultSet.getDate("check_in_date"));
                reservation.setCheckOutDate(resultSet.getDate("check_out_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(resultSet, statement, connection);
        }

        return reservation;
    }

    @Override
    public List<Reservation> findReservationsByCustomer() {
        // Implementation to find reservations by customer
        return null;
    }

    @Override
    public void saveReservation(Reservation reservation) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBUtil.getConnection();
            String sql = "INSERT INTO reservations (customer_id, room_id, check_in_date, check_out_date) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, reservation.getCustomerId());
            statement.setInt(2, reservation.getRoomId());
            statement.setDate(3, new java.sql.Date(reservation.getCheckInDate().getTime()));
            statement.setDate(4, new java.sql.Date(reservation.getCheckOutDate().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(statement, connection);
        }
    }

    @Override
    public void updateReservation(Reservation reservation) {
        // Implementation to update a reservation
    }

    @Override
    public void cancelReservation(int id) {
        // Implementation to cancel a reservation
    }
}