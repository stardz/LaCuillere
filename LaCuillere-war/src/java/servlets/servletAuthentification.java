/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Interfaces.AnnonceInterface;
import Interfaces.MenuInterface;
import Interfaces.PlageInterface;
import Interfaces.RestaurantInterface;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Interfaces.UtilisateurInterface;
import entities.Annonce;
import entities.Menu;
import entities.Plage;
import entities.Restaurant;
import entities.Utilisateur;
import java.util.List;

/**
 *
 * @author Ibra
 */
public class servletAuthentification extends HttpServlet {

    @EJB
    UtilisateurInterface comptesInterface;
    @EJB
    AnnonceInterface annonceInterface;
    @EJB
    PlageInterface plageInterface;
 @EJB
    RestaurantInterface restaurantInterface;
 
  @EJB
    MenuInterface menuInterface;
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
            out.println("<title>Servlet servletAuthentification</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletAuthentification at " + request.getContextPath() + "</h1>");
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
        List<Annonce> listeAnnonce = annonceInterface.getAllAnonces();
        List<Plage> listePlage = plageInterface.getAllPlages();
         List<Restaurant> listeRestaurants = restaurantInterface.getAllRestaurants();
          List<Menu> listeMenu = menuInterface.getAllAnonces();
        Utilisateur usr = comptesInterface.getUser(request.getParameter("user"), request.getParameter("pass"));
        //System.out.println(usr.getPasswordUser());
       request.setAttribute("listeRestaurants", listeRestaurants);
        request.setAttribute("listeAnnonces", listeAnnonce);
        request.setAttribute("listePlage", listePlage);
        request.setAttribute("listeMenu", listeMenu);
        
        if (usr != null) {
            if (usr.getPasswordUser() != null) {
                if (usr.getProfileUsr().equals("CLT")) {
                    getServletConfig().getServletContext().getRequestDispatcher("/ClientSpace.jsp").forward(request, response);
                } else {
                    getServletConfig().getServletContext().getRequestDispatcher("/RestaurateurSpace.jsp").forward(request, response);
                   // response.sendRedirect("RestaurateurHome.html");
                }

            } else {
                response.sendRedirect("Login.html");
            }
        } else {
            response.sendRedirect("Login.html");
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
