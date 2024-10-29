/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cunori.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ferna
 */
@Entity
@Table(name = "habitacion")
@NamedQueries({
    @NamedQuery(name = "Habitacion.findAll", query = "SELECT h FROM Habitacion h"),
    @NamedQuery(name = "Habitacion.findByNumeroHabitacion", query = "SELECT h FROM Habitacion h WHERE h.numeroHabitacion = :numeroHabitacion"),
    @NamedQuery(name = "Habitacion.findByDisponible", query = "SELECT h FROM Habitacion h WHERE h.disponible = :disponible")})
public class Habitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUMERO_HABITACION")
    private Short numeroHabitacion;
    @Basic(optional = false)
    @Column(name = "DISPONIBLE")
    private boolean disponible;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroHabitacion")
    private Collection<Reservacion> reservacionCollection;
    @JoinColumn(name = "ID_TIPO_HABITACION", referencedColumnName = "ID_TIPO_HABITACION")
    @ManyToOne(optional = false)
    private TipoHabitacion idTipoHabitacion;

    public Habitacion() {
    }

    public Habitacion(Short numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public Habitacion(Short numeroHabitacion, boolean disponible) {
        this.numeroHabitacion = numeroHabitacion;
        this.disponible = disponible;
    }

    public Short getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(Short numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Collection<Reservacion> getReservacionCollection() {
        return reservacionCollection;
    }

    public void setReservacionCollection(Collection<Reservacion> reservacionCollection) {
        this.reservacionCollection = reservacionCollection;
    }

    public TipoHabitacion getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(TipoHabitacion idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroHabitacion != null ? numeroHabitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habitacion)) {
            return false;
        }
        Habitacion other = (Habitacion) object;
        if ((this.numeroHabitacion == null && other.numeroHabitacion != null) || (this.numeroHabitacion != null && !this.numeroHabitacion.equals(other.numeroHabitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cunori.models.Habitacion[ numeroHabitacion=" + numeroHabitacion + " ]";
    }
    
}
