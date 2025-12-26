package com.lucatm11.UsernameBlocker;

import java.util.HashSet;

public class BadWords {
    private final Plugin plugin;

    HashSet<String> badWordsSet;

    public BadWords(Plugin plugin) {
        this.plugin = plugin;
    }

    public void RegisterBadWordsFromConfig() {
        plugin.getConfig().getList("badwords").forEach(badWord -> {
            badWordsSet.add(badWord.toString().toLowerCase());
        });
    }

    public void RegisterBadWord(String word) {
        badWordsSet.add(word.toLowerCase());
    }
}
