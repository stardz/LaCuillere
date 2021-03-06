/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import entities.Restaurant;
import entities.Utilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dell
 */
@Local
public interface RestaurantInterface {
    public List<Restaurant> getAllRestaurants();
    public void ajouterRestaurant(Restaurant r);
    public List<Restaurant> getRestaurantByIdRestaurateur(Utilisateur u);
    public Restaurant getRestaurantById(Long idRestaurant);
      public List<Restaurant> getRestaurantByUser(int idUser);
}
