package de.tamion.mc.commands;

import de.tamion.dc.DCChatDC;
import de.tamion.mc.DCChatMC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class SetMCSyntax implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(sender.hasPermission("DCChat.syntax") || sender.hasPermission("DCChat.admin")) {
            if(args.length >= 1) {
                FileConfiguration config = DCChatMC.getPlugin().getConfig();
                StringBuilder sb = new StringBuilder();
                for(String wor: args) {
                    sb.append(wor+ " ");
                }
                config.set("Bot.mcsyntax", sb.toString());
                DCChatMC.getPlugin().saveConfig();
                sender.sendMessage("Syntax Set!");
            } else {
                sender.sendMessage("/setMCSyntax [Syntax]");
            }
        } else {
            sender.sendMessage("You are not allowed to execute this Command!");
        }
        return false;
    }
}
