/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;


import SessionStorage.SessionData;
import entity.Utenti;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UtenteService;

/**
 *
 * @author tss
 */

@WebServlet (urlPatterns = "/utenteLog")
public class PresentationLogin_UtenteSrv extends HttpServlet{
    
    @Inject
    UtenteService utenteservice;
    
    @Inject
    SessionData utenteLogged;
    
    @Override
    public void init() throws ServletException {
        super.init(); 
        
        System.out.println("init()....");
    }

    @Override
    public void destroy() {
        super.destroy(); 
        System.out.println("destroy()....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
         //vado a leggere quello che ha inserito l'utente.
         
       if(utenteLogged == null){  
         
       String nu = req.getParameter("nome_utente");
       
       String pass = req.getParameter("password");
       
       if(nu != null && pass != null){
           
       Utenti utenteL = utenteservice.findByUsrPsw( nu , pass);
       utenteLogged.setUtenteLogged(utenteL);
       }else{
           System.out.println("Campo/i non compilati");
           
       }
       
       //fare verifica se c'è utente su db
       
        
       resp.sendRedirect("PP_Utente_Loggato.html");
       }
    }
    
    
    
    
    
}
