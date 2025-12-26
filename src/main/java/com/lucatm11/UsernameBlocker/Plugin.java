package com.lucatm11.UsernameBlocker;

import java.util.HashSet;

import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
  public final BadWords badWords;

  public Plugin() {
    badWords = new BadWords(this);
  }

  public void onEnable() {
    saveDefaultConfig();

    badWords.badWordsSet = new HashSet<String>();
    badWords.RegisterBadWordsFromConfig();

    getServer().getPluginManager().registerEvents(new JoinListener(this), this);
  }
}
