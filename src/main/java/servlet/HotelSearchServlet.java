package servlet;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HotelSearchServlet")
public class HotelSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Process hotel search form data and perform necessary operations
        // For example:
        String checkInDate = request.getParameter("checkInDate");
        String checkOutDate = request.getParameter("checkOutDate");
        int numGuests = Integer.parseInt(request.getParameter("numGuests"));
        
        // Perform search operation and forward the user to appropriate JSP
        response.sendRedirect("hotelSearch.jsp");
    }
}
