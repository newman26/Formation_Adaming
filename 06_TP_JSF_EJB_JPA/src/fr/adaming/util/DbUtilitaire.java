/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INTI0261
 */
public class DbUtilitaire {

    private static Connection connection;

    //ctor statique
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jsp_sql",
                    "root",
                    "root"
            );
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DbUtilitaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the connection
     */
    public static Connection getConnection() {
        return connection;
    }

}
