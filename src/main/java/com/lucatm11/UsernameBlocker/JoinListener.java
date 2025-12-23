package com.lucatm11.UsernameBlocker;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;

public class JoinListener implements Listener{
    private final Plugin plugin;

    public JoinListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void joinEvent(AsyncPlayerPreLoginEvent event) {
        String playerName = event.getName().toLowerCase();

        plugin.getLogger().info("Checking " + playerName);
        for (String badWord : plugin.bwr.badWords) {
            if(playerName.contains(badWord)) {
                plugin.getLogger().info(playerName + "flagged. (" + badWord + ")");
                event.disallow(Result.KICK_OTHER, Utils.colorize(plugin.getConfig().getString("messages.kick-message")));
                break;
            }
        }
    }
    
}
