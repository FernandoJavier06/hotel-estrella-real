/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cunori.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ferna
 */
@Entity
@Table(name = "reservacion")
@NamedQueries({
    @NamedQuery(name = "Reservacion.findAll", query = "SELECT r FROM Reservacion r"),
    @NamedQuery(name = "Reservacion.findByIdReservacion", query = "SELECT r FROM Reservacion r WHERE r.idReservacion = :idReservacion"),
    @NamedQuery(name = "Reservacion.findByCheckIn", query = "SELECT r FROM Reservacion r WHERE r.checkIn = :checkIn"),
    @NamedQuery(name = "Reservacion.findByCheckOut", query = "SELECT r FROM Reservacion r WHERE r.checkOut = :checkOut"),
    @NamedQuery(name = "Reservacion.findByCamasExtras", query = "SELECT r FROM Reservacion r WHERE r.camasExtras = :camasExtras"),
    @NamedQuery(name = "Reservacion.findByPrecioFinal", query = "SELECT r FROM Reservacion r WHERE r.precioFinal = :precioFinal")})
public class Reservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RESERVACION")
    private Integer idReservacion;
    @Basic(optional = false)
    @Column(name = "CHECK_IN")
    @Temporal(TemporalType.DATE)
    private Date checkIn;
    @Basic(optional = false)
    @Column(name = "CHECK_OUT")
    @Temporal(TemporalType.DATE)
    private Date checkOut;
    @Column(name = "CAMAS_EXTRAS")
    private Short camasExtras;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PRECIO_FINAL")
    private BigDecimal precioFinal;
    @JoinColumn(name = "ID_FACTURA", referencedColumnName = "ID_FACTURA")
    @ManyToOne(optional = false)
    private Factura idFactura;
    @JoinColumn(name = "NUMERO_HABITACION", referencedColumnName = "NUMERO_HABITACION")
    @ManyToOne(optional = false)
    private Habitacion numeroHabitacion;

    public Reservacion() {
    }

    public Reservacion(Integer idReservacion) {
        this.idReservacion = idReservacion;
    }

    public Reservacion(Integer idReservacion, Date checkIn, Date checkOut, BigDecimal precioFinal) {
        this.idReservacion = idReservacion;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.precioFinal = precioFinal;
    }

    public Integer getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(Integer idReservacion) {
        this.idReservacion = idReservacion;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Short getCamasExtras() {
        return camasExtras;
    }

    public void setCamasExtras(Short camasExtras) {
        this.camasExtras = camasExtras;
    }

    public BigDecimal getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(BigDecimal precioFinal) {
        this.precioFinal = precioFinal;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }

    public Habitacion getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(Habitacion numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservacion != null ? idReservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservacion)) {
            return false;
        }
        Reservacion other = (Reservacion) object;
        if ((this.idReservacion == null && other.idReservacion != null) || (this.idReservacion != null && !this.idReservacion.equals(other.idReservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cunori.models.Reservacion[ idReservacion=" + idReservacion + " ]";
    }
    
}
