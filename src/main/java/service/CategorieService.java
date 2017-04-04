/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Categorie;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */

@Stateless
@Named("categoriaSrv")

public class CategorieService {
    @PersistenceContext
    EntityManager em;
    
    public List<Categorie> findAll(){
        return em.createNamedQuery(Categorie.FIND_ALL_CATEGORIE).getResultList();
    }
    
     public Categorie save (Categorie dasalvare){
        return em.merge(dasalvare);
    }
    
    public void delete (String id){
        Categorie find = em.find(Categorie.class , id);
        em.remove(find);
    
}
}
