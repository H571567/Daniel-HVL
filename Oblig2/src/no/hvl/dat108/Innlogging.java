package no.hvl.dat108;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


/**
 * Servlet implementation class Innlogging
 */
// @WebServlet("/Innlogging") GÅR IKKE MED XML!!
@WebServlet(name="Innlogging", urlPatterns="/Innlogging")
public class Innlogging extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
	    resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<style type=\"text/css\"> body {background-color: #d0f0f2;}"
				+ "* {font-family:\"Helvetica Neue Light\"}"
				+ "fieldset{border: 1px solid black;}</style>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Innlogging</title>");
		out.println("</head>");
		out.println("<body>");
		if(req.getParameter("feil") != null) {
			out.println("<p>Feil passord.</p>");
		} else if (req.getParameter("notLoggedIn") != null) {
			out.println("<p>Ikke innlogget.</p>");
		}
		out.println("<form action=\"Innlogging\" method=\"post\">");
		out.println("<fieldset>");
		out.println("<legend>Gi inn passord</legend>");
		out.println("<p>Passord: <input type=\"password\" name=\"passord\" placeholder=\"Skriv inn..\"></p>");
		out.println("<p><input type=\"submit\"value=\"Logg inn\"></p>");
		out.println("</fieldset>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doPost(HttpServletRequest req, 
	         HttpServletResponse resp)
	        throws ServletException, IOException {
		String passInn = req.getParameter("passord");
		String passRett = this.getInitParameter("Passord");
		ServletContext servletContext = req.getServletContext();
		if(passInn.equals(passRett)) {
			HttpSession sesjon = req.getSession(false);
			if (sesjon != null) {
				sesjon.invalidate();
			}
			sesjon = req.getSession(true);
			//Henter tid til inactive fra init paramter i xml-fil
			int tidInactive = Integer.parseInt(this.getInitParameter("Tid"));
			sesjon.setMaxInactiveInterval(tidInactive);

			sesjon.setAttribute("loggedIn", "yes");
			//Finnes handlevogn? Hvis ikke, opprett.
			if(servletContext.getAttribute("liste") == null) {
				servletContext.setAttribute("liste", new HandleObjekt());
			}
			resp.sendRedirect("Handleliste");
		} else {
			resp.sendRedirect("Innlogging" + "?feil='ja'");
		}
	}
}
