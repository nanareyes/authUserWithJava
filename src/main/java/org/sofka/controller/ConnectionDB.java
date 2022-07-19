package org.sofka.controller;

import org.jboss.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public final class ConnectionDB {
    private static final Logger logger = Logger.getLogger(ConnectionDB.class);
    public static ConnectionDB instanceConnection = null;

    private Connection con;

    public ConnectionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/userAuth", "userAuth", "1234");
//                Statement stmt = con.createStatement();
//                ResultSet rs = stmt.executeQuery("userAuth;");
//                System.out.println("Connected");
        } catch (Exception e) {
            logger.info(e + "Hi");
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet rs;
        try {
            Statement stmt = this.con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;
        } catch (Exception e) {
            logger.info(e + "hi");
        }
        return null;
    }

    public static ConnectionDB getInstanceConnection() {
        if (instanceConnection != null) return instanceConnection;
        instanceConnection = new ConnectionDB();
        return instanceConnection;
    }

    public Connection getCon() {
        return con;
    }
}