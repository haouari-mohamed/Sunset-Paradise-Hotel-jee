package dao;

import java.util.List;
import model.Reservation;

public interface ReservationDAO {
    // Method to retrieve reservations by user ID
    List<Reservation> getReservationsByUserId(int userId);
    
    // Method to add a new reservation to the database
    boolean addReservation(Reservation reservation);
    
    // Method to update an existing reservation in the database
    boolean updateReservation(Reservation reservation);
    
    // Method to delete a reservation from the database
    boolean deleteReservation(int reservationId);
    
    // Method to retrieve all reservations from the database
    List<Reservation> getAllReservations();
    
    // Method to create a reservation
    boolean createReservation(Reservation reservation);
}
