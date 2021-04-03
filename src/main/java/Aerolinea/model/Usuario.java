/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.model;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author JoyBB
 */
public class Usuario {
    private String username;
    private String nombre;
    private String apellidos;
    private String clave;
    private String correo;
    private Date fecNacimiento;
    private int sexo;
    private int telTrabajo;
    private int telMovil;
    private String direccion;
    private int tipo;

    public Usuario(String username) {
        this.username = username;
    }

    public Usuario(String username, String nombre, String apellidos, String clave, String correo, Date fecNacimiento, int sexo, int telTrabajo, int telMovil, String direccion, int tipo) {
        this.username = username;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.clave = clave;
        this.correo = correo;
        this.fecNacimiento = fecNacimiento;
        this.sexo = sexo;
        this.telTrabajo = telTrabajo;
        this.telMovil = telMovil;
        this.direccion = direccion;
        this.tipo = tipo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getTelTrabajo() {
        return telTrabajo;
    }

    public void setTelTrabajo(int telTrabajo) {
        this.telTrabajo = telTrabajo;
    }

    public int getTelMovil() {
        return telMovil;
    }

    public void setTelMovil(int telMovil) {
        this.telMovil = telMovil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", nombre=" + nombre + ", correo=" + correo + '}';
    }
    
    
}
