<%-- 
    Document   : CreateRestaurant
    Created on : Jan 28, 2017, 2:38:56 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>CreateRestaurant</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="head">
           <h1>Create a new restaurant</h1> 
        </div>
        
        <div class="corp">
            <p>Please fill in the form (* is required) </p>
            <form action="servletCreateRestaurant" method="post">
            <table border="0">
                <tr>
                    <td>Name*</td>
                    <td><input type="text" name="nomRes" required="required" /></td>
                </tr>
                <tr>
                    <td>Adress</td>
                    <td><input type="text" name="adressRes" required="required" ></td>
                </tr>
                <tr>
                    <td>Telenumber</td>
                    <td><input type="text" name="teleRes" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="emailRes" /></td>
                </tr>
                <tr id="listCate"> 
                <script>                  
                    $.post("../servletGetCategorie", function (response) {
                        $('#listCate').append(response.toString());
                });  
                </script>                  
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
