<%-- 
    Document   : work-details
    Created on : Nov 25, 2019, 6:58:42 PM
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
        <h1 style='text-align:center;'>Descriptif de l'oeuvre</h1>
        
        <div style='width:50%; margin:auto; text-align:center; margin-top:100px;'>
            <img src="${work.urlImg}" style="width:30%;"/>
            <h4> Titre : ${work.title}</h4>
            <p> Année de réalisation : ${work.release}</p>
            <p> Acteur : ${work.mainArtist.name}</p>
            <p> Genre : ${work.genre}</p>
            <p> Description : ${work.summary}</p>

            <form action="addToCart" method="POST">
            <input type="hidden" name="identifiant" value="${work.id}"/>
            <input type="submit" value="Ajouter au caddie"/>
            </form>
        </div>
    </body>
</html>
