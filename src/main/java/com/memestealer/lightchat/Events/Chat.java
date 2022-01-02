package com.memestealer.lightchat.Events;

import com.memestealer.lightchat.LightChat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class Chat implements Listener {

    public LightChat main;

    public Chat(LightChat main) {
        this.main = main;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        Player p = e.getPlayer();

        if (main.getConfig().getBoolean("Chat-Format.Enabled")) {
            String format = main.getConfig().getString("Chat-Format.Format");
            String message = e.getMessage();
            format = main.replacePlaceholder(p, format);

            if (main.getConfig().getBoolean("Anti-Caps.Enabled")) {
                message = main.checkCaps(e.getMessage());
            }

            if (main.getConfig().getBoolean("Filter-Word.Enabled")) {
                if (main.checkFilter(message)) {
                    e.setCancelled(true);
                    p.sendMessage(main.getConfig().getString("Messages.Filter-Word.Warn"));
                }
            }

            format = format.replace("%message%", message);
            e.setFormat(format);
        }
    }

    // ##############################################################
    // ######################### CHAT UTILS #########################
    // ##############################################################

}
