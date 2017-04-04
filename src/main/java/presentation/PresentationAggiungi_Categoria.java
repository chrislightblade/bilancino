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
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CategorieService;

/**
 *
 * @author tss
 */

@WebServlet (urlPatterns = "/AddCategoria")
public class PresentationAggiungi_Categoria extends HttpServlet{
    
    @Inject
    CategorieService categorieservice;
    
    @Inject
    SessionData utenteLogged;
    
    @Override
    public void init() throws ServletException {
        super.init(); 
        
        System.out.println("init().... -- Srv_AddCategoria");
    }

    @Override
    public void destroy() {
        super.destroy(); 
        System.out.println("destroy().... -- Srv_AddCategoria");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Categorie c = new Categorie();
        Utenti u = utenteLogged.getUtenteLogged();
        String r = req.getParameter("categoria");
        
        c.setId(r);
        c.setUtente(u);
        
        categorieservice.save(c);
        
        resp.sendRedirect("PP_Utente_Loggato.html");
    }
    
    
}
