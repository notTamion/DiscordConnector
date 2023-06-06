package de.tamion.minecraft.listeners;

import de.tamion.minecraft.MCMain;
import de.tamion.others.Utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeave implements Listener {
    static FileConfiguration config = MCMain.getPlugin().getConfig();
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Utils.sendtochat(config.getString("Bot.joinsyntax").replaceAll("\\{username}", e.getPlayer().getName()));
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Utils.sendtochat(config.getString("Bot.leavesyntax").replaceAll("\\{username}", e.getPlayer().getName()));
    }
}