/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;


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

@WebServlet (urlPatterns = "/utente")
public class PresentationIns_UtenteSrv extends HttpServlet{
    
    @Inject
    UtenteService utenteservice;
    
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
         
       String nu = req.getParameter("nome_utente");
       
       String pass = req.getParameter("password");
       
       String email = req.getParameter("email");
       
       Utenti u = new Utenti();
       u.setUsername(nu);
       u.setPassword(pass);
       u.setEmail(email);
       
       utenteservice.save(u);
       
       resp.sendRedirect("index.html");
        
    }
    
    
    
    
    
}
