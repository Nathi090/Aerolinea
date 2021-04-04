/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.data;

import Aerolinea.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JoyBB
 */
public class UsuarioDAO {
    private static final String INSERTAR = "call prc_ins_usuario(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT = "select * from usuario where username = '?'";
    
    public static boolean insert(Usuario user){
        boolean flag = false;
        try {
            PreparedStatement stm = Connection.getConnection().prepareStatement(INSERTAR);
            
            stm.setString(0, user.getUsername());
            stm.setString(1, user.getNombre());
            stm.setString(2, user.getApellidos());
            stm.setString(3, user.getClave());
            stm.setString(4, user.getCorreo());
            stm.setDate(5, user.getFecNacimiento());
            stm.setInt(6, user.getSexo());
            stm.setInt(7, user.getTelTrabajo());
            stm.setInt(8, user.getTelMovil());
            stm.setString(9, user.getDireccion());
            stm.setInt(10, user.getTipo());
            
            flag = stm.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(AvionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public static Usuario select(String username){
        Usuario user;
        try {
            PreparedStatement stm = Connection.getConnection().prepareStatement(SELECT);
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                user = new Usuario(rs.getString("username"));
                user.setNombre(rs.getString("nombre"));
                user.setApellidos(rs.getString("apellidos"));
                user.setClave(rs.getString("clave"));
                user.setCorreo(rs.getString("correo"));
                user.setFecNacimiento(rs.getDate("fec_nacimiento"));
                user.setSexo(rs.getInt("sexo"));
                user.setTelTrabajo(rs.getInt("tel_trabajo"));
                user.setTelMovil(rs.getInt("tel_movil"));
                user.setDireccion(rs.getString("direccion"));
                user.setTipo(rs.getInt("tipo"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}