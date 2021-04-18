/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.data;

import Aerolinea.model.Vuelo;
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
public class VueloDAO {
    private static final String INSERTAR = "call prc_ins_vuelo(?,?,?)";
    private static final String SELECT = "select * from vuelo where id = ?";
    private static final String SELECTALL = "select * from vuelo";
    
    public static boolean insert(Vuelo vuelo){
        boolean flag = false;
        try {         
            PreparedStatement stm = Connection.getConnection().prepareStatement(INSERTAR);
            
            stm.setDate(1, vuelo.getIda());
            stm.setDate(2, vuelo.getRegreso());
            stm.setInt(3, vuelo.getHorario().getId());
            
            flag = stm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(AvionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public static Vuelo select(int id){
        Vuelo vuelo = null;
        try {
            PreparedStatement stm = Connection.getConnection().prepareStatement(SELECT);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                vuelo = new Vuelo(rs.getInt("id"));
                vuelo.setIda(rs.getDate("ida"));
                vuelo.setRegreso(rs.getDate("regreso"));
                vuelo.setHorario(HorarioDAO.select(rs.getInt("horario_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vuelo;
    }
    
    public static ArrayList<Vuelo> selectAll(){
        ArrayList<Vuelo> lista = new ArrayList<>();
        try {
            PreparedStatement stm = Connection.getConnection().prepareStatement(SELECTALL);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Vuelo vuelo = new Vuelo(rs.getInt("id"));
                vuelo.setIda(rs.getDate("ida"));
                vuelo.setRegreso(rs.getDate("regreso"));
                vuelo.setHorario(HorarioDAO.select(rs.getInt("horario_id")));
                lista.add(vuelo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
