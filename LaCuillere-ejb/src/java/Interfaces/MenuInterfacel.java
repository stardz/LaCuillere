/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import entities.Menu;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ibra
 */
@Local
public interface MenuInterfacel {
    public List<Menu> getAllMenus();
    public Menu getMenuById(int idMenu);
}
