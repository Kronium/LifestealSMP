package com.hadesdc.lifestealsmp;

import com.hadesdc.lifestealsmp.LifestealSMP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    private LifestealSMP hadescore;
    private final String HOST;
    private final int PORT;
    private final String DATABASE;
    private final String USERNAME;
    private final String PASSWORD;

    private Connection connection;

    public Database(LifestealSMP hadescore) {
        this.hadescore = hadescore;
        this.HOST = hadescore.getConfig().getString("Mysql.Host");
        this.PORT = hadescore.getConfig().getInt("Mysql.Port");
        this.DATABASE = hadescore.getConfig().getString("Mysql.Database");
        this.USERNAME = hadescore.getConfig().getString("Mysql.Username");
        this.PASSWORD = hadescore.getConfig().getString("Mysql.Password");
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://"
                        + HOST + ":" + PORT + "/" + DATABASE + "?useSSL=false",
                USERNAME,
                PASSWORD);
    }

    public boolean isConnected() {
        return connection != null;
    }

    public Connection getConnection() {
        return connection;
    }



    public void disconnect() {
        if(isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
