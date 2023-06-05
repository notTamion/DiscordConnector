package de.tamion.others;

import de.tamion.discord.DCMain;
import de.tamion.minecraft.MCMain;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.bukkit.configuration.file.FileConfiguration;

@Plugin(name = "DCChatConsoleAppender", category = "Core", elementType = "appender", printObject = true)
public class DCChatConsoleAppender extends AbstractAppender {
    public DCChatConsoleAppender() {
        super("DCChatConsoleAppender", null,
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
            if(Schedulers.sb.length()+e.getMessage().getFormattedMessage().length()>1990) {
                Utils.sendtoconsole(Schedulers.sb.toString());
                Schedulers.sb.setLength(0);
                if(e.getMessage().getFormattedMessage().length()<1990) {
                    Schedulers.sb.append(e.getMessage().getFormattedMessage() + "\n");
                } else {
                    for(String mn : e.getMessage().getFormattedMessage().split("(?<=\\G.{4})")) {
                        Utils.sendtoconsole(mn);
                    }
                }
            } else {
                Schedulers.sb.append(e.getMessage().getFormattedMessage() + "\n");
            }

        }
    }
}
