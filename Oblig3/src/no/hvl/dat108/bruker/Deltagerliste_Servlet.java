package no.hvl.dat108.bruker;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Deltagerliste
 */
@WebServlet("/deltagerliste")
public class Deltagerliste_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BrukerEAO bEAO;
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession sesjon = request.getSession(true);
		
		if(sesjon != null && request.getSession().getAttribute("loggedIn") != null) {
			List<Bruker> liste = bEAO.hentBrukere();
			Collections.sort(liste);
			sesjon.setAttribute("brukere", liste);
			sesjon.setAttribute("aktiv", sesjon.getAttribute("loggedIn"));
		
		request.getRequestDispatcher("WEB-INF/deltager.jsp")
		.forward(request, response);
		} else {
		response.sendRedirect("login" + "?notLogin");
		}
	}
}