<%-- 
    Document   : ClientSpace
    Created on : Jan 26, 2017, 10:36:22 AM
    Author     : Ibra
--%>

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
        
        <title>Client Space</title>
    </head>
    <body>
        <%@ include file="Header.html" %>
        <h1>Here is your annonces :</h1>
        <br/>
        <%
           List<Annonce> listeAnn=(List<Annonce>)request.getAttribute("listeAnnonces");
           for(Annonce it:listeAnn){
              out.println( it.getIdAnnonce()+it.getDescriptionAnnonce());
              out.print(it.getMenuCollection().toString());
           }
        %>
    </body>
</html>
