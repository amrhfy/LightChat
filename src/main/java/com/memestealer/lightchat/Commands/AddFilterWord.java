package com.memestealer.lightchat.Commands;

import com.memestealer.lightchat.LightChat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AddFilterWord implements CommandExecutor {

    public LightChat main;

    public AddFilterWord(LightChat plugin) {
        this.main = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length < 1) {
                p.sendMessage(main.color(main.getConfig().getString("Messages.Filter-Word.Usage")));
            } else if (args.length < 2) {
                main.addFilterWord(args[0]);
                p.sendMessage(main.color(main.getConfig().getString("Messages.Filter-Word.Added").replace("%word%", args[0])));
            } else {
                p.sendMessage(main.color(main.getConfig().getString("Messages.Filter-Word.Incorrect-Word")));
            }
        } else {
            System.out.println("Only player can run this command.");
        }
        return false;
    }



}
