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
    
    @Override
    public List<Menu> getAllMenus() {
        List<Menu> menus = (List<Menu>) em.createNamedQuery("Menu.findAll").getResultList();
        return menus;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Menu getMenuById(int idMenu) {
        Menu a=(Menu) em.createNamedQuery("Menu.findByIdMenu").setParameter("idMenu", idMenu).getSingleResult();
        return a;

    }
    
        @Override
    public List<Menu> getAllAnonces() {
        List<Menu> menus=(List<Menu>) em.createNamedQuery("Menu.findAll").getResultList();
        return menus;
    }
    
}
