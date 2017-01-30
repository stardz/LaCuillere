/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Interfaces.PlageInterface;
import entities.Plage;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dell
 */
@Stateless
@LocalBean
public class PlageBean implements PlageInterface{
    @PersistenceContext
    private EntityManager em;
    public void ajouterPlage(Plage p){
          em.persist(p);
    }
}
