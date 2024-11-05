/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cunori.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ferna
 */
@Entity
@Table(name = "tipo_habitacion")
@NamedQueries({
    @NamedQuery(name = "TipoHabitacion.findAll", query = "SELECT t FROM TipoHabitacion t"),
    @NamedQuery(name = "TipoHabitacion.findByIdTipoHabitacion", query = "SELECT t FROM TipoHabitacion t WHERE t.idTipoHabitacion = :idTipoHabitacion"),
    @NamedQuery(name = "TipoHabitacion.findByNombre", query = "SELECT t FROM TipoHabitacion t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoHabitacion.findByPrecio", query = "SELECT t FROM TipoHabitacion t WHERE t.precio = :precio"),
    @NamedQuery(name = "TipoHabitacion.findByDescripcion", query = "SELECT t FROM TipoHabitacion t WHERE t.descripcion = :descripcion")})
public class TipoHabitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_HABITACION")
    private Integer idTipoHabitacion;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PRECIO")
    private BigDecimal precio;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoHabitacion")
    private Collection<Habitacion> habitacionCollection;

    public TipoHabitacion() {
    }

    public TipoHabitacion(Integer idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public TipoHabitacion(Integer idTipoHabitacion, String nombre, BigDecimal precio) {
        this.idTipoHabitacion = idTipoHabitacion;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(Integer idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<Habitacion> getHabitacionCollection() {
        return habitacionCollection;
    }

    public void setHabitacionCollection(Collection<Habitacion> habitacionCollection) {
        this.habitacionCollection = habitacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoHabitacion != null ? idTipoHabitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoHabitacion)) {
            return false;
        }
        TipoHabitacion other = (TipoHabitacion) object;
        if ((this.idTipoHabitacion == null && other.idTipoHabitacion != null) || (this.idTipoHabitacion != null && !this.idTipoHabitacion.equals(other.idTipoHabitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nombre + " | Q" + precio;
    }
    
}
