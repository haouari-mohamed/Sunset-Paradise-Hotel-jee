package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Reservation;
import util.DBUtil;

@WebServlet("/PreviousReservationsServlet")
public class PreviousReservationsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user ID from session or request parameters
        int userId = Integer.parseInt(request.getParameter("userId")); // Example: Assuming user ID is passed as a parameter
        
        // Retrieve previous reservations from database
        List<Reservation> reservations = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection()) {
            String sql = "SELECT * FROM reservations WHERE user_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        // Example: Retrieve reservation details
                        int reservationId = resultSet.getInt("id");
                        int roomId = resultSet.getInt("room_id");
                        String checkInDate = resultSet.getString("check_in_date");
                        String checkOutDate = resultSet.getString("check_out_date");
                        
                        // Create Reservation object
                        Reservation reservation = new Reservation(reservationId, roomId, checkInDate, checkOutDate);
                        // Add reservation to the list
                        reservations.add(reservation);
                    }
                }
            }
        } catch (SQLException e) {
            // Handle database errors
            e.printStackTrace();
            response.getWriter().println("An error occurred while processing your request.");
            return;
        }
        
        // Set reservations attribute and forward to JSP
        request.setAttribute("reservations", reservations);
        RequestDispatcher dispatcher = request.getRequestDispatcher("previousReservations.jsp");
        dispatcher.forward(request, response);
    }
}
