/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "WorkDetailsServlet", urlPatterns = {"/work-details"})
public class WorkDetailsServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       response.setContentType("text/html;charset=UTF-8");
       /* try (PrintWriter out = response.getWriter()) {
            String id = request.getParameter("id");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Online Store</title>");            
            out.println("</head>");
            out.println("<body>");
            for(Work work : Catalogue.listOfWorks) {
                if(Long.parseLong(id) == work.getId()){
                    
                    out.print("<div style='width:50%; margin:auto; text-align:center; margin-top:100px;'>");
                    out.print("<img src='" + work.getUrlImg() +"' style='width:30%;'/>");
                    out.print("<h4> Titre : " + work.getTitle() + "</h4>");
                    out.print("<p> Année de réalisation : " + work.getRelease() +"</p>");
                    out.print("<p> Acteur : " + work.getMainArtist().getName() +"</p>");
                    out.print("<p> Genre : " + work.getGenre() +"</p>");
                    out.print("<p> Description : "+work.getSummary()+"</p>");
                    
                    out.print("<form action='addToCart' method='POST'>");
                    out.print("<input type='hidden' name='identifiant' value='" + work.getId()+ "'/>");
                    out.print("<input type=\"submit\" value=\"Ajouter au caddie\"/>");
                    out.print("</form>");

                    out.print("</div>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        }*/
        String id = request.getParameter("id");
        Work work = null;
        for(Work nextWork : Catalogue.listOfWorks) {
            if(Long.parseLong(id) == nextWork.getId()){
                work = nextWork;
                break;
            }
        }
        PrintWriter out = response.getWriter();
        out.print("<html><body><h1 style='text-align:center;'>Descriptif de l'oeuvre</h1>");
        out.print("<div style='width:50%; margin:auto; text-align:center; margin-top:100px;'>");
        out.print("<img src='" + work.getUrlImg() +"' style='width:30%;'/>");
        out.print("<h4> Titre : " + work.getTitle() + "</h4>");
        out.print("<p> Année de réalisation : " + work.getRelease() +"</p>");
        out.print("<p> Acteur : " + work.getMainArtist().getName() +"</p>");
        out.print("<p> Genre : " + work.getGenre() +"</p>");
        out.print("<p> Description : "+work.getSummary()+"</p>");

        out.print("<form action='addToCart' method='POST'>");
        out.print("<input type='hidden' name='identifiant' value='" + work.getId()+ "'/>");
        out.print("<input type=\"submit\" value=\"Ajouter au caddie\"/>");
        out.print("</form>");

        out.print("</div></body></html>");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    

}
