
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import entities.Annonce;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ibra
 */
@Local
public interface AnnonceInterface {
    public List<Annonce> getAllAnonces();
    public Annonce getAnnonceById(int idAnnonce);
    public void ajouterAnnonce(Annonce a);
 //    public List<Annonce> getAnnonceByUser(int idUser);

}
