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
public class Vuelo {
    private int id;
    private Date ida;
    private Date regreso;
    private Horario horario;

    public Vuelo(int id) {
        this.id = id;
    }

    public Vuelo(int id, Date ida, Date regreso, Horario horario) {
        this.id = id;
        this.ida = ida;
        this.regreso = regreso;
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getIda() {
        return ida;
    }

    public void setIda(Date ida) {
        this.ida = ida;
    }

    public Date getRegreso() {
        return regreso;
    }

    public void setRegreso(Date regreso) {
        this.regreso = regreso;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
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
        final Vuelo other = (Vuelo) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.ida, other.ida)) {
            return false;
        }
        if (!Objects.equals(this.regreso, other.regreso)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vuelo{" + "id=" + id + ", ida=" + ida + ", regreso=" + regreso + ", horario=" + horario + '}';
    }
    
}
