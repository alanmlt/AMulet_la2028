package sio.la2028.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sio.la2028.database.DaoPays;
import sio.la2028.database.DaoPays;
import sio.la2028.form.FormPays;
import sio.la2028.model.Pays;
import sio.la2028.model.Pays;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServetPays {

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
                request.setAttribute("pLesPays", lesPays);
                //System.out.println("lister eleves - nombres d'élèves récupérés" + lesEleves.size() );
                getServletContext().getRequestDispatcher("/vues/Pays/listerPays.jsp").forward(request, response);
            }

            if(url.equals("/la2028/ServletPays/consulter"))
            {
                int idPays = Integer.parseInt((String)request.getParameter("idPays"));
                Pays a = DaoPays.getPaysById(cnx, idPays);
                request.setAttribute("pPays", a);
                //System.out.println("lister eleves - nombres d'élèves récupérés" + lesEleves.size() );
                getServletContext().getRequestDispatcher("/vues/Pays/consulterPays.jsp").forward(request, response);
            }
        }

        /**
         * Handles the HTTP <code>POST</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {


            FormPays form = new FormPays();

            /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
            Pays ath = form.ajouterPays(request);

            /* Stockage du formulaire et de l'objet dans l'objet request */
            request.setAttribute( "form", form );
            request.setAttribute( "pPays", ath );

            if (form.getErreurs().isEmpty()){
                Pays PaysInsere =  DaoPays.addPays(cnx, ath);
                if (PaysInsere != null ){
                    request.setAttribute( "pPays", PaysInsere );
                    this.getServletContext().getRequestDispatcher("/vues/Pays/consulterPays.jsp" ).forward( request, response );
                }
                else
                {
                    // Cas oùl'insertion en bdd a échoué
                    //renvoyer vers une page d'erreur 
                }

            }
            else
            {
                // il y a des erreurs. On réaffiche le formulaire avec des messages d'erreurs
                ArrayList<Pays> lesCasernes = DaoPays.getLesPays(cnx);
                request.setAttribute("pLesPays", lesCasernes);
                this.getServletContext().getRequestDispatcher("/vues/Pays/ajouterPays.jsp" ).forward( request, response );
            }







        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo() {
            return "Short description";
        }// </editor-fold>

}


