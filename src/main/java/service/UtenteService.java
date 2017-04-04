/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Utenti;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
//La maggior parte delle classi che fanno lavori importanti  vengono annotati con stateless
@Stateless
@Named("utenteSrv")//Indicandogli il nome col quale una pagina jsp può interagire con un oggetto clienteservice.
                   //Se non gli mettiamo il nome jsp prende il nome della classe con la prima lettera minuscola

public class UtenteService {

    //Ci serve l'entity manager
    //Ci viene fornita un'istanza di Entitymanager con le caratt dell'entity manager.
    @PersistenceContext
    EntityManager em;
    
    public Utenti save (Utenti dasalvare){
        return em.merge(dasalvare);
    }
    
    public void delete (Long id){
        Utenti find = em.find(Utenti.class , id);
        em.remove(find);
    }
    
    public List<Utenti> findAll(){
        return em.createNamedQuery(Utenti.FIND_ALL_UTENTI) . getResultList();
    }
    
    public Utenti findByUsername(String usr){
        return em.createNamedQuery
                (Utenti.FIND_UTENTE_BY_USERNAME, Utenti.class).
                setParameter("usr" , usr).
                getSingleResult();
    }
    
    
    public Utenti findByUsrPsw (String usr , String psw){
        return em.createNamedQuery
                (Utenti.FIND_UTENTE_BY_USERNAME_PSW , Utenti.class).
                setParameter("usr", usr).
                setParameter("psw", psw).getSingleResult();
    }
    
    
    
    

}
