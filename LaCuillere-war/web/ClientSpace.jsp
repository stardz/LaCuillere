<%-- 
    Document   : ClientSpace
    Created on : Jan 26, 2017, 10:36:22 AM
    Author     : Ibra
--%>

<%@page import="entities.Menu"%>
<%@page import="java.util.List"%>
<%@page import="entities.Annonce"%>
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
        <title>Client Space</title>
        <script>
            function filterMenus(idAnnonce){
//                alert(''+idAnnonce);
//                $('[class^="ann_"]').show();
//                $( ".ann_"+idAnnonce).hide();
//                  $('.ann_'+idAnnonce).hide();
                alert($('[class^="ann_"]').toArray().length);
            }
        </script>
    </head>
    <body>
        <%@ include file="Header.html" %>
        <div class="container"><h2>Bienvenue sur La Cuillere :) </h2></div>
        <div id="exTab3" class="container">	
            <ul  class="nav nav-pills">
                <li class="active">
                    <a  href="#1b" data-toggle="tab">Annonces</a>
                </li>
                <li><a href="#2b" data-toggle="tab">Menus</a>
                </li>
                <li><a href="#3b" data-toggle="tab">Mon Panier</a>
                </li>
                <li><a href="#4a" data-toggle="tab">Mes réservations</a>
                </li>
            </ul>

            <div class="tab-content clearfix">
                <div class="tab-pane active" id="1b">
                    <div style="display: inline-block; overflow-y: scroll; height:800px; width: 100%;">
                        <%
                            List<Annonce> listeAnn = (List<Annonce>) request.getAttribute("listeAnnonces");
                            for (Annonce it : listeAnn) {
//                                out.println("<br/>");
                                out.println("<div id='ann_" + it.getIdAnnonce() + "' class='w3-card-12' style='width:250px;height:300px;margin:5px;display:inline-block;'>");
                                out.println("  <img src='imgs/table-restaurant.png' alt='Annonce' style='width:100%;height:auto;'>");
                                out.println("  <div class='w3-container w3-center'>");
                                out.println("    <p style='color:black;'>" + it.getDescriptionAnnonce() + "</p>");
                                out.println("    <p style='color:black;'>" + "Restaurant La ROZA" + "</p>");
//                                out.println("<div>");
                                out.println("<p style='color:black;'>Rating : <i class='fa fa-star' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star-half-o' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star-o' aria-hidden='true' style='display: inline-block;'></i></p>");
//                                out.println("</div>");
                                out.println("<button class='w3-btn w3-green' style='margin-bottom:5px;' onclick='filterMenus("+it.getIdAnnonce()+")'>Voir nos Menus!</button>");
                                out.println("  </div>");
                                out.println("</div>");
                            }
                        %>
                    </div>
                </div>
                <div class="tab-pane" id="2b">
                    <div style="display: inline-block; overflow-y: scroll; height:800px; width: 100%;">
                        <%
//                            List<Annonce> listeAnn = (List<Annonce>) request.getAttribute("listeAnnonces");
                            for (Annonce it : listeAnn) {
//                                out.println("<br/>");
                                for (Menu it2 : it.getMenuCollection()) {
                                    out.println("<div id='men_" + it2.getIdMenu() + "' class='w3-card-12 ann_"+it.getIdAnnonce()+"' style='width:250px;height:300px;margin:5px;display:inline-block;'>");
                                    out.println("  <img src='imgs/steakdeviande-autres.jpg' alt='Menu' style='width:100%;height:auto;'>");
                                    out.println("  <div class='w3-container w3-center'>");
                                    out.println("    <p style='color:black;display: inline-block;'>" + it2.getNomMenu() + "</p>");
                                    out.println(" <span class='label label-primary';display: inline-block;>" +" "+ it2.getPrixMenu() + " € " + "</span>");
                                    out.println("    <p style='color:black;'>" + it2.getDescriptionMenu() + "</p>");

//                                out.println("<div>");
                                    out.println("<p style='color:black;'>Rating : <i class='fa fa-star' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star-half-o' aria-hidden='true' style='display: inline-block;'></i><i class='fa fa-star-o' aria-hidden='true' style='display: inline-block;'></i></p>");
//                                out.println("</div>");
                                    out.println("<button class='w3-btn w3-green' style='margin-bottom:5px;'> Reserver </button>");
                                    out.println("  </div>");
                                    out.println("</div>");
                                }
                            }
                        %>
                    </div>
                </div>
                <div class="tab-pane" id="3b">
                    <h3>We applied clearfix to the tab-content to rid of the gap between the tab and the content</h3>
                </div>
                <div class="tab-pane" id="4b">
                    <h3>We use css to change the background color of the content to be equal to the tab</h3>
                </div>
            </div>
        </div>

    </body>
</html>
