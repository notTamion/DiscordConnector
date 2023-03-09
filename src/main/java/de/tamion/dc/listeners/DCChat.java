package de.tamion.dc.listeners;

import de.tamion.mc.DCChatMC;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.configuration.file.FileConfiguration;

public class DCChat extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        FileConfiguration config = DCChatMC.getPlugin().getConfig();
        String msg = e.getMessage().getContentDisplay();
        if(e.isFromType(ChannelType.TEXT)) {
            if(e.getChannel().getId().equals(config.getString("Bot.textchannelid"))&&e.getGuild().getId().equals(config.getString("Bot.guildid"))) {
                if(!e.getAuthor().isBot()) {
                    DCChatMC.getPlugin().getServer().broadcastMessage(config.getString("Bot.mcsyntax").replaceAll("\\{Username}", e.getMember().getEffectiveName()).replaceAll("\\{Message}", msg));
                }
            }
        }
    }
}
