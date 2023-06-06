package de.tamion.others;

import de.tamion.discord.DCMain;
import de.tamion.minecraft.MCMain;
import net.dv8tion.jda.api.entities.MessageEmbed;
import org.bukkit.command.CommandSender;

public class Utils {
    public static void sendtochat(String msg) {
        DCMain.jda.getGuildById(MCMain.getPlugin().getConfig().getString("Bot.guildid")).getTextChannels().forEach(textChannel -> {
            if(textChannel.getTopic() != null && textChannel.getTopic().contains("MCCHAT")) {
                try {
                    textChannel.sendMessage(msg).queue();
                } catch (IllegalStateException ignored) {}
            }
        });
    }
    public static void sendtochat(MessageEmbed emb) {
        DCMain.jda.getGuildById(MCMain.getPlugin().getConfig().getString("Bot.guildid")).getTextChannels().forEach(textChannel -> {
            if(textChannel.getTopic() != null && textChannel.getTopic().contains("MCCHAT")) {
                textChannel.sendMessageEmbeds(emb).queue();
            }
        });
    }
    public static void sendtoconsole(String msg) {
        DCMain.jda.getGuildById(MCMain.getPlugin().getConfig().getString("Bot.guildid")).getTextChannels().forEach(textChannel -> {
            if(textChannel.getTopic() != null && textChannel.getTopic().contains("MCCONSOLE")) {
                try {
                    textChannel.sendMessage(msg).queue();
                } catch (IllegalStateException ignored) {}
            }
        });
    }
    public static void sendtoconsole(MessageEmbed emb) {
        DCMain.jda.getGuildById(MCMain.getPlugin().getConfig().getString("Bot.guildid")).getTextChannels().forEach(textChannel -> {
            if(textChannel.getTopic() != null && textChannel.getTopic().contains("MCCONSOLE")) {
                textChannel.sendMessageEmbeds(emb).queue();
            }
        });
    }
    public static String setsyntax(CommandSender sender, String loc, String syntax) {
        if(!sender.hasPermission("DCChat.syntax") || !sender.hasPermission("DCChat.admin")) {
            return "You are not allowed to execute this Command!";
        }
        MCMain.getPlugin().getConfig().set(loc, syntax);
        MCMain.getPlugin().saveConfig();
        return "Syntax Set!";
    }
}