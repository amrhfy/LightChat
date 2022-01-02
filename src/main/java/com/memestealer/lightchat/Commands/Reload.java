package com.memestealer.lightchat.Commands;

import com.memestealer.lightchat.LightChat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Reload implements CommandExecutor {

    public LightChat main;

    public Reload(LightChat plugin) {
        this.main = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        this.reloadConfig();

        if (sender instanceof Player) {
            sender.sendMessage(main.color(main.getConfig().getString("Messages.Reload")));
        } else {
            System.out.println("Chat | Successfully reloaded the config file.");
        }

        return false;
    }

    public void reloadConfig() {
        main.reloadConfig();
        main.saveDefaultConfig();
        main.getConfig().options().copyDefaults(true);
        main.saveConfig();
    }
}
