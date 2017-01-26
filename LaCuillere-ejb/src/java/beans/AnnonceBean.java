/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Interfaces.AnnonceInterface;
import entities.Annonce;
import entities.Utilisateur;
import java.util.ArrayList;
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
public class AnnonceBean implements AnnonceInterface {

    @PersistenceContext(unitName = "LaCuillere-ejbPU")
    private EntityManager em;

    @Override
    public List<Annonce> getAllAnonces() {
        List<Annonce> annonces=(List<Annonce>) em.createNamedQuery("Annonce.findAll").getResultList();
        return annonces;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
