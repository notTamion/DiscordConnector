package de.tamion.mc.commands;

import de.tamion.mc.DCChatMC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class SetChannelID implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(sender.hasPermission("DCChat.id") || sender.hasPermission("DCChat.admin")) {
            if(args.length == 1) {
                FileConfiguration config = DCChatMC.getPlugin().getConfig();
                config.set("Bot.textchannelid", args[0]);
                DCChatMC.getPlugin().saveConfig();
                sender.sendMessage("TextChannelID Set!");
            } else {
                sender.sendMessage("/setChannelID [ID]");
            }
        } else {
            sender.sendMessage("You are not allowed to execute this Command!");
        }
        return false;
    }
}
