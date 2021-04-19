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
public class Avion {
    private int id;
    private int anno;
    private String modelo;
    private String marca;
    private TipoAvion tipoavion;

    public Avion(int id) {
        this.id = id;
    }
    
    public Avion(int id, TipoAvion tipoavion) {
        this.id = id;
        this.tipoavion = tipoavion;
    }

    public Avion(int id, int anno, String modelo, String marca, TipoAvion tipoavion) {
        this.id = id;
        this.anno = anno;
        this.modelo = modelo;
        this.marca = marca;
        this.tipoavion = tipoavion;
    }
    public Avion(int id, int anno, String modelo, String marca) {
        this.id = id;
        this.anno = anno;
        this.modelo = modelo;
        this.marca = marca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public TipoAvion getTipoavion() {
        return tipoavion;
    }

    public void setTipoavion(TipoAvion tipoavion) {
        this.tipoavion = tipoavion;
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
        final Avion other = (Avion) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.anno != other.anno) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.tipoavion, other.tipoavion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Avion{" + "id=" + id + ", anno=" + anno + ", modelo=" + modelo + ", marca=" + marca + ", tipoavion=" + tipoavion.getId() + '}';
    }
    
    
}
