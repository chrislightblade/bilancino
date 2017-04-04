/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import SessionStorage.SessionData;
import entity.Spese;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */

@Stateless
@Named("speseSrv")
public class SpeseService {
    
    @PersistenceContext
    EntityManager em;
    
    @Inject
    SessionData utenteLogged;
    
    
    
    public List<Spese> findAll(){
        return em.createNamedQuery
                (Spese.FIND_ALL_SPESE , Spese.class).
                getResultList();
    }
    
    /*public List <Spese> findSpeseByUsr( String usr){
        
        return em.createNamedQuery
                (Spese.FIND_ALL_SPESE_BY_USER , Spese.class)
                .setParameter("usr", usr).
                getResultList();
    }*/
    
    public List <Spese> findSpeseById( /*Long id*/){
        
        Long t = utenteLogged.getUtenteLogged().getId();
        
        return em.createNamedQuery
                (Spese.FIND_ALL_SPESE_BY_ID , Spese.class).
                setParameter("id", t).
                getResultList();
    }
    
    public Spese save (Spese dasalvare){
        return em.merge(dasalvare);
    }
    
    public void delete (Long id){
        Spese find = em.find(Spese.class , id);
        em.remove(find);
    }
    
}
