/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.data;

import Aerolinea.model.Horario;
import Aerolinea.model.Ruta;
import java.sql.Date;
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
public class HorarioDAO {
    private static final String SELECT = "select * from horario where id = ?";
    private static final String SELECTALL = "select * from horario";
    private static final String INSERTAR = "call prc_ins_horario(?,?,?,?,?)";
    
    public static Horario select(int id){
        Horario horario = null;
        try {
            PreparedStatement stm = Connection.getConnection().prepareStatement(SELECT);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                horario = new Horario(rs.getInt("id"));
                horario.setDia(rs.getString("dia"));
                horario.setHora(rs.getString("hora"));
                horario.setPrecio(rs.getFloat("precio"));
                horario.setAvion(AvionDAO.select(rs.getInt("avion_id")));
                horario.setRuta(RutasDAO.select(rs.getInt("ruta_id")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoAvionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return horario;
    }
    
    public static ArrayList<Horario> selectAll(){
        ArrayList<Horario> lista = new ArrayList<>();
        try {
            PreparedStatement stm = Connection.getConnection().prepareStatement(SELECTALL);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Horario horario = new Horario(rs.getInt("id"));
                horario.setDia(rs.getString("dia"));
                horario.setHora(rs.getString("hora"));
                horario.setPrecio(rs.getFloat("precio"));
                horario.setAvion(AvionDAO.select(rs.getInt("avion_id")));
                horario.setRuta(RutasDAO.select(rs.getInt("ruta_id")));
                lista.add(horario);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoAvionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
     public static boolean insert(Horario horario){
        boolean flag = false;
        try {         
            PreparedStatement stm = Connection.getConnection().prepareStatement(INSERTAR);
            
            stm.setString(1, horario.getDia());
            stm.setString(2, horario.getHora());
            stm.setFloat(3, horario.getPrecio());
            stm.setFloat(4, horario.getDescuento());
            stm.setInt(5, horario.getRuta().getId());
            
            flag = stm.execute();
            
        } catch (SQLException ex) {
            System.out.println("ERROR ESPERADO EN AGREGAR HORARIO");
                    }
        return flag;
    }
}
