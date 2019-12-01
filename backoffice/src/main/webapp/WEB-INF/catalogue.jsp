<%-- 
    Document   : catalogue.jsp
    Created on : Nov 22, 2019, 8:32:00 PM
    Author     : Peterson ALEXIS
--%>

<%@page import="com.directmedia.onlinestore.core.entity.Artist"%>
<%@page import="com.directmedia.onlinestore.core.entity.Work"%>
<%@page import="com.directmedia.onlinestore.core.entity.Catalogue"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Store</title>
    </head>
    <body>
        
        <h1 style='text-align: center; margin-top:100px;'> Catalogue </h1>
        <c:forEach items="${catalogue}" var="work">
            <div style='width:25%; float:left; text-align:center; background:#efefef; padding:40px 0px; margin:2px;' >
                <img src="${work.urlImg}" style='width:300px; height:200px;'/>
                <p> <a href="http://localhost:8080/backoffice-1.0/work-details?id=${work.id}">${work.title}</a></p>
                <p>Année de sortie : ${work.release}</p>
            </div>
        </c:forEach>
    </body>
</html>
