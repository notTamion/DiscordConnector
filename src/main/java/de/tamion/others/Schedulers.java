package de.tamion.others;

import de.tamion.discord.DCMain;
import de.tamion.minecraft.MCMain;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.exceptions.MissingAccessException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class Schedulers {

    public static StringBuilder sb = new StringBuilder();
    public static void consolescheduler() {
        FileConfiguration config = MCMain.getPlugin().getConfig();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(MCMain.getPlugin(), () -> {
            if(sb.length() == 0) {
                return;
            }
            Utils.sendtoconsole(sb.toString());
            sb.setLength(0);
        }, 20L, 20L);
    }
    public static void updatesyntaxchannel() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(MCMain.getPlugin(), () -> {
            try {
                for (TextChannel textChannel : DCMain.jda.getGuildById(MCMain.getPlugin().getConfig().getString("Bot.guildid")).getTextChannels()) {
                    if (textChannel.getTopic() == null || textChannel.getTopic().startsWith("MCSYNTAX:")) {
                        return;
                    }
                    String newname = textChannel.getTopic().replace("MCSYNTAX:", "").trim().replaceAll(" ", "-")
                            .replaceAll("\\{players}", String.valueOf(Bukkit.getOnlinePlayers().size()));
                    if (!textChannel.getName().equals(newname)) {
                        textChannel.getManager().setName(newname).queue();
                        break;
                    }
                }
            } catch (MissingAccessException ignored) {
            }
        }, 20L, 6000L);
    }
}
