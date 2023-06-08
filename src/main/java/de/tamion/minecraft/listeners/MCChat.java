package de.tamion.minecraft.listeners;

import de.tamion.minecraft.MCMain;
import de.tamion.others.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class MCChat implements Listener {
     @EventHandler
     public void onChat(PlayerChatEvent e) {
         Player p = e.getPlayer();
         FileConfiguration config = MCMain.getPlugin().getConfig();
         if(!e.isCancelled()) {
             Utils.sendtochat(config.getString("Bot.dcsyntax").replaceAll("\\{username}", e.getPlayer().getName()).replaceAll("\\{message}", e.getMessage()));
         }
     }
}