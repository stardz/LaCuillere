/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Interfaces.PlageInterface;
import entities.Plage;
import java.util.List;
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
public class PlageBean implements PlageInterface{
    @PersistenceContext
    private EntityManager em;
    public void ajouterPlage(Plage p){
          em.persist(p);
    }

   @Override
    public List<Plage> getAllPlages() {
        List<Plage> plages = (List<Plage>) em.createNamedQuery("Plage.findAll").getResultList();
        return plages;    
    }

    @Override
    public Plage getPlageById(int idPlage) {
        Plage a=(Plage) em.createNamedQuery("Plage.findByIdPlage").setParameter("idPlage", idPlage).getSingleResult();
        return a;
    }
}
