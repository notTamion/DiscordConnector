package de.tamion.discord.listeners;

import de.tamion.minecraft.MCMain;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class DCChat extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        FileConfiguration config = MCMain.getPlugin().getConfig();
        String msg = e.getMessage().getContentDisplay();
        if(!e.isFromType(ChannelType.TEXT)) {
            return;
        }
        TextChannel channel = (TextChannel) e.getChannel();
        if(channel.getTopic() == null || !channel.getTopic().contains("MCCHAT") || !e.getGuild().getId().equals(config.getString("Bot.guildid")) || e.getAuthor().isBot() || msg.startsWith("/") || config.getString("Bot.mcsyntax").equals("")) {
            return;
        }
        Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Bot.mcsyntax")).replaceAll("\\{username}", e.getMember().getEffectiveName()).replaceAll("\\{message}", msg.replaceAll("§", "")));
    }
}
