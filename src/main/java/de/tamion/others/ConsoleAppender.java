package de.tamion.others;

import de.tamion.discord.DCMain;
import de.tamion.minecraft.MCMain;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.bukkit.configuration.file.FileConfiguration;

@Plugin(name = "ConsoleAppender", category = "Core", elementType = "appender", printObject = true)
public class ConsoleAppender extends AbstractAppender {
    public ConsoleAppender() {
        super("ConsoleAppender", null,
                PatternLayout.newBuilder().withPattern("[%d{HH:mm:ss} %level]: %msg").build());
    }

    @Override
    public boolean isStarted() {
        return true;
    }

    @Override
    public void append(LogEvent e) {
        FileConfiguration config = MCMain.getPlugin().getConfig();
        if(DCMain.jda != null && DCMain.jda.getGuildById(config.getString("Bot.guildid")) != null) {
            DCMain.jda.getGuildById(config.getString("Bot.guildid")).getTextChannelById(config.getString("Bot.consoleid")).sendMessage(e.getMessage().getFormattedMessage()).queue();
        }
    }
}
