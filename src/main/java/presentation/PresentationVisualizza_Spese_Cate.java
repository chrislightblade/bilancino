/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import SessionStorage.SessionData;
import entity.Categorie;
import entity.Utenti;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SpeseService;

/**
 *
 * @author tss
 */
@WebServlet (urlPatterns = "/speseCate")
public class PresentationVisualizza_Spese_Cate extends HttpServlet{
    
    @Inject
    SessionData utenteLogged;
    
    @Inject
    SpeseService speseService;

      
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Utenti u = new Utenti();
        u = utenteLogged.getUtenteLogged();
        
        Categorie c = new Categorie();
        c.setId(req.getParameter("categoria"));
        c.setUtente(u);
        
        utenteLogged.setCategoriaScelta(c);
        
        utenteLogged.setTempo(req.getParameter("tempo"));
        resp.sendRedirect("visualizza_spese_per_cat.jsp");
        
    }
    
    
    
}
