package com.hadesdc.lifestealsmp.Events;

import com.hadesdc.lifestealsmp.LifestealSMP;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.net.http.WebSocket;

public class PlayerJoin implements Listener {

    private LifestealSMP lssmp;

    public PlayerJoin(LifestealSMP lssmp) {
        this.lssmp = lssmp;
    }
    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e) {

    }
}
