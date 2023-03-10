package de.tamion.mc.listeners;

import de.tamion.dc.DCChatDC;
import de.tamion.mc.DCChatMC;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeave implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        FileConfiguration config = DCChatMC.getPlugin().getConfig();
        Guild gld = DCChatDC.jda.getGuildById(config.getString("Bot.guildid"));
        TextChannel chan = gld.getTextChannelById(config.getString("Bot.textchannelid"));
        chan.sendMessage(e.getPlayer().getName() + " joined to Server!").queue();
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        FileConfiguration config = DCChatMC.getPlugin().getConfig();
        Guild gld = DCChatDC.jda.getGuildById(config.getString("Bot.guildid"));
        TextChannel chan = gld.getTextChannelById(config.getString("Bot.textchannelid"));
        chan.sendMessage(e.getPlayer().getName() + " left to Server!").queue();
    }
}
