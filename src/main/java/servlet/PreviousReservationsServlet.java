package servlet;

import java.io.PrintWriter;
import java.util.List;

import dao.ReservationDAO;
import dao.RoomDAO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Reservation;

public class PreviousReservationsServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoomDAO roomDAO;
	
	
    
    @Override
	public void init() {
		// TODO Auto-generated method stub
    	roomDAO = new Roo
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer l'identifiant de l'utilisateur à partir de la session ou des paramètres de requête
        int userId = getUserIdFromSessionOrRequest(request);
        
        // Appeler la méthode du DAO pour obtenir les réservations précédentes de l'utilisateur
        ReservationDAO reservationDAO = new;
        List<Reservation> previousReservations = reservationDAO.getPreviousReservations(userId);
        
        // Générer la réponse HTML pour afficher les réservations précédentes
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Vos Réservations Précédentes</h1>");
        if(previousReservations.isEmpty()) {
            out.println("<p>Aucune réservation précédente trouvée.</p>");
        } else {
            out.println("<ul>");
            for(Reservation reservation : previousReservations) {
                out.println("<li>" + reservation.toString() + "</li>");
            }
            out.println("</ul>");
        }
        out.println("</body></html>");
    }
    
    private int getUserIdFromSessionOrRequest(HttpServletRequest request) {
        // Implémentez la logique pour récupérer l'identifiant de l'utilisateur à partir de la session ou des paramètres de requête
        // Par exemple :
        // return (int) request.getSession().getAttribute("userId");
        // OU
        // return Integer.parseInt(request.getParameter("userId"));
        return 123; // 
    }
}