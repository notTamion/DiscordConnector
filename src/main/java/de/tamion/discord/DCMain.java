package de.tamion.discord;

import de.tamion.discord.listeners.Console;
import de.tamion.discord.listeners.DCChat;
import de.tamion.minecraft.MCMain;
import de.tamion.minecraft.listeners.Chat;
import de.tamion.minecraft.listeners.JoinLeave;
import de.tamion.others.DCChatConsoleAppender;
import de.tamion.others.Schedulers;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.exceptions.InvalidTokenException;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;

public class DCMain {

    public static JDA jda;
    static FileConfiguration config = MCMain.getPlugin().getConfig();
    public static void startup() {
        try {
            boolean startallowed = true;
            PluginManager pluginManager = Bukkit.getPluginManager();
            JDABuilder jb = JDABuilder.createDefault(config.getString("Bot.token")).setStatus(OnlineStatus.ONLINE).enableIntents(GatewayIntent.MESSAGE_CONTENT);
            if(!config.contains("Bot.token") || config.get("Bot.token").equals("TOKEN")) {
                MCMain.getPlugin().getLogger().info("Bot token not set. Please set with /setBotToken [Token] or change it directly in the config.yml");
                startallowed=false;
            }
            if(!config.contains("Bot.guildid") || config.get("Bot.guildid").equals("GUILDID")) {
                MCMain.getPlugin().getLogger().info("GuildID not set. Please set with /setGuildID [ID] or change it directly in the config.yml");
                startallowed = false;
            }
            if(!startallowed) {
                return;
            }
            jb.addEventListeners(new DCChat());
            jb.addEventListeners(new Console());
            jda = jb.build().awaitReady();
            Logger log = (Logger) LogManager.getRootLogger();
            log.addAppender(new DCChatConsoleAppender());
            Schedulers.consolescheduler();
            Schedulers.updatesyntaxchannel();
            pluginManager.registerEvents(new Chat(), MCMain.getPlugin());
            pluginManager.registerEvents(new JoinLeave(), MCMain.getPlugin());
            MCMain.getPlugin().getLogger().info("Bot started.");
        } catch (InvalidTokenException e) {
            MCMain.getPlugin().getLogger().info("Invalid Bot token.");
        } catch (InterruptedException ignored) {}
    }

    public static void shutdown() {
        Logger log = (Logger) LogManager.getRootLogger();
        if(log.getAppenders().containsKey("DCChatConsoleAppender")) {
            log.removeAppender(log.getAppenders().get("DCChatConsoleAppender"));
        }
        if(jda != null) {
            jda.shutdown();
        } else {
            MCMain.getPlugin().getLogger().info("Can't stop bot. Bot not running.");
        }
    }

    public static void restart() {
        shutdown();
        startup();
    }
}
