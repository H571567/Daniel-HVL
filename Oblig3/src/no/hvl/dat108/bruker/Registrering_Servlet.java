package no.hvl.dat108.bruker;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.UI.Skjema;

/**
 * Servlet implementation class Registrering
 */
@WebServlet("/registrering")
public class Registrering_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BrukerEAO bEAO;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String RegistreringsMessage = "";

		if (request.getParameter("feilIRegistreringen") != null) {
			RegistreringsMessage = "De har oppgitt noe feil";
		}

		request.setAttribute("registreringsMessage", RegistreringsMessage);

		request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Skjema skjema = new Skjema(request);
		
		if (!skjema.altErGyldig() || bEAO.finnesMobil(skjema.getMobil())) {
			
			skjema.feilmeldinger();
			
			if (bEAO.finnesMobil(skjema.getMobil())) {
				skjema.setFeilMobil("Mobilen finnes allerede");
			}
			
			request.getSession().setAttribute("skjema", skjema);
			response.sendRedirect("registrering" + "?feilIRegistreringen");
			}
			else {
			
			//Kan lage bruker
			HttpSession sesjon = request.getSession(false);
			if (sesjon != null) {
				sesjon.invalidate();
			}

			sesjon = request.getSession(true);
			sesjon.setAttribute("loggedIn", skjema.getMobil());
			
			//Lager og legger til deltaker fra info i skjema
			//Trådsikker i synchronized
				Bruker b = skjema.lagBruker();
				synchronized(b) {
				bEAO.leggTilBruker(b);
				}
				
//			Setter passord til blank, slik at de trygt kan sendes med session
			skjema.gjemPassord();
			sesjon.setAttribute("skjema", skjema);
			
			response.sendRedirect("bekreftet");
			}
			
	}
}
