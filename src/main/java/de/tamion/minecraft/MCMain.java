package de.tamion.minecraft;

import de.tamion.discord.DCMain;
import de.tamion.minecraft.commands.*;
import de.tamion.others.Utils;
import net.dv8tion.jda.api.EmbedBuilder;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;

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
        getCommand("setstartsyntax").setExecutor(new SetStartSyntax());
        getCommand("setstopsyntax").setExecutor(new SetStopSyntax());
        getCommand("setguildid").setExecutor(new SetGuildID());
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
        if(!config.contains("Bot.startsyntax")) {
            config.set("Bot.startsyntax", "Bot started!");
        }
        if(!config.contains("Bot.stopsyntax")) {
            config.set("Bot.stopsyntax", "Bot stopped!");
        }
        if(!config.contains("Bot.token")) {
            config.set("Bot.token", "TOKEN");
        }
        if(!config.contains("Bot.guildid")) {
            config.set("Bot.guildid", "GUILDID");
        }
        plugin.saveConfig();
    }
}
