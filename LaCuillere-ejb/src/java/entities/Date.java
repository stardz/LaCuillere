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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "date")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Date.findAll", query = "SELECT d FROM Date d"),
    @NamedQuery(name = "Date.findByDateDate", query = "SELECT d FROM Date d WHERE d.dateDate = :dateDate")})
public class Date implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_date")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateDate;
    @JoinTable(name = "date_reservation", joinColumns = {
        @JoinColumn(name = "date_date_date", referencedColumnName = "date_date")}, inverseJoinColumns = {
        @JoinColumn(name = "reservations_id_reservation", referencedColumnName = "id_reservation")})
    @ManyToMany
    private Collection<Reservation> reservationCollection;

    public Date() {
    }

    public Date(java.util.Date dateDate) {
        this.dateDate = dateDate;
    }

    public java.util.Date getDateDate() {
        return dateDate;
    }

    public void setDateDate(java.util.Date dateDate) {
        this.dateDate = dateDate;
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
        hash += (dateDate != null ? dateDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Date)) {
            return false;
        }
        Date other = (Date) object;
        if ((this.dateDate == null && other.dateDate != null) || (this.dateDate != null && !this.dateDate.equals(other.dateDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Date[ dateDate=" + dateDate + " ]";
    }
    
}
