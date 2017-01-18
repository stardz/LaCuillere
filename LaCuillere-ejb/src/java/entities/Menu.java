/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ibra
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
    , @NamedQuery(name = "Menu.findByIdMenu", query = "SELECT m FROM Menu m WHERE m.idMenu = :idMenu")
    , @NamedQuery(name = "Menu.findByDescriptionMenu", query = "SELECT m FROM Menu m WHERE m.descriptionMenu = :descriptionMenu")
    , @NamedQuery(name = "Menu.findByNomMenu", query = "SELECT m FROM Menu m WHERE m.nomMenu = :nomMenu")
    , @NamedQuery(name = "Menu.findByPrixMenu", query = "SELECT m FROM Menu m WHERE m.prixMenu = :prixMenu")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_menu")
    private Long idMenu;
    @Size(max = 255)
    @Column(name = "description_menu")
    private String descriptionMenu;
    @Size(max = 255)
    @Column(name = "nom_menu")
    private String nomMenu;
    @Column(name = "prix_menu")
    private BigInteger prixMenu;
    @JoinTable(name = "menu_reservation", joinColumns = {
        @JoinColumn(name = "menu_id_menu", referencedColumnName = "id_menu")}, inverseJoinColumns = {
        @JoinColumn(name = "reservations_id_reservation", referencedColumnName = "id_reservation")})
    @ManyToMany
    private Collection<Reservation> reservationCollection;
    @JoinColumn(name = "annonce_id_annonce", referencedColumnName = "id_annonce")
    @ManyToOne
    private Annonce annonceIdAnnonce;

    public Menu() {
    }

    public Menu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public String getDescriptionMenu() {
        return descriptionMenu;
    }

    public void setDescriptionMenu(String descriptionMenu) {
        this.descriptionMenu = descriptionMenu;
    }

    public String getNomMenu() {
        return nomMenu;
    }

    public void setNomMenu(String nomMenu) {
        this.nomMenu = nomMenu;
    }

    public BigInteger getPrixMenu() {
        return prixMenu;
    }

    public void setPrixMenu(BigInteger prixMenu) {
        this.prixMenu = prixMenu;
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
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Menu[ idMenu=" + idMenu + " ]";
    }
    
}
