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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Ibra
 */
@Entity
@Table(name = "utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findByIdUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.idUtilisateur = :idUtilisateur")
    , @NamedQuery(name = "Utilisateur.findByAdressUsr", query = "SELECT u FROM Utilisateur u WHERE u.adressUsr = :adressUsr")
    , @NamedQuery(name = "Utilisateur.findByMailUsr", query = "SELECT u FROM Utilisateur u WHERE u.mailUsr = :mailUsr")
    , @NamedQuery(name = "Utilisateur.findByNomUsr", query = "SELECT u FROM Utilisateur u WHERE u.nomUsr = :nomUsr")
    , @NamedQuery(name = "Utilisateur.findByPasswordUser", query = "SELECT u FROM Utilisateur u WHERE u.passwordUser = :passwordUser")
    , @NamedQuery(name = "Utilisateur.findByPrenomUsr", query = "SELECT u FROM Utilisateur u WHERE u.prenomUsr = :prenomUsr")
    , @NamedQuery(name = "Utilisateur.findByProfileUsr", query = "SELECT u FROM Utilisateur u WHERE u.profileUsr = :profileUsr")
    , @NamedQuery(name = "Utilisateur.findByTelephoneUsr", query = "SELECT u FROM Utilisateur u WHERE u.telephoneUsr = :telephoneUsr")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_utilisateur")
    private Long idUtilisateur;
    @Size(max = 255)
    @Column(name = "adress_usr")
    private String adressUsr;
    @Size(max = 255)
    @Column(name = "mail_usr")
    private String mailUsr;
    @Size(max = 255)
    @Column(name = "nom_usr")
    private String nomUsr;
    @Size(max = 255)
    @Column(name = "password_user")
    private String passwordUser;
    @Size(max = 255)
    @Column(name = "prenom_usr")
    private String prenomUsr;
    @Size(max = 255)
    @Column(name = "profile_usr")
    private String profileUsr;
    @Size(max = 255)
    @Column(name = "telephone_usr")
    private String telephoneUsr;
    @ManyToMany(mappedBy = "utilisateurCollection")
    private Collection<Plage> plageCollection;
    @ManyToMany(mappedBy = "utilisateurCollection")
    private Collection<Annonce> annonceCollection;
    @JoinTable(name = "utilisateur_reservation", joinColumns = {
        @JoinColumn(name = "utilisateur_id_utilisateur", referencedColumnName = "id_utilisateur")}, inverseJoinColumns = {
        @JoinColumn(name = "reservations_id_reservation", referencedColumnName = "id_reservation")})
    @ManyToMany
    private Collection<Reservation> reservationCollection;

    public Utilisateur() {
    }

    public Utilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getAdressUsr() {
        return adressUsr;
    }

    public void setAdressUsr(String adressUsr) {
        this.adressUsr = adressUsr;
    }

    public String getMailUsr() {
        return mailUsr;
    }

    public void setMailUsr(String mailUsr) {
        this.mailUsr = mailUsr;
    }

    public String getNomUsr() {
        return nomUsr;
    }

    public void setNomUsr(String nomUsr) {
        this.nomUsr = nomUsr;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getPrenomUsr() {
        return prenomUsr;
    }

    public void setPrenomUsr(String prenomUsr) {
        this.prenomUsr = prenomUsr;
    }

    public String getProfileUsr() {
        return profileUsr;
    }

    public void setProfileUsr(String profileUsr) {
        this.profileUsr = profileUsr;
    }

    public String getTelephoneUsr() {
        return telephoneUsr;
    }

    public void setTelephoneUsr(String telephoneUsr) {
        this.telephoneUsr = telephoneUsr;
    }

    @XmlTransient
    public Collection<Plage> getPlageCollection() {
        return plageCollection;
    }

    public void setPlageCollection(Collection<Plage> plageCollection) {
        this.plageCollection = plageCollection;
    }

    @XmlTransient
    public Collection<Annonce> getAnnonceCollection() {
        return annonceCollection;
    }

    public void setAnnonceCollection(Collection<Annonce> annonceCollection) {
        this.annonceCollection = annonceCollection;
    }

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUtilisateur != null ? idUtilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idUtilisateur == null && other.idUtilisateur != null) || (this.idUtilisateur != null && !this.idUtilisateur.equals(other.idUtilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Utilisateur[ idUtilisateur=" + idUtilisateur + " ]";
    }
    
}
