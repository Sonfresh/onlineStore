/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.backoffice.controller;

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
@WebServlet(name = "AuthenticationServlet", urlPatterns = {"/login"})
public class AuthenticationServlet extends HttpServlet {


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
        String user = request.getParameter("user");
        String motDePasse  = request.getParameter("motDePasse");
        
        if((user.equals("michel") && motDePasse.equals("123456")) || (user.equals("caroline") && motDePasse.equals("abcdef"))){
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
                out.println("<a href='http://localhost:8080/backoffice-1.0/home'>Page d'accueil</a>");       
                out.println("</body>");
                out.println("</html>");
            }
        }
        else{
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
                out.println("<h1>login / mot de passe erroné</h1>");
                out.println("<a href='http://localhost:8080/backoffice-1.0/login.html'>Tenter à nouveau de s'identifier</a>");       
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

}
