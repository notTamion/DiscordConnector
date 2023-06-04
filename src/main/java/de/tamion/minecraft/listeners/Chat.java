package de.tamion.minecraft.listeners;

import de.tamion.minecraft.MCMain;
import de.tamion.others.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class Chat implements Listener {
     @EventHandler
     public void onChat(PlayerChatEvent e) {
         FileConfiguration config = MCMain.getPlugin().getConfig();
         Utils.sendtochat(config.getString("Bot.dcsyntax").replaceAll("\\{username}", e.getPlayer().getName()).replaceAll("\\{message}", e.getMessage()));
     }
}