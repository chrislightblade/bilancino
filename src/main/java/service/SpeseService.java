/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import SessionStorage.SessionData;
import entity.Categorie;
import entity.FunzioniData;
import entity.Spese;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
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

    public List<Spese> findAll() {
        return em.createNamedQuery(Spese.FIND_ALL_SPESE, Spese.class).
                getResultList();
    }

    public List<Spese> scegli(String tempo, String cat_id) {
        if (tempo.isEmpty() || cat_id.isEmpty()) {
            System.out.println("parametri vuoti");
            return null;
        }
        System.out.println(tempo + "," + cat_id);
        if (tempo.equals("7gg")) {
            return findSpeseByCategoriaAnd7Gg(cat_id);
        } else if (tempo.equals("1mese")) {
            return findSpeseByCategoriaAnd1Mese(cat_id);
        } else if (tempo.equals("tutto")) {
            return findSpeseByCate(cat_id);
        } else {
            return null;
        }

    }

    /*public List <Spese> findSpeseByUsr( String usr){
        
        return em.createNamedQuery
                (Spese.FIND_ALL_SPESE_BY_USER , Spese.class)
                .setParameter("usr", usr).
                getResultList();
    }*/
    public List<Spese> findSpeseById( /*Long id*/) {

        Long t = utenteLogged.getUtenteLogged().getId();

        return em.createNamedQuery(Spese.FIND_ALL_SPESE_BY_ID, Spese.class).
                setParameter("id", t).
                getResultList();   
    }

    public List<Spese> findSpese7Gg( /*Long id*/) {

        Date dataoggi = new Date();

        LocalDate oggi = LocalDate.now();
        Period p = Period.ofDays(7);
        LocalDate minus = oggi.minus(p);

        System.out.println("La data menu 7 giorni è: " + minus);

        return em.createNamedQuery(Spese.FIND_ALL_SPESE_7_GG, Spese.class).
                setParameter("dat", dataoggi).
                setParameter("dat2", FunzioniData.converti(minus)).
                getResultList();
    }

    public List<Spese> findSpese1Mese( /*Long id*/) {

        Date dataoggi = new Date();

        LocalDate oggi = LocalDate.now();
        Period p = Period.ofMonths(1);
        LocalDate minus = oggi.minus(p);

        System.out.println("La data menu 31 giorni è: " + minus);

        /*Calendar cal = Calendar.getInstance();        
        cal.add(Calendar.DATE, -31);
        Date dateBefore31Days = cal.getTime();*/
        return em.createNamedQuery(Spese.FIND_ALL_SPESE_1_MESE, Spese.class).
                setParameter("dat", dataoggi).
                setParameter("dat2", FunzioniData.converti(minus)).
                getResultList();
    }

    public List<Spese> findSpeseByCategoriaAnd7Gg(String cat_id) {

        Categorie c = em.find(Categorie.class, cat_id);

        Date dataoggi = new Date();

        LocalDate oggi = LocalDate.now();
        Period p = Period.ofDays(7);
        LocalDate minus = oggi.minus(p);

        System.out.println("La data menu 31 giorni è: " + minus);

        return em.createNamedQuery(Spese.FIND_ALL_BY_CATEGORY_AND_7GG, Spese.class).
                setParameter("dat", dataoggi).
                setParameter("dat2", FunzioniData.converti(minus)).
                setParameter("cat", c).
                getResultList();
    }

    public List<Spese> findSpeseByCategoriaAnd1Mese(String cat_id) {

        Categorie c = em.find(Categorie.class, cat_id);

        Date dataoggi = new Date();

        LocalDate oggi = LocalDate.now();
        Period p = Period.ofMonths(1);
        LocalDate minus = oggi.minus(p);

        System.out.println("La data menu 31 giorni è: " + minus);

        return em.createNamedQuery(Spese.FIND_ALL_BY_CATEGORY_AND_1_MESE, Spese.class).
                setParameter("dat", dataoggi).
                setParameter("dat2", FunzioniData.converti(minus)).
                setParameter("cat", c).
                getResultList();
    }
    
    public List<Spese> findSpeseByCate(String cat_id) {
        Categorie c = em.find(Categorie.class, cat_id);
        return em.createNamedQuery(Spese.FIND_ALL_BY_CATEGORY, Spese.class).setParameter("cat", c).getResultList();        
    }

    public Spese save(Spese dasalvare) {
        return em.merge(dasalvare);
    }

    public void delete(Long id) {
        Spese find = em.find(Spese.class, id);
        em.remove(find);
    }

    
}
