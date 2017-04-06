/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionStorage;

import entity.Categorie;
import entity.Utenti;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author tss
 */
@SessionScoped
public class SessionData implements Serializable{
    
    
    private Utenti utenteLogged;
    
    private Categorie categoriaScelta;
    
    private String tempo;
    
    /*private boolean logged = false;

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }*/

    public Utenti getUtenteLogged() {
        return utenteLogged;
    }

    public void setUtenteLogged(Utenti utenteLogged) {
        this.utenteLogged = utenteLogged;
    }

    public Categorie getCategoriaScelta() {
        return categoriaScelta;
    }

    public void setCategoriaScelta(Categorie categoriaScelta) {
        this.categoriaScelta = categoriaScelta;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }
    
    
    
}
