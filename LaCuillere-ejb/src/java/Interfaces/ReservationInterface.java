/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import entities.Reservation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ibra
 */
@Local
public interface ReservationInterface {
    public void ajouterReservation(Reservation r);
    public List<Reservation> getAllReservation();
    public List<Reservation> getReservationByUser(int idUser);
}
