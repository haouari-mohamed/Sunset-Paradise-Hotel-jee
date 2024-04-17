package dao;

import java.util.List;

import model.Reservation;

public interface ReservationDAO {
  List<Reservation> findAllReservations();
  Reservation findReservationById(int id);
  List<Reservation> findReservationsByCustomer();
  void saveReservation(Reservation reservation);
  void updateReservation(Reservation reservation);
  void cancelReservation(int id);
}
