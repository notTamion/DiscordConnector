package de.tamion.dc.listeners;

import de.tamion.mc.MCMain;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class DCChat extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        FileConfiguration config = MCMain.getPlugin().getConfig();
        String msg = e.getMessage().getContentDisplay();
        if(!e.isFromType(ChannelType.TEXT)) {
            return;
        }
        if(!e.getChannel().getId().equals(config.getString("Bot.textchannelid"))&&!e.getGuild().getId().equals(config.getString("Bot.guildid"))) {
            return;
        }
        if(e.getAuthor().isBot()) {
            return;
        }
        Bukkit.getConsoleSender().sendMessage(config.getString("Bot.mcsyntax").replaceAll("\\{username}", e.getMember().getEffectiveName()).replaceAll("\\{message}", msg));
        Bukkit.getServer().broadcastMessage(config.getString("Bot.mcsyntax").replaceAll("\\{username}", e.getMember().getEffectiveName()).replaceAll("\\{message}", msg));
    }
}
