package de.tamion.minecraft.listeners;

import de.tamion.discord.DCMain;
import de.tamion.minecraft.MCMain;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeave implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        FileConfiguration config = MCMain.getPlugin().getConfig();
        DCMain.jda.getGuildById(config.getString("Bot.guildid")).getTextChannelById(config.getString("Bot.chatid")).sendMessage(config.getString("Bot.joinsyntax").replaceAll("\\{username}", e.getPlayer().getName())).queue();
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        FileConfiguration config = MCMain.getPlugin().getConfig();
        DCMain.jda.getGuildById(config.getString("Bot.guildid")).getTextChannelById(config.getString("Bot.chatid")).sendMessage(config.getString("Bot.leavesyntax").replaceAll("\\{username}", e.getPlayer().getName())).queue();
    }
}