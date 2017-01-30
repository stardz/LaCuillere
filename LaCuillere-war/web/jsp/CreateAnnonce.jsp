<%-- 
    Document   : CreateAnnonce
    Created on : Jan 29, 2017, 2:45:11 AM
    Author     : dell
--%>

<%@page import="entities.Menu"%>
<%@page import="java.util.List"%>
<%@page import="entities.Restaurant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlets.servletGetRestaurant"  %>
<%@page import="javax.servlet.RequestDispatcher" %>

<!DOCTYPE html>
<html>
    <head>
        <title>CreateADS</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
  <body>
        <div class="head">
           <h1>Create an ads</h1> 
        </div>
        
        <div class="corp">
            <p>Please fill in the form (* is required) </p>
            <form action="servletCreateRestaurant" method="post">
            <table border="0">
                <tr>
                    <td>Choose your restaurant</td>
                    <td>
                       <select name="annonceIdRes">
                    <%
                        RequestDispatcher rd = request.getRequestDispatcher("/servletGetCategorie");
                        List<Restaurant> listR = (List<Restaurant>)request.getAttribute("listR");
                        for(Restaurant r: listR){                           
                     %>
                     <option value =<%= r.getIdRestaurant() %> > <%= r.getNomRes() %></option>
                     <% } %>
                       </select> 
                    </td>
                </tr>
                <tr>
<!--                  <%
                    List<Menu> listM = (List<Menu>)request.getAttribute("listM");
                    out.println("<td rowspan="+listM.size()+">Choose your Menu</td>");
                    out.println(listM.size());
                    for(Menu m: listM){
                        out.println("<td><input type='checkbox' name='MenuList' value='"+m.getIdMenu()+"'/>"+m.getNomMenu()+" - "+m.getPrixMenu()+"</td>");
                    }
                        %>                   -->
                        
                </tr>
                <tr>
                    
                </tr>
                <tr>
                    <td>The available time</td>
                    <td><input type="date" name="dateAnnonce" /> Places numbers : <input type="text" name = "numPlace"></td>
                </tr>
                <tr>
                    <td>Telenumber</td>
                    <td><input type="text" name="teleAnnonce" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="emailAnnonce" /></td>
                </tr>
            </table>
             <br/>
                <input type="submit" value="Submit" />
                <input type="reset" value="Reset" />
        </form>
        </div>
        
        <div class="foot">
            Thanks for visiting our web site!
        </div>
    </body>
</html>
