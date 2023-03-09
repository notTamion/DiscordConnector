package de.tamion.mc.listeners;

import de.tamion.dc.DCChatDC;
import de.tamion.mc.DCChatMC;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class Chat implements Listener {
     @EventHandler
     public void onChat(PlayerChatEvent e) {
         FileConfiguration config = DCChatMC.getPlugin().getConfig();
         Guild gld = DCChatDC.jda.getGuildById(config.getString("Bot.guildid"));
         TextChannel chan = gld.getTextChannelById(config.getString("Bot.textchannelid"));
         chan.sendMessage(config.getString("Bot.dcsyntax").replaceAll("\\{Username}", e.getPlayer().getName()).replaceAll("\\{Message}", e.getMessage())).queue();
     }
}
