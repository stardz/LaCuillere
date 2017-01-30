<%-- 
    Document   : testCate
    Created on : Jan 28, 2017, 4:07:42 PM
    Author     : dell
--%>

<%@page import="java.util.List"%>
<%@page import="entities.Categorie"%>
<%@page import="java.util.ArrayList"%>
<%@page import="servlets.servletGetCategorie" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%
            List<Categorie> list = (List<Categorie>) request.getAttribute("listCate");
              out.println(list.size());
            %>
    </body>
</html>
