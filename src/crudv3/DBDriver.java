/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudv3;

import crudv3.controller.BidangStudiController;
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
 * @author auliayf
 */
public class DBDriver {

    private static final String URL = "jdbc:mysql://localhost:3306/ukom1";
    private static final String UNAME = "root";
    private static final String PASS = "root";

    /**
     * getConnection
     *
     * @return connection
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, UNAME, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn, PreparedStatement state) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (state != null) {
                state.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void close(Connection conn, Statement state, ResultSet result) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (state != null) {
                state.close();
            }
            if (result != null) {
                result.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void close(Connection conn, PreparedStatement state, ResultSet result) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (state != null) {
                state.close();
            }
            if (result != null) {
                result.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
