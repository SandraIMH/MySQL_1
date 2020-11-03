package com.mycompany.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SandraIMH
 */

public class MySQLInsertar {
    public static void main(String[] args){
        
        String url = "jdbc:mysql://localhost:3360/libreriadb?useSSL=false";
        String user = "root";
        String password = "";
        
        String autor = "Trygve Gulbranssen";
        String sql = "INSERT INTO Autores(Nombre) VALUES(?)";
        
        try  (Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement pst = con.prepareStatement(sql)) {
        pst.setString(1,autor);
        pst.executeUpdate();
        System.out.println("Un nuevo autor ha sido insertado");
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(MySQLInsertar.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
