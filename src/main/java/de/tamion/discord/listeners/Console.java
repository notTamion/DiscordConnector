package de.tamion.discord.listeners;

import de.tamion.minecraft.MCMain;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class Console extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent e) {
        FileConfiguration config = MCMain.getPlugin().getConfig();
        String msg = e.getMessage().getContentDisplay();
        if(!e.isFromType(ChannelType.TEXT)) {
            return;
        }
        if(!e.getChannel().getId().equals(config.getString("Bot.consoleid")) || !e.getGuild().getId().equals(config.getString("Bot.guildid"))) {
            return;
        }
        if(e.getAuthor().isBot()) {
            return;
        }
        if(e.getMessage().getContentDisplay().startsWith("/")) {
            return;
        }
        Bukkit.getScheduler().callSyncMethod(MCMain.getPlugin(), () -> Bukkit.dispatchCommand(Bukkit.getConsoleSender(), e.getMessage().getContentDisplay()));
    }
}