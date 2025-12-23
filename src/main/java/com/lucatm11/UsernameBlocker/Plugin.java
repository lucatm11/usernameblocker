package com.lucatm11.UsernameBlocker;

import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin
{
  BadWordsRegistrar bwr;

  public void onEnable()
  {
    saveDefaultConfig();
    bwr = new BadWordsRegistrar(this);
    bwr.init();
    bwr.RegisterBadWordsFromConfig();
    getServer().getPluginManager().registerEvents(new JoinListener(this), this);
    getLogger().info("UsernameBlocker enabled.");
  }

  public void onDisable()
  {
    getLogger().info("UsernameBlocker disabled.");
  }
}
