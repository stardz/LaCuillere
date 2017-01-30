/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import Interfaces.MenuInterfacel;
import entities.Menu;
import java.util.List;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ibra
 */
@Stateless
@LocalBean
public class MenuBean implements MenuInterfacel {

    @PersistenceContext(unitName = "LaCuillere-ejbPU")
    private EntityManager em;

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
}
