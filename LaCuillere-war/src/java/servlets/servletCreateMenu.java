/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Interfaces.MenuInterface;
import entities.Menu;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
public class servletCreateMenu extends HttpServlet {
    
    @EJB
     MenuInterface mInterface;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomMenu = request.getParameter("nomMenu");
        String prixMenu = request.getParameter("prixMenu");
        String descriptionMenu = request.getParameter("descriptionMenu");
        
        
        Menu m = new Menu(new Long("27"));
        m.setNomMenu(nomMenu);
        m.setPrixMenu(new BigInteger(prixMenu));
     
     /*   il faut le session qui a l'id de restaurateur
        m.setMenuIdUtilisateur(menuIdUtilisateur);
     */   
        mInterface.ajouterMenu(m);
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
