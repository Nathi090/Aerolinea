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
public class Tiquete {
    private int id;
    private int fila;
    private int columna;
    private Reserva reserva;

    public Tiquete(int id) {
        this.id = id;
    }

    public Tiquete(int id, int fila, int columna, Reserva reserva) {
        this.id = id;
        this.fila = fila;
        this.columna = columna;
        this.reserva = reserva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
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
        final Tiquete other = (Tiquete) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.fila != other.fila) {
            return false;
        }
        if (this.columna != other.columna) {
            return false;
        }
        if (!Objects.equals(this.reserva, other.reserva)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tiquete{" + "id=" + id + ", fila=" + fila + ", columna=" + columna + ", reserva=" + reserva + '}';
    }
    
}
