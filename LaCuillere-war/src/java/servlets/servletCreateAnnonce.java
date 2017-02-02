/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Interfaces.AnnonceInterface;
import Interfaces.MenuInterface;
import Interfaces.RestaurantInterface;
import Interfaces.UtilisateurInterface;
import entities.Annonce;
import entities.Menu;
import entities.Plage;
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

/**
 *
 * @author dell
 */
public class servletCreateAnnonce extends HttpServlet {

    @EJB
    AnnonceInterface aInterface;
    @EJB
    RestaurantInterface rInterface;
    @EJB
    MenuInterface mInterface;
    @EJB
    UtilisateurInterface uInterface;

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

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Long annonceIdRes = new Long(request.getParameter("annonceIdRes"));
        String teleAnnonce = request.getParameter("teleAnnonce");
        String emailAnnonce = request.getParameter("emailAnnonce");
        String anneAnnonce = request.getParameter("anneAnnonce");
        String moisAnnonce = request.getParameter("moisAnnonce");
        String jourAnnonce = request.getParameter("jourAnnonce");
        Integer heureDebut = new Integer(request.getParameter("heureDebut"));
        Integer heureFin = new Integer(request.getParameter("heureFin"));
        String numPlace = request.getParameter("numPlace");
        String descriptionAnnonce = request.getParameter("descriptionAnnonce");
        Annonce a = new Annonce();

        Restaurant r = rInterface.getRestaurantById(annonceIdRes);
        List<Restaurant> listR = new ArrayList<Restaurant>();
        listR.add(r);
/*
        if (request.getParameterValues("MenuList") != null) {
            String[] MenuList = request.getParameterValues("MenuList");
            List<Menu> listM = new ArrayList<Menu>();
            for (int i = 0; i < MenuList.length; i++) {
                Menu m = new Menu();
                m = mInterface.getMenuById(new Long(MenuList[i]));
                listM.add(m);
            }
            a.setMenuCollection(listM);
        }*/

     /* Utilisateur usr = uInterface.getUser("FANG", "123");
        List<Utilisateur> listU = new ArrayList<Utilisateur>();
        listU.add(usr);
        a.setUtilisateurCollection(listU);

        a.setRestaurantCollection(listR);*/
        a.setTeleAnnonce(teleAnnonce);
        a.setEmailAnnonce(emailAnnonce);
        a.setDescriptionAnnonce(descriptionAnnonce);

        List<Plage> listP = new ArrayList<Plage>();
        for (int i = heureDebut; i <= heureFin; i++) {
            Plage p = new Plage();
            p.setAnnee(new Integer(anneAnnonce));
            p.setMois(new Integer(moisAnnonce));
            p.setJour(new Integer(jourAnnonce));
            p.setHeure(i);
            p.setNombrePlacesPlage(new Integer(numPlace));
            p.setAnnonceIdAnnonce(a);
        }

        a.setPlageCollection(listP);
        aInterface.ajouterAnnonce(a);

        try {
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<title>CreateMenu</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Save your annonce successfully!</h1>");
            out.println("</body></html>");
            out.close();
        } finally {
            out.close();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
