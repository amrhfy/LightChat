package com.memestealer.lightchat;

import com.memestealer.lightchat.Commands.AddFilterWord;
import com.memestealer.lightchat.Commands.Reload;
import com.memestealer.lightchat.Events.Chat;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Locale;

public class LightChat extends JavaPlugin {

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {

            Bukkit.getPluginManager().registerEvents(new Chat(this), this);

            getCommand("lcreload").setExecutor(new Reload(this));
            getCommand("lcaddword").setExecutor(new AddFilterWord(this));

            System.out.println("LightChat has been enabled.");

        } else {
            getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }

    }

    // Color Code Method
    public String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public String replacePlaceholder(Player p, String msg) {
        String m = msg;
        if (PlaceholderAPI.containsPlaceholders(msg)) {
            m = PlaceholderAPI.setPlaceholders(p, msg);
        }
        return m;
    }

    public String checkCaps(String msg) {
        String m = msg;
        int caps = 0;

        for (char c : m.toCharArray()) {
            if (Character.isUpperCase(c)) {
                ++caps;
            }
        }
        double pct = (caps * 1D) / (m.length() * 1D) * 100D;

        if (pct > getConfig().getDouble("Anti-Caps.Percentage")) {
            m = m.toLowerCase(Locale.ROOT);
        }
        return m;
    }

    public Boolean checkFilter(String msg) {

        boolean swear = false;
        String arr[] = msg.split(" ", msg.length());
        String sb = new StringBuilder();

        List<String> fWord = getConfig().getStringList("Filter-Words.Words");

        for (int i = 0 ; i < arr.length ; i++) {
            for ()
        }





        return swear;
    }

    public void addFilterWord(String word) {
        List<String> list = getConfig().getStringList("Filter-Words.Words");
        list.add(word);
        getConfig().set("Filter-Word.Words", list);
        saveConfig();
    }

}



