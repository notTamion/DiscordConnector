package de.tamion.mc;

import de.tamion.dc.DCChatDC;
import de.tamion.mc.commands.*;
import de.tamion.mc.listeners.Chat;
import de.tamion.mc.listeners.JoinLeave;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class DCChatMC extends JavaPlugin {

    static DCChatMC plugin;

    @Override
    public void onEnable() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        plugin = this;
        defaultconfig();
        DCChatDC.startup();
        getCommand("restartbot").setExecutor(new RestartBot());
        getCommand("setbottoken").setExecutor(new SetToken());
        getCommand("setmcsyntax").setExecutor(new SetMCSyntax());
        getCommand("setdcsyntax").setExecutor(new SetDCSyntax());
        getCommand("setguildid").setExecutor(new SetGuildID());
        getCommand("setchannelid").setExecutor(new SetChannelID());
    }

    @Override
    public void onDisable() {
        DCChatDC.shutdown();
    }

    public static DCChatMC getPlugin() {
        return plugin;
    }

    public static void defaultconfig() {
        FileConfiguration config = plugin.getConfig();
        if(!config.contains("Bot.mcsyntax")) {
            config.set("Bot.mcsyntax", "[DC] {Username}: {Message}");
        }
        if(!config.contains("Bot.dcsyntax")) {
            config.set("Bot.dcsyntax", "[MC] {Username}: {Message}");
        }

        plugin.saveConfig();
    }
}
