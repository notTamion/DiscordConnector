package de.tamion.mc.listeners;

import de.tamion.dc.DCMain;
import de.tamion.mc.MCMain;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class Chat implements Listener {
     @EventHandler
     public void onChat(PlayerChatEvent e) {
         FileConfiguration config = MCMain.getPlugin().getConfig();
         DCMain.jda.getGuildById(config.getString("Bot.guildid")).getTextChannelById(config.getString("Bot.textchannelid")).sendMessage(config.getString("Bot.dcsyntax").replaceAll("\\{username}", e.getPlayer().getName()).replaceAll("\\{message}", e.getMessage())).queue();
     }
}
