/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.backoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
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
@WebServlet(name = "AddWorkServlet", urlPatterns = {"/add-work"})
public class AddWorkServlet extends HttpServlet {


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
         String title = request.getParameter("titreFilm");
        String annee = request.getParameter("annee");
        String genre = request.getParameter("genre");
        String resume = request.getParameter("resume");
        String urlImg = request.getParameter("urlImg");
        String artist = request.getParameter("artist");
        
        Work work = new Work(title, Integer.parseInt(annee), new Artist(artist), genre, resume, urlImg);
        //Catalogue.listOfWorks = new HashSet<>();
        Catalogue.listOfWorks.add(work);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Online Store</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>OnlineStore - Gestion de la boutique</h1>");
            out.println("<h3>Le film a été ajouté</h3>");
            out.println("<a href='http://localhost:8080/backoffice-1.0/home'>Retourner à la page d'accueil</a>");       
            out.println("</body>");
            out.println("</html>");
        }
    }

   

}
