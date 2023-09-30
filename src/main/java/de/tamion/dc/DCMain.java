package de.tamion.dc;

import de.tamion.dc.listeners.DCChat;
import de.tamion.mc.MCMain;
import de.tamion.mc.listeners.Chat;
import de.tamion.mc.listeners.JoinLeave;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.exceptions.InvalidTokenException;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;

public class DCMain {

    public static ShardManager jda;
    static FileConfiguration config = MCMain.getPlugin().getConfig();
    public static void startup() {
        boolean startallowed = true;
        if(!config.contains("Bot.token") || config.get("Bot.token").equals("TOKEN")) {
            startallowed=false;
            Bukkit.getConsoleSender().sendMessage("§cBOT TOKEN NOT SET. PLEASE SET WITH /setBotToken [Token] or change it directly in the config.yml");
        }
        if(!config.contains("Bot.guildid") || config.get("Bot.guildid").equals("GUILDID")) {
            startallowed=false;
            Bukkit.getConsoleSender().sendMessage("§cGUILDID NOT SET. PLEASE SET WITH /setGuildID [ID] or change it directly in the config.yml");
        }
        if(!config.contains("Bot.textchannelid") || config.get("Bot.textchannelid").equals("CHANNELID")) {
            startallowed=false;
            Bukkit.getConsoleSender().sendMessage("§cTEXTCHANNELID NOT SET. PLEASE SET WITH /setChannelID [ID] or change it directly in the config.yml");
        }
        if(startallowed == false) {
            return;
        }
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new Chat(), MCMain.getPlugin());
        pluginManager.registerEvents(new JoinLeave(), MCMain.getPlugin());
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(config.getString("Bot.token"));
        builder.setStatus(OnlineStatus.ONLINE);
        builder.addEventListeners(new DCChat());
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        try {
            jda = builder.build();
            Bukkit.getConsoleSender().sendMessage("§aBOT STARTED!");
        } catch (InvalidTokenException e) {
            Bukkit.getConsoleSender().sendMessage("§cINVALID BOT TOKEN");
        }
    }

    public static void shutdown() {
        if(jda != null) {
            jda.setStatus(OnlineStatus.OFFLINE);
            jda.shutdown();
        } else {
            Bukkit.getConsoleSender().sendMessage("§cCANT STOP BOT! BOT NOT RUNNING!");
        }
    }

    public static void restart() {
        shutdown();
        startup();
    }
}
