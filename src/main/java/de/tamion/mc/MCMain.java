package de.tamion.mc;

import de.tamion.dc.DCMain;
import de.tamion.mc.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MCMain extends JavaPlugin {

    static MCMain plugin;

    @Override
    public void onEnable() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        plugin = this;
        defaultconfig();
        DCMain.startup();
        getCommand("restartbot").setExecutor(new RestartBot());
        getCommand("setbottoken").setExecutor(new SetToken());
        getCommand("setmcsyntax").setExecutor(new SetMCSyntax());
        getCommand("setdcsyntax").setExecutor(new SetDCSyntax());
        getCommand("setguildid").setExecutor(new SetGuildID());
        getCommand("setchannelid").setExecutor(new SetChannelID());
    }

    @Override
    public void onDisable() {
        DCMain.shutdown();
    }

    public static MCMain getPlugin() {
        return plugin;
    }

    public static void defaultconfig() {
        FileConfiguration config = plugin.getConfig();
        if(!config.contains("Bot.mcsyntax")) {
            config.set("Bot.mcsyntax", "[DC] {username}: {message}");
        }
        if(!config.contains("Bot.dcsyntax")) {
            config.set("Bot.dcsyntax", "{username}: {message}");
        }
        if(!config.contains("Bot.token")) {
            config.set("Bot.token", "TOKEN");
        }
        if(!config.contains("Bot.guildid")) {
            config.set("Bot.guildid", "GUILDID");
        }
        if(!config.contains("Bot.textchannelid")) {
            config.set("Bot.textchannelid", "CHANNELID");
        }
        plugin.saveConfig();
    }
}
