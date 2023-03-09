package de.tamion.mc.commands;

import de.tamion.mc.DCChatMC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class SetGuildID implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(sender.hasPermission("DCChat.id") || sender.hasPermission("DCChat.admin")) {
            if(args.length == 1) {
                FileConfiguration config = DCChatMC.getPlugin().getConfig();
                config.set("Bot.guildid", args[0]);
                DCChatMC.getPlugin().saveConfig();
                sender.sendMessage("GuildID Set!");
            } else {
                sender.sendMessage("/setGuildID [ID]");
            }
        }
        return false;
    }
}
