/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import entities.Plage;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ibra
 */
@Local
public interface PlageInterface {
    public List<Plage> getAllPlages();
    public Plage getPlageById(int idPlage);
}
