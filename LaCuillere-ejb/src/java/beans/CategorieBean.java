/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Interfaces.CategorieInterface;
import entities.Categorie;
import java.util.ArrayList;
import java.util.Iterator;
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
public class CategorieBean implements CategorieInterface{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Categorie> getCate(){
        System.out.print("======================================================");
        List<Categorie> listC = new ArrayList<Categorie>();       
        Query query = em.createNamedQuery("Categorie.findAll");
        listC = query.getResultList();
        return listC;
    }
    
    @Override
    public Categorie getCateById(Integer id_cate){
        Categorie c = new Categorie();
        List<Categorie> cate = em.createNamedQuery("Categorie.findByIdCate").setParameter("idCate", id_cate).getResultList();
        c = cate.get(cate.size()-1);
        return c;
    }
}
