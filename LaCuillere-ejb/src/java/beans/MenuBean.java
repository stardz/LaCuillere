/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import entities.Menu;
import Interfaces.MenuInterface;
import entities.Utilisateur;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
/**
 *
 * @author dell
 */
@Stateless
@LocalBean
public class MenuBean implements MenuInterface{

    @PersistenceContext
    private EntityManager em;
    
    public void ajouterMenu(Menu m){
        em.persist(m);
    }
    
    public List<Menu> getMenuByIdRestaurateur(Utilisateur u){
        List<Menu> listM = new ArrayList<Menu>();
        Query query = em.createNamedQuery("Menu.findByIdRestaurateur");
        listM = query.setParameter("menuRestaurateur", u).getResultList();
        return listM;
    }
    
    public Menu getMenuById(Long idMenu){
        Menu m = new Menu();
        Query query = em.createNamedQuery("Menu.findByIdMenu");
        List<Menu> listM = new ArrayList<Menu>();
        listM = query.setParameter("idMenu", idMenu).getResultList();
        m = listM.get(listM.size()-1);
        return m;
    }
}
