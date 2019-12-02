<%-- 
    Document   : home
    Created on : Nov 22, 2019, 3:51:31 PM
    Author     : Peterson ALEXIS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/application.js"></script>
        <title>Online Store</title>
    </head>
    <body>
        <%
           String userName = (String)session.getAttribute("identifiantUser"); 
            if(userName != null){
                %>
                <h3>Bonjour ${identifiantUser} <a href='http://localhost:8080/backoffice-1.0/logout'>(Déconnexion)</a></h3>
                <a href='http://localhost:8080/backoffice-1.0/add-work-form.html'>Ajouter une œuvre au catalogue</a><br/>
                    <a href='catalogue'>Afficher le catalogue des oeuvres</a><br/>
                <%
            }else{
                %>
                    <a href='catalogue'>Afficher le catalogue des oeuvres</a>
                <%
            }
        %>
    </body>
</html>
