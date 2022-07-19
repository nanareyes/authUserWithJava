package org.sofka.model;

import org.jboss.logging.Logger;
import org.sofka.controller.ConnectionDB;
import java.io.Console;
import java.sql.*;

public final class UserConnectionDB {

    private static final ConnectionDB instanceConnection = ConnectionDB.getInstanceConnection();
    private static final Logger logger = Logger.getLogger(UserConnectionDB.class);

    public static void addUser(User user){
        //Boolean searchUser = searchUsers(userName);

      //  if(Boolean.FALSE.equals(searchUser)){
            String sql = "INSERT INTO user (name, lastname, email, password) VALUES (?,?,?,?)";
            PreparedStatement statement = null;
            try {
                statement = instanceConnection.getCon().prepareStatement(sql);
                statement.setString(1, user.getName());
                statement.setString(2, user.getLastName());
                statement.setString(3, user.getEmail());
                statement.setString(4, user.getPassword());
                Integer rowsInserted = statement.executeUpdate();
                if(rowsInserted > 0){
                    logger.info("REGISTRO INGRESADO CORRECTAMENTE");
                }else{
                    logger.info("NAdaaaA!!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
       // }

    }

    private static Boolean searchUsers(String userName){

        String sql = "SELECT * FROM user WHERE name = ?";
        PreparedStatement statement = null;
        try {
            statement = instanceConnection.getCon().prepareStatement(sql);
            statement.setString(1, userName);
            ResultSet result = statement.executeQuery();
            return result.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }




}
