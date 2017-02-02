/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Interfaces.ReservationInterface;
import entities.Menu;
import entities.Plage;
import entities.Reservation;
import entities.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
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
public class servletRefreshReservation extends HttpServlet {

    @EJB
    ReservationInterface reservationInterface;

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
            out.println("<title>Servlet servletRefreshReservation</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletRefreshReservation at " + request.getContextPath() + "</h1>");
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
        HttpSession session=request.getSession();
        Utilisateur usr=(Utilisateur)session.getAttribute("user");
        System.out.println("=========================="+usr.getAdressUsr());
        for (Reservation r : reservationInterface.getReservationByUser(usr.getIdUtilisateur())) {
            response.getWriter().write("<tr>");
            response.getWriter().write("<td>"+r.getIdReservation()+"</td>");
            response.getWriter().write("<td>"+((Plage)r.getPlageCollection().toArray()[0]).getJour()+"</td>");
            response.getWriter().write("<td>"+((Menu)r.getMenuCollection().toArray()[0]).getNomMenu()+"</td>");
            response.getWriter().write("<td>"+r.getMenuCollection().size()+"</td>");
            response.getWriter().write("<td>"+r.getMenuCollection().size()+" Eu </td>");
            response.getWriter().write("<td class='text-center'><a class='btn btn-info btn-xs' href='#'><span class='glyphicon glyphicon-edit'></span> Modifier</a> <a href='#' class='btn btn-danger btn-xs'><span class='glyphicon glyphicon-remove'></span> Supprimer</a></td>");
            response.getWriter().write("</tr>");
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
