/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.data;

import Aerolinea.model.Tiquete;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JoyBB
 */
public class TiqueteDAO {
    private static final String INSERTAR = "call prc_ins_ruta(?,?,?)";
    private static final String SELECTALL = "select * from ruta where reserva_id = ?";
    
    public static boolean insert(Tiquete tiquete){
        boolean flag = false;
        try {         
            PreparedStatement stm = Connection.getConnection().prepareStatement(INSERTAR);
            stm.setInt(1, tiquete.getFila());
            stm.setInt(2, tiquete.getColumna());
            stm.setInt(3, tiquete.getReserva().getId());
            
            flag = stm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(RutasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public static Tiquete selectAll(int id){
        Tiquete tiquete = null;
        try {
            PreparedStatement stm = Connection.getConnection().prepareStatement(SELECTALL);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                tiquete = new Tiquete(rs.getInt("id"));
                tiquete.setFila(rs.getInt("fila"));
                tiquete.setColumna(rs.getInt("columna"));
                tiquete.setReserva(ReservaDAO.select(rs.getInt("reserva_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RutasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tiquete;
    }
}
