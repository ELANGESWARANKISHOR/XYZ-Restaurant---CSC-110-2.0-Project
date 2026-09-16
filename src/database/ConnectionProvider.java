/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author us
 */
public class ConnectionProvider {

   

        static Connection con = null ;
        
       public static Connection getDBConnection() {
        try {
            if (con == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xyzrestaurant","root","xyz1234");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return con;
    }
        
}
