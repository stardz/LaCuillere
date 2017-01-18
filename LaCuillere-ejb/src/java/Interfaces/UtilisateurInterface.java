/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import entities.Utilisateur;
import javax.ejb.Local;

/**
 *
 * @author Ibra
 */
@Local
public interface UtilisateurInterface {
    public Utilisateur getUser(String login,String pass);
    public void registerUser(Utilisateur usr);
}
