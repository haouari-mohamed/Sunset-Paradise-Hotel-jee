package servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/search-rooms")
public class RoomSearchServlet extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Extract search criteria from request parameters
    String type = request.getParameter("type"); // Optional
    Date startDate = ...; // Parse from request
    Date endDate = ...; // Parse from request

    RoomDAO dao = new RoomDAOImpl(); // Assuming a concrete implementation class
    List<Room> availableRooms = dao.findAvailableRooms(startDate, endDate);

    request.setAttribute("rooms", availableRooms);
    request.getRequestDispatcher("/room-list.jsp").forward(request, response);
  }
}
