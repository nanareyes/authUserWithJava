package org.sofka;

import org.sofka.controller.ConnectionDB;
import org.sofka.controller.MyApp;

import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        MyApp app = new MyApp();
        app.run();
        ConnectionDB con = new ConnectionDB();
        try {
            ResultSet result = con.executeQuery("select * FROM user");
            while(result.next()) {
                System.out.println(result.getString("NAME"));
            }
        } catch (SQLException e) {
            System.out.println("El error: " + e);
        }
    }
}

