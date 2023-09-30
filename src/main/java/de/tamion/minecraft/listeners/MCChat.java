package de.tamion.minecraft.listeners;

import de.tamion.minecraft.MCMain;
import de.tamion.others.Utils;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MCChat implements Listener {
     @EventHandler
     public void onChat(AsyncChatEvent e) {
         Player p = e.getPlayer();
         FileConfiguration config = MCMain.getPlugin().getConfig();
         if(!e.isCancelled()) {
             Utils.sendtochat(config.getString("Bot.dcsyntax").replaceAll("\\{username}", e.getPlayer().getName()).replaceAll("\\{message}", PlainTextComponentSerializer.plainText().serialize(e.message())));
         }
     }
}