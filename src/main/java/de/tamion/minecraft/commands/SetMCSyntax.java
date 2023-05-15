package de.tamion.minecraft.commands;

import de.tamion.minecraft.MCMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class SetMCSyntax implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(!sender.hasPermission("DCChat.syntax") || !sender.hasPermission("DCChat.admin")) {
            sender.sendMessage("You are not allowed to execute this Command!");
            return false;
        }
        if(!(args.length >= 1)) {
            sender.sendMessage("/setMCSyntax [Syntax]");
            return false;
        }
        FileConfiguration config = MCMain.getPlugin().getConfig();
        StringBuilder sb = new StringBuilder();
        for(String wor: args) {
            sb.append(wor+ " ");
        }
        config.set("Bot.mcsyntax", sb.toString());
        MCMain.getPlugin().saveConfig();
        sender.sendMessage("Syntax Set!");
        return true;
    }
}
