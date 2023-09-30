package de.tamion.mc;

import de.tamion.dc.DCChatDC;
import de.tamion.mc.commands.SetDCSyntax;
import de.tamion.mc.commands.SetGuildID;
import de.tamion.mc.commands.SetMCSyntax;
import de.tamion.mc.commands.SetToken;
import de.tamion.mc.listeners.Chat;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import de.tamion.mc.commands.SetChannelID;
public final class DCChatMC extends JavaPlugin {

    static DCChatMC plugin;

    @Override
    public void onEnable() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        plugin = this;
        defaultconfig();
        if(getConfig().contains("Bot.token")) {
            if(getConfig().contains("Bot.guildid")) {
                if(getConfig().contains("Bot.textchannelid")) {
                    DCChatDC.startup();
                } else {
                    Bukkit.getConsoleSender().sendMessage("§TEXTCHANNELID NOT SET. PLEASE SET WITH /setChannelID [ID]");
                }
            } else {
                Bukkit.getConsoleSender().sendMessage("§GUILDID NOT SET. PLEASE SET WITH /setGuildID [ID]");
            }
        } else {
            Bukkit.getConsoleSender().sendMessage("§cBOT TOKEN NOT SET. PLEASE SET WITH /setBotToken [Token]");
        }
        pluginManager.registerEvents(new Chat(), this);
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
