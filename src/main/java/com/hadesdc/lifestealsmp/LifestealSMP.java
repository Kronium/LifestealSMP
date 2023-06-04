

package com.hadesdc.lifestealsmp;

import com.hadesdc.lifestealsmp.Events.PlayerJoin;
import com.hadesdc.lifestealsmp.Events.PlayerMYSQL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public final class LifestealSMP extends JavaPlugin {
    private Database database;

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        System.out.println("Loading LifestealSMP by HadesDC");
        //database registration and connection
        database = new Database(this);
        System.out.println("Attempting to connect to database");
        try {
            database.connect();
        } catch (SQLException e) {
            System.out.println("Unable to connect to the database please make sure it is configured!");
        }
        System.out.println(database.isConnected());

        Bukkit.getPluginManager().registerEvents(new PlayerJoin(this), this);



    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        database.disconnect();
    }
    public Database getDatabase() {
        return database;
    }
}

