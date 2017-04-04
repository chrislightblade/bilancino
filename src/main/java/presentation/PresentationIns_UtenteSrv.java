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
@WebServlet(urlPatterns = "/utente")
public class PresentationIns_UtenteSrv extends HttpServlet {

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

        Utenti finded = utenteservice.findByUsername(nu);
        Utenti finded2 = utenteservice.findByEmail(email);

        System.out.println(finded);
        System.out.println(finded2);

        if (finded == null) {

            if (finded2 == null) {

                utenteservice.save(u);

                resp.sendRedirect("index.html");
            } else {
                String error = "Email già presente nel DB";
                System.out.println(error);
                /*//resp.sendError(0, error);
                resp.addHeader("errore", "<html><body><div>Email già presente nel DB</div><br><a href=\"index.html\">Torna alla Home</a></body></html>");
                doGet(req, resp);*/
                resp.sendRedirect("errore1.html");
            }

        } else {

            System.out.println("Nome utente già presente nel DB");            
            /*resp.addHeader("errore", "<html><body><div>Nome utente già presente nel DB</div><br><a href=\"index.html\">Torna alla Home</a></body></html>");
            doGet(req, resp);*/
            resp.sendRedirect("errore2.html");
        }

    }

    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("presentation.PresentationIns_UtenteSrv.doGet()");
        resp.sendRedirect("errore.html");
        System.out.println(resp.getHeader("errore"));
        StringBuilder sb = new StringBuilder(resp.getHeader("errore"));
        resp.getWriter().println(sb.toString());        
    }*/

}
