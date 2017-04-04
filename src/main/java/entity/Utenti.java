/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author tss
 */

    //IMPORTANDE , DA RICORDARSI: IL FROM STA SULLA CLASSE NON SUL TABLENAME.
    //RICORDA: SELECT _ FROM (NOME DELLA CLASSE)
@NamedQueries({
    @NamedQuery(name = Utenti.FIND_ALL_UTENTI , 
            query = "select c from Utenti c order by c.username ASC") ,
    @NamedQuery(name = Utenti.FIND_UTENTE_BY_USERNAME , 
            query = "select c from Utenti c WHERE c.username = :usr") , 
    @NamedQuery(name = Utenti.FIND_UTENTE_BY_USERNAME_PSW , 
            query = "select c from Utenti c where c.username = :usr and c.password = :psw"),
    @NamedQuery(name = Utenti.FIND_UTENTE_BY_EMAIL , 
            query = "select c from Utenti c where c.email = :email")
        
        
})





@Entity       //Specifico che è una entity
@Table (name = "t_utenti") //Così verrà richiamata la classe. anche se 
                         //è uguale lo metto per sicurezza

public class Utenti implements Serializable{
    
    //nomino le query
    public static final String FIND_ALL_UTENTI = "Utenti.findAll";
    public static final String FIND_UTENTE_BY_USERNAME = "Utenti.findByUser";
    public static final String FIND_UTENTE_BY_USERNAME_PSW = "Utenti.findByUserPsw";
    public static final String FIND_UTENTE_BY_EMAIL = "Utenti.findByEmail";
    
    
    //Gli indico che questa è la mia chiave primaria
    @Id
    
    //Generated value è una annotazione che viene applicata sulla chiave primaria
    //Specifica il tipo di strategia da applicare all'id.
    //IDENTITY = Il database metterà in automatico il valore valido seguente.
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    //COLUMN = da una serie di opzioni come ad esempio unique o nullable
    //UNIQUE = nel db ci può essere solo una persona con stesso username
    //NULLABLE = questo campo non può essere lasciato vuoto
    @Column(unique = true , nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String password;
    
    @Column(unique = true , nullable = false)
    private String email;

    
    
    //Costruttore vuoto obbligatorio per db
    public Utenti() {
    }

    //Costruttore completo
    public Utenti(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    
    //Getter e setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
    
    //Equals & hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.username);
        hash = 89 * hash + Objects.hashCode(this.password);
        hash = 89 * hash + Objects.hashCode(this.email);
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
        final Utenti other = (Utenti) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    //ToString
    @Override
    public String toString() {
        return "utente{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + '}';
    }
    
    
       
    
}
