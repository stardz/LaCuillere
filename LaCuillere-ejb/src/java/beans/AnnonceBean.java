/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Interfaces.AnnonceInterface;
import entities.Annonce;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dell
 */
@Stateless
@LocalBean
public class AnnonceBean implements AnnonceInterface{

    @PersistenceContext
    private EntityManager em;
    
     public void ajouterAnnonce(Annonce a){
         em.persist(a);
     }
}
