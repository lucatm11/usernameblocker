package com.lucatm11.UsernameBlocker;

import java.util.HashSet;

public class BadWordsRegistrar {
    private final Plugin plugin;
    HashSet<String> badWords;

    public BadWordsRegistrar(Plugin plugin) {
        this.plugin = plugin;
    }

    public void init() {
        badWords = new HashSet<String>();
    }

    public void RegisterBadWordsFromConfig() {
        plugin.getConfig().getList("badwords").forEach(badWord -> {
            badWords.add(badWord.toString().toLowerCase());
            plugin.getLogger().info("Added " + badWord + " to the bad words list.");
        });
    }

    public void RegisterBadWord(String word) {
        badWords.add(word.toLowerCase());
    }
}
