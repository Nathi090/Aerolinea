/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.data;

import Aerolinea.model.Avion;
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
public class AvionDAO {
    private static final String INSERTAR = "call prc_ins_avion(?,?,?,?)";
    private static final String SELECT = "select * from avion where id = ?";
    private static final String SELECTALL = "select * from avion";
    
    public static boolean insert(Avion avion){
        boolean flag = false;
        try {         
            PreparedStatement stm = Connection.getConnection().prepareStatement(INSERTAR);
            
            stm.setInt(1, avion.getAnno());
            stm.setString(2, avion.getModelo());
            stm.setString(3, avion.getMarca());
            stm.setInt(4, avion.getTipoavion().getId());
            
            flag = stm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(AvionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public static Avion select(int id){
        Avion avion = null;
        try {
            PreparedStatement stm = Connection.getConnection().prepareStatement(SELECT);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                avion = new Avion(rs.getInt("id"));
                avion.setAnno(rs.getInt("anno"));
                avion.setModelo(rs.getString("modelo"));
                avion.setMarca(rs.getString("marca"));
                avion.setTipoavion(TipoAvionDAO.select(rs.getInt("tipo_avion_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return avion;
    }
    
    public static ArrayList<Avion> selectAll(){
        ArrayList<Avion> lista = new ArrayList<>();
        try {
            PreparedStatement stm = Connection.getConnection().prepareStatement(SELECTALL);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Avion avion = new Avion(rs.getInt("id"));
                avion.setAnno(rs.getInt("anno"));
                avion.setModelo(rs.getString("modelo"));
                avion.setMarca(rs.getString("marca"));
                avion.setTipoavion(TipoAvionDAO.select(rs.getInt("tipo_avion_id")));
                lista.add(avion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
