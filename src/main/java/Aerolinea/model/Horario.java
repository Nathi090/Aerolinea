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
public class Horario {
    private int id;
    private String dia;
    private Date hora;
    private float precio;
    private float descuento;
    private Avion avion;
    private Ruta ruta;

    public Horario(int id) {
        this.id = id;
    }

    public Horario(int id, String dia, Date hora, float precio, float descuento, Avion avion, Ruta ruta) {
        this.id = id;
        this.dia = dia;
        this.hora = hora;
        this.precio = precio;
        this.descuento = descuento;
        this.avion = avion;
        this.ruta = ruta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Horario other = (Horario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.precio) != Float.floatToIntBits(other.precio)) {
            return false;
        }
        if (Float.floatToIntBits(this.descuento) != Float.floatToIntBits(other.descuento)) {
            return false;
        }
        if (!Objects.equals(this.dia, other.dia)) {
            return false;
        }
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        if (!Objects.equals(this.avion, other.avion)) {
            return false;
        }
        if (!Objects.equals(this.ruta, other.ruta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Horario{" + "id=" + id + ", dia=" + dia + ", hora=" + hora + ", precio=" + precio + ", descuento=" + descuento + ", avion=" + avion + ", ruta=" + ruta + '}';
    }
    
    
}
