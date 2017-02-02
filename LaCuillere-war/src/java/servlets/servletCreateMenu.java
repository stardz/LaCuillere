/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Interfaces.AnnonceInterface;
import Interfaces.MenuInterface;
import Interfaces.UtilisateurInterface;
import entities.Annonce;
import entities.Menu;
import entities.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
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
public class servletCreateMenu extends HttpServlet {

    @EJB
    MenuInterface mInterface;
    @EJB
    UtilisateurInterface uInterface;
    @EJB
    AnnonceInterface annonceInterface;

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

        String nomMenu = request.getParameter("nomMenu");
        String prixMenu = request.getParameter("prixMenu");
        String descriptionMenu = request.getParameter("descriptionMenu");

        Menu m = new Menu();

        m.setNomMenu(nomMenu);
        m.setPrixMenu(new BigInteger(prixMenu));
        m.setDescriptionMenu(descriptionMenu);
        m.setAnnonceIdAnnonce(annonceInterface.getAnnonceById(1));
        HttpSession session = request.getSession();
        Utilisateur usr = (Utilisateur) session.getAttribute("user");
        
//       Utilisateur usr = uInterface.getUser("FANG", "123");
        m.setMenuIdUtilisateur(usr);

        mInterface.ajouterMenu(m);
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<title>CreateMenu</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Save your menu successfully!</h1>");
            out.println("</body></html>");
            out.close();
        } finally {
            out.close();
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
