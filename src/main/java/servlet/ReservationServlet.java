package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Reservation;
import util.DBUtil;

@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve reservation details from the request
        int userId = Integer.parseInt(request.getParameter("userId"));
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        String checkInDate = request.getParameter("checkInDate");
        String checkOutDate = request.getParameter("checkOutDate");
        
        // Create a Reservation object
        Reservation reservation = new Reservation(0, roomId, checkInDate, checkOutDate);
        
        // Add the reservation to the database
        boolean success = addReservation(reservation, userId);
        
        if (success) {
            // If reservation is successful, forward to a success page
            request.getRequestDispatcher("reservationSuccess.jsp").forward(request, response);
        } else {
            // If reservation fails, forward to an error page
            request.getRequestDispatcher("reservationError.jsp").forward(request, response);
        }
    }
    
    // Method to add a reservation to the database
    private boolean addReservation(Reservation reservation, int userId) {
        try (Connection connection = DBUtil.getConnection()) {
            String sql = "INSERT INTO reservations (user_id, room_id, check_in_date, check_out_date) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userId);
                statement.setInt(2, reservation.getRoomId());
                statement.setString(3, reservation.getCheckInDate());
                statement.setString(4, reservation.getCheckOutDate());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
