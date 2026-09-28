package sio.la2028.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sio.la2028.database.DaoEpreuve;
import sio.la2028.database.DaoEpreuve;
import sio.la2028.model.Athlete;
import sio.la2028.model.Epreuve;
import sio.la2028.model.Epreuve;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServletEpreuve extends HttpServlet {

    Connection cnx ;

    @Override
    public void init()
    {
        ServletContext servletContext=getServletContext();

        System.out.println("SERVLKET CONTEXT=" + servletContext.getContextPath());
        cnx = (Connection)servletContext.getAttribute("connection");

        try {
            System.out.println("INIT SERVLET=" + cnx.getSchema());
        } catch (SQLException ex) {
            Logger.getLogger(sio.la2028.servlet.ServletEpreuve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletEpreuve</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletEpreuve at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = request.getRequestURI();

        // Récup et affichage les Epreuve
        if (url.equals("/la2028/ServletEpreuve/lister")) {
            ArrayList<Epreuve> lesEpreuves = DaoEpreuve.getLesEpreuves(cnx);
            request.setAttribute("eLesEpreuve", lesEpreuves);
            //System.out.println("lister eleves - nombres d'élèves récupérés" + lesEleves.size() );
            request.getServletContext().getRequestDispatcher("/vues/epreuve/listerEpreuves.jsp").forward(request, response);
        }

        if(url.equals("/la2028/ServletEpreuve/consulter"))
        {
            int idEpreuve = Integer.parseInt((String)request.getParameter("idEpreuve"));
            Epreuve e = DaoEpreuve.getEpreuveById(cnx, idEpreuve);
            ArrayList<Athlete> lesAthletes = DaoEpreuve.getEpreuveByAthleteById(cnx, idEpreuve);
            e.setLesAthletes(lesAthletes);
            request.setAttribute("eEpreuve", e);
            request.setAttribute("eLesAthletes", lesAthletes);
            //System.out.println("lister eleves - nombres d'élèves récupérés" + lesEleves.size() );
            request.getServletContext().getRequestDispatcher("/vues/epreuve/consulterEpreuve.jsp").forward(request, response);
        }
    }
}