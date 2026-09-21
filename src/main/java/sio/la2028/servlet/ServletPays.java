package sio.la2028.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sio.la2028.database.DaoPays;
import sio.la2028.model.Athlete;
import sio.la2028.model.Pays;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServletPays extends HttpServlet {

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
                Logger.getLogger(sio.la2028.servlet.ServletPays.class.getName()).log(Level.SEVERE, null, ex);
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
                out.println("<title>Servlet ServletPays</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet ServletPays at " + request.getContextPath() + "</h1>");
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

            // Récup et affichage les Pays
            if(url.equals("/la2028/ServletPays/lister"))
            {
                ArrayList<Pays> lesPayss = DaoPays.getLesPays(cnx);
                request.setAttribute("pLesPays", lesPayss);
                //System.out.println("lister eleves - nombres d'élèves récupérés" + lesEleves.size() );
                request.getServletContext().getRequestDispatcher("/vues/pays/listerPays.jsp").forward(request, response);
            }

            if(url.equals("/la2028/ServletPays/consulter"))
            {
                int idPays = Integer.parseInt((String)request.getParameter("idPays"));
                Pays p = DaoPays.getPaysById(cnx, idPays);
                ArrayList<Athlete> lesAthletes = DaoPays.getPaysByAthleteById(cnx, idPays);
                p.setLesAthletes(lesAthletes);
                request.setAttribute("pPays", p);
                request.setAttribute("pLesAthletes", lesAthletes);
                //System.out.println("lister eleves - nombres d'élèves récupérés" + lesEleves.size() );
                request.getServletContext().getRequestDispatcher("/vues/pays/consulterPays.jsp").forward(request, response);
            }
        }
    }



