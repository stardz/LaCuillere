/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Interfaces.CategorieInterface;
import Interfaces.RestaurantInterface;
import Interfaces.UtilisateurInterface;
import entities.Categorie;
import entities.Restaurant;
import entities.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dell
 */
public class servletCreateRestaurant extends HttpServlet {

    @EJB
    RestaurantInterface rInterface;
    @EJB
    CategorieInterface cateInterface;
    @EJB
    UtilisateurInterface uInterface;

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

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String nomRes = request.getParameter("nomRes");
        String adressRes = request.getParameter("adressRes");
        String teleRes = request.getParameter("teleRes");
        String emailRes = request.getParameter("emailRes");

        Restaurant r = new Restaurant(new Long("27"));
        r.setNomRes(nomRes);
        r.setTeleRes(teleRes);
        r.setEmailRes(emailRes);
        r.setAdresseRes(adressRes);
       
        HttpSession session = request.getSession();
        Utilisateur usr = (Utilisateur) session.getAttribute("user");
//      Utilisateur usr = uInterface.getUser("FANG", "123");
        r.setRestaurantIdUtilisateur(usr);

        List<Categorie> listcate = new ArrayList<Categorie>();
        if (request.getParameterValues("categorieRes") != null) {
            String[] categorieRes = request.getParameterValues("categorieRes");
            for (int i = 0; i < categorieRes.length; i++) {
                Categorie c = cateInterface.getCateById(new Integer(categorieRes[i]));
                listcate.add(c);
                c.getRestaurantCollection().add(r);
            }
        }
        r.setCategorieCollection(listcate);
        rInterface.ajouterRestaurant(r);

        try {
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<title>CreateMenu</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Save your restaurant successfully!</h1>");
            out.println("</body></html>");
            out.close();
        } finally {
            out.close();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
