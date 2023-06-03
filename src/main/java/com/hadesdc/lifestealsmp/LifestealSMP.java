package com.hadesdc.lifestealsmp;

import com.hadesdc.lifestealsmp.Config.ConfigCommand;
import com.hadesdc.lifestealsmp.Events.PlayerDeath;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LifestealSMP extends JavaPlugin {

    @Override
    public void onEnable() {
        //registering config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //Logic for player deaths.
        Bukkit.getPluginManager().registerEvents(new PlayerDeath(), this);

        //logic for player kills

        //config stuffs
        getCommand("config").setExecutor(new ConfigCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
