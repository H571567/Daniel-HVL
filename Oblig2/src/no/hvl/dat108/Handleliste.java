package no.hvl.dat108;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringEscapeUtils;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Handleliste")
public class Handleliste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession sesjon = req.getSession();

		if (sesjon != null && req.getSession().getAttribute("loggedIn") != null) {
			HandleObjekt handleliste = (HandleObjekt) req.getServletContext().getAttribute("liste");

			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<style type=\"text/css\"> body {background-color: #d0f0f2;}"
					+ "* {font-family:\"Helvetica Neue Light\"}"
					+ "fieldset{border: 1px solid black;}</style>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>Handleliste</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form action=\"Handleliste\" method=\"post\">");
			out.println("<fieldset>");
			out.println("<legend>Min handleliste</legend>");
			out.println("<button type=\"submit\">Legg til</button>");
			out.println("<input type=\"text\" name=\"leggTilVare\" placeholder=\"Ny vare..\">");
			out.println("</fieldset>");
			out.println("</form>");
			out.println("<ul style=\"list-style-type:none\">");
			if (handleliste.getHandleObjekt().isEmpty()) {
				out.println("<p>Handlelisten er tom</p>");
			} else {
				for (String vare : handleliste.getHandleObjekt()) {
					out.println("<form action=\"Handleliste\" method=\"post\">"
							+ "<li>"
							+ "<input class=\"form-control\" type=\"hidden\" name=\"slettListe\" value=" + vare +">"
							+ "<button type=\"submit\" form-control\"></span>Slett</button>"
							+ " " + vare
							+ "</li>"
							+ "<br></form>");
				}
			out.println("</ul>");
			}
			out.println("</ul>");
			out.println("</div>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		} else {
			resp.sendRedirect("Innlogging" + "?notLoggedIn");
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//Sjekker at innteksten ikke er HTML-kode.
		String nyVare = StringEscapeUtils.escapeHtml(req.getParameter("leggTilVare"));
		//Fjerner mellomrom fra inntekst.
		if(nyVare != null) {
			nyVare = nyVare.trim();
		}
		
		//Sjekker om bruker har session.
		HttpSession sesjon = req.getSession(false);
		if (sesjon == null || sesjon.getAttribute("loggedIn") == null) {
			resp.sendRedirect("Innlogging" + "?notLoggedIn");
		} else {
			//Bruker har godkjent session.
			HandleObjekt handleliste = (HandleObjekt) req.getServletContext().getAttribute("liste");
			
			//Sjekker om man prøver legge til eller slette vare.
			if(req.getParameter("slettListe") == null) {
				if (nyVare != null && !nyVare.isEmpty() && handleliste != null) {
					handleliste.LeggTil(nyVare);
				}
			} else { //Dersom den ikke skal legges til, slettes den.
				if(!handleliste.getHandleObjekt().isEmpty()) {
					String slett = req.getParameter("slettListe");
					synchronized(handleliste){
						handleliste.slettVare(slett);
					}
					
				}
			}
			resp.sendRedirect("Handleliste");
		}
	}
}