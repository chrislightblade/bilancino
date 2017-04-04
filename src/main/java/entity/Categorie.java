/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author tss
 */

@NamedQueries({
    @NamedQuery(name = Categorie.FIND_ALL_CATEGORIE , 
                query = "select c from Categorie c "),
        @NamedQuery(name = Categorie.FIND_CATEGORIE_BY_NOME ,
                query = "select c from Categorie c WHERE c.id = :nome")
})




@Entity
@Table(name = "t_categorie")
public class Categorie implements Serializable{
    
    public static final String FIND_ALL_CATEGORIE = "Categorie.findAll";
    public static final String FIND_CATEGORIE_BY_NOME = "Categorie.findCatByNome";
    
    
    @Id
    private String id;
    
    
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Utenti utente;

    public Categorie() {
    }

    public Categorie(String id, Utenti utente) {
        this.id = id;
        this.utente = utente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Utenti getUtente() {
        return utente;
    }

    public void setUtente(Utenti utente) {
        this.utente = utente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.utente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categorie other = (Categorie) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.utente, other.utente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", utente=" + utente + '}';
    }

    

    

    
    
    
    
    
    
    
}
