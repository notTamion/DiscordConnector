package de.tamion.mc.commands;

import de.tamion.dc.DCChatDC;
import de.tamion.mc.DCChatMC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class SetToken implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(sender.hasPermission("DCChat.token") || sender.hasPermission("DCChat.admin")) {
            if(args.length == 1) {
                FileConfiguration config = DCChatMC.getPlugin().getConfig();
                config.set("Bot.token", args[0]);
                DCChatMC.getPlugin().saveConfig();
                sender.sendMessage("Token has been set to " + args[0]);
            } else {
                sender.sendMessage("/setBotToken [BotToken]");
            }
        } else {
            sender.sendMessage("You are not allowed to execute this Command!");
        }
        return false;
    }
}
