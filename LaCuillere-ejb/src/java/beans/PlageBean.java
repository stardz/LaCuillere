/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Interfaces.PlageInterface;
import entities.Plage;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ibra
 */
@Stateless
@LocalBean
public class PlageBean implements PlageInterface {

    @PersistenceContext(unitName = "LaCuillere-ejbPU")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

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
