package no.hvl.dat108.control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.UI.Skjema_login;
import no.hvl.dat108.bruker.BrukerEAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BrukerEAO bEAO;
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		
		String loginMessage = "";

		if (request.getParameter("invalidUsername") != null) {
			
			loginMessage = "Ugyldig mobil/passord";
		} else if (request.getParameter("notLogin") != null) {
			
			loginMessage = "Du er logget ut";
		}

		request.setAttribute("loginMessage", loginMessage);
		
		request.getRequestDispatcher("WEB-INF/logginn.jsp")
		.forward(request, response);		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Skjema_login sl = new Skjema_login(request);
		
		if (sl.sjekkInnlogging(bEAO)) {
			
			HttpSession sesjon = request.getSession(false);
			if (sesjon != null) {
				sesjon.invalidate();
			}
			
			sesjon = request.getSession(true);
			
			sesjon.setMaxInactiveInterval(1000);
			sesjon.setAttribute("loggedIn", sl.getMobil());
			
			response.sendRedirect("deltagerliste");
		}	else { 
			response.sendRedirect("login" + "?invalidUsername");
		}
	}
}        

