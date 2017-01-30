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
 * @author dell
 */
@Entity
@Table(name = "categorie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorie.findAll", query = "SELECT c FROM Categorie c"),
    @NamedQuery(name = "Categorie.findByIdCate", query = "SELECT c FROM Categorie c WHERE c.idCate = :idCate"),
    @NamedQuery(name = "Categorie.findByNomCate", query = "SELECT c FROM Categorie c WHERE c.nomCate = :nomCate")})
public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cate")
    private Integer idCate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_cate")
    private String nomCate;
    @JoinTable(name = "restaurant_categorie", joinColumns = {
        @JoinColumn(name = "categorie_id_cate", referencedColumnName = "id_cate")}, inverseJoinColumns = {
        @JoinColumn(name = "restaurant_id_restaurant", referencedColumnName = "id_restaurant")})
    @ManyToMany
    private Collection<Restaurant> restaurantCollection;

    public Categorie() {
    }

    public Categorie(Integer idCate) {
        this.idCate = idCate;
    }

    public Categorie(Integer idCate, String nomCate) {
        this.idCate = idCate;
        this.nomCate = nomCate;
    }

    public Integer getIdCate() {
        return idCate;
    }

    public void setIdCate(Integer idCate) {
        this.idCate = idCate;
    }

    public String getNomCate() {
        return nomCate;
    }

    public void setNomCate(String nomCate) {
        this.nomCate = nomCate;
    }

    @XmlTransient
    public Collection<Restaurant> getRestaurantCollection() {
        return restaurantCollection;
    }

    public void setRestaurantCollection(Collection<Restaurant> restaurantCollection) {
        this.restaurantCollection = restaurantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCate != null ? idCate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.idCate == null && other.idCate != null) || (this.idCate != null && !this.idCate.equals(other.idCate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Categorie[ idCate=" + idCate + " ]";
    }
    
}
