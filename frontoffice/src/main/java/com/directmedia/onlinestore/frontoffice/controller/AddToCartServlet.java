/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.ShoppingCart;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/addToCart"})
public class AddToCartServlet extends HttpServlet {


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
       /* HttpSession session = request.getSession();
        String idWork = request.getParameter("identifiant");
        if(ShoppingCart.items.isEmpty()){
            for(Work work : Catalogue.listOfWorks){
                if(Integer.parseInt(idWork) == work.getId()){
                    ShoppingCart.items.add(work);
                    session.setAttribute("caddie", ShoppingCart.items);
                }
            }
        }else{
            ShoppingCart.items = (Set<Work>) session.getAttribute("caddie");
            for(Work work : Catalogue.listOfWorks){
                if(Integer.parseInt(idWork) == work.getId()){
                    ShoppingCart.items.add(work);
                    session.setAttribute("caddie", ShoppingCart.items);
                }
            }
        }*/
        
        /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddToCartServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Œuvre ajoutée au caddie (" + ShoppingCart.items.size() + ")</h1>");
            out.println("<a href='http://localhost:8080/frontoffice-1.0/catalogue'>Accès au catalogue des oeuvres</a>");
            out.println("</body>");
            out.println("</html>");
        }*/
        
        String idAsString = request.getParameter("identifiant");
        long idAsLong = Long.parseLong(idAsString);
        
        ShoppingCart cart = (ShoppingCart)request.getSession().getAttribute("cart");
        //On crée l'attribut de session cart si ce dernier n'existe pas
        if(cart == null){
            cart = new ShoppingCart();
            request.getSession().setAttribute("cart", cart);
        }
        
        /*for(Work work : Catalogue.listOfWorks){
            if(work.getId() == idAsLong){
                cart.getItems().add(work);
            }
        }*/
        
        Optional<Work> optionalWork = Catalogue.listOfWorks.stream().filter(work -> work.getId() == idAsLong).findAny();
        
        if(optionalWork.isPresent()){
            cart.getItems().add(optionalWork.get());
        }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Œuvre ajoutée au caddie (" + cart.getItems().size() + ")</h1>");
        out.println("<a href='http://localhost:8080/frontoffice-1.0/catalogue'>Accès au catalogue des oeuvres</a>");
        out.println("</body>");
        out.println("</html>");
    }

}
