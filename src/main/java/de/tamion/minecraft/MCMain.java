package de.tamion.minecraft;

import de.tamion.discord.DCMain;
import de.tamion.minecraft.commands.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class MCMain extends JavaPlugin {

    static MCMain plugin;

    @Override
    public void onEnable() {
        plugin = this;
        defaultconfig();
        DCMain.startup();
        getCommand("setbottoken").setExecutor(new SetToken());
        getCommand("setmcsyntax").setExecutor(new SetMCSyntax());
        getCommand("setdcsyntax").setExecutor(new SetDCSyntax());
        getCommand("setjoinsyntax").setExecutor(new SetJoinSyntax());
        getCommand("setleavesyntax").setExecutor(new SetLeaveSyntax());
        getCommand("setguildid").setExecutor(new SetGuildID());
        getCommand("setchatid").setExecutor(new SetChatID());
        getCommand("setconsoleid").setExecutor(new SetConsoleID());
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
            config.set("Bot.mcsyntax", "[Discord] {username}: {message}");
        }
        if(!config.contains("Bot.dcsyntax")) {
            config.set("Bot.dcsyntax", "[Minecraft] {username}: {message}");
        }
        if(!config.contains("Bot.joinsyntax")) {
            config.set("Bot.joinsyntax", "[Minecraft] {username} joined the Server!");
        }
        if(!config.contains("Bot.leavesyntax")) {
            config.set("Bot.leavesyntax", "[Minecraft] {username} left the Server!");
        }
        if(!config.contains("Bot.token")) {
            config.set("Bot.token", "TOKEN");
        }
        if(!config.contains("Bot.guildid")) {
            config.set("Bot.guildid", "GUILDID");
        }
        if(!config.contains("Bot.chatid")) {
            config.set("Bot.chatid", "CHATID");
        }
        if(!config.contains("Bot.consoleid")) {
            config.set("Bot.consoleid", "CONSOLEID");
        }
        plugin.saveConfig();
    }
}
