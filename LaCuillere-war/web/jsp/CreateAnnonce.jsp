<%-- 
    Document   : CreateAnnonce
    Created on : Jan 29, 2017, 2:45:11 AM
    Author     : dell
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>CreateADS</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
  <body>
        <div class="head">
           <h1>Create an ads</h1> 
        </div>
        
        <div class="corp">
            <p>Please fill in the form (* is required) </p>
            <form action="../servletCreateAnnonce" method="post">
            <table border="1">
               <tr id="listRes"> 
                <script>                  
                    $.post("../servletGetRestaurant", function (response) {
                        $('#listRes').append(response.toString());
                });  
                </script>                  
                </tr>
                <tr id="listMenu"> 
                <script>                  
                    $.post("../servletGetMenu", function (response) {
                        $('#listMenu').append(response.toString());
                });  
                </script>                  
                </tr>
                <tr>
                    <td>The available time :</td>
                    <td>
                        <ul>
                            <li>An:<input type="text" name="anneAnnonce" required="required" /></li>
                            <li>Month:<input type="text" name="moisAnnonce" required="required" /></li>
                            <li>Day:<input type="text" name="jourAnnonce" required="required" /></li>
                        </ul>
                    </td>
                </tr>
                <tr>
                    <td>Strat Hour : </td>
                    <td><input type="text" name="heureDebut" required="required" /></td>
                </tr>
                <tr>
                    <td>End Hour : </td>
                    <td><input type="text" name="heureFin" required="required" /></td>
                </tr>
                <tr>
                    <td>Places numbers : </td>
                    <td><input type="text" name = "numPlace" required="required" /></td>
                </tr>
                <tr>
                    <td>Telenumber : </td>
                    <td><input type="text" name="teleAnnonce" /></td>
                </tr>
                <tr>
                    <td>Email : </td>
                    <td><input type="text" name="emailAnnonce" /></td>
                </tr>
                <tr>
                    <td>Description :</td>
                    <td><input type="text" name="descriptionAnnonce" /></td>
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
