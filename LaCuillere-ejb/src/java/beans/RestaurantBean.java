/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Interfaces.RestaurantInterface;
import entities.Restaurant;
import entities.Utilisateur;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dell
 */
@Stateless
@LocalBean
public class RestaurantBean implements RestaurantInterface{

    @PersistenceContext
   private EntityManager em;
    
    public void ajouterRestaurant(Restaurant r){
      em.persist(r);
    }
    
    public List<Restaurant> getRestaurantByIdRestaurateur(Utilisateur u){             
        Query query = em.createNamedQuery("Restaurant.findByIdRestaurateur");
        List<Restaurant> listR = query.setParameter("u", u).getResultList();
        return listR;
    }
    
    public Restaurant getRestaurantById(Long idRestaurant){
        Restaurant r = new Restaurant(); 
        Query query = em.createNamedQuery("Restaurant.findByIdRestaurant");
        List<Restaurant> list = query.setParameter("idRestaurant", query).getResultList();
        r= list.get(list.size()-1);
        return r;
    }
}
