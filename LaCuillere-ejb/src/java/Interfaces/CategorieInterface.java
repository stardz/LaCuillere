/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import entities.Categorie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dell
 */
@Local
public interface CategorieInterface {
     public List<Categorie> getCate();
     public Categorie getCateById(Integer id_cate);
}
