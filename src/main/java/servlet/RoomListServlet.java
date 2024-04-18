package servlet;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.RoomDAO;
import dao.RoomDAOImpl;
import model.Room;

@WebServlet("/ListRoomServlet")
public class RoomListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO roomDAO = new RoomDAOImpl();
        List<Room> roomList = roomDAO.getAllRooms();
        
        request.setAttribute("roomList", roomList);
        request.getRequestDispatcher("/WEB-INF/jsp/roomList.jsp").forward(request, response);
    }
}
