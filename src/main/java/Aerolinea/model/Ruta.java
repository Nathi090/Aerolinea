/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.model;

import java.util.Objects;

/**
 *
 * @author JoyBB
 */
public class Ruta {
    private int id;
    private String origen;
    private String destino;
    private float duracion;

    public Ruta(int id) {
        this.id = id;
    }

    public Ruta(int id, String origen, String destino, float duracion) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
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
        final Ruta other = (Ruta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.duracion) != Float.floatToIntBits(other.duracion)) {
            return false;
        }
        if (!Objects.equals(this.origen, other.origen)) {
            return false;
        }
        if (!Objects.equals(this.destino, other.destino)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ruta{" + "id=" + id + ", origen=" + origen + ", destino=" + destino + ", duracion=" + duracion + '}';
    }
    
}
