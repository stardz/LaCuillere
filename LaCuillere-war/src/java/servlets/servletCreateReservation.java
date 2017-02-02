/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Interfaces.PlageInterface;
import Interfaces.ReservationInterface;
import Interfaces.UtilisateurInterface;
import Interfaces.MenuInterface;
import entities.Date;
import entities.Menu;
import entities.Plage;
import entities.Reservation;
import entities.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.list;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ibra
 */
public class servletCreateReservation extends HttpServlet {
     @EJB
     ReservationInterface reservationInterface;
     @EJB
     PlageInterface plageInterface;
     @EJB
     MenuInterface menuInterface;
     @EJB
     UtilisateurInterface utilisateurInterface;
     
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
            out.println("<title>Servlet servletCreateReservation</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletCreateReservation at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        Reservation r=new Reservation();
        ArrayList<Menu> arrMenu=new ArrayList<Menu>();
        ArrayList<Plage> arrPlage=new ArrayList<Plage>();
        ArrayList<Utilisateur> arrUtilisateur=new ArrayList<Utilisateur>();
        ArrayList<Date> arrDate=new ArrayList<Date>();
        HttpSession session=request.getSession();
        Utilisateur usr=(Utilisateur)session.getAttribute("user");
        Date date = new Date();
        java.util.Date dte=new java.util.Date();
        date.setDateDate(dte);
        String str = request.getParameter("ids");
        arrDate.add(date);
        arrUtilisateur.add(usr);
        for (String p : str.split(",")) {
               arrMenu.add(menuInterface.getMenuById(new Long(p.split("-")[0])));
               arrPlage.add(plageInterface.getPlageById(Integer.parseInt(p.split("-")[1])));
              
        }
//        r.setIdReservation(new Long(2));
        r.setDateCollection(arrDate);
        r.setMenuCollection(arrMenu);
        r.setPlageCollection(arrPlage);
        r.setUtilisateurCollection(arrUtilisateur);
        reservationInterface.ajouterReservation(r);
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
