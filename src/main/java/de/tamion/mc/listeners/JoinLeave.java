package de.tamion.mc.listeners;

import de.tamion.dc.DCMain;
import de.tamion.mc.MCMain;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeave implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        FileConfiguration config = MCMain.getPlugin().getConfig();
        DCMain.jda.getGuildById(config.getString("Bot.guildid")).getTextChannelById(config.getString("Bot.textchannelid")).sendMessage(e.getPlayer().getName() + " joined to Server!").queue();
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        FileConfiguration config = MCMain.getPlugin().getConfig();
        DCMain.jda.getGuildById(config.getString("Bot.guildid")).getTextChannelById(config.getString("Bot.textchannelid")).sendMessage(e.getPlayer().getName() + " left to Server!").queue();
    }
}
