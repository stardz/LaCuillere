/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Interfaces.CategorieInterface;
import Interfaces.RestaurantInterface;
import entities.Categorie;
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
public class servletCreateRestaurant extends HttpServlet {

    @EJB
  RestaurantInterface rInterface;  
  CategorieInterface cateInterface;
  
  
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
       String nomRes = request.getParameter("nomRes");
       String adressRes = request.getParameter("adressRes");
       String teleRes = request.getParameter("teleRes");
       String emailRes = request.getParameter("emailRes");
       String[] categorieRes = request.getParameterValues("categorieRes");
       
       List<Categorie> listcate = new ArrayList<Categorie>();    

       Restaurant r = new Restaurant(new Long("27"));
       r.setNomRes(nomRes);
       r.setTeleRes(teleRes);
       r.setEmailRes(emailRes);
       r.setAdresseRes(adressRes);
       r.setCategorieCollection(listcate);   
       
       /* il faut le session qui a l'id de restaurateur
       r.setRestaurantIdUtilisateur(restaurantIdUtilisateur);
 */
       for(int i = 0; i < categorieRes.length; i++){
           Categorie c = new Categorie();
           c = cateInterface.getCateById(new Integer(categorieRes[i]));
           listcate.add(c);
           c.getRestaurantCollection().add(r);
       }
       
       rInterface.ajouterRestaurant(r);
             
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
