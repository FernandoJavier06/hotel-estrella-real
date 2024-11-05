package com.cunori.models;

import java.math.BigDecimal;

public class HabitacionDisponibleDTO {
    private Short numeroHabitacion;
    private String nombre;
    private BigDecimal precio;

    public HabitacionDisponibleDTO() {
    }

    public HabitacionDisponibleDTO(Short numeroHabitacion, String nombre, BigDecimal precio) {
        this.numeroHabitacion = numeroHabitacion;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Short getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(Short numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
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

    @Override
    public String toString() {
        return "HabitacionDisponible{" + "numeroHabitacion=" + numeroHabitacion + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
    
}
