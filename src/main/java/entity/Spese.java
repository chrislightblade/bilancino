/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tss
 */

@NamedQueries({
    @NamedQuery (name = Spese.FIND_ALL_SPESE , 
                 query = "select c from Spese c order by c.id ASC") , 
    //@NamedQuery (name = Spese.FIND_ALL_SPESE_BY_USER , 
    //             query = "select c from Spese c WHERE c.utente.username = :usr") , 
    @NamedQuery (name = Spese.FIND_ALL_SPESE_BY_ID , 
                 query = "select c from Spese c WHERE c.utente.id = :id") , 
    @NamedQuery (name = Spese.FIND_ALL_SPESE_7_GG , 
                 query = "SELECT c FROM Spese c WHERE c.dataCreazione BETWEEN :dat2 AND :dat") ,
    @NamedQuery (name = Spese.FIND_ALL_SPESE_31_GG , 
                 query = "SELECT c FROM Spese c WHERE c.dataCreazione BETWEEN :dat2 AND :dat") 
    
})



@Entity
@Table(name = "t_spese")

public class Spese implements Serializable {
    
    
    public static final String FIND_ALL_SPESE_BY_ID = "Spese.findById";
    public static final String FIND_ALL_SPESE = "Spese.findAll";
    public static final String FIND_ALL_SPESE_7_GG = "Spese.find7Gg";
    public static final String FIND_ALL_SPESE_31_GG = "Spese.find31Gg";
    //public static final String FIND_ALL_SPESE_BY_USER = "Spese.findByUser";
    
    
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Mettiamo join column perchè in relazione!
    /*The difference between optional and nullable 
    is the scope at which they are evaluated. 
    The definition of 'optional' talks about property 
    and field values and suggests that this feature should 
    be evaluated within the runtime. 'nullable' 
    is only in reference to database columns. 
     */
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Utenti utente;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Categorie categoria;
    
    @Column(nullable = false)
    private double importo;

    //Serve a dire a jpa che questpo è un campo data
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_CREAZIONE" , nullable = false)
    private Date dataCreazione = new Date();
    
    @Column(nullable = true)
    private String descrizione;

    
    public Spese() {
    }
    
    
    public Spese(Utenti utente, Categorie categoria, double importo, String descrizione) {
        this.utente = utente;
        this.categoria = categoria;
        this.importo = importo;
        this.descrizione = descrizione;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utenti getUtente() {
        return utente;
    }

    public void setUtente(Utenti utente) {
        this.utente = utente;
    }

    public Categorie getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorie categoria) {
        this.categoria = categoria;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.utente);
        hash = 53 * hash + Objects.hashCode(this.categoria);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.importo) ^ (Double.doubleToLongBits(this.importo) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.dataCreazione);
        hash = 53 * hash + Objects.hashCode(this.descrizione);
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
        final Spese other = (Spese) obj;
        if (Double.doubleToLongBits(this.importo) != Double.doubleToLongBits(other.importo)) {
            return false;
        }
        if (!Objects.equals(this.descrizione, other.descrizione)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.utente, other.utente)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.dataCreazione, other.dataCreazione)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "spese{" + "id=" + id + ", utente=" + utente + ", categoria=" + categoria + ", importo=" + importo + ", dataCreazione=" + dataCreazione + ", descrizione=" + descrizione + '}';
    }

    

    
    





}
