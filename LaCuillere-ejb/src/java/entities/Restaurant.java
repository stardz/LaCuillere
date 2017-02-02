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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "restaurant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restaurant.findAll", query = "SELECT r FROM Restaurant r"),
    @NamedQuery(name = "Restaurant.findByIdRestaurant", query = "SELECT r FROM Restaurant r WHERE r.idRestaurant = :idRestaurant"),
    @NamedQuery(name = "Restaurant.findByNomRes", query = "SELECT r FROM Restaurant r WHERE r.nomRes = :nomRes"),
    @NamedQuery(name = "Restaurant.findByTeleRes", query = "SELECT r FROM Restaurant r WHERE r.teleRes = :teleRes"),
    @NamedQuery(name = "Restaurant.findByEmailRes", query = "SELECT r FROM Restaurant r WHERE r.emailRes = :emailRes"),
    @NamedQuery(name = "Restaurant.findByAdresseRes", query = "SELECT r FROM Restaurant r WHERE r.adresseRes = :adresseRes")})

public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_restaurant")
    private Long idRestaurant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_res")
    private String nomRes;
    @Size(max = 50)
    @Column(name = "tele_res")
    private String teleRes;
    @Size(max = 50)
    @Column(name = "email_res")
    private String emailRes;
    @Size(max = 50)
    @Column(name = "adresse_res")
    private String adresseRes;
    @ManyToMany(mappedBy = "restaurantCollection")
    private Collection<Annonce> annonceCollection;
    @ManyToMany(mappedBy = "restaurantCollection")
    private Collection<Categorie> categorieCollection;
    @JoinColumn(name = "restaurant_id_utilisateur", referencedColumnName = "id_utilisateur")
    @ManyToOne
    private Utilisateur restaurantIdUtilisateur;

    public Restaurant() {
    }

    public Restaurant(Long idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public Restaurant(Long idRestaurant, String nomRes) {
        this.idRestaurant = idRestaurant;
        this.nomRes = nomRes;
    }

    public Long getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Long idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getNomRes() {
        return nomRes;
    }

    public void setNomRes(String nomRes) {
        this.nomRes = nomRes;
    }

    public String getTeleRes() {
        return teleRes;
    }

    public void setTeleRes(String teleRes) {
        this.teleRes = teleRes;
    }

    public String getEmailRes() {
        return emailRes;
    }

    public void setEmailRes(String emailRes) {
        this.emailRes = emailRes;
    }

    public String getAdresseRes() {
        return adresseRes;
    }

    public void setAdresseRes(String adresseRes) {
        this.adresseRes = adresseRes;
    }

    @XmlTransient
    public Collection<Annonce> getAnnonceCollection() {
        return annonceCollection;
    }

    public void setAnnonceCollection(Collection<Annonce> annonceCollection) {
        this.annonceCollection = annonceCollection;
    }

    @XmlTransient
    public Collection<Categorie> getCategorieCollection() {
        return categorieCollection;
    }

    public void setCategorieCollection(Collection<Categorie> categorieCollection) {
        this.categorieCollection = categorieCollection;
    }

    public Utilisateur getRestaurantIdUtilisateur() {
        return restaurantIdUtilisateur;
    }

    public void setRestaurantIdUtilisateur(Utilisateur restaurantIdUtilisateur) {
        this.restaurantIdUtilisateur = restaurantIdUtilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRestaurant != null ? idRestaurant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurant)) {
            return false;
        }
        Restaurant other = (Restaurant) object;
        if ((this.idRestaurant == null && other.idRestaurant != null) || (this.idRestaurant != null && !this.idRestaurant.equals(other.idRestaurant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Restaurant[ idRestaurant=" + idRestaurant + " ]";
    }
    
}
