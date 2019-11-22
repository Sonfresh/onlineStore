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
        
        boolean success = true;
        String title = request.getParameter("titreFilm");
        String annee = request.getParameter("annee");
        String genre = request.getParameter("genre");
        String resume = request.getParameter("resume");
        String urlImg = request.getParameter("urlImg");
        String artist = request.getParameter("artist");
        
        Work workAddAnne = new Work();
        try{
            workAddAnne.setRelease(Integer.parseInt(annee));
         }catch(NumberFormatException nfe){
            success = false;
            //RequestDispatcher dispatcher = request.getRequestDispatcher("/error");
            //dispatcher.forward(request, response);
        }
        
        
        
          Work  workAdd = new Work(title, workAddAnne.getRelease(), new Artist(artist), genre, resume, urlImg);
           /* for(Work work : Catalogue.listOfWorks){
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
            }*/
       
        
        Optional<Work> optionalWork = Catalogue.listOfWorks.stream().filter(work -> work.getTitle().equals(workAdd.getTitle()) && work.getRelease() == workAdd.getRelease()).findAny();
        if(optionalWork.isPresent()){
            success = false;
        }
        
        RequestDispatcher dispatcher = null;
        
        if(success){
            Catalogue.listOfWorks.add(workAdd);
            dispatcher = request.getRequestDispatcher("/success");
            dispatcher.forward(request, response);
        }else{
            dispatcher = request.getRequestDispatcher("/error");
            dispatcher.forward(request, response);
        }
        
    }

   

}
