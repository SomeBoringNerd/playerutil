package xyz.twobtwofr.playerutil.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class dupe implements CommandExecutor
{

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args)
    {
        sender.sendMessage("[§5SpaceAnarchy§r] : here's a tutorial on how to dupe on the server : ");
        sender.sendMessage("[§5SpaceAnarchy§r] : §6https://www.youtube.com/watch?v=-PIgK0eoxMU");

        return true;
    }
}
