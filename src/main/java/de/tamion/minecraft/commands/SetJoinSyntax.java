package de.tamion.minecraft.commands;

import de.tamion.others.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class SetJoinSyntax implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        sender.sendMessage(Utils.setsyntax(sender, "Bot.joinsyntax", String.join(" ", args)));
        return true;
    }
}
