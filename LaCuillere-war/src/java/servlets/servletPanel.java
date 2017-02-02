/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Interfaces.AnnonceInterface;
import Interfaces.MenuInterface;
import Interfaces.PlageInterface;
import entities.Annonce;
import entities.Menu;
import entities.Plage;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import javax.ejb.EJB;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ibra
 */
public class servletPanel extends HttpServlet {

    @EJB
    AnnonceInterface annonceInterface;
    @EJB
    PlageInterface plageInterface;
    @EJB
    MenuInterface menuInterface;
   
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
            out.println("<title>Servlet servletPanel</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletPanel at " + request.getContextPath() + "</h1>");
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
        
        ArrayList<String> months=new ArrayList<String>(Arrays.asList("Jan", "Fev", "Mar", "Avr", "Mai", "Jun", "Jui", "Aou", "Sep", "Oct", "Nov", "Dec"));
//        int idAnnonce = Integer.parseInt(request.getParameter("annonce"));
//        Annonce a = annonceInterface.getAnnonceById(idAnnonce);
        Plage pge = plageInterface.getPlageById(Integer.parseInt(request.getParameter("idPlage"))); // request.setAttribute("annonce", listeAnnonce);
        Menu menu = menuInterface.getMenuById(Integer.parseInt(request.getParameter("menu"))); // request.setAttribute("annonce", listeAnnonce);
        
        response.setContentType("text/html");
        response.getWriter().write("<li>");
        response.getWriter().write("<span class='ids_res' id='"+menu.getIdMenu()+"-"+pge.getIdPlage()+"'></span>");
        response.getWriter().write("<time datetime='2014-07-31 1600'>");
        response.getWriter().write("<span class='day'>"+pge.getJour()+"</span>");
        response.getWriter().write("<span class='month'>"+months.get(pge.getMois()-1)+"</span>");
        response.getWriter().write("<span class='year'>"+pge.getAnnee()+"</span>");
        response.getWriter().write("<span class='time'>"+pge.getHeure()+"</span>");
        response.getWriter().write("</time>");
        response.getWriter().write("<img alt='Disney Junior Live On Tour!' src='imgs/table-restaurant.jpg' />");
        response.getWriter().write("<div class='info'>");
        response.getWriter().write("<h2 class='title'>"+menu.getNomMenu()+"</h2>");
        response.getWriter().write("<p class='desc'>"+menu.getAnnonceIdAnnonce().getRestaurantCollection().toArray()[0].toString()+"</p>");
        response.getWriter().write("<ul>");
        response.getWriter().write("<li style='width:33%;'><span class='fa fa-eur'></span><span class='prixpart'>"+menu.getPrixMenu().multiply(new BigInteger(pge.getNombrePlacesPlage()+""))+"</span> € </li>");
        response.getWriter().write("<li style='width:34%;'><span class='fa fa-male'></span>"+pge.getNombrePlacesPlage()+"</li>");
        response.getWriter().write("</ul>");
        response.getWriter().write("</div>");
        response.getWriter().write("<div class='social'>");
        response.getWriter().write("<ul>");
        response.getWriter().write("<li class='facebook' style='width:33%;'><a href='#facebook'><span class='fa fa-facebook'></span></a></li>");
        response.getWriter().write("<li class='twitter' style='width:34%;'><a href='#twitter'><span class='fa fa-twitter'></span></a></li>");
        response.getWriter().write("<li class='google-plus' style='width:33%;'><a href='#google-plus'><span class='fa fa-google-plus'></span></a></li>");
        response.getWriter().write("</ul>");
        response.getWriter().write("</div>");
        response.getWriter().write("</li>");
        
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
