package de.tamion.minecraft.commands;

import de.tamion.minecraft.MCMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class SetGuildID implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(!sender.hasPermission("DCChat.id")) {
            sender.sendMessage("You are not allowed to execute this Command!");
            return false;
        }
        if(args.length != 1) {
            sender.sendMessage("/setGuildID [ID]");
            return false;
        }
        FileConfiguration config = MCMain.getPlugin().getConfig();
        config.set("Bot.guildid", args[0]);
        MCMain.getPlugin().saveConfig();
        sender.sendMessage("GuildID Set!");
        return true;
    }
}
