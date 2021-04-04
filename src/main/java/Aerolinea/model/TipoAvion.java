/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.model;

/**
 *
 * @author JoyBB
 */
public class TipoAvion {
    private int id;
    private int filas;
    private int columnas;

    public TipoAvion(int id) {
        this.id = id;
    }

    public TipoAvion(int id, int filas, int columnas) {
        this.id = id;
        this.filas = filas;
        this.columnas = columnas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
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
        final TipoAvion other = (TipoAvion) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.filas != other.filas) {
            return false;
        }
        if (this.columnas != other.columnas) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoAvion{" + "id=" + id + ", filas=" + filas + ", columnas=" + columnas + '}';
    }
    
}

