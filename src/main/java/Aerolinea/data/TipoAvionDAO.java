/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.data;

import Aerolinea.model.TipoAvion;
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
public class TipoAvionDAO {
    private static final String SELECT = "select * from tipo_avion where id = ?";
    private static final String SELECTALL = "select * from tipo_avion";
    
    public static TipoAvion select(int id){
        TipoAvion tipoavion = null;
        try(java.sql.Connection con = Connection.getConnection()) {
            PreparedStatement stm = con.prepareStatement(SELECT);
            
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                tipoavion = new TipoAvion(rs.getInt("id"));
                tipoavion.setFilas(rs.getInt("filas"));
                tipoavion.setColumnas(rs.getInt("columnas"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoAvionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipoavion;
    }
    
    public static ArrayList<TipoAvion> selectAll(){
        ArrayList<TipoAvion> lista = new ArrayList<>();
        try(java.sql.Connection con = Connection.getConnection()) {
            PreparedStatement stm = con.prepareStatement(SELECTALL);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                TipoAvion tipoavion = new TipoAvion(rs.getInt("id"));
                tipoavion.setFilas(rs.getInt("filas"));
                tipoavion.setColumnas(rs.getInt("columnas"));
                lista.add(tipoavion);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoAvionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
