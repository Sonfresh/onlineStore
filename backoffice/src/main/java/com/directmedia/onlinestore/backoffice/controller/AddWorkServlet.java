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
import java.util.Optional;
import javax.servlet.RequestDispatcher;
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
        
        Work workAdd = null;
        boolean doublonExist = false;
        
        try{
            workAdd = new Work(title, Integer.parseInt(annee), new Artist(artist), genre, resume, urlImg);
            for(Work work : Catalogue.listOfWorks){
                if(work.getTitle().equals(workAdd.getTitle()) && work.getRelease() == workAdd.getRelease()){
                    doublonExist = true; 
                    break;
                }
            }
            
            if(doublonExist){
                RequestDispatcher dispatcher = request.getRequestDispatcher("/error");
                dispatcher.forward(request, response);
            }else{
                Catalogue.listOfWorks.add(workAdd);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/success");
                dispatcher.forward(request, response);
            }
        }catch(NumberFormatException nfe){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/error");
            dispatcher.forward(request, response);
        }
        
    }

   

}
