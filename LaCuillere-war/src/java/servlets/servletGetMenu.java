/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Interfaces.MenuInterface;
import Interfaces.UtilisateurInterface;
import entities.Menu;
import entities.Utilisateur;
import java.io.IOException;
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
public class servletGetMenu extends HttpServlet {

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
        HttpSession session = request.getSession();
        Utilisateur usr = (Utilisateur) session.getAttribute("user");
        List<Menu> listMenu = mInterface.getMenuByIdRestaurateur(usr.getIdUtilisateur());
        System.out.println("===================="+listMenu.toString()+"===============");
        response.getWriter().write("<td> Choose your menu</td>");
            for(Menu m: listMenu){
                response.getWriter().write("<td><input type='checkbox' name='MenuList' value='"+m.getIdMenu()+"'/>"+m.getNomMenu()+"</td>");
            }       
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
