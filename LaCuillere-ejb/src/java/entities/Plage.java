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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ibra
 */
@Entity
@Table(name = "plage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plage.findAll", query = "SELECT p FROM Plage p")
    , @NamedQuery(name = "Plage.findByIdPlage", query = "SELECT p FROM Plage p WHERE p.idPlage = :idPlage")
    , @NamedQuery(name = "Plage.findByAnnee", query = "SELECT p FROM Plage p WHERE p.annee = :annee")
    , @NamedQuery(name = "Plage.findByHeure", query = "SELECT p FROM Plage p WHERE p.heure = :heure")
    , @NamedQuery(name = "Plage.findByJour", query = "SELECT p FROM Plage p WHERE p.jour = :jour")
    , @NamedQuery(name = "Plage.findByMois", query = "SELECT p FROM Plage p WHERE p.mois = :mois")
    , @NamedQuery(name = "Plage.findByNombrePlacesPlage", query = "SELECT p FROM Plage p WHERE p.nombrePlacesPlage = :nombrePlacesPlage")})
public class Plage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_plage")
    private Long idPlage;
    @Column(name = "annee")
    private Integer annee;
    @Column(name = "heure")
    private Integer heure;
    @Column(name = "jour")
    private Integer jour;
    @Column(name = "mois")
    private Integer mois;
    @Column(name = "nombre_places_plage")
    private Integer nombrePlacesPlage;
    @JoinTable(name = "utilisateur_plage", joinColumns = {
        @JoinColumn(name = "plages_id_plage", referencedColumnName = "id_plage")}, inverseJoinColumns = {
        @JoinColumn(name = "utilisateur_id_utilisateur", referencedColumnName = "id_utilisateur")})
    @ManyToMany
    private Collection<Utilisateur> utilisateurCollection;
    @JoinTable(name = "plage_reservation", joinColumns = {
        @JoinColumn(name = "plage_id_plage", referencedColumnName = "id_plage")}, inverseJoinColumns = {
        @JoinColumn(name = "reservations_id_reservation", referencedColumnName = "id_reservation")})
    @ManyToMany
    private Collection<Reservation> reservationCollection;
    @JoinColumn(name = "annonce_id_annonce", referencedColumnName = "id_annonce")
    @ManyToOne
    private Annonce annonceIdAnnonce;

    public Plage() {
    }

    public Plage(Long idPlage) {
        this.idPlage = idPlage;
    }

    public Long getIdPlage() {
        return idPlage;
    }

    public void setIdPlage(Long idPlage) {
        this.idPlage = idPlage;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Integer getHeure() {
        return heure;
    }

    public void setHeure(Integer heure) {
        this.heure = heure;
    }

    public Integer getJour() {
        return jour;
    }

    public void setJour(Integer jour) {
        this.jour = jour;
    }

    public Integer getMois() {
        return mois;
    }

    public void setMois(Integer mois) {
        this.mois = mois;
    }

    public Integer getNombrePlacesPlage() {
        return nombrePlacesPlage;
    }

    public void setNombrePlacesPlage(Integer nombrePlacesPlage) {
        this.nombrePlacesPlage = nombrePlacesPlage;
    }

    @XmlTransient
    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
    }

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    public Annonce getAnnonceIdAnnonce() {
        return annonceIdAnnonce;
    }

    public void setAnnonceIdAnnonce(Annonce annonceIdAnnonce) {
        this.annonceIdAnnonce = annonceIdAnnonce;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlage != null ? idPlage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plage)) {
            return false;
        }
        Plage other = (Plage) object;
        if ((this.idPlage == null && other.idPlage != null) || (this.idPlage != null && !this.idPlage.equals(other.idPlage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Plage[ idPlage=" + idPlage + " ]";
    }
    
}
