/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JoyBB
 */
package Aerolinea.data;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleDriver;

public class Connection {
    private static java.sql.Connection conn;

    public static java.sql.Connection getConnection(){
        try {
            if(conn == null)
                DriverManager.registerDriver(new OracleDriver());
                conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    
}

