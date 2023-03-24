package xyz.twobtwofr.playerutil.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class commands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args)
    {
        sender.sendMessage("§5SpaceAnarchy COMMANDS : ");
        sender.sendMessage("§6/dupe §r: tutorial on how to dupe");
        sender.sendMessage("§6/playtime <player> §r: display a player's playtime");
        sender.sendMessage("§6/ratio <player> §r: kill/death ratio of a player");
        sender.sendMessage("§6/tpa <player> §r: teleport to a player");

        return true;
    }
}
