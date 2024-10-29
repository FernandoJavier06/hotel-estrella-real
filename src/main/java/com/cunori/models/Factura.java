/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cunori.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ferna
 */
@Entity
@Table(name = "factura")
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura"),
    @NamedQuery(name = "Factura.findByFechaCreacion", query = "SELECT f FROM Factura f WHERE f.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Factura.findByIva", query = "SELECT f FROM Factura f WHERE f.iva = :iva"),
    @NamedQuery(name = "Factura.findByInguat", query = "SELECT f FROM Factura f WHERE f.inguat = :inguat"),
    @NamedQuery(name = "Factura.findByTotal", query = "SELECT f FROM Factura f WHERE f.total = :total")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FACTURA")
    private Integer idFactura;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "IVA")
    private BigDecimal iva;
    @Basic(optional = false)
    @Column(name = "INGUAT")
    private BigDecimal inguat;
    @Basic(optional = false)
    @Column(name = "TOTAL")
    private BigDecimal total;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFactura")
    private Collection<Reservacion> reservacionCollection;
    @JoinColumn(name = "NIT_CLIENTE", referencedColumnName = "NIT_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente nitCliente;

    public Factura() {
    }

    public Factura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Factura(Integer idFactura, Date fechaCreacion, BigDecimal iva, BigDecimal inguat, BigDecimal total) {
        this.idFactura = idFactura;
        this.fechaCreacion = fechaCreacion;
        this.iva = iva;
        this.inguat = inguat;
        this.total = total;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getInguat() {
        return inguat;
    }

    public void setInguat(BigDecimal inguat) {
        this.inguat = inguat;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Collection<Reservacion> getReservacionCollection() {
        return reservacionCollection;
    }

    public void setReservacionCollection(Collection<Reservacion> reservacionCollection) {
        this.reservacionCollection = reservacionCollection;
    }

    public Cliente getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(Cliente nitCliente) {
        this.nitCliente = nitCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cunori.models.Factura[ idFactura=" + idFactura + " ]";
    }
    
}
