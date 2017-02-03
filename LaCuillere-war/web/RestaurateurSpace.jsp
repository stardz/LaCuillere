<%-- 
    Document   : RestaurateurSpace
    Created on : Jan 30, 2017, 10:36:22 AM
    Author     : Aissa
--%>

<%@page import="entities.Restaurant"%>
<%@page import="entities.Plage"%>
<%@page import="entities.Menu"%>
<%@page import="java.util.List"%>
<%@page import="entities.Annonce"%>
<%@page import="entities.Restaurant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <link rel="stylesheet" type="text/css" href="ClientSpace.css">
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
        <script src="path/to/javascripts/bootstrap-rating-input.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
        <title>Restaurateur Space</title>
        <script>
            var annonce;
            var menu;
            var plage;
            function filterMenus(idAnnonce) {
                $("div[class*='ann']").hide();
                $('.ann_' + idAnnonce).show();
                $('#tab2').tab('show');
            }
            function filterPlages(idAnnonce, idMenu) {
                $("button[class*='plage_an']").hide();
                $('.plage_an' + idAnnonce).show();
                annonce = idAnnonce;
                menu = idMenu;
                //  $('#tab2').tab('show');
            }
            function pushIdPlage(idP) {
                idPlage = idP;
            }
            function addToPanel() {
                alert(annonce + '-' + menu + '-' + idPlage);
                var params = {
                    menu: menu,
                    idPlage: idPlage
                };

                $.post("servletPanel", $.param(params), function (response) {
                    $('.event-list').append(response.toString());
                });
            }
        </script>
    </head>
    <body>
        <%@ include file="Header.html" %>
        <div class="container"><h2>Bienvenue sur La Cuillere :) </h2></div>
        <div id="exTab3" class="container">	
            <ul  class="nav nav-pills">
                <li class="active">
                    <a id="tab1" href="#1b" data-toggle="tab">Restaurants</a>
                </li>
                <li><a id="tab2" href="#2b" data-toggle="tab">Annonces</a>
                </li>
                <li><a id="tab3" href="#3b" data-toggle="tab">Menus</a>
                </li>
            </ul>

            <div class="tab-content clearfix">
                
                <div class="tab-pane active" id="1b">
                     <button class='w3-btn w3-green' style='margin-left: 900px'>Ajouter Restaurant</button>;
                     <br/>;
                    <div style="display: inline-block; overflow-y: scroll; height:800px; width: 100%;">
                        <%
                            List<Restaurant> listeRest = (List<Restaurant>) request.getAttribute("listeRestaurants");
                            for (Restaurant it : listeRest) {
                               // out.println("<br/>");
                                out.println("<div id='ann_" + it.getNomRes()+ "' class='w3-card-12' style='width:250px;height:300px;margin:5px;display:inline-block;'>");
                                out.println("  <img src='imgs/1.png' alt='Restaurant' style='width:100%;height:auto;'>");
                                out.println("  <div class='w3-container w3-center'>");
                                out.println("    <p style='color:blue;'>Nom:" +it.getNomRes()+ "</p>");
                                out.println("    <p style='color:black;'>Adresse:"+ it.getAdresseRes()+ "</p>");
                                out.println("    <p style='color:black;'>Tel:"+ it.getTeleRes()+ "</p>");
//                                out.println("<div>");
                             //   out.println("<p style='color:black;'>Rating : <i class='fa fa-star' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star-half-o' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star-o' aria-hidden='true' style='display: inline-block;'></i></p>");
//                                out.println("</div>");
                               // out.println("<button class='w3-btn w3-green' style='margin-bottom:5px;' onclick='filterMenus(" + it.getIdRestaurant()+ ")'>Voir nos Menus!</button>");
                                out.println("  </div>");
                                out.println("</div>");
                            }
                        %>
                    </div>
                  <a href="jsp/CreateRestaurant.jsp" class="btn btn-info" role="button">Ajouter Restaurant</a>
                </div>
                  
                    
                    <div class="tab-pane " id="2b">
                     <button class='w3-btn w3-green' style='margin-left: 900px'>Ajouter Annonce</button>;
                     <br/>;
                    <div style="display: inline-block; overflow-y: scroll; height:800px; width: 100%;">
                        <%
                            List<Annonce> listeAnnonce = (List<Annonce>) request.getAttribute("listeAnnonces");
                            for (Annonce it : listeAnnonce) {
                               // out.println("<br/>");
                                out.println("<div id='ann_" + it.getDescriptionAnnonce()+ "' class='w3-card-12' style='width:250px;height:300px;margin:5px;display:inline-block;'>");
                                out.println("  <img src='imgs/1.png' alt='Annonce' style='width:100%;height:auto;'>");
                                out.println("  <div class='w3-container w3-center'>");
                                out.println("    <p style='color:blue;'>" +it.getDescriptionAnnonce()+ "</p>");
                                out.println("    <p style='color:black;'>Email:"+ it.getEmailAnnonce()+ "</p>");
                                out.println("    <p style='color:black;'>Tel:"+ it.getTeleAnnonce()+ "</p>");
//                                out.println("<div>");
                             //   out.println("<p style='color:black;'>Rating : <i class='fa fa-star' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star-half-o' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star-o' aria-hidden='true' style='display: inline-block;'></i></p>");
//                                out.println("</div>");
                               // out.println("<button class='w3-btn w3-green' style='margin-bottom:5px;' onclick='filterMenus(" + it.getIdRestaurant()+ ")'>Voir nos Menus!</button>");
                                out.println("  </div>");
                                out.println("</div>");
                            }
                        %>
                    </div>
                      <button class='w3-btn w3-green' >Ajouter Annonce</button>;
                </div>
                    
                    
                                        <div class="tab-pane " id="3b">
                     <button class='w3-btn w3-green' style='margin-left: 900px'>Ajouter Menu</button>;
                     <br/>;
                    <div style="display: inline-block; overflow-y: scroll; height:800px; width: 100%;">
                        <%
                            List<Menu> listeMenu = (List<Menu>) request.getAttribute("listeMenu");
                            for (Menu it : listeMenu) {
                               // out.println("<br/>");
                                out.println("<div id='ann_" + it.getNomMenu()+ "' class='w3-card-12' style='width:250px;height:300px;margin:5px;display:inline-block;'>");
                                out.println("  <img src='imgs/menu.gif' alt='Menu' style='width:100%;height:auto;'>");
                                out.println("  <div class='w3-container w3-center'>");
                                out.println("    <p style='color:blue;'>" +it.getNomMenu()+ "</p>");
                                out.println("    <p style='color:black;'>Desc:"+ it.getDescriptionMenu()+ "</p>");
                                out.println("    <p style='color:black;'>Prix:"+ it.getPrixMenu()+ "</p>");
//                                out.println("<div>");
                             //   out.println("<p style='color:black;'>Rating : <i class='fa fa-star' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star-half-o' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star-o' aria-hidden='true' style='display: inline-block;'></i></p>");
//                                out.println("</div>");
                               // out.println("<button class='w3-btn w3-green' style='margin-bottom:5px;' onclick='filterMenus(" + it.getIdRestaurant()+ ")'>Voir nos Menus!</button>");
                                out.println("  </div>");
                                out.println("</div>");
                            }
                        %>
                    </div>
                      <button class='w3-btn w3-green' >Ajouter Menu</button>;
                </div>
                    
                    
            </div>   

            
    </body>
</html>
