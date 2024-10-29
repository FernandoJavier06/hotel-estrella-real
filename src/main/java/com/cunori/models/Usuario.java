/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cunori.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ferna
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByNitUsuario", query = "SELECT u FROM Usuario u WHERE u.nitUsuario = :nitUsuario"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuario.findByContrasenia", query = "SELECT u FROM Usuario u WHERE u.contrasenia = :contrasenia"),
    @NamedQuery(name = "Usuario.findByRol", query = "SELECT u FROM Usuario u WHERE u.rol = :rol")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NIT_USUARIO")
    private String nitUsuario;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "CORREO")
    private String correo;
    @Basic(optional = false)
    @Column(name = "CONTRASENIA")
    private String contrasenia;
    @Basic(optional = false)
    @Column(name = "ROL")
    private String rol;

    public Usuario() {
    }

    public Usuario(String nitUsuario) {
        this.nitUsuario = nitUsuario;
    }

    public Usuario(String nitUsuario, String nombre, String apellidos, String telefono, String correo, String contrasenia, String rol) {
        this.nitUsuario = nitUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    public String getNitUsuario() {
        return nitUsuario;
    }

    public void setNitUsuario(String nitUsuario) {
        this.nitUsuario = nitUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nitUsuario != null ? nitUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.nitUsuario == null && other.nitUsuario != null) || (this.nitUsuario != null && !this.nitUsuario.equals(other.nitUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cunori.models.Usuario[ nitUsuario=" + nitUsuario + " ]";
    }
    
}
