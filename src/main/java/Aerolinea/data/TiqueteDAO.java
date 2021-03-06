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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JoyBB
 */
public class TiqueteDAO {
    private static final String INSERTAR = "call prc_ins_tiquete(?,?,?)";
    private static final String SELECTALL = "select * from tiquete where reserva_id = ?";
    
    public static boolean insert(Tiquete tiquete){
        boolean flag = false;
        try(java.sql.Connection con = Connection.getConnection()) {         
            PreparedStatement stm = con.prepareStatement(INSERTAR);
            stm.setInt(1, tiquete.getFila());
            stm.setInt(2, tiquete.getColumna());
            stm.setInt(3, tiquete.getReserva().getId());
            
            flag = stm.execute();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(RutasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public static ArrayList<Tiquete> selectAllFromReservation(int id){
        ArrayList<Tiquete> tiquetes = new ArrayList();
        try(java.sql.Connection con = Connection.getConnection()) {
            PreparedStatement stm = con.prepareStatement(SELECTALL);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Tiquete tiquete = new Tiquete(rs.getInt("id"));
                tiquete.setFila(rs.getInt("fila"));
                tiquete.setColumna(rs.getInt("columna"));
                tiquete.setReserva(ReservaDAO.select(rs.getInt("reserva_id")));
                tiquetes.add(tiquete);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(RutasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tiquetes;
    }
}
