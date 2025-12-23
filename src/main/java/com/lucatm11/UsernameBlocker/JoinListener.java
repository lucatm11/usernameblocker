package com.lucatm11.UsernameBlocker;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener{
    private final Plugin plugin;

    public JoinListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void joinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName().toLowerCase();

        plugin.getLogger().info("Checking " + playerName);
        for (String badWord : plugin.bwr.badWords) {
            if(playerName.contains(badWord)) {
                plugin.getLogger().info(playerName + "flagged. (" + badWord + ")");
                player.kickPlayer(Utils.colorize(plugin.getConfig().getString("messages.kick-message")));
                break;
            }
        }
    }
    
}
