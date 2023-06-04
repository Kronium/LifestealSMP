package com.hadesdc.lifestealsmp.Events;

import com.hadesdc.lifestealsmp.Players.CustomPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.UUID;

public class PlayerMYSQL implements Listener {
    private HashMap <UUID, CustomPlayer> customPlayer = new HashMap<>();

    public CustomPlayer getCustomPlayer(UUID uuid) {
        return customPlayer.get(uuid);
    }
}
