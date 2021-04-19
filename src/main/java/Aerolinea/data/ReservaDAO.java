/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.data;

import Aerolinea.model.Reserva;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JoyBB
 */
public class ReservaDAO {
    private static final String INSERTAR = "call prc_ins_reserva(?,?,?)";
    private static final String SELECT = "select * from reserva where id = ?";
    private static final String SELECTALL = "select * from reserva where cliente_id = ?";
    
    public static boolean insert(Reserva reserva){
        boolean flag = false;
        try {         
            PreparedStatement stm = Connection.getConnection().prepareStatement(INSERTAR);
            stm.setFloat(1, reserva.getPrecio());
            stm.setString(2, reserva.getCliente().getUsername());
            stm.setInt(3, reserva.getVuelo().getId());
            
            flag = stm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(RutasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public static int selectLastID(){
        int val = 0;
        try {         
            PreparedStatement stm = Connection.getConnection().prepareStatement("select max(id) id from reserva");
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                val = rs.getInt("id");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RutasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return val;
    }
    
    public static Reserva select(int id){
        Reserva reserva = null;
        try {
            PreparedStatement stm = Connection.getConnection().prepareStatement(SELECT);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                reserva = new Reserva(rs.getInt("id"));
                reserva.setPrecio(rs.getFloat("precio"));
                reserva.setCliente(UsuarioDAO.select(rs.getString("cliente_id")));
                reserva.setVuelo(VueloDAO.select(rs.getInt("vuelo_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RutasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reserva;
    }
    
    public static ArrayList<Reserva> selectAll(String user){
        ArrayList<Reserva> lista = new ArrayList<>();
        try {
            PreparedStatement stm = Connection.getConnection().prepareStatement(SELECTALL);
            stm.setString(1, user);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Reserva reserva = new Reserva(rs.getInt("id"));
                reserva.setPrecio(rs.getFloat("precio"));
                reserva.setCliente(UsuarioDAO.select(rs.getString("cliente_id")));
                reserva.setVuelo(VueloDAO.select(rs.getInt("vuelo_id")));
                lista.add(reserva);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RutasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
