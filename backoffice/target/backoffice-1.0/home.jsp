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
        <title>Online Store</title>
    </head>
    <body>
        <h1>OnlineStore - Gestion de la boutique</h1>
        <%
           String userName = (String)session.getAttribute("identifiantUser"); 
            if(userName != null){
                %>
                <h3>Bonjour <%=userName%> <a href='http://localhost:8080/backoffice-1.0/logout'>(Déconnexion)</a></h3>
                    <a href='http://localhost:8080/backoffice-1.0/catalogue.jsp'>Accès au catalogue des oeuvres</a><br/>
                    <a href='http://localhost:8080/backoffice-1.0/add-work-form.html'>Ajouter une œuvre au catalogue</a>
                <%
            }else{
                %>
                    <a href='http://localhost:8080/backoffice-1.0/catalogue.jsp'>Accès au catalogue des oeuvres</a>
                <%
            }
        %>
    </body>
</html>
