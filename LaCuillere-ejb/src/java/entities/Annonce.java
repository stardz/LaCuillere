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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "annonce")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Annonce.findAll", query = "SELECT a FROM Annonce a"),
    @NamedQuery(name = "Annonce.findByIdAnnonce", query = "SELECT a FROM Annonce a WHERE a.idAnnonce = :idAnnonce"),
    @NamedQuery(name = "Annonce.findByDescriptionAnnonce", query = "SELECT a FROM Annonce a WHERE a.descriptionAnnonce = :descriptionAnnonce"),
    @NamedQuery(name = "Annonce.findByTeleAnnonce", query = "SELECT a FROM Annonce a WHERE a.teleAnnonce = :teleAnnonce"),
    @NamedQuery(name = "Annonce.findByEmailAnnonce", query = "SELECT a FROM Annonce a WHERE a.emailAnnonce = :emailAnnonce"),
   //@NamedQuery(name = "Annonce.findByUser", query = "SELECT a FROM Annonce left join Utilisateur u where u. = :idUser")
})
public class Annonce implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_annonce")
    private Long idAnnonce;
    @Size(max = 255)
    @Column(name = "description_annonce")
    private String descriptionAnnonce;
    @Size(max = 50)
    @Column(name = "tele_annonce")
    private String teleAnnonce;
    @Size(max = 50)
    @Column(name = "email_annonce")
    private String emailAnnonce;
    @JoinTable(name = "restaurant_annonce", joinColumns = {
        @JoinColumn(name = "annonces_id_annonce", referencedColumnName = "id_annonce")}, inverseJoinColumns = {
        @JoinColumn(name = "restaurant_id_restaurant", referencedColumnName = "id_restaurant")})
    @ManyToMany
    private Collection<Restaurant> restaurantCollection;
    @JoinTable(name = "utilisateur_annonce", joinColumns = {
        @JoinColumn(name = "annonces_id_annonce", referencedColumnName = "id_annonce")}, inverseJoinColumns = {
        @JoinColumn(name = "utilisateur_id_utilisateur", referencedColumnName = "id_utilisateur")})
    @ManyToMany
    private Collection<Utilisateur> utilisateurCollection;
    @OneToMany(mappedBy = "annonceIdAnnonce",fetch = FetchType.EAGER)
    private Collection<Menu> menuCollection;
    @OneToMany(mappedBy = "annonceIdAnnonce")
    private Collection<Plage> plageCollection;

    public Annonce() {
    }

    public Annonce(Long idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public Long getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(Long idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public String getDescriptionAnnonce() {
        return descriptionAnnonce;
    }

    public void setDescriptionAnnonce(String descriptionAnnonce) {
        this.descriptionAnnonce = descriptionAnnonce;
    }

    public String getTeleAnnonce() {
        return teleAnnonce;
    }

    public void setTeleAnnonce(String teleAnnonce) {
        this.teleAnnonce = teleAnnonce;
    }

    public String getEmailAnnonce() {
        return emailAnnonce;
    }

    public void setEmailAnnonce(String emailAnnonce) {
        this.emailAnnonce = emailAnnonce;
    }

    @XmlTransient
    public Collection<Restaurant> getRestaurantCollection() {
        return restaurantCollection;
    }

    public void setRestaurantCollection(Collection<Restaurant> restaurantCollection) {
        this.restaurantCollection = restaurantCollection;
    }

    @XmlTransient
    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnnonce != null ? idAnnonce.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Annonce)) {
            return false;
        }
        Annonce other = (Annonce) object;
        if ((this.idAnnonce == null && other.idAnnonce != null) || (this.idAnnonce != null && !this.idAnnonce.equals(other.idAnnonce))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Annonce[ idAnnonce=" + idAnnonce + " ]";
    }
    
}
