package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/manage-reservation")
public class ReservationServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    int roomId = ...; // Parse from request
    String customerName = ...; // Parse from request
    Date checkInDate = ...; // Parse from request
    Date checkOutDate = ...; // Parse from request

    RoomDAO roomDAO = new RoomDAOImpl();
    Room room = roomDAO.findRoomById(roomId);

    if (room != null && room.
