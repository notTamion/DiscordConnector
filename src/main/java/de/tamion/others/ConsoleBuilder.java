package de.tamion.others;

import de.tamion.discord.DCMain;
import de.tamion.minecraft.MCMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class ConsoleBuilder {

    public static StringBuilder sb = new StringBuilder();
    public static void consolescheduler() {
        FileConfiguration config = MCMain.getPlugin().getConfig();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(MCMain.getPlugin(), () -> {
            if(sb.length() != 0) {
                DCMain.jda.getGuildById(config.getString("Bot.guildid")).getTextChannelById(config.getString("Bot.consoleid")).sendMessage(sb.toString()).queue();
                sb.setLength(0);
            }
        }, 20L, 20L);
    }
}
