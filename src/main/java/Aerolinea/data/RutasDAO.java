/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.data;

import Aerolinea.model.Ruta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nati2
 */
public class RutasDAO {
    private static final String INSERTAR = "call prc_ins_ruta(?,?,?)";
    private static final String SELECT = "select * from ruta where id = ?";
    private static final String SELECTALL = "select * from ruta";
    
    public static boolean insert(Ruta ruta){
        boolean flag = false;
        try {         
            PreparedStatement stm = Connection.getConnection().prepareStatement(INSERTAR);
            
            stm.setString(1, ruta.getOrigen());
            stm.setString(2, ruta.getDestino());
            stm.setFloat(3, ruta.getDuracion());
            
            flag = stm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(RutasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public static Ruta select(int id){
        Ruta ruta = null;
        try {
            PreparedStatement stm = Connection.getConnection().prepareStatement(SELECT);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                ruta = new Ruta(rs.getInt("id"));
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                ruta.setDuracion(rs.getInt("duracion"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RutasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ruta;
    }
    
    public static ArrayList<Ruta> selectAll(){
        ArrayList<Ruta> lista = new ArrayList<>();
        try {
            PreparedStatement stm = Connection.getConnection().prepareStatement(SELECTALL);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Ruta ruta = new Ruta(rs.getInt("id"));
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                ruta.setDuracion(rs.getInt("duracion"));
                lista.add(ruta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RutasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
