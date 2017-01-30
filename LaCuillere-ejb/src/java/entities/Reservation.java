/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "reservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
    @NamedQuery(name = "Reservation.findByIdReservation", query = "SELECT r FROM Reservation r WHERE r.idReservation = :idReservation"),
    @NamedQuery(name = "Reservation.findByEtatReservation", query = "SELECT r FROM Reservation r WHERE r.etatReservation = :etatReservation")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_reservation")
    private Long idReservation;
    @Size(max = 255)
    @Column(name = "etat_reservation")
    private String etatReservation;
    @ManyToMany(mappedBy = "reservationCollection")
    private Collection<Date> dateCollection;
    @ManyToMany(mappedBy = "reservationCollection")
    private Collection<Menu> menuCollection;
    @ManyToMany(mappedBy = "reservationCollection")
    private Collection<Plage> plageCollection;
    @JoinTable(name = "utilisateur_reservation", joinColumns = {
        @JoinColumn(name = "reservations_id_reservation", referencedColumnName = "id_reservation")}, inverseJoinColumns = {
        @JoinColumn(name = "utilisateur_id_utilisateur", referencedColumnName = "id_utilisateur")})
    @ManyToMany
    private Collection<Utilisateur> utilisateurCollection;

    public Reservation() {
    }

    public Reservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public String getEtatReservation() {
        return etatReservation;
    }

    public void setEtatReservation(String etatReservation) {
        this.etatReservation = etatReservation;
    }

    @XmlTransient
    public Collection<Date> getDateCollection() {
        return dateCollection;
    }

    public void setDateCollection(Collection<Date> dateCollection) {
        this.dateCollection = dateCollection;
    }

    @XmlTransient
    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    @XmlTransient
    public Collection<Plage> getPlageCollection() {
        return plageCollection;
    }

    public void setPlageCollection(Collection<Plage> plageCollection) {
        this.plageCollection = plageCollection;
    }

    @XmlTransient
    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservation != null ? idReservation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.idReservation == null && other.idReservation != null) || (this.idReservation != null && !this.idReservation.equals(other.idReservation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reservation[ idReservation=" + idReservation + " ]";
    }
    
}
