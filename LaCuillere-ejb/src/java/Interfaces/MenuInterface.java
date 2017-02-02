/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import entities.Annonce;
import entities.Menu;
import entities.Utilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dell
 */

@Local
public interface MenuInterface {
    
    public List<Menu> getAllAnonces();
    public void ajouterMenu(Menu m);
    public List<Menu> getMenuByIdRestaurateur(Utilisateur u);
    public Menu getMenuById(Long idMenu);
    public List<Menu> getAllMenus();
    public Menu getMenuById(int idMenu);
       public List<Menu> getMenuByUser(int idUser);
}
