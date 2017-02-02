/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import Interfaces.ReservationInterface;
import entities.Reservation;
import java.util.List;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ibra
 */
@Stateless
@LocalBean
public class ReservationBean implements ReservationInterface {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void ajouterReservation(Reservation r) {
        em.persist(r);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Reservation> getAllReservation() {
       List<Reservation> reservations = (List<Reservation>) em.createNamedQuery("Reservation.findAll").getResultList();
        return reservations;  
    }

    @Override
    public List<Reservation> getReservationByUser(int idUser) {
        List<Reservation> reservations = (List<Reservation>) em.createNamedQuery("Reservation.findByUserReservation").setParameter("idUser", idUser).getResultList();
        return reservations;
    }
}
