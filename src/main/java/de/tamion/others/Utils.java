package de.tamion.others;

import de.tamion.discord.DCMain;
import de.tamion.minecraft.MCMain;

public class Utils {
    public static void sendtochat(String msg) {
        DCMain.jda.getGuildById(MCMain.getPlugin().getConfig().getString("Bot.guildid")).getTextChannels().forEach(textChannel -> {
            if(textChannel.getTopic() != null && textChannel.getTopic().contains("MCCHAT")) {
                textChannel.sendMessage(msg).queue();
            }
        });
    }
    public static void sendtoconsole(String msg) {
        DCMain.jda.getGuildById(MCMain.getPlugin().getConfig().getString("Bot.guildid")).getTextChannels().forEach(textChannel -> {
            if(textChannel.getTopic() != null && textChannel.getTopic().contains("MCCONSOLE")) {
                textChannel.sendMessage(msg).queue();
            }
        });
    }
}
