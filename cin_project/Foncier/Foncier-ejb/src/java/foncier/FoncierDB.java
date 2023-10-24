/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foncier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author antho
 */
public class FoncierDB {
    static String jdbcUrl = "jdbc:postgresql://localhost:5432/";
    // String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";

    static String base = "cin_foncier";
    static String username = "postgres";
    static String password = "anthony";
    
    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            return null;
        }
        Connection conn = DriverManager.getConnection(jdbcUrl+base, username, password);
        return conn;
    }
}
