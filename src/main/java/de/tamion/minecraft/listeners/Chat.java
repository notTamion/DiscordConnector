package de.tamion.minecraft.listeners;

import de.tamion.discord.DCMain;
import de.tamion.minecraft.MCMain;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class Chat implements Listener {
     @EventHandler
     public void onChat(PlayerChatEvent e) {
         FileConfiguration config = MCMain.getPlugin().getConfig();
         DCMain.jda.getGuildById(config.getString("Bot.guildid")).getTextChannelById(config.getString("Bot.chatid")).sendMessage(config.getString("Bot.dcsyntax").replaceAll("\\{username}", e.getPlayer().getName()).replaceAll("\\{message}", e.getMessage())).queue();
     }
}