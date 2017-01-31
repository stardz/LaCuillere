/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Interfaces.RestaurantInterface;
import Interfaces.UtilisateurInterface;
import entities.Restaurant;
import entities.Utilisateur;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
public class servletGetRestaurant extends HttpServlet {

     @EJB
      RestaurantInterface rInterface;
    @EJB
      UtilisateurInterface uInterface;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Utilisateur usr = uInterface.getUser("FANG", "123");
            List<Restaurant> listRes = rInterface.getRestaurantByIdRestaurateur(usr);          
            response.getWriter().write("<td> Choose your restaurant : </td><td><select name='annonceIdRes'>");
            for(Restaurant r: listRes){
                response.getWriter().write("<option value ='"+r.getIdRestaurant() +"'>"+  r.getNomRes() +"</option>");
            }     
            response.getWriter().write("</select></td>");
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
