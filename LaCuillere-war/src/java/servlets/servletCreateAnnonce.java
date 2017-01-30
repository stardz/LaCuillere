/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Interfaces.AnnonceInterface;
import Interfaces.MenuInterface;
import Interfaces.RestaurantInterface;
import entities.Annonce;
import entities.Menu;
import entities.Restaurant;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class servletCreateAnnonce extends HttpServlet {

    @EJB
    AnnonceInterface aInterface;
    RestaurantInterface rInterface;
    MenuInterface mInterface;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String annonceIdRes = request.getParameter("annonceIdRes");
       String[] MenuList = request.getParameterValues("MenuList");
       String teleAnnonce = request.getParameter("teleAnnonce");
       String emailAnnonce = request.getParameter("emailAnnonce");
       
       Annonce a = new Annonce(new Long("27"));
       
       Restaurant r = new Restaurant();
       r = rInterface.getRestaurantById(new Long(annonceIdRes));
       List<Restaurant> listR = new ArrayList<Restaurant>();
       listR.add(r);
       
       List<Menu> listM = new ArrayList<Menu>();
       for(int i= 0; i<MenuList.length; i++){
           Menu m = new Menu();
           m = mInterface.getMenuById(new Long(MenuList[i]));
           listM.add(m);
       }
       
       /*
       a.setUtilisateurCollection(urs);
       */
       a.setRestaurantCollection(listR);
       a.setMenuCollection(listM);
       a.setTeleAnnonce(teleAnnonce);
       a.setEmailAnnonce(emailAnnonce);
       
       aInterface.ajouterAnnonce(a);
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
