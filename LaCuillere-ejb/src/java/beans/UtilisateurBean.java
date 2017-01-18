/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Interfaces.UtilisateurInterface;
import entities.Utilisateur;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ibra
 */
@Stateless
@LocalBean
public class UtilisateurBean implements UtilisateurInterface {

    @PersistenceContext(unitName = "LaCuillere-ejbPU")
    private EntityManager em;

    @Override
    public Utilisateur getUser(String login, String pass) {
       
       Utilisateur u=new Utilisateur();
       /* u.setNomUsr("test");
        u.setPasswordUser("test");
        return u;*/
        List<Utilisateur> usrs=em.createNamedQuery("Utilisateur.findByNomUsr").setParameter("nomUsr", login).getResultList();
        
        try {
            u= usrs.get(usrs.size()-1);
            if(!u.getPasswordUser().equals(pass))return null;
            else return u;
            
        } catch (Exception e) {
            return null;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void registerUser(Utilisateur usr) {
        em.persist(usr);
    }
}
